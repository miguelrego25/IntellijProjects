package com.company;

public class Menu {
    public static int MenuInicial() {
        StringBuilder sb = new StringBuilder("------ MENU INICIAL ------\n");
        sb.append("1 -> Jogar.\n");
        sb.append("2 -> Jogador.\n");
        sb.append("3 -> Equipa.\n");
        sb.append("4 -> Gravar estado.\n");
        sb.append("5 -> Consultar estado.\n");
        sb.append("0 -> Sair.\n");
        sb.append("Introduza o numero da opcao pretendida: ");

    }

    public static int menuJogador(){
        StringBuilder sb = new StringBuilder("------ MENU JOGADOR ------\n");
        sb.append("1 -> Criar jogador.\n");
        sb.append("2 -> Consultar jogadores.\n");
        sb.append("3 -> Associar jogador a uma equipa.\n");
        sb.append("4 -> Consultar habilidade de jogador.\n");
        sb.append("Introduza o numero da opcao pretendida: ");

    }

    public static int menuEquipa(){
        StringBuilder sb = new StringBuilder("------ MENU EQUIPA ------\n");
        sb.append("1 -> Criar equipa.\n");
        sb.append("2 -> Consultar equipas.\n");
        sb.append("3 -> Consultar jogadores de uma equipa.\n");
        sb.append("4 -> Consultar habilidade de uma equipa.\n");
        sb.append("Introduza o numero da opcao pretendida: ");
    }



}
