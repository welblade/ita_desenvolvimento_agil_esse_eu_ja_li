package cap.wesantos.jali.data.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@Embeddable
public class TrofeuPK  implements Serializable {
    @Column(name = "categoria_id")
    private Long categoriaId;

    @Column(name = "usuario_id")
    private Long usuarioId;
}
