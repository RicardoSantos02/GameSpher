package br.edu.ifrn.gamespher.persistencia.repositorio;
import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.ifrn.gamespher.persistencia.modelo.Hardware;
public interface HardwareRepository extends JpaRepository<Hardware, Long> {}