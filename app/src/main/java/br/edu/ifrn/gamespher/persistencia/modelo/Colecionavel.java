package br.edu.ifrn.gamespher.persistencia.modelo;
import jakarta.persistence.*;
import lombok.*;

@Entity @Table(name = "colecionaveis")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
@PrimaryKeyJoinColumn(name = "id")
public class Colecionavel extends Produto {
    private String franquia;
    @Column(name = "edicao_exclusiva")
    private Boolean edicaoExclusiva;
}