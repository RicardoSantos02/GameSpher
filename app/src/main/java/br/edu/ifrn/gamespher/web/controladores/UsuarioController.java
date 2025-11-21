package br.edu.ifrn.gamespher.web.controladores;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.ifrn.gamespher.web.dto.PedidoDTO;
import jakarta.servlet.http.HttpSession;

@Controller
public class UsuarioController {

    @GetMapping("/perfil")
    public String perfil(HttpSession session, Model model) {
        verificarLogin(session, model);
        return "usuarios/perfil";
    }

    @PostMapping("/perfil/salvar")
    public String salvarPerfil() {
        return "redirect:/perfil?sucesso=true";
    }

    @GetMapping("/meus-pedidos")
    @SuppressWarnings("unchecked")
    public String meusPedidos(@RequestParam(required = false) Boolean sucesso, HttpSession session, Model model) {
        verificarLogin(session, model);
        
        if (sucesso != null && sucesso) {
            model.addAttribute("mensagem", "Compra realizada com sucesso!");
        }
        
        // Recupera a lista real da sessão. Se não existir, cria vazia.
        List<PedidoDTO> pedidos = (List<PedidoDTO>) session.getAttribute("meusPedidos");
        if (pedidos == null) pedidos = new ArrayList<>();
        
        model.addAttribute("listaPedidos", pedidos); // Nome da variável no HTML
        
        return "usuarios/meus-pedidos";
    }
    
    private void verificarLogin(HttpSession session, Model model) {
        model.addAttribute("usuarioLogado", session.getAttribute("usuarioLogado"));
    }
}