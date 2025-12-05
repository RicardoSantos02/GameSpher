package br.edu.ifrn.gamespher.persistencia.modelo;
import jakarta.persistence.*;
import lombok.*;

@Entity @Table(name = "jogos")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
@PrimaryKeyJoinColumn(name = "id")
public class Jogo extends Produto {
    private String plataforma;
    @Column(name = "ano_lancamento")
    private Integer anoLancamento;
}