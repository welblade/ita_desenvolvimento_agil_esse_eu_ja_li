package cap.wesantos.jali.data.model;

import cap.wesantos.jali.data.enumeration.Funcao;
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
    @Enumerated(EnumType.STRING)
    private Funcao funcao = Funcao.USER;

    @Column
    private Long pontos = 0L;

    @OneToMany(mappedBy = "usuario")
    private Set<LivroUsuario> livros = new HashSet<>();

    @OneToMany(mappedBy = "usuario")
    private Set<Trofeu> trofeus = new HashSet<>();
}
