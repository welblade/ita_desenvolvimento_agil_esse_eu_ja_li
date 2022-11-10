package cap.wesantos.jali.domain.service;

import cap.wesantos.jali.core.exception.UsuarioNaoEncontradoException;
import cap.wesantos.jali.core.security.JwtService;
import cap.wesantos.jali.data.model.Usuario;
import cap.wesantos.jali.data.repository.UsuarioRepository;
import cap.wesantos.jali.domain.mapper.UsuarioMapper;
import cap.wesantos.jali.rest.controller.dto.HeaderAuthorizationRequestTO;
import cap.wesantos.jali.rest.controller.dto.PerfilUsuarioResponseTO;
import cap.wesantos.jali.rest.controller.dto.UsuarioResponseTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UsuarioServiceImpl implements UserDetailsService, UsuarioService {

    private final JwtService jwtService;
    private final UsuarioRepository repository;

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

    @Override
    public List<UsuarioResponseTO> obterRankingLeitura() {
        return repository.findAll(Sort.by("pontos").descending())
                .stream()
                .map(UsuarioMapper.CONVERT::toResponseTO)
                .collect(Collectors.toList());
    }

    @Override
    public PerfilUsuarioResponseTO obterPerfilUsuarioPorId(Long usuarioId) {
        return repository.findById(usuarioId).map(UsuarioMapper.CONVERT::toPerfilResponseTO)
                .orElseThrow(UsuarioNaoEncontradoException::new);
    }

    @Override
    public PerfilUsuarioResponseTO obterPerfilUsuarioPorAutorizacao(HeaderAuthorizationRequestTO authorization) {
        return UsuarioMapper.CONVERT.toPerfilResponseTO(obterUsuarioUsandoAutorizacao(authorization));
    }

    public Usuario obterUsuarioUsandoAutorizacao(HeaderAuthorizationRequestTO authorization) {
        String login = jwtService.obterLoginUsuario(authorization.getAuthorization());
        return repository.findByLogin(login)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não autenticado."));
    }
}
