package src;
public class TesteCirculos {
    public static void main (String[] args){
        ColCirculos cc = new ColCirculos();

        for (int i=1;i<10;i++){
            cc.addCirculo(new CirculoPonto(i,new Ponto(i,i)));
        }
        System.out.println("coleçao" + cc);

        ColCirculos cc1 = cc.clone();
        System.out.println("Colecao Clone" + cc1);
        System.out.println("cc equals cc1" + cc.equals(cc1 ));

        for(int i = 1;i<10;i++){
            CirculoPonto cp = new CirculoPonto(i,new Ponto(i,i));
            System.out.println("colecao contains" + cp + " " + cc.containsCirculo(cp));
        }
    }
}
