package br.edu.ifrn.gamespher.web.controladores;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.ifrn.gamespher.persistencia.modelo.Usuario;
import br.edu.ifrn.gamespher.persistencia.repositorio.UsuarioRepository;
import br.edu.ifrn.gamespher.web.dto.PedidoDTO;
import jakarta.servlet.http.HttpSession;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // --- CADASTRO REAL ---
    @GetMapping("/usuarios/novo")
    public String novoUsuario() {
        return "usuarios/formulario-usuario";
    }

    @PostMapping("/usuarios/novo")
    public String salvarUsuario(Usuario usuario) {
        // Salva o novo cliente no banco de dados
        usuarioRepository.save(usuario);
        return "redirect:/login";
    }

    // --- PERFIL REAL ---
    @GetMapping("/perfil")
    public String perfil(HttpSession session, Model model) {
        Usuario usuarioSessao = (Usuario) session.getAttribute("usuarioLogado");
        
        if (usuarioSessao == null) return "redirect:/login";

        // Recarrega do banco para garantir dados atualizados
        Usuario usuarioAtualizado = usuarioRepository.findById(usuarioSessao.getId()).orElse(usuarioSessao);
        
        model.addAttribute("usuario", usuarioAtualizado);
        model.addAttribute("usuarioLogado", usuarioAtualizado.getNome());
        
        return "usuarios/perfil";
    }

    @PostMapping("/perfil/salvar")
    public String salvarPerfil(@ModelAttribute Usuario usuarioForm, @RequestParam String senhaConfirmacao, HttpSession session) {
        Usuario usuarioSessao = (Usuario) session.getAttribute("usuarioLogado");
        
        if (usuarioSessao == null) return "redirect:/login";

        // Valida a senha atual para permitir edição
        if (!usuarioSessao.getSenha().equals(senhaConfirmacao)) {
            return "redirect:/perfil?erro=senha";
        }

        // Atualiza os dados
        Usuario usuarioBanco = usuarioRepository.findById(usuarioSessao.getId()).get();
        usuarioBanco.setNome(usuarioForm.getNome());
        usuarioBanco.setEmail(usuarioForm.getEmail());
        usuarioBanco.setTelefone(usuarioForm.getTelefone());
        
        usuarioRepository.save(usuarioBanco);
        
        // Atualiza a sessão
        session.setAttribute("usuarioLogado", usuarioBanco);

        return "redirect:/perfil?sucesso=true";
    }

    // --- PEDIDOS (Mantém lógica de sessão por enquanto) ---
    @GetMapping("/meus-pedidos")
    @SuppressWarnings("unchecked")
    public String meusPedidos(@RequestParam(required = false) Boolean sucesso, HttpSession session, Model model) {
        Usuario u = (Usuario) session.getAttribute("usuarioLogado");
        if(u != null) model.addAttribute("usuarioLogado", u.getNome());

        if (sucesso != null && sucesso) model.addAttribute("mensagem", "Compra realizada com sucesso!");
        
        List<PedidoDTO> pedidos = (List<PedidoDTO>) session.getAttribute("meusPedidos");
        if (pedidos == null) pedidos = new ArrayList<>();
        
        model.addAttribute("listaPedidos", pedidos);
        return "usuarios/meus-pedidos";
    }
}