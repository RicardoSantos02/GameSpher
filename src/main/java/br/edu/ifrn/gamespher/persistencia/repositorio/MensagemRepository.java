package br.edu.ifrn.gamespher.persistencia.repositorio;

import br.edu.ifrn.gamespher.persistencia.modelo.Mensagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MensagemRepository extends JpaRepository<Mensagem, Long> {
}
