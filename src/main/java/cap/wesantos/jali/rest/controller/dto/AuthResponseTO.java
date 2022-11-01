package cap.wesantos.jali.rest.controller.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthResponseTO {
    private String token;
    private String tipo;
    private String info;
    private String autorizacoes;
}
