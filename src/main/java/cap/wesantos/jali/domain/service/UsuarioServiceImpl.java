package cap.wesantos.jali.domain.service;

import cap.wesantos.jali.data.model.Usuario;
import cap.wesantos.jali.data.repository.UsuarioRepository;
import cap.wesantos.jali.domain.mapper.UsuarioMapper;
import cap.wesantos.jali.rest.controller.dto.UsuarioResponseTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UserDetailsService, UsuarioService {

    @Autowired
    UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = repository.findByLogin(username)
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

    @Override
    public UsuarioResponseTO obterUsuarioPorId(Long usuarioId) {
        return repository.findById(usuarioId).map(UsuarioMapper.CONVERT::toResponseTO)
                .orElseThrow();
    }
}
