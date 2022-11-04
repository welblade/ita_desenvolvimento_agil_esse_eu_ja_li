package cap.wesantos.jali.domain.service;

import cap.wesantos.jali.rest.controller.dto.LivroResponseTO;

import java.util.List;

public interface LivroService {
    List<LivroResponseTO> listarLivros();

    LivroResponseTO obterPorId(Long id);
}
