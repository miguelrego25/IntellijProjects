package com.company;


/**
 * Variaveis de instancia da classe Jogador
 */
public abstract class Jogador {
    private String nomeJogador;
    private int numJogador;
    private int idadeJogador;
    private double habilidadeJogador;
    private String equipa;

    private int velocidade;
    private int resistencia;
    private int destreza;
    private int impulsao;
    private int cabeca;
    private int remate;
    private int passe;




    /**
     * Construtor Vazio
     */
    public Jogador(){
        this.nomeJogador = "";
        this.numJogador = 0;
        this.idadeJogador = 0;
        this.habilidadeJogador = 0;
        this.equipa = "";
        this.velocidade = 0;
        this.resistencia = 0;
        this.destreza = 0;
        this.impulsao = 0;
        this.cabeca = 0;
        this.remate = 0;
        this.passe = 0;
        this.remate = 0;

    }

    /**
     *
     */
    public Jogador(String nomeJogador , int numJogador, int idadeJogador, int habilidadeJogador, String equipa, int velocidade,int destreza, int resistencia, int impulsao, int cabeca, int remate, int passe){
        this.nomeJogador = nomeJogador;
        this.numJogador = numJogador;
        this.idadeJogador = idadeJogador;
        this.habilidadeJogador = habilidadeJogador;
        this.equipa = equipa;
        this.velocidade = velocidade;
        this.resistencia = resistencia;
        this.destreza = destreza;
        this.impulsao = impulsao;
        this.cabeca = cabeca;
        this.remate = remate;
        this.passe = passe;
    }

    /**

     */
    public Jogador (Jogador jogador){
        this.nomeJogador = jogador.getNomeJogador();
        this.numJogador = jogador.getNumJogador();
        this.idadeJogador = jogador.getIdadeJogador();
        this.habilidadeJogador = jogador.getHabilidadeJogador();
        this.equipa = jogador.getEquipa();
        this.velocidade = jogador.getVelocidade();
        this.resistencia = jogador.getResistencia();
        this.destreza = jogador.getDestreza();
        this.impulsao = jogador.getImpulsao();
        this.cabeca = jogador.getCabeca();
        this.remate = jogador.getRemate();
        this.passe = jogador.getPasse();
    }


    /**
     * Get and Set
     */
    public String getNomeJogador() {
        return nomeJogador;
    }

    public void setNomeJogador(String nomeJogador) {
        this.nomeJogador = nomeJogador;
    }

    public int getNumJogador() {
        return numJogador;
    }

    public void setNumJogador(int numJogador) {
        this.numJogador = numJogador;
    }

    public int getIdadeJogador() {
        return idadeJogador;
    }

    public void setIdadeJogador(int idadeJogador) {
        this.idadeJogador = idadeJogador;
    }

    public abstract double getHabilidadeJogador();

    public void setHabilidadeJogador(double habilidadeJogador) { this.habilidadeJogador = habilidadeJogador; }

    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    public int getResistencia() {return resistencia;}

    public void setResistencia(int resistencia) { this.resistencia = resistencia; }

    public int getDestreza() { return destreza; }

    public void setDestreza(int destreza) { this.destreza = destreza; }

    public int getImpulsao() { return impulsao; }

    public void setImpulsao(int impulsao) { this.impulsao = impulsao; }

    public int getCabeca() { return cabeca; }

    public void setCabeca(int cabeca) { this.cabeca = cabeca; }

    public int getRemate() { return remate; }

    public void setRemate(int remate) { this.remate = remate; }

    public int getPasse() { return passe; }

    public void setPasse(int passe) { this.passe = passe; }

    public String getEquipa() { return equipa; }

    public void setEquipa(String equipa) { this.equipa = equipa; }

    /**
     * Clone
     */
    //public Jogador clone() {return new Jogador(this); }


    /**
     *Equals
     */
    public boolean equals(Object j){
        if (this == j) return true;
        if (j == null || this.getClass() != j.getClass()) return false;
        Jogador jog = (Jogador) j;
        return jog.getNomeJogador().equals(this.nomeJogador) &&
                jog.getNumJogador() == (this.numJogador) &&
                jog.getIdadeJogador() == (this.idadeJogador) &&
                jog.getHabilidadeJogador() == (this.habilidadeJogador) &&
                jog.getEquipa().equals(this.equipa) &&
                jog.getVelocidade() == (this.velocidade) &&
                jog.getCabeca() == (this.cabeca) &&
                jog.getPasse() == (this.passe) &&
                jog.getImpulsao() == (this.remate) &&
                jog.getRemate() == (this.remate) &&
                jog.getDestreza() == (this.destreza) &&
                jog.getResistencia() == (this.resistencia);
    }

    /**
     *toString
     */
    public String toString(){
        StringBuilder sb = new StringBuilder("Jogador: \n");
        sb.append("Nome: ");
        sb.append(this.nomeJogador).append("\n");
        sb.append("Numero: ");
        sb.append(this.numJogador).append("\n");
        sb.append("Idade: ");
        sb.append(this.idadeJogador).append("\n");
        sb.append("Habilidade: ");
        sb.append(this.habilidadeJogador).append("\n");
        sb.append("Equipa: ");
        sb.append(this.equipa).append("\n");
        return sb.toString();
    }

/**
 * Criar jogador
 *
 * Nome:
 * Idade:
 * Posicao(AVA, LAT, MED, DEF, GR):
 * destreza:
 * ...
 * if posicao AVA , Habilidade
 * ...
 *
 *
 *
 */


}

