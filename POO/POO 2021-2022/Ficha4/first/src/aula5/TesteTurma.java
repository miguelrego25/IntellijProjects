package aula5;

public class TesteTurma {
    public static void main(String[] args){
        TurmaComposicao t = new TurmaComposicao();
        for(int j = 0;j<2;j++){
        for( int i = 0; i<10 ;i++){
            t.addAluno(new Aluno( String.valueOf(i), i, String.valueOf(i), "Um curso"));
        }
    }
    System.out.println("Turma :" + t.getTurma().size() +t.getTurma());
    System.out.println("Turma por ordem alfabetica:" + t.AlunosOrdemAlfabetica().size() + t.AlunosOrdemAlfabetica());
}
}
