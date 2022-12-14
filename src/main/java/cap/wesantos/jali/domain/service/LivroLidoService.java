package cap.wesantos.jali.domain.service;

import cap.wesantos.jali.rest.controller.dto.HeaderAuthorizationRequestTO;

public interface LivroLidoService {
    void gravarLivroLido(Long livroId, HeaderAuthorizationRequestTO authorization);

    void deletarLivroLido(Long livroId, HeaderAuthorizationRequestTO authorization);
}
