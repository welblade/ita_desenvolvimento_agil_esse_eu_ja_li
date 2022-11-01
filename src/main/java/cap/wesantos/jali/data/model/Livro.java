package cap.wesantos.jali.data.model;

import javax.persistence.*;

@Entity
public class Livro {

    @Id
    @Column
    private Long id;

    @Column
    private String nome;

    @Column
    private int paginas;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    public Long getId() {
        return id;
    }

    public Livro setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Livro setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public int getPaginas() {
        return paginas;
    }

    public Livro setPaginas(int paginas) {
        this.paginas = paginas;
        return this;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Livro setCategoria(Categoria categoria) {
        this.categoria = categoria;
        return this;
    }
}
