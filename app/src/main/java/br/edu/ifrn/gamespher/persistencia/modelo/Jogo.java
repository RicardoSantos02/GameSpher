package br.edu.ifrn.gamespher.persistencia.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;

@Entity
@Table(name = "jogos")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Jogo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String plataforma;
    private String tipo; // Físico ou Digital
    private BigDecimal preco;
    
    @Column(name = "ano_lancamento")
    private Integer anoLancamento;
}