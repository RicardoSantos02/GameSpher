package br.edu.ifrn.gamespher.web.controladores;

import br.edu.ifrn.gamespher.persistencia.modelo.Cliente;
import br.edu.ifrn.gamespher.persistencia.modelo.Mensagem;
import br.edu.ifrn.gamespher.persistencia.modelo.Produto;
import br.edu.ifrn.gamespher.persistencia.modelo.Reembolso;
import br.edu.ifrn.gamespher.persistencia.repositorio.ClienteRepository;
import br.edu.ifrn.gamespher.persistencia.repositorio.MensagemRepository;
import br.edu.ifrn.gamespher.persistencia.repositorio.ProdutoRepository;
import br.edu.ifrn.gamespher.persistencia.repositorio.ReembolsoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/suporte")
public class SuporteController {

    @Autowired
    private MensagemRepository mensagemRepository;

    @Autowired
    private ReembolsoRepository reembolsoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    // Método auxiliar para obter o cliente logado
    private Optional<Cliente> getClienteLogado() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated() && authentication.getPrincipal() instanceof User) {
            String email = authentication.getName();
            return clienteRepository.findByEmail(email);
        }
        return Optional.empty();
    }

    // Exibir página de contato/suporte
    @GetMapping("/contato/{produtoId}")
    @PreAuthorize("isAuthenticated()")
    public String exibirFormularioContato(@PathVariable("produtoId") Long produtoId, Model model, RedirectAttributes attributes) {
        Optional<Produto> produtoOptional = produtoRepository.findById(produtoId);
        if (produtoOptional.isEmpty()) {
            attributes.addFlashAttribute("erro", "Produto não encontrado.");
            return "redirect:/inicio";
        }

        model.addAttribute("produto", produtoOptional.get());
        model.addAttribute("mensagem", new Mensagem());
        return "suporte/formulario-contato";
    }

    // Enviar mensagem direta ao vendedor
    @PostMapping("/contato/enviar")
    @PreAuthorize("hasRole('CLIENTE')")
    public String enviarMensagem(@Valid @ModelAttribute("mensagem") Mensagem mensagem, BindingResult result, RedirectAttributes attributes) {
        Optional<Cliente> clienteOptional = getClienteLogado();
        if (clienteOptional.isEmpty()) {
            attributes.addFlashAttribute("erro", "Você precisa estar logado como cliente para enviar uma mensagem.");
            return "redirect:/login";
        }

        if (result.hasErrors()) {
            // Se houver erro, precisamos do produto novamente no modelo
            Optional<Produto> produtoOptional = produtoRepository.findById(mensagem.getProduto().getId());
            produtoOptional.ifPresent(produto -> mensagem.setProduto(produto));
            return "suporte/formulario-contato";
        }

        mensagem.setCliente(clienteOptional.get());
        mensagemRepository.save(mensagem);
        attributes.addFlashAttribute("mensagem", "Mensagem enviada com sucesso ao vendedor!");
        return "redirect:/inicio";
    }

    // Exibir formulário de solicitação de reembolso
    @GetMapping("/reembolso/{produtoId}")
    @PreAuthorize("isAuthenticated()")
    public String exibirFormularioReembolso(@PathVariable("produtoId") Long produtoId, Model model, RedirectAttributes attributes) {
        Optional<Produto> produtoOptional = produtoRepository.findById(produtoId);
        if (produtoOptional.isEmpty()) {
            attributes.addFlashAttribute("erro", "Produto não encontrado.");
            return "redirect:/inicio";
        }

        model.addAttribute("produto", produtoOptional.get());
        model.addAttribute("reembolso", new Reembolso());
        return "suporte/formulario-reembolso";
    }

    // Solicitar reembolso
    @PostMapping("/reembolso/solicitar")
    @PreAuthorize("hasRole('CLIENTE')")
    public String solicitarReembolso(@Valid @ModelAttribute("reembolso") Reembolso reembolso, BindingResult result, RedirectAttributes attributes) {
        Optional<Cliente> clienteOptional = getClienteLogado();
        if (clienteOptional.isEmpty()) {
            attributes.addFlashAttribute("erro", "Você precisa estar logado como cliente para solicitar reembolso.");
            return "redirect:/login";
        }

        if (result.hasErrors()) {
            // Se houver erro, precisamos do produto novamente no modelo
            Optional<Produto> produtoOptional = produtoRepository.findById(reembolso.getProduto().getId());
            produtoOptional.ifPresent(produto -> reembolso.setProduto(produto));
            return "suporte/formulario-reembolso";
        }

        reembolso.setCliente(clienteOptional.get());
        reembolsoRepository.save(reembolso);
        attributes.addFlashAttribute("mensagem", "Solicitação de reembolso enviada com sucesso! Aguarde a análise.");
        return "redirect:/inicio";
    }
}
