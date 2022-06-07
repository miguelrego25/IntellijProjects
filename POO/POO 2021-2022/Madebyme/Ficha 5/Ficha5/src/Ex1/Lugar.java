package Ex1;

import java.util.Objects;

public class Lugar {

    //VARIAVEIS DE INSTANCIA

    //Matricula do veiculo estacionado
    private String matricula;

    //Nome proprietario
    private String nome;

    //Tempo atribuido ao lugar em minutos
    private int minutos;

    //Indica se o lugar é permanente, ou de aluguer
    private boolean permanente;


    //CONSTRUTORES
    public Lugar(){
        this.matricula = "";
        this.nome = "";
        this.minutos = 0;
        this.permanente = false;
    }

    public Lugar(String matricula, String nome, int minutos, boolean permanente){
        this.matricula = matricula;
        this.nome = nome;
        this.minutos = minutos;
        this.permanente = permanente;
    }

    public Lugar(Lugar lugar){
        this.matricula = getMatricula();
        this.nome = getNome();
        this.minutos = getMinutos();
        this.permanente = isPermanente();
    }

    //CLONE
    public Lugar clone(){
        return new Lugar(this);
    }

    //GETTERS && SETTERS

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public boolean isPermanente() {
        return permanente;
    }

    public void setPermanente(boolean permanente) {
        this.permanente = permanente;
    }

    //EQUALS
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lugar)) return false;
        Lugar lugar = (Lugar) o;
        return getMinutos() == lugar.getMinutos() && isPermanente() == lugar.isPermanente() && Objects.equals(getMatricula(), lugar.getMatricula()) && Objects.equals(getNome(), lugar.getNome());
    }


}
