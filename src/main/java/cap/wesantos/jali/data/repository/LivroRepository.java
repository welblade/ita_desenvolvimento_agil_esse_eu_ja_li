package cap.wesantos.jali.data.repository;

import cap.wesantos.jali.data.model.Livro;
import cap.wesantos.jali.data.model.Usuario;
import cap.wesantos.jali.data.projection.LivroView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface LivroRepository extends JpaRepository<Livro, Long> {
    @Query(value = "SELECT l.id id, l.nome nome, l.paginas paginas, c.nome categoria, " +
            "lu.usuario_id IS NOT NULL AND u.id IS NOT NULL AS lido " +
            "FROM livro l LEFT JOIN categoria c ON c.id = l.categoria_id " +
            "LEFT JOIN livro_usuario lu ON (l.id = lu.LIVRO_ID AND lu.usuario_id = :#{#usuario.id})" +
            "LEFT JOIN usuario u ON (lu.usuario_id = u.id AND u.id = :#{#usuario.id})", nativeQuery = true)
    List<LivroView> listarLivrosEIndicarSeLidoPeloUsuario(@Param("usuario") Usuario usuario);

    @Query(value = "SELECT l.id id, l.nome nome, l.paginas paginas, c.nome categoria, " +
            "lu.usuario_id IS NOT NULL AND u.id IS NOT NULL AS lido " +
            "FROM livro l LEFT JOIN categoria c ON c.id = l.categoria_id " +
            "LEFT JOIN livro_usuario lu ON l.id = lu.LIVRO_ID " +
            "LEFT JOIN usuario u ON (lu.usuario_id = u.id AND u.id = :#{#usuario.id}) WHERE l.id = :id LIMIT 1", nativeQuery = true)
    Optional<LivroView> encontrarLivroPorIdEIndicarSeLidoPeloUsuario(@Param("id") Long id, @Param("usuario") Usuario usuario);
}
