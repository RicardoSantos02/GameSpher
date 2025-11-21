package br.edu.ifrn.gamespher.web.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

    // Página Inicial
    @GetMapping("/")
    public String index(Model model, HttpSession session) {
        // Pega o usuário da sessão (se existir)
        model.addAttribute("usuarioLogado", session.getAttribute("usuarioLogado"));
        return "index";
    }

    // Página de Login (agora aceita parâmetro ?tipo=vendedor)
    @GetMapping("/login")
    public String login(@RequestParam(required = false) String tipo, Model model) {
        model.addAttribute("tipoLogin", tipo); // Passa para a view se quiser personalizar o título
        return "login";
    }

    // Processar Login (SIMULAÇÃO)
    @PostMapping("/login")
    public String processarLogin(HttpSession session) {
        // SIMULA que o usuário "Ricardo" logou com sucesso
        session.setAttribute("usuarioLogado", "Ricardo");
        return "redirect:/";
    }

    // Rota de Logout
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // Destrói a sessão
        return "redirect:/";
    }

    // Rota para Produtos (Redireciona para jogos)
    @GetMapping("/produtos")
    public String produtos() {
        return "redirect:/produtos/jogos";
    }

    @GetMapping("/contato")
    public String contato(Model model, HttpSession session) {
        model.addAttribute("usuarioLogado", session.getAttribute("usuarioLogado"));
        return "contato";
    }
    
    // Cadastro
    @GetMapping("/usuarios/novo")
    public String novoUsuario(Model model, HttpSession session) {
        model.addAttribute("usuarioLogado", session.getAttribute("usuarioLogado"));
        return "usuarios/formulario-usuario";
    }

    @PostMapping("/usuarios/novo")
    public String salvarUsuario() {
        return "redirect:/login";
    }
}