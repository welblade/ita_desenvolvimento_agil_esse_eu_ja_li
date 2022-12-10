package cap.wesantos.jali.data.model;

import cap.wesantos.jali.data.enumeration.Funcao;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.CascadeType.*;


@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"livros", "trofeus"})
@ToString
@Getter
@Setter
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

    @OneToMany(mappedBy = "usuario", fetch=FetchType.EAGER, cascade = {REFRESH, REMOVE, MERGE}, orphanRemoval = true)
    private Set<LivroLido> livros = new HashSet<>();

    @OneToMany(mappedBy = "usuario", fetch=FetchType.EAGER, cascade = {REFRESH, REMOVE, MERGE}, orphanRemoval = true)
    private Set<Trofeu> trofeus = new HashSet<>();


}
