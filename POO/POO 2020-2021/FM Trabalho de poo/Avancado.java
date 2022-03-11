package com.company;

public class Avancado extends Jogador{
    @Override
    public double getHabilidadeJogador() {
        return (0.1 * getDestreza() +
                0.1 * getResistencia() +
                0.2 * getRemate() +
                0.2 * getImpulsao() +
                0.1 * getPasse() +
                0.1 * getVelocidade() +
                0.2 * getCabeca());
    }
}
