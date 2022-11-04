package cap.wesantos.jali.domain.service;

import cap.wesantos.jali.data.model.Usuario;
import cap.wesantos.jali.data.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = (Usuario) repository.findByLogin(username)
                .orElseThrow(
                        () -> new UsernameNotFoundException("Usuário não encontrado na base de dados.")
                );

        return User
                .builder()
                .username(usuario.getLogin())
                .password(usuario.getSenha())
                .roles(usuario.getFuncao().name())
                .build();
    }
}
