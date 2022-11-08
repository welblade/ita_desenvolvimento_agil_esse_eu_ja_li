package cap.wesantos.jali.domain.service;

import cap.wesantos.jali.rest.controller.dto.HeaderAuthorizationRequestTO;

public interface UsuarioLivroService {
    void gravarLivroLido(Long id, HeaderAuthorizationRequestTO authorization);
}
