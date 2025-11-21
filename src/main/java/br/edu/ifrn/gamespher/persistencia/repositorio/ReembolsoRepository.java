package br.edu.ifrn.gamespher.persistencia.repositorio;

import br.edu.ifrn.gamespher.persistencia.modelo.Reembolso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReembolsoRepository extends JpaRepository<Reembolso, Long> {
}
