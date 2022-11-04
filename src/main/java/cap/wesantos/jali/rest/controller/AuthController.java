package cap.wesantos.jali.rest.controller;

import cap.wesantos.jali.domain.service.AuthService;
import cap.wesantos.jali.rest.controller.dto.AuthRequestTO;
import cap.wesantos.jali.rest.controller.dto.AuthResponseTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService service;

    @PostMapping
    public AuthResponseTO logar(@RequestBody AuthRequestTO authRequest) {
        return service.autenticar(authRequest);
    }
}
