
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	int n;
	int soma;
	int maiorvariação = Integer.MIN_VALUE;
	int nv;
	int ant;
	int act;
	int dia;


		Scanner input = new Scanner(System.in);

		System.out.println("Introduza a 1ª temperatura");
		ant = input.nextInt();
		soma = ant;
		nv=1;

		System.out.println("Quantas temperaturas mais pretende introduzir?");
		n=input.nextInt();

		for (int i =0 ; i<n ; i++){

			System.out.println("Introduza a proxima temperatura");
			act = input.nextInt();

			int dif = act-ant;

			if (dif > maiorvariação){
				maiorvariação = dif;
				dia = i;
			}

			soma+=act;
			nv++;
			ant = act;
		}

		double media =((double) soma)/nv;
		System.out.println("A media dos " + nv + "Temperatua foi de " + media  );
		System.out.println("A maior variaçao registou-se entre os dias " + dia + "e" + "e"+ (dia+1) +
		"tendo a temperatura" + (maiorvariação > 0 ? "subido":"descido") + Math.abs(maiorvariação) + "graus");


    }
}
