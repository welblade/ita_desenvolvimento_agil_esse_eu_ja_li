package cap.wesantos.jali.rest.controller.dto;

import cap.wesantos.jali.data.enumeration.Funcao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioResponseTO {
    private Long id;

    private String nome;

    private String login;

    private Long pontos;
}
