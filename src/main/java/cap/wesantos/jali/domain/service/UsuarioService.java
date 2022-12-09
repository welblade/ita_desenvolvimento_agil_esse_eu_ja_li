package cap.wesantos.jali.domain.service;

import cap.wesantos.jali.data.model.Usuario;
import cap.wesantos.jali.rest.controller.dto.HeaderAuthorizationRequestTO;
import cap.wesantos.jali.rest.controller.dto.PerfilUsuarioResponseTO;
import cap.wesantos.jali.rest.controller.dto.UsuarioResponseTO;

import java.util.List;

public interface UsuarioService {
    UsuarioResponseTO obterUsuarioPorId(Long usuarioId);

    List<UsuarioResponseTO> obterRankingLeitura();

    PerfilUsuarioResponseTO obterPerfilUsuarioPorId(Long usuarioId);

    PerfilUsuarioResponseTO obterPerfilUsuarioPorAutorizacao(HeaderAuthorizationRequestTO authorization);

    Usuario obterUsuarioUsandoAutorizacao(HeaderAuthorizationRequestTO authorization);
}
