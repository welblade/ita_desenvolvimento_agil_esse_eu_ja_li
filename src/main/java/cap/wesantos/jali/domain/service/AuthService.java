package cap.wesantos.jali.domain.service;

import cap.wesantos.jali.rest.controller.dto.AuthRequestTO;
import cap.wesantos.jali.rest.controller.dto.AuthResponseTO;

public interface AuthService {
    AuthResponseTO autenticar(AuthRequestTO usuario);
}
