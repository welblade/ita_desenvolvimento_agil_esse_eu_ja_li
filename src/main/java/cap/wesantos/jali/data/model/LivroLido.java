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
@Table(name = "livro_usuario")
public class LivroLido {
    @EmbeddedId
    private LivroLidoPk id = new LivroLidoPk();

    @ManyToOne
    @MapsId("usuarioId")
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @MapsId("livroId")
    @JoinColumn(name = "livro_id")
    private Livro livro;

    public LivroLido(Usuario usuario, Livro livro) {
        this.usuario = usuario;
        this.livro = livro;
    }
}
