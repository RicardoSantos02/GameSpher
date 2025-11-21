package br.edu.ifrn.gamespher.web.controladores;

import br.edu.ifrn.gamespher.persistencia.modelo.Cliente;
import br.edu.ifrn.gamespher.persistencia.repositorio.ClienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/perfil")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PasswordEncoder passwordEncoder; // Necessário para codificar a senha

    // Método auxiliar para obter o email do usuário logado (simulação, pois a autenticação real será mais complexa)
    private String getEmailUsuarioLogado() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated() && !"anonymousUser".equals(authentication.getPrincipal())) {
            // Em um cenário real, o principal seria um objeto UserDetails customizado
            return authentication.getName(); // Retorna o email/username
        }
        // Retorna um email de teste para fins de desenvolvimento, já que a autenticação ainda não está completa
        return "teste@cliente.com";
    }

    // CREATE - Exibir formulário de cadastro (para fins de teste inicial)
    @GetMapping("/cadastro")
    public String exibirFormularioCadastro(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "perfil/formulario-cliente";
    }

    // CREATE - Salvar novo cliente (para fins de teste inicial)
    @PostMapping("/cadastro")
    public String salvarCliente(@Valid @ModelAttribute("cliente") Cliente cliente, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            return "perfil/formulario-cliente";
        }

        // Codificar a senha antes de salvar
        cliente.setSenha(passwordEncoder.encode(cliente.getSenha()));

        clienteRepository.save(cliente);
        attributes.addFlashAttribute("mensagem", "Cadastro realizado com sucesso! Faça login.");
        return "redirect:/login";
    }

    // UPDATE - Exibir formulário de edição
    @GetMapping("/editar")
    public String exibirFormularioEdicao(Model model, RedirectAttributes attributes) {
        String email = getEmailUsuarioLogado();
        Optional<Cliente> clienteOptional = clienteRepository.findByEmail(email);

        if (clienteOptional.isEmpty()) {
            // Se não encontrar, redireciona para o login ou página de erro
            attributes.addFlashAttribute("erro", "Usuário não encontrado. Faça login novamente.");
            return "redirect:/login";
        }

        model.addAttribute("cliente", clienteOptional.get());
        return "perfil/formulario-cliente";
    }

    // UPDATE - Salvar alterações do perfil
    @PostMapping("/salvar")
    public String salvarEdicao(@Valid @ModelAttribute("cliente") Cliente cliente, BindingResult result, RedirectAttributes attributes) {
        // O ID deve ser mantido no formulário (hidden field)
        if (result.hasErrors()) {
            return "perfil/formulario-cliente";
        }

        // Buscar o cliente existente para manter a senha (se não for alterada)
        Optional<Cliente> clienteExistente = clienteRepository.findById(cliente.getId());
        if (clienteExistente.isPresent()) {
            Cliente clienteDB = clienteExistente.get();
            // Se a senha no objeto cliente estiver vazia, mantém a senha antiga
            if (cliente.getSenha() == null || cliente.getSenha().isEmpty()) {
                cliente.setSenha(clienteDB.getSenha());
            } else {
                // Se a senha foi alterada, codifica a nova senha
                cliente.setSenha(passwordEncoder.encode(cliente.getSenha()));
            }
        }

        clienteRepository.save(cliente);
        attributes.addFlashAttribute("mensagem", "Perfil atualizado com sucesso!");
        return "redirect:/perfil/editar";
    }
}
