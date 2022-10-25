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

    public Long getId() {
        return id;
    }

    public Usuario setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Usuario setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getSenha() {
        return senha;
    }

    public Usuario setSenha(String senha) {
        this.senha = senha;
        return this;
    }

    public Long getPontos() {
        return pontos;
    }

    public Usuario setPontos(Long pontos) {
        this.pontos = pontos;
        return this;
    }

    public Set<LivroUsuario> getLivros() {
        return livros;
    }

    public Usuario setLivros(Set<LivroUsuario> livros) {
        this.livros = livros;
        return this;
    }

    public Set<Trofeu> getTrofeus() {
        return trofeus;
    }

    public Usuario setTrofeus(Set<Trofeu> trofeus) {
        this.trofeus = trofeus;
        return this;
    }
}
