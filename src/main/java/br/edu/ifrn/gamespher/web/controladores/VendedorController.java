package br.edu.ifrn.gamespher.web.controladores; // LINHA CORRIGIDA!

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

import br.edu.ifrn.gamespher.persistencia.modelo.Vendedor;                 // Importa a entidade Vendedor
import br.edu.ifrn.gamespher.persistencia.repositorio.VendedorRepository; // Importa o repositório de Vendedores
import jakarta.validation.Valid;

@Controller
@RequestMapping("/vendedores") // Define o caminho base do módulo
public class VendedorController {

    @Autowired
    private VendedorRepository vendedorRepository; // Injeta o repositório para acesso ao banco

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Lista todos os vendedores cadastrados
    @GetMapping
    public String listar(Model model) {
        List<Vendedor> vendedores = vendedorRepository.findAll();            // Busca todos os vendedores
        model.addAttribute("vendedores", vendedores);                        // Adiciona ao modelo para exibição na view
        return "vendedores/lista-vendedores";                                // Retorna a view de listagem
    }

    // Mostra o formulário de novo vendedor
    @GetMapping("/novo")
    public String formulario(Model model) {
        model.addAttribute("vendedor", new Vendedor());                      // Cria um objeto vazio para o formulário
        return "vendedores/formulario-vendedor";                             // Retorna a view do formulário
    }

    // Salva um novo vendedor no banco
    @PostMapping
    public String salvar(@Valid @ModelAttribute Vendedor vendedor, BindingResult result, Model model, RedirectAttributes attributes) {
        // Verifica duplicidade de CPF (campo único)
        Optional<Vendedor> vendedorExistente = vendedorRepository.findByCpf(vendedor.getCpf());
        if (vendedorExistente.isPresent() && (vendedor.getId() == null || !vendedorExistente.get().getId().equals(vendedor.getId()))) {
            result.rejectValue("cpf", "erro.duplicado", "Já existe um vendedor com esse CPF");
        }

        if (result.hasErrors()) {
            return "vendedores/formulario-vendedor"; // Retorna para o formulário com os erros
        }

        // Lógica para manter a senha em caso de edição sem alteração de senha
        if (vendedor.getId() != null) {
            Optional<Vendedor> vendedorDB = vendedorRepository.findById(vendedor.getId());
            if (vendedorDB.isPresent()) {
                // Se a senha não foi preenchida no formulário, mantém a senha antiga
                if (vendedor.getSenha() == null || vendedor.getSenha().isEmpty()) {
                    vendedor.setSenha(vendedorDB.get().getSenha());
                } else {
                    // Se a senha foi preenchida, codifica a nova senha
                    vendedor.setSenha(passwordEncoder.encode(vendedor.getSenha()));
                }
            }
        } else {
            // Novo cadastro: codifica a senha
            vendedor.setSenha(passwordEncoder.encode(vendedor.getSenha()));
        }

        vendedorRepository.save(vendedor); // Salva o vendedor no banco
        attributes.addFlashAttribute("mensagem", "Vendedor salvo com sucesso!");
        return "redirect:/vendedores";     // Redireciona para a listagem
    }

    // UPDATE - Exibir formulário de edição
    @GetMapping("/editar/{id}")
    public String exibirFormularioEdicao(@PathVariable("id") Long id, Model model, RedirectAttributes attributes) {
        Optional<Vendedor> vendedorOptional = vendedorRepository.findById(id);
        if (vendedorOptional.isEmpty()) {
            attributes.addFlashAttribute("erro", "Vendedor não encontrado.");
            return "redirect:/vendedores";
        }
        Vendedor vendedor = vendedorOptional.get();
        // Limpa a senha para não ser exibida no formulário de edição
        vendedor.setSenha(null);
        model.addAttribute("vendedor", vendedor);
        return "vendedores/formulario-vendedor";
    }

    // DELETE - Excluir vendedor
    @GetMapping("/excluir/{id}")
    public String excluirVendedor(@PathVariable("id") Long id, RedirectAttributes attributes) {
        // Adicionar verificação se o vendedor possui produtos antes de excluir
        if (vendedorRepository.existsById(id)) {
            vendedorRepository.deleteById(id);
            attributes.addFlashAttribute("mensagem", "Vendedor excluído com sucesso!");
        } else {
            attributes.addFlashAttribute("erro", "Vendedor não encontrado.");
        }
        return "redirect:/vendedores";
    }
}