package cap.wesantos.jali.data.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

    @Column
    private String login;

    @Column
    private String senha;

    @Column
    private Long pontos;

    @OneToMany(mappedBy = "usuario")
    private Set<LivroUsuario> livros = new HashSet<>();

    @OneToMany(mappedBy = "usuario")
    private Set<Trofeu> trofeus = new HashSet<>();
}
