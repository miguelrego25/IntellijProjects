package aula5;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class TurmaMap {
    private Map<String,Aluno> alunos;

    public TurmaMap(){
        this.alunos =new HashMap<>();
    }
    public TurmaMap(Map<String,Aluno> alunos){
        this();/*
        for (String n: alunos.keySet()){
            Aluno a = alunos.get(n);
            this.alunos.put (n,a.clone()));
        }
        for (Aluno a: alunos.getvalues()){
            String n = a.getNumero();
            this.alunos.put (n,a.clone()));
        }*/

        for (Map.Entry<String, Aluno>e: alunos.entrySet()){
            String n = a.getNumero();
            Aluno a = alunos.get(n);
            this.alunos.put(n,a.clone());
        }
        this.alunos= alunos.entrySet().stream().collect(toMap(e->e.getKey(),e->e.getValue().clone()));
    }

    public Map<String, Aluno> getAlunos(){
        return this.alunos.entrySet().stream().collect(toMap(e->e.getKey(),e->e.getValue().clone()));
    }
    public Map<String, Aluno> getAlunosAgreg(){
        Map<String,Aluno> res = new HashMap<>();
        res.putAll(this.alunos);
        return res;
    }
    public Map<String, Aluno> getAlunos2(){
        return this.alunos.entrySet().stream().collect(toMap(Aluno::getNumero, Aluno::clone));
    }
    public void adicAluno(Aluno a){
        this.alunos.put(a.getNumero(),a.clone());
    }
    public boolean existe (String num){
        return this.alunos.containsKey(num);
    }
    public Aluno getAluno (String num){
        Aluno a = this.alunos.get(num);
        return a == null? a: a.clone();
    }

    public List<Aluno> porNota(){
        Comparator <Aluno> c = (a1,a2) -> a1.getNota()-a2.getNota();
    }
}
