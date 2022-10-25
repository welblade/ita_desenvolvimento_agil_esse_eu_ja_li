package cap.wesantos.jali.data.repository;

import cap.wesantos.jali.data.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
