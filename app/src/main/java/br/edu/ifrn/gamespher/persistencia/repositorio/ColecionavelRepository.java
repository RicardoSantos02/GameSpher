package br.edu.ifrn.gamespher.persistencia.repositorio;
import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.ifrn.gamespher.persistencia.modelo.Colecionavel;
public interface ColecionavelRepository extends JpaRepository<Colecionavel, Long> {}