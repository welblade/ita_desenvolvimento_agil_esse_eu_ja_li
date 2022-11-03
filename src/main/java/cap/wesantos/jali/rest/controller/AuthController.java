package cap.wesantos.jali.rest.controller;

import cap.wesantos.jali.core.exception.SenhaInvalidaException;
import cap.wesantos.jali.domain.service.AuthService;
import cap.wesantos.jali.rest.controller.dto.AuthRequestTO;
import cap.wesantos.jali.rest.controller.dto.AuthResponseTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService service;

    @PostMapping
    public AuthResponseTO login(@RequestBody AuthRequestTO authRequest) {
        try {
            return service.autenticar(authRequest);
        } catch (UsernameNotFoundException | SenhaInvalidaException ex) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, ex.getMessage());
        }
    }
}
