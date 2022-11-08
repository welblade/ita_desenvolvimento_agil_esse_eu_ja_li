package cap.wesantos.jali.domain.service;

import cap.wesantos.jali.core.exception.LivroJaMarcadoComoLidoException;
import cap.wesantos.jali.core.exception.LivroNaoEncontradoException;
import cap.wesantos.jali.core.security.JwtService;
import cap.wesantos.jali.data.model.Livro;
import cap.wesantos.jali.data.model.LivroLido;
import cap.wesantos.jali.data.model.Usuario;
import cap.wesantos.jali.data.repository.LivroLidoRepository;
import cap.wesantos.jali.data.repository.LivroRepository;
import cap.wesantos.jali.data.repository.UsuarioRepository;
import cap.wesantos.jali.rest.controller.dto.HeaderAuthorizationRequestTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;

@Service
public class UsuarioLivroServiceImpl implements UsuarioLivroService {

    @Autowired
    JwtService jwtService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private LivroLidoRepository repository;


    @Override
    public void gravarLivroLido(Long id, HeaderAuthorizationRequestTO authorization) {
        String login = jwtService.obterLoginUsuario(authorization.getAuthorization());
        Usuario usuario = usuarioRepository.findByLogin(login)
                .orElseThrow();

        Livro livro = livroRepository.findById(id)
                .orElseThrow(LivroNaoEncontradoException::new);

        LivroLido livroLido = new LivroLido();
        livroLido.setUsuario(usuario);
        livroLido.setLivro(livro);
        try {
            repository.save(livroLido);
        }catch (EntityExistsException | DataIntegrityViolationException e) {
            throw new LivroJaMarcadoComoLidoException();
        }
    }
}
