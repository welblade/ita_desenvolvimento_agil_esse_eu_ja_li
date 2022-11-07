package cap.wesantos.jali.data.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "livro_usuario")
@IdClass(LivroUsuarioId.class)
public class LivroUsuario {

    @Id
    @ManyToOne
    @JoinColumn(name = "livro_id", referencedColumnName = "id", nullable = false)
    private Livro livro;

    @Id
    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id", nullable = false)
    private Usuario usuario;
}
