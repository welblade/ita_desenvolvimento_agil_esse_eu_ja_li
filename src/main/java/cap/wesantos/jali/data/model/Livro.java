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

    @OneToOne(mappedBy = "categoria_id", fetch = FetchType.EAGER)
    private Categoria categoria;
}
