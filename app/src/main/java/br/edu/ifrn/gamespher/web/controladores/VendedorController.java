package br.edu.ifrn.gamespher.web.controladores; // LINHA CORRIGIDA!

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifrn.gamespher.persistencia.modelo.Vendedor;                 // Importa a entidade Vendedor
import br.edu.ifrn.gamespher.persistencia.repositorio.VendedorRepository; // Importa o repositório de Vendedores
import jakarta.validation.Valid;

@Controller
@RequestMapping("/vendedores") // Define o caminho base do módulo
public class VendedorController {

    @Autowired
    private VendedorRepository vendedorRepository; // Injeta o repositório para acesso ao banco

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
    public String salvar(@Valid @ModelAttribute Vendedor vendedor, BindingResult result, Model model) {
        // Verifica duplicidade de CPF (campo único)
        if (vendedorRepository.findByCpf(vendedor.getCpf()).isPresent()) {
            result.rejectValue("cpf", "erro.duplicado", "Já existe um vendedor com esse CPF");
        }

        if (result.hasErrors()) {
            return "vendedores/formulario-vendedor"; // Retorna para o formulário com os erros
        }

        vendedorRepository.save(vendedor); // Salva o vendedor no banco
        return "redirect:/vendedores";     // Redireciona para a listagem
    }
}