package br.edu.ifrn.gamespher.config;

import br.edu.ifrn.gamespher.persistencia.modelo.Cliente;
import br.edu.ifrn.gamespher.persistencia.modelo.Vendedor;
import br.edu.ifrn.gamespher.persistencia.repositorio.ClienteRepository;
import br.edu.ifrn.gamespher.persistencia.repositorio.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private VendedorRepository vendedorRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 1. Tenta buscar como Cliente
        Optional<Cliente> clienteOptional = clienteRepository.findByEmail(username);
        if (clienteOptional.isPresent()) {
            Cliente cliente = clienteOptional.get();
            return User.withUsername(cliente.getEmail())
                    .password(cliente.getSenha())
                    .roles("CLIENTE")
                    .build();
        }

        // 2. Tenta buscar como Vendedor
        Optional<Vendedor> vendedorOptional = vendedorRepository.findByEmail(username);
        if (vendedorOptional.isPresent()) {
            Vendedor vendedor = vendedorOptional.get();
            return User.withUsername(vendedor.getEmail())
                    .password(vendedor.getSenha())
                    .roles("VENDEDOR")
                    .build();
        }

        throw new UsernameNotFoundException("Usuário não encontrado: " + username);
    }
}
