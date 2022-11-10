package cap.wesantos.jali.data.repository;

import cap.wesantos.jali.data.model.Categoria;
import cap.wesantos.jali.data.model.LivroLido;
import cap.wesantos.jali.data.model.LivroLidoPk;
import cap.wesantos.jali.data.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;


public interface LivroLidoRepository extends JpaRepository<LivroLido, LivroLidoPk> {
    @Query("SELECT COUNT(lido) as value FROM LivroLido lido JOIN lido.livro l JOIN l.categoria cat WHERE lido.usuario = :usuario AND l.categoria = :categoria GROUP BY l.categoria.id")
    Optional<Integer> encontrarQuantidadeLivrosLidosByUsuarioAndCategoria(Usuario usuario, Categoria categoria);
}
