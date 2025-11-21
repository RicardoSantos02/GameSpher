package br.edu.ifrn.gamespher.web.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import br.edu.ifrn.gamespher.persistencia.repositorio.JogoRepository;

@Controller
@RequestMapping("/produtos/jogos")
public class JogoController {

    @Autowired
    private JogoRepository jogoRepository;

    @GetMapping
    public String listarJogos(Model model) {
        model.addAttribute("jogos", jogoRepository.findAll());
        // Você precisará criar este arquivo HTML depois: templates/produtos/lista-jogos.html
        return "produtos/lista-jogos"; 
    }

}