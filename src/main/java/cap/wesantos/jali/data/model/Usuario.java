package cap.wesantos.jali.data.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String nome;

    @Column
    private String senha;

    @Column
    private Long pontos;

    @OneToMany(mappedBy = "usuario")
    private Set<LivroUsuario> livros = new HashSet<>();

    @OneToMany(mappedBy = "usuario")
    private Set<Trofeu> trofeus = new HashSet<>();


}
