package aula5;

import java.util.Objects;

public class Aluno {
    private String numero;
    private int nota;
    private String nome;
    private String curso;

    public Aluno(){
        this.numero ="";
        this.nota = 0;
        this.nome = "";
        this.curso= "";
    }

    public Aluno(String valueOf, int i, String valueOf1, String um_curso) {
    }

    public Aluno(Aluno aluno) {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Aluno)) return false;
        Aluno aluno = (Aluno) o;
        return nota == aluno.nota && Objects.equals(numero, aluno.numero) && Objects.equals(nome, aluno.nome) && Objects.equals(curso, aluno.curso);
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "numero='" + numero + '\'' +
                ", nota=" + nota +
                ", nome='" + nome + '\'' +
                ", curso='" + curso + '\'' +
                '}';
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getNumero() {
        return numero;
    }

    public int getNota() {
        return nota;
    }

    public String getNome() {
        return nome;
    }

    public String getCurso() {
        return curso;
    }
    public Aluno clone(){
        return new Aluno( this);
    }



}
