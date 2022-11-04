package cap.wesantos.jali.data.repository;

import cap.wesantos.jali.data.model.Livro;
import cap.wesantos.jali.data.projection.LivroView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface LivroRepository extends JpaRepository<Livro, Long> {
    @Query(value = "SELECT l.id id, l.nome nome, l.paginas paginas, c.nome categoria, " +
            "CASE lu.is_lido WHEN TRUE AND lu.USUARIO_ID = u.ID  THEN TRUE ELSE FALSE END AS lido " +
            "FROM livro l LEFT JOIN categoria c ON c.id = l.categoria_id " +
            "LEFT JOIN livro_usuario lu ON l.id = lu.LIVRO_ID " +
            "LEFT JOIN usuario u ON (lu.usuario_id = u.id AND u.login = :login)", nativeQuery = true)
    List<LivroView> listarLivrosEIndicarSeLidoPeloUsuario(@Param("login") String login);

    @Query(value = "SELECT l.id id, l.nome nome, l.paginas paginas, c.nome categoria, " +
            "CASE lu.is_lido WHEN TRUE AND lu.USUARIO_ID = u.ID  THEN TRUE ELSE FALSE END AS lido " +
            "FROM livro l LEFT JOIN categoria c ON c.id = l.categoria_id " +
            "LEFT JOIN livro_usuario lu ON l.id = lu.LIVRO_ID " +
            "LEFT JOIN usuario u ON (lu.usuario_id = u.id AND u.login = :login) WHERE l.id = :id LIMIT 1", nativeQuery = true)
    Optional<LivroView> encontrarLivroPorIdEIndicarSeLidoPeloUsuario(@Param("id") Long id, @Param("login") String Login);
}
