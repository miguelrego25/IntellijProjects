public class CirculoPonto {



    public class CirculoPonto(){
        private int raio;
        private double centri;
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

    public setCentro(CirculoPonto c){
        this.centro=c.getCentro();
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

    public static void main(String[] args) {
	// write your code here
    }
}
