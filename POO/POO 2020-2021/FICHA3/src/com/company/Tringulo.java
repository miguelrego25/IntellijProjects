package aula4;

import com.company.Ponto;

public class Triangulo {
    //instance variables- replace the example below with your own
    private Ponto p1, p2, p3;

    public Triangulo() {
        p1 = new Ponto();
        p2 = new Ponto();
        p3 = new Ponto();

    }

    public Triangulo(Ponto p1, Ponto p2, Ponto p3) {
        this.p1 = p1.clone();
        this.p2 = p2.clone();
        this.p3 = p3.clone();
    }

    public Triangulo(Triangulo) {
        //this (t.getP1(), t.getP2(), t.getP3)
        this.p1 = t.getP1();
        this.p2 = t.getP2();
        this.p3 = t.getP3();
    }

    public Ponto getP1() {
        return this.p1.clone();

    }

    public Ponto getP2() {
        return this.p2.clone();

    }

    public Ponto getP3() {
        return this.p3.clone();

    }

    public void setP1(Ponto p) {
        this.p1 = p.clone();

    }

    public int perimetro() {
        return p1.distancia(p2) + p2.distancia(p3) + p3.distancia(p1);
    }

    public boolean equals(Object o) {
        if (this == o)
            return true;
        if ((o == null) || (this.getClass() != o.getClass()))
            return false;
        Triangulo p = (Triangulo) o;
        return this.p1.equals(t.getP1()) && this.p2.equals(t.getP2()) && this.p3.equals(t.getP3());

    }

    public String toString(){
        StringBuilder sb = new StringBuilder("Triangulo:");
        sb.append(this.p1.toString());
        sb.append("  /  ");
        sb.append(this.p2.toString());
        sb.append("  /  ");
        sb.append(this.p3.toString());
        sb.append("  /  ");
        return
    }

    public Triangulo clone(){
        return new Triangulo (this);
    }

}