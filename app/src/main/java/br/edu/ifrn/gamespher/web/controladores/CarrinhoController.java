package br.edu.ifrn.gamespher.web.controladores;

import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifrn.gamespher.persistencia.modelo.Jogo;
import br.edu.ifrn.gamespher.persistencia.modelo.Hardware;
import br.edu.ifrn.gamespher.persistencia.modelo.Colecionavel;
import br.edu.ifrn.gamespher.persistencia.repositorio.JogoRepository;
import br.edu.ifrn.gamespher.persistencia.repositorio.HardwareRepository;
import br.edu.ifrn.gamespher.persistencia.repositorio.ColecionavelRepository;
import br.edu.ifrn.gamespher.web.dto.ItemCarrinho;
import br.edu.ifrn.gamespher.web.dto.PedidoDTO; // Importamos o novo DTO
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/carrinho")
public class CarrinhoController {

    @Autowired private JogoRepository jogoRepo;
    @Autowired private HardwareRepository hardwareRepo;
    @Autowired private ColecionavelRepository colecionavelRepo;

    @GetMapping
    public String verCarrinho(HttpSession session, Model model) {
        List<ItemCarrinho> carrinho = obterCarrinho(session);
        BigDecimal total = calcularTotal(carrinho);

        model.addAttribute("itens", carrinho);
        model.addAttribute("total", total);
        return "carrinho";
    }

    @GetMapping("/adicionar/{tipo}/{id}")
    public String adicionarItem(@PathVariable String tipo, @PathVariable Long id, HttpSession session) {
        List<ItemCarrinho> carrinho = obterCarrinho(session);
        ItemCarrinho novoItem = null;

        if ("jogo".equals(tipo)) {
            Jogo j = jogoRepo.findById(id).orElse(null);
            if (j != null) novoItem = new ItemCarrinho(j.getId(), j.getTitulo(), j.getPreco(), "Jogo", "🎮");
        } else if ("hardware".equals(tipo)) {
            Hardware h = hardwareRepo.findById(id).orElse(null);
            if (h != null) novoItem = new ItemCarrinho(h.getId(), h.getNome(), h.getPreco(), "Hardware", "🖥️");
        } else if ("colecionavel".equals(tipo)) {
            Colecionavel c = colecionavelRepo.findById(id).orElse(null);
            if (c != null) novoItem = new ItemCarrinho(c.getId(), c.getNome(), c.getPreco(), "Colecionável", "🏆");
        }

        if (novoItem != null) carrinho.add(novoItem);
        return "redirect:/carrinho";
    }

    @GetMapping("/remover/{indice}")
    public String removerItem(@PathVariable int indice, HttpSession session) {
        List<ItemCarrinho> carrinho = obterCarrinho(session);
        if (indice >= 0 && indice < carrinho.size()) carrinho.remove(indice);
        return "redirect:/carrinho";
    }

    // FINALIZAR COMPRA ATUALIZADO
    @GetMapping("/finalizar")
    public String finalizarCompra(HttpSession session) {
        List<ItemCarrinho> carrinho = obterCarrinho(session);
        if (carrinho.isEmpty()) return "redirect:/carrinho";

        // 1. Cria o Pedido
        BigDecimal total = calcularTotal(carrinho);
        String codigo = "PED-" + (1000 + new Random().nextInt(9000));
        String data = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        
        PedidoDTO novoPedido = new PedidoDTO(codigo, data, "R$ " + total.toString(), "Processando");

        // 2. Salva na lista de pedidos da sessão
        List<PedidoDTO> meusPedidos = obterMeusPedidos(session);
        meusPedidos.add(0, novoPedido); // Adiciona no topo da lista

        // 3. Limpa o carrinho
        session.removeAttribute("carrinho");
        
        return "redirect:/meus-pedidos?sucesso=true";
    }

    @SuppressWarnings("unchecked")
    private List<ItemCarrinho> obterCarrinho(HttpSession session) {
        List<ItemCarrinho> carrinho = (List<ItemCarrinho>) session.getAttribute("carrinho");
        if (carrinho == null) {
            carrinho = new ArrayList<>();
            session.setAttribute("carrinho", carrinho);
        }
        return carrinho;
    }

    @SuppressWarnings("unchecked")
    private List<PedidoDTO> obterMeusPedidos(HttpSession session) {
        List<PedidoDTO> pedidos = (List<PedidoDTO>) session.getAttribute("meusPedidos");
        if (pedidos == null) {
            pedidos = new ArrayList<>();
            session.setAttribute("meusPedidos", pedidos);
        }
        return pedidos;
    }

    private BigDecimal calcularTotal(List<ItemCarrinho> carrinho) {
        return carrinho.stream().map(ItemCarrinho::getPreco).reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}