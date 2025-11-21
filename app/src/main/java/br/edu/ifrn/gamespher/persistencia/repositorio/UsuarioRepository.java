package br.edu.ifrn.gamespher.persistencia.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.ifrn.gamespher.persistencia.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // Método mágico para encontrar pelo email
    Usuario findByEmail(String email);
}