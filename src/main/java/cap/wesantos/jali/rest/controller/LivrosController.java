package cap.wesantos.jali.rest.controller;

import cap.wesantos.jali.domain.service.LivroService;
import cap.wesantos.jali.rest.controller.dto.LivroResponseTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.NoSuchElementException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequestMapping("/api/livros")
public class LivrosController {

    @Autowired
    private LivroService service;

    @GetMapping
    @ResponseBody
    public List<LivroResponseTO> listar() {
        return service.listarLivros();
    }
    @GetMapping("{id}")
    @ResponseBody
    public LivroResponseTO detalhar(@PathParam("id") Long id) {
        return service.obterPorId(id);
    }
}
