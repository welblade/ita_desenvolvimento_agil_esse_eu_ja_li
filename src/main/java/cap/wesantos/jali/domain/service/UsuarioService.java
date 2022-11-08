package cap.wesantos.jali.domain.service;

import cap.wesantos.jali.rest.controller.dto.UsuarioResponseTO;

public interface UsuarioService {
    UsuarioResponseTO obterUsuarioPorId(Long usuarioId);
}
