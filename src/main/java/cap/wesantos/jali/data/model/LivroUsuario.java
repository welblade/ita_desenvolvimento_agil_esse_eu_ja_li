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

    public Long getId() {
        return id;
    }

    public LivroUsuario setId(Long id) {
        this.id = id;
        return this;
    }

    public Livro getLivro() {
        return livro;
    }

    public LivroUsuario setLivro(Livro livro) {
        this.livro = livro;
        return this;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public LivroUsuario setUsuario(Usuario usuario) {
        this.usuario = usuario;
        return this;
    }

    public boolean isLido() {
        return isLido;
    }

    public LivroUsuario setLido(boolean lido) {
        isLido = lido;
        return this;
    }
}
