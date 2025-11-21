package br.edu.ifrn.gamespher.persistencia.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.ifrn.gamespher.persistencia.modelo.Pedido;
import br.edu.ifrn.gamespher.persistencia.modelo.Usuario;
import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    // Buscar pedidos de um usuário específico
    List<Pedido> findByUsuario(Usuario usuario);
}