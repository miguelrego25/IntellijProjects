
public class TesteCirculo {
    public static void main(String[] args){
        Circulo c1, c2;
        c1 = new Circulo(1,1,10);
        c2 = c1.clone();

        if(c1.equals(c2)) System.out.println("Iguais!");
        else System.out.println("Diferentes!");

        System.out.println(c1);
        System.out.println(c1.calculaArea());
    }
}
