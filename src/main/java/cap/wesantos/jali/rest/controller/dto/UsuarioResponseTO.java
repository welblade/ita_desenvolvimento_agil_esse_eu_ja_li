package cap.wesantos.jali.rest.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
