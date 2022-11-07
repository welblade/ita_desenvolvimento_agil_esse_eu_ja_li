package cap.wesantos.jali.data.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LivroUsuarioId implements Serializable {
    private Livro livro;
    private Usuario usuario;
}
