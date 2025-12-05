package br.edu.ifrn.gamespher.web.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import br.edu.ifrn.gamespher.persistencia.modelo.*;
import br.edu.ifrn.gamespher.persistencia.repositorio.*;

@Controller
@RequestMapping("/gerencia")
public class GerenciaController {

    @Autowired private JogoRepository jogoRepo;
    @Autowired private HardwareRepository hardwareRepo;
    @Autowired private ColecionavelRepository colecionavelRepo;
    @Autowired private CategoriaRepository categoriaRepo;

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

    // --- CATEGORIAS (CRUD Exigido na Atividade) ---
    @GetMapping("/categorias")
    public String listarCategorias(Model model) {
        model.addAttribute("categorias", categoriaRepo.findAll());
        return "gerencia/lista-categorias";
    }
    @GetMapping("/categorias/nova")
    public String novaCategoria(Model model) {
        model.addAttribute("categoria", new Categoria());
        return "gerencia/formulario-categoria";
    }
    @PostMapping("/categorias/salvar")
    public String salvarCategoria(Categoria categoria) {
        categoriaRepo.save(categoria);
        return "redirect:/gerencia/categorias";
    }
    @GetMapping("/categorias/deletar/{id}")
    public String deletarCategoria(@PathVariable Long id) {
        categoriaRepo.deleteById(id);
        return "redirect:/gerencia/categorias";
    }

    // --- PRODUTOS: NOVO (Carrega as categorias) ---
    @GetMapping("/jogos/novo")
    public String novoJogo(Model model) {
        model.addAttribute("jogo", new Jogo());
        model.addAttribute("categorias", categoriaRepo.findByGrupo("JOGO")); 
        return "produtos/formulario-jogo";
    }

    @GetMapping("/hardware/novo")
    public String novoHardware(Model model) {
        model.addAttribute("hardware", new Hardware());
        model.addAttribute("categorias", categoriaRepo.findByGrupo("HARDWARE"));
        return "produtos/formulario-hardware";
    }

    @GetMapping("/colecionaveis/novo")
    public String novoColecionavel(Model model) {
        model.addAttribute("colecionavel", new Colecionavel());
        model.addAttribute("categorias", categoriaRepo.findByGrupo("COLECIONAVEL"));
        return "produtos/formulario-colecionavel";
    }

    // --- PRODUTOS: SALVAR ---
    @PostMapping("/jogos/salvar") public String salvarJogo(Jogo jogo) { jogoRepo.save(jogo); return "redirect:/gerencia/jogos"; }
    @PostMapping("/hardware/salvar") public String salvarHardware(Hardware hardware) { hardwareRepo.save(hardware); return "redirect:/gerencia/hardware"; }
    @PostMapping("/colecionaveis/salvar") public String salvarCol(Colecionavel c) { colecionavelRepo.save(c); return "redirect:/gerencia/colecionaveis"; }
    
    // --- PRODUTOS: EDITAR (CORRIGIDO: Agora carrega as categorias também!) ---
    @GetMapping("/jogos/editar/{id}")
    public String editarJogo(@PathVariable Long id, Model model) {
        Jogo j = jogoRepo.findById(id).orElse(null);
        if(j != null) { 
            model.addAttribute("jogo", j); 
            // CORREÇÃO: Adicionado para aparecer na edição
            model.addAttribute("categorias", categoriaRepo.findByGrupo("JOGO")); 
            return "produtos/formulario-jogo"; 
        }
        return "redirect:/gerencia/jogos";
    }

    @GetMapping("/hardware/editar/{id}")
    public String editarHardware(@PathVariable Long id, Model model) {
        Hardware hw = hardwareRepo.findById(id).orElse(null);
        if(hw != null) { 
            model.addAttribute("hardware", hw);
            // CORREÇÃO: Adicionado para aparecer na edição
            model.addAttribute("categorias", categoriaRepo.findByGrupo("HARDWARE")); 
            return "produtos/formulario-hardware"; 
        }
        return "redirect:/gerencia/hardware";
    }

    @GetMapping("/colecionaveis/editar/{id}")
    public String editarColecionavel(@PathVariable Long id, Model model) {
        Colecionavel col = colecionavelRepo.findById(id).orElse(null);
        if(col != null) { 
            model.addAttribute("colecionavel", col);
            // CORREÇÃO: Adicionado para aparecer na edição
            model.addAttribute("categorias", categoriaRepo.findByGrupo("COLECIONAVEL")); 
            return "produtos/formulario-colecionavel"; 
        }
        return "redirect:/gerencia/colecionaveis";
    }

    // --- PRODUTOS: DELETAR ---
    @GetMapping("/jogos/deletar/{id}") public String delJogo(@PathVariable Long id) { jogoRepo.deleteById(id); return "redirect:/gerencia/jogos"; }
    @GetMapping("/hardware/deletar/{id}") public String delHard(@PathVariable Long id) { hardwareRepo.deleteById(id); return "redirect:/gerencia/hardware"; }
    @GetMapping("/colecionaveis/deletar/{id}") public String delCol(@PathVariable Long id) { colecionavelRepo.deleteById(id); return "redirect:/gerencia/colecionaveis"; }
}