package br.edu.ifrn.gamespher.web.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import br.edu.ifrn.gamespher.persistencia.modelo.Usuario;
import jakarta.servlet.http.HttpSession;

@ControllerAdvice
public class GlobalControllerAdvice {

    @ModelAttribute("usuarioLogado")
    public String definirUsuarioLogado(HttpSession session) {
        // Tenta pegar o objeto usuário da sessão
        Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
        
        // Se existir, retorna apenas o nome para ser usado no Menu
        if (usuario != null) {
            return usuario.getNome();
        }
        
        // Se não, retorna nulo (o menu mostrará "Entrar")
        return null;
    }
}