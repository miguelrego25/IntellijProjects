package Ex1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Parque {
    //VARIAVEIS DE INSTANCIA
    private String nome;
    private Map<String, Lugar> LugarParque;


    //CONSTRUTORES PARAMETRIZADOS

    public Parque() {
        this.LugarParque = new HashMap<>();
        this.nome = "";
    }

    public Parque(String nome, Map<String, Lugar> lugarParque) {
        this.nome = nome;
        setLugarParque(lugarParque);
    }
    public Parque(Parque p){
        this.nome = p.getNome();
        this.LugarParque = p.getLugarParque();
    }

    //METODOS
    //i) -> Método que devolve todas as matriculas dos lugares ocupados;
    public List<String> getAllMatriculas() {
        return new ArrayList<>(this.LugarParque.keySet());
    }

    //ii) -> Método que regista uma nova ocupação de lugar;
    public void newOccupation (Lugar lugar) {
        this.LugarParque.putIfAbsent(lugar.getMatricula(),lugar.clone());
    }

    //iii) -> Método que remove o lugar de dada matricula;
    public void removeLugar (String matricula) {
        this.LugarParque.remove(matricula);
    }

    //iv) -> Método que altera o tempo disponível de um lugar, para uma dada matricula;
    public void setTempo (String matricula, int tempo) {
        this.LugarParque.get(matricula).setMinutos(tempo);
    }

    //v) -> Método que devolve a quantidade total de minutos atribuídos. Implemente com iterador interno e iterador externo;
    //Iterador interno
    //interno
    public int allMin1 () {
        return this.LugarParque.values().stream().mapToInt(Lugar::getMinutos).sum();
    }

    //externo
    public int allMin2 () {
        int totalminutos = 0;
        for(Lugar lugar : this.LugarParque.values()){
            totalminutos += lugar.getMinutos();
        }
        return totalminutos;
    }

    //vi) -> Método que cria uma lista com as matriculas com tempo atribuído > x, em que o lugar seja permanente.
    // Implemente com iterador interno e iterador externo;

    //Iterador interno
    public List<String> timedMatriculas1 (int time) {
        return this.LugarParque.values().stream().filter(lugar->lugar.getMinutos() > time).map(Lugar::getMatricula).collect(Collectors.toList());
    }

    //iterador externo
    public List<String> timedMatriculas2 (int time) {
        List<String> finalist = new ArrayList<>();
        for(Lugar lugar: this.LugarParque.values()){
            if(lugar.getMinutos()>time){
                finalist.add(lugar.getMatricula());
            }
        }
        return finalist;
    }


    ////vii) -> Método que verifica existe lugar atribuído a uma dada matrícula;
    public boolean hasLugar (String matricula) {
        return this.LugarParque.containsKey(matricula);
    }

    //viii) -> Método que devolve uma cópia dos lugares;
    public List<Lugar> getAllLugares() {
        return this.LugarParque.values().stream().map(Lugar::clone).collect(Collectors.toList());
    }

    //ix) -> Método que devolve a informação de um lugar para uma dada matricula;
    public Lugar getLugarInfo(String matricula) {
        if(!hasLugar(matricula));
        return this.LugarParque.get(matricula).clone();
    }






    //GETTERS && SETTERS
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Map<String, Lugar> getLugarParque() {
        return LugarParque;
    }

    public void setLugarParque(Map<String, Lugar> lugarParque) {
        LugarParque = lugarParque;
    }
}
