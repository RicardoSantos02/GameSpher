package br.edu.ifrn.gamespher.web.controladores;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.ifrn.gamespher.web.dto.PedidoDTO;
import br.edu.ifrn.gamespher.web.dto.UsuarioDTO;
import jakarta.servlet.http.HttpSession;

@Controller
public class UsuarioController {

    @GetMapping("/perfil")
    public String perfil(HttpSession session, Model model) {
        // Verifica/Cria o usuário na sessão
        UsuarioDTO usuario = (UsuarioDTO) session.getAttribute("dadosUsuario");
        if (usuario == null) {
            usuario = new UsuarioDTO("Ricardo Santos", "ricardo@email.com", "(84) 99999-8888");
            session.setAttribute("dadosUsuario", usuario);
        }
        
        // Passa o objeto para a tela preencher os campos
        model.addAttribute("usuario", usuario);
        
        // Mantém o nome no menu superior
        session.setAttribute("usuarioLogado", usuario.getNome());
        model.addAttribute("usuarioLogado", usuario.getNome());
        
        return "usuarios/perfil";
    }

    @PostMapping("/perfil/salvar")
    public String salvarPerfil(
            @RequestParam String nome,
            @RequestParam String email,
            @RequestParam String telefone,
            @RequestParam String senha, // Recebe a senha
            HttpSession session,
            Model model) {

        // Simulação de verificação de senha
        if (!"123".equals(senha)) {
            return "redirect:/perfil?erro=senha";
        }

        // Atualiza os dados na sessão (Memória)
        UsuarioDTO usuario = new UsuarioDTO(nome, email, telefone);
        session.setAttribute("dadosUsuario", usuario);
        session.setAttribute("usuarioLogado", nome); // Atualiza nome no menu

        return "redirect:/perfil?sucesso=true";
    }

    @GetMapping("/meus-pedidos")
    @SuppressWarnings("unchecked")
    public String meusPedidos(@RequestParam(required = false) Boolean sucesso, HttpSession session, Model model) {
        verificarLogin(session, model);
        
        if (sucesso != null && sucesso) {
            model.addAttribute("mensagem", "Compra realizada com sucesso!");
        }
        
        List<PedidoDTO> pedidos = (List<PedidoDTO>) session.getAttribute("meusPedidos");
        if (pedidos == null) pedidos = new ArrayList<>();
        
        model.addAttribute("listaPedidos", pedidos);
        
        return "usuarios/meus-pedidos";
    }
    
    private void verificarLogin(HttpSession session, Model model) {
        model.addAttribute("usuarioLogado", session.getAttribute("usuarioLogado"));
    }
}