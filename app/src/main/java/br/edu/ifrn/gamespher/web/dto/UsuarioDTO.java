package br.edu.ifrn.gamespher.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class UsuarioDTO {
    private String nome;
    private String email;
    private String telefone;
    // A senha não trafega de volta para a tela por segurança
}