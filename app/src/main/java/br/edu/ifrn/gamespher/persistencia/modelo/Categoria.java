package br.edu.ifrn.gamespher.persistencia.modelo;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "categorias")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Categoria {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome; // Ex: "Console", "Mídia Física"
    
    private String grupo; // "JOGO", "HARDWARE", "COLECIONAVEL"

    @OneToMany(mappedBy = "categoria")
    private List<Produto> produtos;
}