package com.company;
package aula4;
import aula4.Triangulo;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class ListaDeTriangulos {
    private List<aula4.Triangulo>lst;

    public ListaDeTriangulos(){
        this.lst=new ArrayList();

    }

    public ListaDeTriangulos(List<aula4.Triangulo> nLst) {
        this();

        for(aula4.Triangulo t: nLst){
            this.lst.add(t.clone());

        }

    }

    public ListaDeTriangulos(ListaDeTriangulos l) {
        this();

        for(Triangulo t:l.getLst()){
            this.lst.add(t);
        }
    }

    public List<Triangulo> getLst() {
       List<Triangulo> re = new ArrayList<Triangulo>();
        for(Triangulo t: this.lst){
            re.add(t.clone());
        }

        //this.lst.forEach(t -> re.add(t.clone()));

        return re;
    }
    public void setLst(List<Triangulo> l){
        this.lst.clear();
        for(Triangulo t: l){
            this.lst.add(t.clone());
        }
    }
    public double somPerimetros(){
        double res=0;
        for(Triangulo t: lst){
            res+=t.perimetro();
        }
        return res;
    }
    public boolean temPerimetroMaiorQue(double per){
        boolean enc = false;
        Iterator<Triangulo> it =this.lst.iterator();


       while(it.hasNext()&& !enc){
           Triangulo t = it.next();
           enc = t.perimetro()>per;
       }

    return enc;
    }

    public String toString(){
        return "ListaDeTriangulos; "+list.lst.toString();

    }
    public ListaDeTriangulos clone(){
        return new ListaDeTriangulos(this);
    }

}
