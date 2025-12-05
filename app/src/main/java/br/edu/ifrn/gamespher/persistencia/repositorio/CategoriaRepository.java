package br.edu.ifrn.gamespher.persistencia.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.ifrn.gamespher.persistencia.modelo.Categoria;
import java.util.List;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    List<Categoria> findByGrupo(String grupo);
}