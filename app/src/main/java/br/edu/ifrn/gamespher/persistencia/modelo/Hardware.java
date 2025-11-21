package br.edu.ifrn.gamespher.persistencia.modelo;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity @Table(name = "hardware")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Hardware {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_hardware")
    private Long id;
    private String nome;
    private String fabricante;
    private String categoria;
    private String plataforma;
    
    @Column(columnDefinition = "TEXT")
    private String descricao;
    
    private BigDecimal preco;

    @Column(name = "imagem_url")
    private String imagemUrl;

    @Column(name = "loja_url")
    private String lojaUrl;
}