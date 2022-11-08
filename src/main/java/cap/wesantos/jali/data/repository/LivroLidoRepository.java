package cap.wesantos.jali.data.repository;

import cap.wesantos.jali.data.model.LivroLido;
import cap.wesantos.jali.data.model.LivroLidoPk;
import org.springframework.data.jpa.repository.JpaRepository;
public interface LivroLidoRepository extends JpaRepository<LivroLido, LivroLidoPk> {

}
