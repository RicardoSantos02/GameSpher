package br.edu.ifrn.gamespher.web.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import br.edu.ifrn.gamespher.persistencia.modelo.Jogo;
import br.edu.ifrn.gamespher.persistencia.repositorio.ColecionavelRepository;
import br.edu.ifrn.gamespher.persistencia.repositorio.HardwareRepository;
import br.edu.ifrn.gamespher.persistencia.repositorio.JogoRepository;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired private JogoRepository jogoRepo;
    @Autowired private HardwareRepository hardwareRepo;
    @Autowired private ColecionavelRepository colecionavelRepo;

    // Listar Jogos
    @GetMapping("/jogos")
    public String listarJogos(Model model) {
        model.addAttribute("jogos", jogoRepo.findAll());
        return "produtos/lista-jogos";
    }

    // Listar Hardware
    @GetMapping("/hardware")
    public String listarHardware(Model model) {
        model.addAttribute("listaHardware", hardwareRepo.findAll());
        return "produtos/lista-hardware";
    }

    // Listar Colecionáveis
    @GetMapping("/colecionaveis")
    public String listarColecionaveis(Model model) {
        model.addAttribute("colecionaveis", colecionavelRepo.findAll());
        return "produtos/lista-colecionaveis";
    }

    // Editar Jogo (Apenas Admin via HTML)
    @GetMapping("/jogos/editar/{id}")
    public String editarJogo(@PathVariable Long id, Model model) {
        Jogo jogo = jogoRepo.findById(id).orElse(null);
        if (jogo != null) {
            model.addAttribute("jogo", jogo);
            return "produtos/formulario-jogo";
        }
        return "redirect:/produtos/jogos";
    }

    @PostMapping("/jogos/salvar")
    public String salvarJogo(Jogo jogo) {
        jogoRepo.save(jogo);
        return "redirect:/produtos/jogos";
    }
    
    @GetMapping("/jogos/deletar/{id}")
    public String deletarJogo(@PathVariable Long id) {
        jogoRepo.deleteById(id);
        return "redirect:/produtos/jogos";
    }
}