package cap.wesantos.jali.data.model;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"id"})
@ToString
@Getter
@Setter
@Entity
@Table(name = "trofeu")
public class Trofeu {

    @EmbeddedId
    private TrofeuPK id = new TrofeuPK();

    @ManyToOne
    @MapsId("categoriaId")
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @ManyToOne
    @MapsId("usuarioId")
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public Trofeu(Categoria categoria, Usuario usuario){
        this.categoria = categoria;
        this.usuario = usuario;
    }
}
