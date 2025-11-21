package br.edu.ifrn.gamespher.web.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import br.edu.ifrn.gamespher.persistencia.modelo.Pedido;
import br.edu.ifrn.gamespher.persistencia.repositorio.PedidoRepository;

@Controller
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired private PedidoRepository pedidoRepository;

    // UPDATE: Mostrar formulário de edição
    @GetMapping("/editar/{id}")
    public String editarPedido(@PathVariable Long id, Model model) {
        Pedido pedido = pedidoRepository.findById(id).orElse(null);
        if (pedido != null) {
            model.addAttribute("pedido", pedido);
            return "usuarios/editar-pedido"; // Vamos criar este HTML
        }
        return "redirect:/meus-pedidos";
    }

    // UPDATE: Salvar alterações
    @PostMapping("/salvar")
    public String salvarEdicao(Pedido pedido) {
        // Recarrega o original para não perder o usuário dono do pedido
        Pedido original = pedidoRepository.findById(pedido.getId()).get();
        original.setStatus(pedido.getStatus()); // Só permitimos mudar o status por segurança
        // original.setTotal(pedido.getTotal()); // Poderia permitir mudar total se quisesse
        
        pedidoRepository.save(original);
        return "redirect:/meus-pedidos";
    }

    // DELETE: Excluir pedido
    @GetMapping("/deletar/{id}")
    public String deletarPedido(@PathVariable Long id) {
        pedidoRepository.deleteById(id);
        return "redirect:/meus-pedidos";
    }
}