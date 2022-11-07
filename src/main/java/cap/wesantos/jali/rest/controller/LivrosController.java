package cap.wesantos.jali.rest.controller;

import cap.wesantos.jali.domain.service.LivroService;
import cap.wesantos.jali.rest.controller.dto.HeaderAuthorizationRequestTO;
import cap.wesantos.jali.rest.controller.dto.LivroResponseTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@RestController
@RequestMapping("/api/livros")
public class LivrosController {

    @Autowired
    private LivroService service;

    @GetMapping
    @ResponseBody
    public List<LivroResponseTO> listar(
            @RequestHeader(value = AUTHORIZATION) HeaderAuthorizationRequestTO authorization
    ) {
        return service.listarLivros(authorization);
    }

    @GetMapping("{id}")
    @ResponseBody
    public LivroResponseTO detalhar(
            @PathVariable("id") Long id,
            @RequestHeader(value = AUTHORIZATION) HeaderAuthorizationRequestTO authorization
            ) {
        return service.obterPorId(id, authorization);
    }
}
