package src;//package aula4;

public class CirculoPonto{
        private int raio;
        private double centro;

    public CirculoPonto(){
        centro = new Ponto();
        raio = 0;
    }
    public CirculoPonto(int raio, int centro){
        this.raio = raio;
        this.centro = centro.clone();
    }
    public CirculoPonto(CirculoPonto outro){

    }
    public int getRaio(){
        return raio;
    }
    public Ponto getCentro(){
        return centro.clone();
    }

    public void setRaio(int raio) {
        this.raio = raio;
    }

    public void setCentro(CirculoPonto c){
        this.centro = c.getCentro();
    }
    public CirculoPonto clone(){
        return new CirculoPonto(this);
    }
    public double calculatearea(){
        return Math.PI*Math.pow(this.raio,2);
    }
    public double calculateperimetro(){
        return Math.PI*2*this.raio;
    }

    public Boolean equals (Object o){
        if(this == o){
            return true;
        }
        if(o == null ||o.getClass() != this.getClass()){
                return false;
        }
        CirculoPonto cp =(CirculoPonto) o;
        return(this.raio == cp.getRaio()
                && this.centro.equals(cp.getCentro()));

    }

    @Override
    public String toString() {
        return "src.CirculoPonto{" +
                "raio="+ raio +
                ", centro= "+ centro
                + "}";
    }
    public void ChangeCentroX(int x){
        this.centro.setX(x);

    }
}
