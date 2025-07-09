package br.edu.ifrn.gamespher.persistencia.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "vendedores")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Vendedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "email", nullable = false, unique = true, length = 100)
    private String email;

    @Column(name = "telefone", length = 20)
    private String telefone;

    @Column(name = "cnpj_cpf", nullable = false, unique = true, length = 20)
    private String cnpjCpf;  // CPF ou CNPJ do vendedor

    @Column(name = "tipo", nullable = false, length = 20)
    private String tipo;  // Pessoa Física ou Pessoa Jurídica

}
