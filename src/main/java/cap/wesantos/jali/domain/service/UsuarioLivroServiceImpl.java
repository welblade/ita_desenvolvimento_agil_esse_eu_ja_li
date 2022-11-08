package cap.wesantos.jali.domain.service;

import cap.wesantos.jali.core.exception.LivroJaMarcadoComoLidoException;
import cap.wesantos.jali.core.exception.LivroNaoEncontradoException;
import cap.wesantos.jali.core.exception.LivroNaoMarcadoComoLidoException;
import cap.wesantos.jali.core.security.JwtService;
import cap.wesantos.jali.data.model.Livro;
import cap.wesantos.jali.data.model.LivroLido;
import cap.wesantos.jali.data.model.LivroLidoPk;
import cap.wesantos.jali.data.model.Usuario;
import cap.wesantos.jali.data.repository.LivroLidoRepository;
import cap.wesantos.jali.data.repository.LivroRepository;
import cap.wesantos.jali.data.repository.UsuarioRepository;
import cap.wesantos.jali.rest.controller.dto.HeaderAuthorizationRequestTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
    public void gravarLivroLido(Long livroId, HeaderAuthorizationRequestTO authorization) {
        Usuario usuario = obterUsuarioUsandoAutorizacao(authorization);

        Livro livro = livroRepository.findById(livroId)
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

    @Override
    public void deletarLivroLido(Long livroId, HeaderAuthorizationRequestTO authorization) {
        Usuario usuario = obterUsuarioUsandoAutorizacao(authorization);

        Livro livro = livroRepository.findById(livroId)
                .orElseThrow(LivroNaoEncontradoException::new);

        try {
            repository.deleteById(new LivroLidoPk(usuario.getId(), livro.getId()));
        } catch (EmptyResultDataAccessException e) {
            throw new LivroNaoMarcadoComoLidoException();
        }
    }

    private Usuario obterUsuarioUsandoAutorizacao(HeaderAuthorizationRequestTO authorization) {
        String login = jwtService.obterLoginUsuario(authorization.getAuthorization());
        return usuarioRepository.findByLogin(login)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não autenticado."));
    }
}
