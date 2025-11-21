package br.edu.ifrn.gamespher.web.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifrn.gamespher.persistencia.repositorio.HardwareRepository;
import br.edu.ifrn.gamespher.persistencia.repositorio.ColecionavelRepository;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired private HardwareRepository hardwareRepository;
    @Autowired private ColecionavelRepository colecionavelRepository;

    @GetMapping("/hardware")
    public String listarHardware(Model model) {
        model.addAttribute("listaHardware", hardwareRepository.findAll());
        return "produtos/lista-hardware";
    }

    @GetMapping("/colecionaveis")
    public String listarColecionaveis(Model model) {
        model.addAttribute("colecionaveis", colecionavelRepository.findAll());
        return "produtos/lista-colecionaveis";
    }
}