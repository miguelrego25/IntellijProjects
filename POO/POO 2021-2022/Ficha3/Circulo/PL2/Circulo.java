import java.util.Objects;

public class Circulo
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    private int x;
    private int y;
    private double raio;


    /**
     * COnstrutor para objetos da classe Circulo
     */

    public Circulo()
    {
        this.x = this.y = 0;
        this.raio = 1;

    }

    public Circulo(int x, int y, double raio){
        this.x = x;
        this.y = y;
        this.setRaio(raio);
    }



    public Circulo(Circulo c){
        this.x = c.getX();
        this.y = c.getY();
        this.raio = c.getRaio();
    }
    public void alteraCentro(int x, int y ){
        this.x = x;
        this.y = y;
    }
    public double calculaArea(){
        return Math.PI * this.raio * this.raio;
    }
    public double calculaPerimetro(){
        return Math.PI*this.raio*2;
    }

    public int getX() {
        return x;
    }

    private int getY() {
        return this.y;
    }

    private double getRaio() {
        return this.raio;
    }
    private void setRaio(double raio) {
        this.raio = raio;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if ((o == null) || (o.getClass() != this.getClass())) return false;
        Circulo circulo = (Circulo) o;
        return x == circulo.x && y == circulo.y && Double.compare(circulo.raio, raio) == 0;
    }


    public String toString() {
        //return "Circulo(" + "x=" + this.x + ", y=" + this.y + ", raio=" + this.raio + ')';
        //outra forma
        StringBuffer sb = new StringBuffer("Circulo c: ");
        sb.append("x = ").append(this.x).append(", y = ").append(this.y).append(", raio = ").append(this.raio);
        return sb.toString();
    }
    public Circulo clone(){
        return new Circulo(this);

    }

}