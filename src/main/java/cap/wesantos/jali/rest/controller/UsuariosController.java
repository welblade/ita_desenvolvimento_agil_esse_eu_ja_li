package cap.wesantos.jali.rest.controller;

import cap.wesantos.jali.domain.service.UsuarioService;
import cap.wesantos.jali.rest.controller.dto.UsuarioResponseTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
public class UsuariosController {

    @Autowired
    private UsuarioService service;

    @GetMapping("{id}")
    @ResponseBody
    public UsuarioResponseTO obterInformacoes(@PathVariable("id") Long usuarioId) {
        return service.obterUsuarioPorId(usuarioId);
    }

}
