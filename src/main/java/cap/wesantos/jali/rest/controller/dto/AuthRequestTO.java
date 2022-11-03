package cap.wesantos.jali.rest.controller.dto;


import lombok.*;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthRequestTO {
    @NotEmpty
    private String login;
    @NotEmpty
    private String senha;
}
