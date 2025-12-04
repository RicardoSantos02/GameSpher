package br.edu.ifrn.gamespher.web.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import br.edu.ifrn.gamespher.persistencia.modelo.Colecionavel;
import br.edu.ifrn.gamespher.persistencia.modelo.Hardware;
import br.edu.ifrn.gamespher.persistencia.modelo.Jogo;
import br.edu.ifrn.gamespher.persistencia.repositorio.ColecionavelRepository;
import br.edu.ifrn.gamespher.persistencia.repositorio.HardwareRepository;
import br.edu.ifrn.gamespher.persistencia.repositorio.JogoRepository;

@Controller
@RequestMapping("/gerencia")
public class GerenciaController {

    @Autowired private JogoRepository jogoRepo;
    @Autowired private HardwareRepository hardwareRepo;
    @Autowired private ColecionavelRepository colecionavelRepo;

    // --- LISTAGENS ---
    
    @GetMapping("/jogos")
    public String gerenciarJogos(Model model) {
        model.addAttribute("jogos", jogoRepo.findAll());
        return "gerencia/lista-jogos";
    }

    @GetMapping("/hardware")
    public String gerenciarHardware(Model model) {
        model.addAttribute("listaHardware", hardwareRepo.findAll());
        return "gerencia/lista-hardware";
    }

    @GetMapping("/colecionaveis")
    public String gerenciarColecionaveis(Model model) {
        model.addAttribute("colecionaveis", colecionavelRepo.findAll());
        return "gerencia/lista-colecionaveis";
    }

    // --- NOVO PRODUTO (MÉTODOS NOVOS) ---

    @GetMapping("/jogos/novo")
    public String novoJogo(Model model) {
        model.addAttribute("jogo", new Jogo()); // Objeto vazio para criar
        return "produtos/formulario-jogo";
    }

    @GetMapping("/hardware/novo")
    public String novoHardware(Model model) {
        model.addAttribute("hardware", new Hardware());
        return "produtos/formulario-hardware";
    }

    @GetMapping("/colecionaveis/novo")
    public String novoColecionavel(Model model) {
        model.addAttribute("colecionavel", new Colecionavel());
        return "produtos/formulario-colecionavel";
    }

    // --- EDIÇÃO E SALVAMENTO ---

    // Jogos
    @GetMapping("/jogos/editar/{id}")
    public String editarJogo(@PathVariable Long id, Model model) {
        Jogo jogo = jogoRepo.findById(id).orElse(null);
        if(jogo != null) {
            model.addAttribute("jogo", jogo);
            return "produtos/formulario-jogo";
        }
        return "redirect:/gerencia/jogos";
    }

    @PostMapping("/jogos/salvar")
    public String salvarJogo(Jogo jogo) {
        jogoRepo.save(jogo);
        return "redirect:/gerencia/jogos";
    }

    @GetMapping("/jogos/deletar/{id}")
    public String deletarJogo(@PathVariable Long id) {
        jogoRepo.deleteById(id);
        return "redirect:/gerencia/jogos";
    }

    // Hardware
    @GetMapping("/hardware/editar/{id}")
    public String editarHardware(@PathVariable Long id, Model model) {
        Hardware hw = hardwareRepo.findById(id).orElse(null);
        if(hw != null) {
            model.addAttribute("hardware", hw);
            return "produtos/formulario-hardware";
        }
        return "redirect:/gerencia/hardware";
    }

    @PostMapping("/hardware/salvar")
    public String salvarHardware(Hardware hardware) {
        hardwareRepo.save(hardware);
        return "redirect:/gerencia/hardware";
    }

    @GetMapping("/hardware/deletar/{id}")
    public String deletarHardware(@PathVariable Long id) {
        hardwareRepo.deleteById(id);
        return "redirect:/gerencia/hardware";
    }

    // Colecionáveis
    @GetMapping("/colecionaveis/editar/{id}")
    public String editarColecionavel(@PathVariable Long id, Model model) {
        Colecionavel col = colecionavelRepo.findById(id).orElse(null);
        if(col != null) {
            model.addAttribute("colecionavel", col);
            return "produtos/formulario-colecionavel";
        }
        return "redirect:/gerencia/colecionaveis";
    }

    @PostMapping("/colecionaveis/salvar")
    public String salvarColecionavel(Colecionavel colecionavel) {
        colecionavelRepo.save(colecionavel);
        return "redirect:/gerencia/colecionaveis";
    }

    @GetMapping("/colecionaveis/deletar/{id}")
    public String deletarColecionavel(@PathVariable Long id) {
        colecionavelRepo.deleteById(id);
        return "redirect:/gerencia/colecionaveis";
    }
}