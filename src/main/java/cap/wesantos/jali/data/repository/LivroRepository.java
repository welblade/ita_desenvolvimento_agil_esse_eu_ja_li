package cap.wesantos.jali.data.repository;

import cap.wesantos.jali.data.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}
