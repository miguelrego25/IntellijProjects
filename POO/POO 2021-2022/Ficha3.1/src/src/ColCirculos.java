package src;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ColCirculos {

    private List<CirculoPontos> circs;
    public ColCirculos(){
        circs new = ArrayList<>();
    }


    public ColCirculos(<List<CirculoPontos> circs){
        this.circs = new ArrayList<>();
        for(CirculoPonto cp: circs ){
            this.circs.add(cp.clone());
        }
    }
    public ColCirculos(CirculoPonto outro){


    }
    public List<CirculoPonto> getCircs(){
        List<ColCirculos>res  = new ArrayList<>(this.circs.size());
        for(CirculoPonto cp: this.circs){
            res.add(cp.clone());
        }
        return res;
    }
    public void setCircs(List<CirculoPonto>circs){
        this.circs = new ArrayList<>(circs .size());
        for(CirculoPonto cp: this.circs) {
            this.circs.add(cp.clone());
        }
    }
    public void addCirculo(CirculoPonto cp){
        this.circs.add(cp.clone());
    }
    public boolean containsCirculo((CirculoPonto cp ){
        return this.circs.contains(cp);
    }
    public void removeCirculo(CirculoPonto cp){
     this.circs.remove(cp);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ColCirculos)) return false;
        ColCirculos that = (ColCirculos) o;
        return Objects.equals(circs, that.circs);
    }
    public ColCirculos clone(){
        return new ColCirculos (this);
    }

    @Override
    public String toString() {
        return "ColCirculos{" +
                "circs=" + circs +
                '}';
    }
}
