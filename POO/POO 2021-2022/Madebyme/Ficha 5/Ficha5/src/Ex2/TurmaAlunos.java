package Ex2;

import java.util.*;
import java.util.stream.Collectors;

public class TurmaAlunos {                                  //ESTRATÉGIA DE COMPOSIÇÃO

    private Map<String, Aluno> alunos;
    private String nomeTurma;
    private String codUC;

    //CONSTRUTORES//
    // i. métodos usuais da classe TurmaAlunos, nomeadamente construtores, getters e setters, equals, toString, clone
    public TurmaAlunos() {
        this.alunos = new HashMap<>();
        //this.alunos = new TreeMap<>();                TAMBÉM PODERIA SER!

        this.nomeTurma = "N/A";
        this.codUC = "N/A";
    }

    public TurmaAlunos(Map<String, Aluno> nAlunos, String nNomeTurma, String ncodUC) {
        //setAlunos(nAlunos);

        this.nomeTurma = nNomeTurma;
        this.codUC = ncodUC;

        this.alunos = new HashMap<>();  //vazio, para agora iterarmos por todos os elementos de nAlunos e colonar as suas informações para dentro deste novo HashMap();

        for (Aluno a : nAlunos.values()) {
            String chave = a.getNumero();
            this.alunos.put(chave, a.clone());        // this.alunos.put(a.getNumero(), a.clone());
        }
    }

    public TurmaAlunos(TurmaAlunos t) {
        this.alunos = t.getAlunos();
        this.codUC = t.getCodUC();
        this.nomeTurma = t.getNomeTurma();
    }

    //GETTER & SETTER'S//
    public Map<String, Aluno> getAlunos() {
        Map<String, Aluno> r = new HashMap<>();

        for (Map.Entry<String, Aluno> e : this.alunos.entrySet()) {
            String chave = e.getKey();
            Aluno valor = e.getValue();

            r.put(chave, valor.clone());                // r.put ( e.getKey(), e.getValue().clone());
        }

        return r;

        //return this.alunos.values().stream().collect(Collectors.toMap(Aluno::getNumero, Aluno::clone));
    }

    public void setAlunos(Map<String, Aluno> nAlunos) {
        this.alunos = new HashMap<>();

        for (String k : nAlunos.keySet()) {
            this.alunos.put(k, nAlunos.get(k).clone());
        }

        //this.alunos = al.values().stream().collect(Collectors.toMap(Aluno::getNumero, Aluno::clone));
    }

    public String getNomeTurma() {
        return nomeTurma;
    }

    public void setNomeTurma(String nomeTurma) {
        this.nomeTurma = nomeTurma;
    }

    public String getCodUC() {
        return codUC;
    }

    public void setCodUC(String codUC) {
        this.codUC = codUC;
    }

    //OUTROS MÉTODOS QUE TODAS AS CLASSES DEVEM CONTER//

    public boolean equals(Object o) {
        if (this == o) return true;
        if ((o == null) || (this.getClass() != o.getClass())) return false;

        TurmaAlunos t = (TurmaAlunos) o;
        return (this.alunos.equals(t.getAlunos())
                && this.nomeTurma.equals(t.getNomeTurma())
                && this.codUC.equals(t.getCodUC())
        );
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Nome da Turma: ").append(this.nomeTurma).append("\n")
                .append("Codigo da UC: ").append(this.codUC).append("\n");

        for (Aluno a : this.alunos.values()) {
            sb.append(a.toString()).append("\n");
        }

        return sb.toString();
    }

    public TurmaAlunos clone() {
        return new TurmaAlunos(this);
    }

    //METODOS

    //ii. adicionar um novo aluno à turma, public void insereAluno(Aluno a)

    public void insereAluno(Aluno a){
        this.alunos.put(a.getNumero(),a.clone());
    }

    //iii. dado um código de aluno devolver a instância de Aluno associada, public Aluno getAluno(String codAluno)
    public Aluno getAluno(String codAluno){
        if(!this.alunos.containsKey(codAluno)) return null;
        return this.alunos.get(codAluno).clone();
    }

    //iv. remover um aluno dado o seu código, public void removeAluno(String codAluno)
    public void removeAluno(String codAluno){
        this.alunos.remove(codAluno);
    }

    //v. devolver a informação de todos os números de aluno existentes, public Set<String> todosOsCodigos()
    public Set<String> todosOsCodigos(){
        return this.alunos.keySet();
    }

    //vi. devolver a informação de quantos alunos existem na turma, public int qtsAlunos()
    public int qtsAlunos(){
        return this.alunos.values().size();
    }

    //vii. devolver os alunos ordenados por ordem alfabética do seu nome, public Collection<Aluno> alunosOrdemAlfabetica()
    public Collection<Aluno> alunosOrdemAlfabetica(){
        return this.alunos.values().stream().sorted((p1,p2)-> p1.getNome().compareTo(p2.getNome())).collect(Collectors.toList());
    }

    //viii. devolver os alunos ordenados por ordem decrescente do seu número, public Set<Aluno> alunosOrdemDescrescenteNumero()
    //(assume-se que não existem números repetidos, daí ser viável devolver um Set sem correr o risco de a comparação eliminar resultados).
    public Set<Aluno> alunosOrdemDecrescenteNumero(){
        return this.alunos.values().stream().sorted((p2,p1)-> p1.getNumero().compareTo(p2.getNumero())).map(Aluno::clone).collect(Collectors.toSet());
    }



}
