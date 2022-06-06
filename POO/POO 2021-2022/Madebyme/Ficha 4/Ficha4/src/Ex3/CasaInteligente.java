package Ex3;

import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CasaInteligente {

    private ArrayList<Lampada> lamps;

    // CONSTRUTORES //
    public CasaInteligente() {
        this.lamps = new ArrayList<>();
    }

    public CasaInteligente(List<Lampada> lis) {
        this.lamps = lis.stream().map(Lampada::clone).collect(Collectors.toCollection(ArrayList::new));
    }

    public CasaInteligente(CasaInteligente c) {
        this(c.lamps);
    }



    // GETTER'S & SETTER'S //
    public List<Lampada> getLamps() {
        return this.lamps.stream().map(Lampada::clone).collect(Collectors.toList());
    }

    public void setLamps(List<Lampada> lamps) {
        this.lamps = new ArrayList<>();
        for(Lampada l: lamps){
            this.lamps.add(l.clone());
        }
    }

    //OUTROS MÉTODOS//

    //i. public void addLampada(Lampada l), que adiciona mais uma lâmpada à casa

    public void addLampada(Lampada l){
        this.lamps.add(l.clone());
    }

    //ii. public void ligaLampadaNormal(int index), que liga no modo de consumo máximo a lâmpada que está na posição indicada

    public void ligaLampadaNormal(int index){
        this.lamps.get(index).lampON();
    }
    //iii.public void ligaLampadaEco(int index), que liga no
    //modo de consumo económico a lâmpada que está na posição
    //indicada

    public void ligaLampadaEco(int index){
        this.lamps.get(index).lampECO();
    }

    //iv. public int qtEmEco(), que determina quantas lâmpadas é
    //que estão ligadas em modo económico.

    public int qtEmEco(){
        return (int) this.lamps.stream().filter(le->le.getModo().equals(Lampada.Modo.ECO)).count();
    }

    //v. public void removeLampada(int index), que remove a
    //lâmpada da posição passada como parâmetro

    public void removeLampada(int index){
        this.lamps.remove(index);
    }

    //vi. public void ligaTodasEco() e public void
    //ligaTodasMax(), que liga todas as lâmpadas da casa
    //respectivamente em modo Eco e em modo de consumo máximo

    public void ligaTodasEco(){
        this.lamps.forEach(Lampada::lampECO);
    }
    public void ligaTodasMax(){
        this.lamps.forEach(Lampada::lampON);
    }

    //vii. public double consumoTotal(), que determina o consumo
    //total da casa

    public double consumoTotal(){
        return this.lamps.stream().mapToDouble(Lampada :: getConsumoTotal).sum();
    }

    //viii. public Lampada maisGastadora(), que determina a lâmpada
    //que mais consumiu até à data

    public Lampada maisGastadora(){
        return lamps.stream().max(Comparator.comparing(Lampada :: getConsumoTotal)).get();
    }

    //ix. public Set<Lampada> podiumEconomia(), que devolve as
    //três lâmpadas mais económicas da casa

    public Set<Lampada> podiumEconomia(){
        Set<Lampada> set = new HashSet<>();
        return set;
    }

    //x. public void reset(), que efectua o reset do contador parcial de consumo em todas as lâmpadas.

    public void reset() {
        this.lamps.forEach(a-> {
            a.setConsumoTotal((int) (a.getConsumoTotal()  * (System.currentTimeMillis() - a.getPeriodoConsumo())));
            a.setPeriodoConsumo(System.currentTimeMillis());
        });
    }

}