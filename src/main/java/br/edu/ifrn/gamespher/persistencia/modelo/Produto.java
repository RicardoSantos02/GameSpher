package br.edu.ifrn.gamespher.persistencia.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "produtos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produto")
    private Long id;

    @NotBlank(message = "O nome é obrigatório.")
    @Size(max = 100, message = "O nome deve ter no máximo 100 caracteres.")
    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Size(max = 500, message = "A descrição deve ter no máximo 500 caracteres.")
    @Column(name = "descricao", length = 500)
    private String descricao;

    @NotNull(message = "O preço é obrigatório.")
    @DecimalMin(value = "0.01", message = "O preço deve ser maior que zero.")
    @Column(name = "preco", nullable = false, precision = 10, scale = 2)
    private BigDecimal preco;

    @NotNull(message = "A quantidade em estoque é obrigatória.")
    @Min(value = 0, message = "A quantidade não pode ser negativa.")
    @Column(name = "quantidade_estoque", nullable = false)
    private Integer quantidadeEstoque;

    @NotBlank(message = "A categoria é obrigatória.")
    @Column(name = "categoria", nullable = false, length = 50)
    private String categoria; // Ex: "Jogos", "Consoles", "Acessórios"

    @Column(name = "url_imagem", length = 255)
    private String urlImagem;

    // Relacionamento Muitos para Um (N:1) com Vendedor
    @ManyToOne
    @JoinColumn(name = "vendedor_id", nullable = false) // Chave estrangeira
    @NotNull(message = "O produto deve estar associado a um vendedor.")
    private Vendedor vendedor;
}
