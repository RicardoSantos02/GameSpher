package br.edu.ifrn.gamespher.persistencia.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "clientes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long id;

    @NotBlank(message = "O nome é obrigatório.")
    @Size(max = 100, message = "O nome deve ter no máximo 100 caracteres.")
    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @NotBlank(message = "O email é obrigatório.")
    @Email(message = "Email inválido.")
    @Column(name = "email", nullable = false, unique = true, length = 100)
    private String email;

    @NotBlank(message = "A senha é obrigatória.")
    @Column(name = "senha", nullable = false, length = 255)
    private String senha; // Será armazenada como hash

    @Column(name = "telefone", length = 20)
    private String telefone;

    @Column(name = "cpf", unique = true, length = 20)
    private String cpf;

    @Column(name = "cep", length = 10)
    private String cep;

    @Column(name = "endereco", length = 255)
    private String endereco;

    @Column(name = "numero", length = 10)
    private String numero;

    @Column(name = "estado", length = 2)
    private String estado;
}
