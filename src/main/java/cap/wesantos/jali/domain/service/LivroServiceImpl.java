package cap.wesantos.jali.domain.service;

import cap.wesantos.jali.core.exception.LivroNaoEncontradoException;
import cap.wesantos.jali.core.security.JwtService;
import cap.wesantos.jali.data.model.Usuario;
import cap.wesantos.jali.data.repository.LivroRepository;
import cap.wesantos.jali.domain.mapper.LivroMapper;
import cap.wesantos.jali.rest.controller.dto.HeaderAuthorizationRequestTO;
import cap.wesantos.jali.rest.controller.dto.LivroResponseTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LivroServiceImpl implements LivroService {

    private final LivroRepository repository;
    private final UsuarioService usuarioService;
    @Override
    public List<LivroResponseTO> listarLivros(HeaderAuthorizationRequestTO authorization) {
        Usuario usuario = this.usuarioService.obterUsuarioUsandoAutorizacao(authorization);
        return repository.listarLivrosEIndicarSeLidoPeloUsuario(usuario)
                .stream()
                .map(LivroMapper.CONVERT::toResponseDTO)
                .collect(Collectors.toList())
        ;
    }

    @Override
    public LivroResponseTO obterPorId(Long id, HeaderAuthorizationRequestTO authorization) {
        Usuario usuario = this.usuarioService.obterUsuarioUsandoAutorizacao(authorization);
        return repository.encontrarLivroPorIdEIndicarSeLidoPeloUsuario(id, usuario)
                .map(LivroMapper.CONVERT::toResponseDTO)
                .orElseThrow(LivroNaoEncontradoException::new);
    }
}
