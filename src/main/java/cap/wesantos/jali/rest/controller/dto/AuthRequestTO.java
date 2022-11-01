package cap.wesantos.jali.rest.controller.dto;


import lombok.*;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthRequestTO {
    @NotEmpty
    private String nomeUsuario;
    @NotEmpty
    private String senha;
}
