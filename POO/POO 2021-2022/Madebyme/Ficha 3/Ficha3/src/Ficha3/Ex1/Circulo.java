package Ficha3.Ex1;

public class Circulo {
    private int raio;
    private int x;
    private int y;

    public Circulo(){
        raio = 0;
        x = 0;
        y = 0;
    }
    public Circulo(int raio, int x, int y){
            this.raio = raio;
            this.x = x;
            this.y = y;
    }
    public Circulo(Circulo circulo){
        this.x = getX();
        this.y = getY();
        this.raio = getRaio();
    }
    public void alteraCentro(int cx, int cy){
        this.x=cx;
        this.y=cy;
    }
    public double calculaArea(Circulo circulo){
        return Math.PI *(raio^2);
    }
    public double calculaPerimetro(Circulo circulo){
        return Math.PI * raio * 2;
    }


    public int getRaio() {
        return raio;
    }

    public void setRaio(int raio) {
        this.raio = raio;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
