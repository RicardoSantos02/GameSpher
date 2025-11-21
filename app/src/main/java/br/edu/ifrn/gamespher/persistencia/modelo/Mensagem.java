package br.edu.ifrn.gamespher.persistencia.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "mensagens")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Mensagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O assunto é obrigatório.")
    @Column(name = "assunto", nullable = false, length = 100)
    private String assunto;

    @NotBlank(message = "O conteúdo da mensagem é obrigatório.")
    @Column(name = "conteudo", nullable = false, columnDefinition = "TEXT")
    private String conteudo;

    @NotNull(message = "A mensagem deve estar associada a um cliente.")
    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @NotNull(message = "A mensagem deve estar associada a um produto.")
    @ManyToOne
    @JoinColumn(name = "produto_id", nullable = false)
    private Produto produto;

    @Column(name = "data_envio", nullable = false)
    private LocalDateTime dataEnvio = LocalDateTime.now();

    @Column(name = "respondida", nullable = false)
    private boolean respondida = false;
}
