package br.edu.ifrn.gamespher.persistencia.modelo;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity @Table(name = "colecionaveis")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Colecionavel {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String franquia;
    @Column(name = "tipo_item")
    private String tipoItem;
    @Column(name = "edicao_exclusiva")
    private Boolean edicaoExclusiva;
    private BigDecimal preco;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    @Column(name = "imagem_url")
    private String imagemUrl;

    @Column(name = "loja_url")
    private String lojaUrl;
}