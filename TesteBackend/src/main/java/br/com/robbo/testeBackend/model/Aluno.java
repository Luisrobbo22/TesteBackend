package br.com.robbo.testeBackend.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "TB_ALUNO")
public class Aluno implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CD_ALUNO")
    @NotNull
    private Integer id;

    @Column(name = "NM_ALUNO")
    @NotNull
    @Size(min = 3, max = 30)
    private String nome;

    @Column(name = "VL_IDADE")
    @NotNull
    @Min(value = 18, message = "Aluno precisa ser maior de 18 anos")
    private int idade;


    public Aluno() {
    }

    public Aluno(Integer id, String nome, int idade) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Aluno)) return false;
        Aluno aluno = (Aluno) o;
        return id.equals(aluno.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
