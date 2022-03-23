package aula5;

import java.util.*;
import java.util.stream.Collectors;

public class TurmaComposicao {
    private String designacao;
    private List<Aluno> turma;

    public TurmaComposicao(){
        designacao="Uma Turma";
        turma = new ArrayList<>();
    }
    public TurmaComposicao(String designacao, List<Aluno> alunos){
        this.designacao = designacao;
        //this.turma = alunos.stream().map(Aluno::clone).collect(Collectors.toList());
        this.turma= new ArrayList<>();
        //for(Iterator<Aluno> i = alunos.iterator();i.hasNext();){
        //    this.turma.add(i.next().clone());
        //}
        for (Aluno a: alunos){
            this.turma.add(a.clone());
        }
    }
    public TurmaComposicao(TurmaComposicao outro){

    }
    public String getDesignacao(){
        return this.designacao;
    }
    public List<Aluno> getTurma(){
        return turma.stream().map(a->(a.clone())).collect(Collectors.toList());
    }
    public void setDesignacao(String designacao){
        this.designacao=designacao;
    }
    public void setTurma(List<Aluno> turma){
        this.turma = turma.stream().map(Aluno::clone).collect(Collectors.toList());
    }
    public void addAluno(Aluno a){
        this.turma.add(a.clone());
    }
    public boolean existeAluno(Aluno a){
        return this.turma.contains(a);
    }
    public boolean existeAluno(String nome){
        return !(this.turma.stream().filter(a->a.getNome().equals(nome)).count()==0);
    }
    public boolean existeAlunonum(String num){
        return this.turma.stream().anyMatch(a->a.getNome().equals(num));
    }
    public Set<Aluno> AlunosOrdemAlfabetica(){
        //return this.turma.stream().map(Aluno::clone).collect(Collectors.toSet());
        TreeSet<Aluno> res = new TreeSet<>(new Comparator<Aluno>() {
            @Override
            public int compare(Aluno o1, Aluno o2) {
                return o1.getNome().compareTo(o2.getNome());
            }
        });
        for (Aluno a:this.turma){
            res.add(a.clone());
        }
        return res;
    }
    public Set<Aluno> AlunosPorOrdem(Comparator<Aluno> c) {
        TreeSet<Aluno> res = new TreeSet<>(c);
        for (Aluno a : this.turma) {
            res.add().clone();
        }
    }

}
