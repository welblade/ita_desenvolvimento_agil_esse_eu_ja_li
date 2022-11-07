package cap.wesantos.jali.domain.service;

import cap.wesantos.jali.core.exception.LivroNaoEncontradoException;
import cap.wesantos.jali.core.security.JwtService;
import cap.wesantos.jali.data.repository.LivroRepository;
import cap.wesantos.jali.domain.mapper.LivroMapper;
import cap.wesantos.jali.rest.controller.dto.HeaderAuthorizationRequestTO;
import cap.wesantos.jali.rest.controller.dto.LivroResponseTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LivroServiceImpl implements LivroService {

    @Autowired
    LivroRepository repository;

    @Autowired
    JwtService jwtService;

    @Override
    public List<LivroResponseTO> listarLivros(HeaderAuthorizationRequestTO authorization) {
        String loginUsuario = extrairLoginDaAuthorization(authorization.getAuthorization());

        return repository.listarLivrosEIndicarSeLidoPeloUsuario(loginUsuario)
                .stream()
                .map(LivroMapper.CONVERT::toResponseDTO)
                .collect(Collectors.toList())
        ;
    }

    @Override
    public LivroResponseTO obterPorId(Long id, HeaderAuthorizationRequestTO authorization) {
        String loginUsuario = extrairLoginDaAuthorization(authorization.getAuthorization());
        return repository.encontrarLivroPorIdEIndicarSeLidoPeloUsuario(id, loginUsuario)
                .map(LivroMapper.CONVERT::toResponseDTO)
                .orElseThrow(LivroNaoEncontradoException::new);
    }

    private String extrairLoginDaAuthorization(String authorization) {
        return jwtService.obterLoginUsuario(authorization);
    }
}
