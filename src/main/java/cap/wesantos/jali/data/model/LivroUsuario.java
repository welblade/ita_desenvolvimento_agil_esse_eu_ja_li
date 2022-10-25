package cap.wesantos.jali.data.model;

import javax.persistence.*;

@Entity
@Table(name = "livro_usuario")
public class LivroUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "livro_id", referencedColumnName = "id")
    private Livro livro;

    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private Usuario usuario;

    @Column
    private boolean isLido;
}
