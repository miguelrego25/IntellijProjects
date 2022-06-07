package Ex3;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SistemaVideos {
    //VARIAVEL DE INSTANCIA
    private Map<String, VideoYoutube> videos;

    //CONSTRUTOR PARAMETRIZADO
    public SistemaVideos() {
        this.videos = Collections.emptyMap();
    }

    public SistemaVideos(Map<String, VideoYoutube> vids) {
        this.videos = vids.values().stream().collect(Collectors.toMap(VideoYoutube::getNomeVideo, VideoYoutube::clone));
    }

    public SistemaVideos(SistemaVideos sis) {
        this(sis.videos);
    }

    //GETTER && SETTER

    public Map<String, VideoYoutube> getVideos() {
        return videos;
    }

    public void setVideos(Map<String, VideoYoutube> videos) {
        this.videos = videos;
    }

    // OUTROS MÉTODOS QUE TODAS AS CLASSES DEVEM CONTER //
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Videos: ");
        this.videos.values().forEach(a -> sb.append(a.toString()));

        return sb.toString();
    }

    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || this.getClass() != o.getClass()) return false;

        SistemaVideos s = (SistemaVideos) o;
        return this.videos.equals(s.videos);
    }

    public SistemaVideos clone() {
        return new SistemaVideos(this);
    }

    public int compareTo(SistemaVideos sis) {
        return this.videos.size() - sis.videos.size();
    }

    //ii. adicionar um novo video ao sistema,
    public void addVideo(VideoYoutube v) {
        videos.put(v.getNomeVideo(), v.clone());
    }

    //iii. dado um código de video devolver a instância associada,
    public VideoYoutube getVideo(String nome) {
        return this.videos.getOrDefault(nome, null).clone();
    }

    //iv. remover um video dado um código,
    public void removeVideo(String nome) {
        this.videos.remove(nome);
    }

    //v. dado um código de video adicionar mais um like ao mesmo,
    public void addLike(String nome) {
        int likes = this.videos.get(nome).getLikes();
        this.videos.get(nome).setLikes(likes+1);
    }

    //vi. devolver o código do video com mais likes,
    public String topLikes() {
        return this.videos.values().stream().min((p1,p2) -> p2.getLikes() - p1.getLikes()).get().getNomeVideo();
    }

    //vii. devolver o código do video com mais likes num intervalo de tempo,
    //  Deve haver uma mandeira melhor de fazer isto
    public String topLike(LocalDate dInicial, LocalDate dFinal) {
        if (this.videos.isEmpty()) return null;
        VideoYoutube v =  this.videos.values().stream().filter(a->
                        a.getData().isAfter(ChronoLocalDateTime.from(dInicial))
                                && a.getData().isBefore(ChronoLocalDateTime.from(dFinal)))
                .min((a, b) -> b.getLikes() - a.getLikes()).orElse(null);
        return (v == null) ? null : v.getNomeVideo();
    }

    //viii. devolve o video mais longo, public Video videoMaisLongo()
    //  Deve haver uma mandeira melhor de fazer isto
    public VideoYoutube videoMaisLongo() {
        if (this.videos.isEmpty()) return null;
        Comparator<VideoYoutube> comp = Comparator.comparing(a->-a.getMinutos());
        Comparator<VideoYoutube> comparadorFinal = comp.thenComparing(Comparator.comparing(a->-a.getSegundos()));
        VideoYoutube v = this.videos.values().stream().min(comp).orElse(null);
        return (v == null) ? null : v.clone();
    }

}