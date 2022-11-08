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
    private final int PONTO_POR_LIVRO = 1;
    private final int PONTO_BONUS_DE_PAGINAS = 1;
    private final int QUANTIDADE_PAGINAS_BONUS = 100;

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

        var pontosTotais = calcularPontosDoUsuario(usuario) + calcularPontosDoLivro(livro);
        usuario.setPontos(pontosTotais);

        LivroLido livroLido = new LivroLido(usuario, livro);

        try {
            repository.save(livroLido);
            usuario.getLivros().add(livroLido);
            usuarioRepository.save(usuario);
        }catch (EntityExistsException | DataIntegrityViolationException e) {
            throw new LivroJaMarcadoComoLidoException();
        }
    }

    @Override
    public void deletarLivroLido(Long livroId, HeaderAuthorizationRequestTO authorization) {
        Usuario usuario = obterUsuarioUsandoAutorizacao(authorization);

        Livro livro = livroRepository.findById(livroId)
                .orElseThrow(LivroNaoEncontradoException::new);

        var pontosTotais = calcularPontosDoUsuario(usuario) - calcularPontosDoLivro(livro);
        usuario.setPontos(pontosTotais);

        LivroLido livroLido = new LivroLido(usuario, livro);

        try {
            usuario.getLivros().remove(livroLido);
            usuarioRepository.save(usuario);
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

    private long calcularPontosDoUsuario(Usuario usuario) {
        return usuario.getLivros()
                .stream()
                .reduce(0L,
                        (total, livroLido2) -> total + calcularPontosDoLivro(livroLido2.getLivro()),
                        Long::sum
                );
    }

    private long calcularPontosDoLivro(Livro livro) {
        var qtdPaginas = livro.getPaginas();
        var bonus = qtdPaginas / QUANTIDADE_PAGINAS_BONUS * PONTO_BONUS_DE_PAGINAS;
        return PONTO_POR_LIVRO + bonus;
    }
}
