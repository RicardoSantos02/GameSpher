package br.edu.ifrn.gamespher.persistencia.repositorio;

import br.edu.ifrn.gamespher.persistencia.modelo.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
