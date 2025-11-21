package br.edu.ifrn.gamespher.persistencia.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.ifrn.gamespher.persistencia.modelo.Jogo;

public interface JogoRepository extends JpaRepository<Jogo, Long> {
    // Aqui podemos adicionar buscas, ex: findByPlataforma(String plataforma);
}
