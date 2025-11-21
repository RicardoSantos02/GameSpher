package br.edu.ifrn.gamespher.web.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping({"/", "/inicio"})
    public String inicio() {
        return "inicio"; // Nome do template Thymeleaf
    }

    @GetMapping("/login")
    public String login() {
        return "login"; // Nome do template Thymeleaf
    }
}
