package cap.wesantos.jali.domain.service;

import cap.wesantos.jali.core.exception.SenhaInvalidaException;
import cap.wesantos.jali.data.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private PasswordEncoder encoder;

    public UserDetails autenticar(Usuario usuario) {
        UserDetails details = usuarioService.loadUserByUsername(usuario.getLogin());
        if (encoder.matches(usuario.getSenha(), details.getPassword())) {
            return details;
        }
        throw new SenhaInvalidaException();
    }
}
