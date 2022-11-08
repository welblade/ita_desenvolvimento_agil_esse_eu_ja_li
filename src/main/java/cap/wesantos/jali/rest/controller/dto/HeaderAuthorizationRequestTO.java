package cap.wesantos.jali.rest.controller.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@Builder
public class HeaderAuthorizationRequestTO {

    @NotEmpty
    private String authorization;

    public HeaderAuthorizationRequestTO(String authorization) {
        this.setAuthorization(authorization);
    }

    public void setAuthorization(String token) {
        if (token.contains(" ")) {
            this.authorization = token.split(" ")[1];
        } else {
            this.authorization = token;
        }
    }
}
