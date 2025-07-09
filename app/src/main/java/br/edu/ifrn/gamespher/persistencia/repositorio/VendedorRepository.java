package br.edu.ifrn.gamespher.persistencia.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifrn.gamespher.persistencia.modelo.Vendedor;

// Interface que oferece as operações CRUD para a entidade Vendedor
public interface VendedorRepository extends JpaRepository<Vendedor, Long> {

    // Método para buscar um vendedor pelo CNPJ ou CPF (campo único) para validar duplicidade
    Optional<Vendedor> findByCnpjCpf(String cnpjCpf);

}
