package br.edu.ifrn.gamespher.persistencia.modelo;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "produtos")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public abstract class Produto {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome; 
    
    @Column(columnDefinition = "TEXT")
    private String descricao;
    
    private BigDecimal preco;

    @Column(name = "imagem_url", columnDefinition = "TEXT")
    private String imagemUrl;

    @Column(name = "loja_url", columnDefinition = "TEXT")
    private String lojaUrl;
}