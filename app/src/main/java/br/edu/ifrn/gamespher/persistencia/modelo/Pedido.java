package br.edu.ifrn.gamespher.persistencia.modelo;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity
@Table(name = "pedidos")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Pedido {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codigo;
    
    @Column(name = "data_pedido")
    private String data;
    
    private BigDecimal total;
    private String status;
    
    @Column(name = "itens_resumo")
    private String itensResumo; // Ex: "FIFA 24, PS5"

    // Relacionamento N:1 (Muitos pedidos pertencem a um usuário)
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}