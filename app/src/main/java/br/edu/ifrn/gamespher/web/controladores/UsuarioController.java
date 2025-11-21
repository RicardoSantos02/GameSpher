package br.edu.ifrn.gamespher.web.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.ifrn.gamespher.persistencia.modelo.Pedido; // <--- IMPORTANTE: Usa a Entidade
import br.edu.ifrn.gamespher.persistencia.modelo.Usuario;
import br.edu.ifrn.gamespher.persistencia.repositorio.PedidoRepository;
import br.edu.ifrn.gamespher.persistencia.repositorio.UsuarioRepository;
import jakarta.servlet.http.HttpSession;

@Controller
public class UsuarioController {

    @Autowired private UsuarioRepository usuarioRepository;
    @Autowired private PedidoRepository pedidoRepository; 

    // --- CADASTRO ---
    @GetMapping("/usuarios/novo")
    public String novoUsuario() {
        return "usuarios/formulario-usuario";
    }

    @PostMapping("/usuarios/novo")
    public String salvarUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
        return "redirect:/login";
    }

    // --- PERFIL ---
    @GetMapping("/perfil")
    public String perfil(HttpSession session, Model model) {
        Usuario usuarioSessao = (Usuario) session.getAttribute("usuarioLogado");
        if (usuarioSessao == null) return "redirect:/login";

        // Recarrega do banco para garantir dados atualizados
        Usuario usuarioAtualizado = usuarioRepository.findById(usuarioSessao.getId()).orElse(usuarioSessao);
        
        model.addAttribute("usuario", usuarioAtualizado);
        model.addAttribute("usuarioLogado", usuarioAtualizado.getNome());
        return "usuarios/perfil";
    }

    @PostMapping("/perfil/salvar")
    public String salvarPerfil(@ModelAttribute Usuario usuarioForm, @RequestParam String senhaConfirmacao, HttpSession session) {
        Usuario usuarioSessao = (Usuario) session.getAttribute("usuarioLogado");
        if (usuarioSessao == null) return "redirect:/login";

        // Verifica senha
        if (!usuarioSessao.getSenha().equals(senhaConfirmacao)) {
            return "redirect:/perfil?erro=senha";
        }

        // Atualiza no Banco
        Usuario usuarioBanco = usuarioRepository.findById(usuarioSessao.getId()).get();
        usuarioBanco.setNome(usuarioForm.getNome());
        usuarioBanco.setEmail(usuarioForm.getEmail());
        usuarioBanco.setTelefone(usuarioForm.getTelefone());
        
        usuarioRepository.save(usuarioBanco);
        
        // Atualiza Sessão
        session.setAttribute("usuarioLogado", usuarioBanco);

        return "redirect:/perfil?sucesso=true";
    }

    // --- EXCLUIR CONTA ---
    @GetMapping("/usuarios/deletar")
    public String deletarConta(HttpSession session) {
        Usuario usuarioSessao = (Usuario) session.getAttribute("usuarioLogado");
        if (usuarioSessao != null) {
            usuarioRepository.deleteById(usuarioSessao.getId());
            session.invalidate();
        }
        return "redirect:/";
    }

    // --- MEUS PEDIDOS (CORRIGIDO) ---
    @GetMapping("/meus-pedidos")
    public String meusPedidos(@RequestParam(required = false) Boolean sucesso, HttpSession session, Model model) {
        // 1. Pega o usuário logado
        Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
        if (usuario == null) return "redirect:/login";
        
        model.addAttribute("usuarioLogado", usuario.getNome());

        if (sucesso != null && sucesso) {
            model.addAttribute("mensagem", "Compra realizada com sucesso!");
        }
        
        // 2. BUSCA REAL NO BANCO DE DADOS
        // O erro acontecia porque aqui estava buscando da "session" (DTO antigo)
        // Agora buscamos do "repository" (Entidade nova com itensResumo)
        List<Pedido> pedidos = pedidoRepository.findByUsuario(usuario);
        
        model.addAttribute("listaPedidos", pedidos);
        
        return "usuarios/meus-pedidos";
    }
}