package Ficha3.Ex3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class YoutubeVideo {

    //(a) métodos usuais de acesso e alteração das variáveis de instância
    // Object variables -----------------------------------------------------
    private String name;
    private List<Byte> video;
    private LocalDate date;
    private String resolution;
    private final int[] time;
    private List<String> comments;
    private int like;
    private int dislike;
    // ----------------------------------------------------------------------

    // CONSTRUTORES //
    public YoutubeVideo() {
        this.name = "Java Full Course";
        this.video = new ArrayList<>();
        this.date = LocalDate.of(2020, 11, 9);
        this.resolution = "720p";
        this.time = new int[]{719, 59}; // min; seg
        this.comments = new ArrayList<>();
        this.like = 23000;
        this.dislike = 106;
    }

    public YoutubeVideo(String name, List<Byte> video, LocalDate date,
                   String resolution, int[] time,
                   List<String> comments, int like, int dislike) {
        this.name = name;
        this.video = new ArrayList<>(video);
        this.date = date;
        this.resolution = resolution;
        this.time = time;
        this.comments = new ArrayList<>(comments);
        this.like = like;
        this.dislike = dislike;
    }

    public YoutubeVideo(YoutubeVideo y) {
        this.name = y.getName();
        this.video = y.getVideo();
        this.date = y.getDate();
        this.resolution = y.getResolution();
        this.time = y.getTime();
        this.comments = y.getComments();
        this.like = y.getLike();
        this.dislike = y.getDislike();
    }

    public void insereComentario(String comentario) {
        this.comments.add(comentario);
    }

    public long qtsDiasDepois() {
        LocalDate lancamento = this.getDate();
        LocalDate atual = LocalDate.now();

        return ChronoUnit.DAYS.between(lancamento, atual);
    }

    public void thumbsUp() {
        this.like += 1;
    }
    // (e) método que devolve o conteúdo do vídeo pronto para ser depois enviado para um qualquer render,
    //(no caso da classe de teste o render será o System.out)
//    public String processa(){
//        StringBuilder s = new StringBuilder();
//        String[] vid = this.getVideo();
//        for(String i :vid) s.append(i);
//        return s.toString();
//    }

    // (e) método que devolve o conteúdo do vídeo pronto para ser depois enviado para um qualquer render,
    //(no caso da classe de teste o render será o System.out)
//    public String processa(){
//        StringBuilder s = new StringBuilder();
//        String[] vid = this.getVideo();
//        for(String i :vid) s.append(i);
//        return s.toString();
//    }

    // OUTROS MÉTODOS QUE TODAS AS CLASSES DEVIAM CONTER //



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Byte> getVideo() {
        return video;
    }

    public void setVideo(List<Byte> video) {
        this.video = video;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public int[] getTime() {
        return time;
    }

    public List<String> getComments() {
        return comments;
    }

    public void setComments(List<String> comments) {
        this.comments = comments;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public int getDislike() {
        return dislike;
    }

    public void setDislike(int dislike) {
        this.dislike = dislike;
    }

    @Override
    public String toString() {
        return "YoutubeVideo{" +
                "name='" + name + '\'' +
                ", video=" + video +
                ", date=" + date +
                ", resolution='" + resolution + '\'' +
                ", time=" + Arrays.toString(time) +
                ", comments=" + comments +
                ", like=" + like +
                ", dislike=" + dislike +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof YoutubeVideo)) return false;
        YoutubeVideo that = (YoutubeVideo) o;
        return getLike() == that.getLike() && getDislike() == that.getDislike() && Objects.equals(getName(), that.getName()) && Objects.equals(getVideo(), that.getVideo()) && Objects.equals(getDate(), that.getDate()) && Objects.equals(getResolution(), that.getResolution()) && Arrays.equals(getTime(), that.getTime()) && Objects.equals(getComments(), that.getComments());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getName(), getVideo(), getDate(), getResolution(), getComments(), getLike(), getDislike());
        result = 31 * result + Arrays.hashCode(getTime());
        return result;
    }
}
