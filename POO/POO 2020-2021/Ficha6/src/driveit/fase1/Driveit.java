package driveit.fase1;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.Comparator;

public class Driveit {
    public Map<String, Veiculo> frota;
    private String nome;

    public Driveit () {
        this.frota = new HashMap();
        this.nome="n/d";

    }

    public Driveit(String nome, Map<String, Veiculo> frota){
       this.nome = nome;
       this.setFrota(frota);
    }

    public Driveit(Driveit drvit){
        //this(drvit.getNome(), drvit.getFrota());
        this.nome =drvit.getNome();
        this.frota=drvit.getFrota();
    }
    public void setFrota(Map<String, Veiculo> f){
        this.frota=f.entrySet().stream().collect(Collectors.toMap(e->e.getKey(),e->e.getValue().clone()));
    }

    public String getNome() {
        return this.nome;
    }
    public Map<String, Veiculo>getFrota(){
        return this.frota.entrySet().stream().collect(Collectors.toMap(e->e.getKey(),e->e.getValue().clone()));
    }
    public boolean existeVeiculo(String mat){
        return this.frota.containsKey(mat);
    }
    public int quantos (String marca){
        return ( int )this.frota.values().stream().filter(v->v.getMarca().equals(marca)).count;
    }
    public Veiculo getVeiculo(String cod){
        Veiculo v = this.frota.get(cod).clone();
        return v!=null?v.clone();
    }
    public void adiciona(Set<Veiculo> vs) {
        for (Veiculo v : vs) {
            this.adiciona(v);
        }
    }
    public void registarAluguer(String codVeiculo, int numKms){
        Veiculo v= this.getVeiculo(codVeiculo);
        v.addViagem(numKms);
    }
    public List<Veiculo> veiculosOrdenadosCusto(){
        Comparator<Veiculo> comp = (v1, v2) -> (int)( v1.custoRealKM()- v2.custoRealKM());
        return this.frota.values().stream().sorted(comp).collect(Collectors.toList());

    }
}

