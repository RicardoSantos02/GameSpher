package br.edu.ifrn.gamespher.persistencia.modelo;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "hardware")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
@PrimaryKeyJoinColumn(name = "id")
public class Hardware extends Produto {
    private String fabricante;
    private String categoria;
    private String plataforma;
}