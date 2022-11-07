package cap.wesantos.jali.domain.service;

import cap.wesantos.jali.rest.controller.dto.HeaderAuthorizationRequestTO;
import cap.wesantos.jali.rest.controller.dto.LivroResponseTO;

import java.util.List;

public interface LivroService {
    List<LivroResponseTO> listarLivros(HeaderAuthorizationRequestTO authorization);

    LivroResponseTO obterPorId(Long id, HeaderAuthorizationRequestTO authorization);
}
