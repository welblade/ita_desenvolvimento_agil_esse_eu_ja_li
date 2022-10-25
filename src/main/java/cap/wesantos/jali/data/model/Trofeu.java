package cap.wesantos.jali.data.model;

import javax.persistence.*;

@Entity
@Table(name = "trofeu")
public class Trofeu {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "categoria_id", referencedColumnName = "id")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private Usuario usuario;

    public Long getId() {
        return id;
    }

    public Trofeu setId(Long id) {
        this.id = id;
        return this;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Trofeu setCategoria(Categoria categoria) {
        this.categoria = categoria;
        return this;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Trofeu setUsuario(Usuario usuario) {
        this.usuario = usuario;
        return this;
    }
}
