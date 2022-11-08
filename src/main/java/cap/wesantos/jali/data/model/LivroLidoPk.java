package cap.wesantos.jali.data.model;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter @Setter
@Embeddable
public class LivroLidoPk implements Serializable {

    @Column(name = "usuario_id")
    private Long usuarioId;

    @Column(name = "livro_id")
    private Long livroId;
}
