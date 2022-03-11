package aula2;

import java.util.Arrays;
import java.util.Scanner;

public class Ficha2Prog {

    public static void main (String[] args) {
        int n;
        Scanner input = new Scanner(System.in);
        System.out.println("Introduza o numero de inteiros a ler ");
        n= input.nextInt();
        int array[]= new int [n];
        for (int i = 0; i<n ; i++){
            System.out.println("Introduza o proximo inteiro:");
            while(!input.hasNextInt()){
                input.next();
            }
            array[i]=input.nextInt();
        }

        Ficha2 f = new Ficha2();
        System.out.println("O valor minimo do array é " + f.minimo(array));
        System.out.println("O valor minimo do array é " + f.minimo2(array));

        int id1, id2;
        System.out.println("Introduza indice 1:  ");
        id1= input.nextInt();
        System.out.println("Introduza indice 2:  ");
        id2= input.nextInt();

        int array2[] = f.arrayEntre(array,id1,id2);
        System.out.println("O array entre " +id1+ " e "+ id2+ " e " +array2+ " ou " + Arrays.toString(array2));
        System.out.println("Introduza o tamanho do proximo array : );
    }
}
