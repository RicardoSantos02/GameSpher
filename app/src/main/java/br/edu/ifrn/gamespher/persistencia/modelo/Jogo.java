package br.edu.ifrn.gamespher.persistencia.modelo;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity
@Table(name = "jogos")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Jogo {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String plataforma;
    private String tipo;
    private BigDecimal preco;
    
    @Column(name = "ano_lancamento")
    private Integer anoLancamento;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    @Column(name = "imagem_url")
    private String imagemUrl;

    @Column(name = "loja_url")
    private String lojaUrl;
}