package br.edu.ifrn.gamespher.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class ItemCarrinho {
    private Long id;
    private String titulo; // Nome do produto
    private BigDecimal preco;
    private String tipo;   // "Jogo", "Hardware" ou "Colecionavel"
    private String imagem; // Emoji para exibição
}