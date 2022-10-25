package cap.wesantos.jali.data.repository;

import cap.wesantos.jali.data.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
