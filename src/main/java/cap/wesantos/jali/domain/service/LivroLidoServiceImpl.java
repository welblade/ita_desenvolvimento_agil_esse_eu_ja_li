package cap.wesantos.jali.domain.service;

import cap.wesantos.jali.core.exception.LivroJaMarcadoComoLidoException;
import cap.wesantos.jali.core.exception.LivroNaoEncontradoException;
import cap.wesantos.jali.core.exception.LivroNaoMarcadoComoLidoException;
import cap.wesantos.jali.core.security.JwtService;
import cap.wesantos.jali.data.model.*;
import cap.wesantos.jali.data.repository.LivroLidoRepository;
import cap.wesantos.jali.data.repository.LivroRepository;
import cap.wesantos.jali.data.repository.TrofeuRepository;
import cap.wesantos.jali.data.repository.UsuarioRepository;
import cap.wesantos.jali.rest.controller.dto.HeaderAuthorizationRequestTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import java.util.NoSuchElementException;

@Service
public class LivroLidoServiceImpl implements LivroLidoService {
    private final int PONTO_POR_LIVRO = 1;
    private final int PONTO_BONUS_DE_PAGINAS = 1;
    private final int QUANTIDADE_PAGINAS_BONUS = 100;
    private final int REQUISITO_LIVROS_LIDOS = 5;
    @Autowired
    private JwtService jwtService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private LivroLidoRepository repository;

    @Autowired
    private TrofeuRepository trofeuRepository;


    @Override
    public void gravarLivroLido(Long livroId, HeaderAuthorizationRequestTO authorization) {
        Usuario usuario = obterUsuarioUsandoAutorizacao(authorization);

        Livro livro = livroRepository.findById(livroId)
                .orElseThrow(LivroNaoEncontradoException::new);

        LivroLido livroLido = new LivroLido(usuario, livro);

        try {
            LivroLido livroLidoSalvo = repository.save(livroLido);
            aoRemoverOuSalvar(livroLidoSalvo);
        }catch (EntityExistsException | DataIntegrityViolationException e) {
            throw new LivroJaMarcadoComoLidoException();
        }
    }

    @Override
    public void deletarLivroLido(Long livroId, HeaderAuthorizationRequestTO authorization) {
        Usuario usuario = obterUsuarioUsandoAutorizacao(authorization);

        Livro livro = livroRepository.findById(livroId)
                .orElseThrow(LivroNaoEncontradoException::new);

        LivroLido livroLido = usuario.getLivros()
                .stream()
                .filter(l -> l.getLivro().equals(livro))
                .findFirst()
                .orElseThrow();

        try {
            repository.delete(livroLido);
            aoRemoverOuSalvar(livroLido);
        } catch (EmptyResultDataAccessException | NoSuchElementException e) {
            throw new LivroNaoMarcadoComoLidoException();
        }
    }

    private Usuario obterUsuarioUsandoAutorizacao(HeaderAuthorizationRequestTO authorization) {
        String login = jwtService.obterLoginUsuario(authorization.getAuthorization());
        return usuarioRepository.findByLogin(login)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não autenticado."));
    }


    public void aoRemoverOuSalvar(final LivroLido livroLido) {
        var usuario = livroLido.getUsuario();
        var livro = livroLido.getLivro();

        usuario.setPontos(calcularPontosDoUsuario(usuario));

        var livrosLidosDaCategoria = qtdLivroLidoCategoria(usuario, livro.getCategoria());

        TrofeuPK id = new TrofeuPK(livro.getCategoria().getId(), usuario.getId());
        if (livrosLidosDaCategoria >= REQUISITO_LIVROS_LIDOS) {
            if (!trofeuRepository.existsById(id)) {
                trofeuRepository.save(new Trofeu(livro.getCategoria(), usuario));
            }
        } else  {
            if (trofeuRepository.existsById(id)) {
                trofeuRepository.deleteById(id);
            }
        }
        usuarioRepository.save(usuario);
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

    private long qtdLivroLidoCategoria(Usuario usuario, Categoria categoria) {
        return usuario.getLivros()
                .stream()
                .filter(
                        it -> it.getLivro().getCategoria().equals(categoria)
                ).count();
    }

}
