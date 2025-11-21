package br.edu.ifrn.gamespher.web.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.ifrn.gamespher.persistencia.modelo.Usuario;
import br.edu.ifrn.gamespher.persistencia.repositorio.UsuarioRepository;
import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Página Inicial
    @GetMapping("/")
    public String index(Model model, HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
        model.addAttribute("usuarioLogado", usuario != null ? usuario.getNome() : null);
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    // --- LÓGICA DE LOGIN REAL ---
    @PostMapping("/login")
    public String processarLogin(@RequestParam String email, @RequestParam String senha, HttpSession session, Model model) {
        // 1. Busca o usuário no banco pelo email
        Usuario usuario = usuarioRepository.findByEmail(email);

        // 2. Verifica se existe e se a senha bate
        if (usuario != null && usuario.getSenha().equals(senha)) {
            session.setAttribute("usuarioLogado", usuario); // Salva o OBJETO inteiro na sessão
            return "redirect:/";
        }

        // 3. Se falhar, volta pro login com erro (você pode adicionar msg de erro no HTML depois)
        return "redirect:/login?erro=true";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    @GetMapping("/produtos")
    public String produtos() { return "redirect:/produtos/jogos"; }

    @GetMapping("/contato")
    public String contato() { return "contato"; }
}