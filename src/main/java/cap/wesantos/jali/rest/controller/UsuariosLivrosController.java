package cap.wesantos.jali.rest.controller;

import cap.wesantos.jali.domain.service.UsuarioLivroService;
import cap.wesantos.jali.rest.controller.dto.HeaderAuthorizationRequestTO;
import cap.wesantos.jali.rest.controller.dto.LivroResponseTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@RestController
@RequestMapping("/api/usuarios/livros")
public class UsuariosLivrosController {
    @Autowired
    private UsuarioLivroService service;

    public List<LivroResponseTO> listLivrosLidos(){
        return null;
    }

    @PostMapping("{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void marcarLivroLido(
            @PathVariable("id") Long livroId,
            @RequestHeader(value = AUTHORIZATION) HeaderAuthorizationRequestTO authorization
    ) {
        service.gravarLivroLido(livroId, authorization);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void desmarcarLivroLido(
            @PathVariable("id") Long livroId,
            @RequestHeader(value = AUTHORIZATION) HeaderAuthorizationRequestTO authorization
    ) {
        service.deletarLivroLido(livroId, authorization);
    }

}
