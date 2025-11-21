package br.edu.ifrn.gamespher.web.controladores;

import br.edu.ifrn.gamespher.persistencia.modelo.Produto;
import br.edu.ifrn.gamespher.persistencia.repositorio.ProdutoRepository;
import br.edu.ifrn.gamespher.persistencia.repositorio.VendedorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/produtos")
@PreAuthorize("hasRole('VENDEDOR')")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private VendedorRepository vendedorRepository;

    // READ - Listar todos os produtos
    @GetMapping
    public String listarProdutos(Model model) {
        model.addAttribute("produtos", produtoRepository.findAll());
        return "produtos/lista-produtos";
    }

    // CREATE - Exibir formulário de cadastro
    @GetMapping("/novo")
    public String exibirFormularioCadastro(Model model) {
        model.addAttribute("produto", new Produto());
        model.addAttribute("vendedores", vendedorRepository.findAll()); // Para selecionar o vendedor
        return "produtos/formulario-produto";
    }

    // CREATE - Salvar novo produto
    @PostMapping("/salvar")
    public String salvarProduto(@Valid @ModelAttribute("produto") Produto produto, BindingResult result, RedirectAttributes attributes, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("vendedores", vendedorRepository.findAll());
            return "produtos/formulario-produto";
        }
        produtoRepository.save(produto);
        attributes.addFlashAttribute("mensagem", "Produto salvo com sucesso!");
        return "redirect:/produtos";
    }

    // UPDATE - Exibir formulário de edição
    @GetMapping("/editar/{id}")
    public String exibirFormularioEdicao(@PathVariable("id") Long id, Model model, RedirectAttributes attributes) {
        Optional<Produto> produtoOptional = produtoRepository.findById(id);
        if (produtoOptional.isEmpty()) {
            attributes.addFlashAttribute("erro", "Produto não encontrado.");
            return "redirect:/produtos";
        }
        model.addAttribute("produto", produtoOptional.get());
        model.addAttribute("vendedores", vendedorRepository.findAll());
        return "produtos/formulario-produto";
    }

    // DELETE - Excluir produto
    @GetMapping("/excluir/{id}")
    public String excluirProduto(@PathVariable("id") Long id, RedirectAttributes attributes) {
        if (produtoRepository.existsById(id)) {
            produtoRepository.deleteById(id);
            attributes.addFlashAttribute("mensagem", "Produto excluído com sucesso!");
        } else {
            attributes.addFlashAttribute("erro", "Produto não encontrado.");
        }
        return "redirect:/produtos";
    }
}
