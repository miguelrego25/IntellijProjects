package com.company;
/**
 * Escreva a descrição da classe OlaMundo aqui.
 *
 * @author (seu nome)
 * @version (número de versão ou data)

import java.util.Scanner;
import java.io.*;


public class OlaAlguem {



    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int dia = scan.nextInt();
        int mes = scan.nextInt();
        int ano = scan.nextInt();

        int diasdesde = (ano-1900)*365;
        diasdesde = diasdesde + (ano-1900)/4;
        if((mes==1 || mes==2) && (ano%4==0 && ano%100!=0)) {
            diasdesde = diasdesde-1;
        }
        diasdesde = diasdesde + diasdesteano(mes, dia );
        System.out.print(diasdesde);
        diadasemana(diasdesde);



    }
    public static void diadasemana(int diasdesde){
        if(diasdesde%7==0) System.out.println("Domingo");
        if(diasdesde%7==1) System.out.println("Segunda");
        if(diasdesde%7==2) System.out.println("Terça");
        if(diasdesde%7==3) System.out.println("Quarta");
        if(diasdesde%7==4) System.out.println("Quinta");
        if(diasdesde%7==5) System.out.println("Sexta");
        if(diasdesde%7==6) System.out.println("Sabado");

    }
    public static int diasdesteano(int mes, int dia){
        int diaspassadosdestemes = 0;
        if(mes==1) diaspassadosdestemes = 31;
        if(mes==2) diaspassadosdestemes = 59;
        if(mes==3) diaspassadosdestemes = 90;
        if(mes==4) diaspassadosdestemes = 120;
        if(mes==5) diaspassadosdestemes = 151;
        if(mes==6) diaspassadosdestemes = 181;
        if(mes==7) diaspassadosdestemes = 212;
        if(mes==8) diaspassadosdestemes = 242;
        if(mes==9) diaspassadosdestemes = 273;
        if(mes==10) diaspassadosdestemes = 303;
        if(mes==11) diaspassadosdestemes = 334;
        if(mes==12) diaspassadosdestemes = 364;
        return diaspassadosdestemes-dia;
    }
*/

/**
 * Escreva a descrição da classe CalcHoras aqui.
 *
 * @author (seu nome)
 * @version (número de versão ou data)
 */


    /**
     * COnstrutor para objetos da classe CalcHoras
     */

/**
 * Escreva a descrição da classe CalcHoras aqui.
 *
 * @author (seu nome)
 * @version (número de versão ou data)
 */

/**
 * Escreva a descrição da classe CalcHoras aqui.
 *
 * @author (seu nome)
 * @version (número de versão ou data)

import java.util.Scanner;
public class CalcHoras
{


    public static void main(String[] arg) {
        Scanner scan = new Scanner(System.in);
        int dia1 = scan.nextInt();
        int horas1 = scan.nextInt();
        int minutos1 = scan.nextInt();
        int segundos1 = scan.nextInt();
        int dia2 = scan.nextInt();
        int horas2 = scan.nextInt();
        int minutos2 = scan.nextInt();
        int segundos2 = scan.nextInt();
        calculadoradehoras(dia1,dia2,horas1,horas2,minutos1,minutos2,segundos1,segundos2);
    }

    public static void calculadoradehoras(int dia1,int dia2,int horas1,
                                          int horas2,int minutos1,int minutos2,int segundos1,int segundos2){
        int diafinal=dia1+dia2;
        int horasfinais=horas1+horas2;
        if(horasfinais>24){
            diafinal++;
            horasfinais-=24;
        }
        int minutosfinais=minutos1+minutos2;
        if(minutosfinais>60){
            horasfinais++;
            minutosfinais-=60;
        }
        int segundosfinais=segundos1+segundos2;
        if(segundosfinais>60){
            minutosfinais++;
            segundosfinais-=60;
        }



        System.out.print(diafinal + " ");
        System.out.print(horasfinais + " ");
        System.out.print(minutosfinais + " ");
        System.out.print(segundosfinais + " ");
    }
}
 */
