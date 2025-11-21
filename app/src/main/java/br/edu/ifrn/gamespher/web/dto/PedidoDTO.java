package br.edu.ifrn.gamespher.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class PedidoDTO {
    private String codigo;
    private String data;
    private String total;
    private String status;
}