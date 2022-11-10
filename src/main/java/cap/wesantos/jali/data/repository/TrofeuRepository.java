package cap.wesantos.jali.data.repository;

import cap.wesantos.jali.data.model.Trofeu;
import cap.wesantos.jali.data.model.TrofeuPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrofeuRepository extends JpaRepository<Trofeu, TrofeuPK> {
}
