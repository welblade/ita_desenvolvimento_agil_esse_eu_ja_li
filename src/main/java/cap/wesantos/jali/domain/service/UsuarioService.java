package cap.wesantos.jali.domain.service;

import cap.wesantos.jali.rest.controller.dto.UsuarioResponseTO;

import java.util.List;

public interface UsuarioService {
    UsuarioResponseTO obterUsuarioPorId(Long usuarioId);

    List<UsuarioResponseTO> obterRankingLeitura();
}
