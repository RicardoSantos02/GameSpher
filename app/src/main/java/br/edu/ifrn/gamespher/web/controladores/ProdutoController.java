package br.edu.ifrn.gamespher.web.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifrn.gamespher.persistencia.repositorio.ColecionavelRepository;
import br.edu.ifrn.gamespher.persistencia.repositorio.HardwareRepository;
import br.edu.ifrn.gamespher.persistencia.repositorio.JogoRepository;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired private JogoRepository jogoRepo;
    @Autowired private HardwareRepository hardwareRepo;
    @Autowired private ColecionavelRepository colecionavelRepo;

    @GetMapping("/jogos")
    public String listarJogos(Model model) {
        // O GlobalControllerAdvice já coloca o 'usuarioLogado' aqui automaticamente!
        model.addAttribute("jogos", jogoRepo.findAll());
        return "produtos/lista-jogos";
    }

    @GetMapping("/hardware")
    public String listarHardware(Model model) {
        model.addAttribute("listaHardware", hardwareRepo.findAll());
        return "produtos/lista-hardware";
    }

    @GetMapping("/colecionaveis")
    public String listarColecionaveis(Model model) {
        model.addAttribute("colecionaveis", colecionavelRepo.findAll());
        return "produtos/lista-colecionaveis";
    }
}