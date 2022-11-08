package cap.wesantos.jali.domain.service;

import cap.wesantos.jali.core.exception.SenhaInvalidaException;
import cap.wesantos.jali.core.security.JwtService;
import cap.wesantos.jali.rest.controller.dto.AuthRequestTO;
import cap.wesantos.jali.rest.controller.dto.AuthResponseTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private UsuarioServiceImpl usuarioServiceImpl;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private PasswordEncoder encoder;

    public AuthResponseTO autenticar(AuthRequestTO authRequest) {
        UserDetails details = usuarioServiceImpl.loadUserByUsername(authRequest.getLogin());

        if (encoder.matches(authRequest.getSenha(), details.getPassword())) {
            String token = jwtService.gerarToken(details.getUsername());
            return new AuthResponseTO(token, "USER", details.getUsername(), "");
        }
        throw new SenhaInvalidaException();
    }
}
