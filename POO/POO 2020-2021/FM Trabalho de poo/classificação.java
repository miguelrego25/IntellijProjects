import java.util.Objects;

public class Classificacao {

    private Integer classificacaonum;//posição na tabela
    private Integer Pontos;
    private Integer Jornada;
    private Integer JogosGanhos;
    private Integer JogosPerdidos;
    private Integer JogosEmpatados;
    private Integer GolosMarcados;
    private Integer GolosSofridos;


    public Classificacao {
        (Integer classificacaonum, Integer Pontos, Integer Jornada,
                Integer JogosGanhos, Integer JogosPerdidos, Integer JogosEmpatados,
                Integer GolosMarcados, Integer GolosSofridos)

        this.classificacaonum = classificacaonum;
        this.Pontos = Pontos;
        this.Jornada = Jornada;
        this.JogosGanhos = JogosGanhos;
        this.JogosPerdidos = JogosPerdidos;
        this.JogosEmpatados = JogosEmpatados;
        this.GolosMarcados = GolosMarcados;
        this.GolosSofridos = GolosSofridos;

    }

    public Integer getClassificacaonum() {
        return classificacaonum;
    }

    public void setClassificacaonum(Integer classificacaonum) {
        this.classificacaonum = classificacaonum;
    }

    public Integer getGolosMarcados() {
        return GolosMarcados;
    }

    public void setGolosSofridos(Integer golosSofridos) {
        GolosSofridos = golosSofridos;
    }

    public void setGolosMarcados(Integer golosMarcados) {
        GolosMarcados = golosMarcados;
    }

    public Integer getGolosSofridos() {
        return GolosSofridos;
    }

    public Integer getJogosEmpatados() {
        return JogosEmpatados;
    }

    public Integer getJogosGanhos() {
        return JogosGanhos;
    }

    public Integer getJogosPerdidos() {
        return JogosPerdidos;
    }

    public Integer getJornada() {
        return Jornada;
    }

    public Integer getPontos() {
        return Pontos;
    }

    public void setJogosEmpatados(Integer jogosEmpatados) {
        JogosEmpatados = jogosEmpatados;
    }

    public void setJogosGanhos(Integer jogosGanhos) {
        JogosGanhos = jogosGanhos;
    }

    public void setJogosPerdidos(Integer jogosPerdidos) {
        JogosPerdidos = jogosPerdidos;
    }
    public void setJornada(Integer jornada) {
        Jornada = jornada;
    }

    public void setPontos(Integer pontos) {
        Pontos = pontos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Classificacao)) return false;
        Classificacao that = (Classificacao) o;
        return Objects.equals(classificacaonum, that.classificacaonum) && Objects.equals(Pontos, that.Pontos) && Objects.equals(Jornada, that.Jornada) && Objects.equals(JogosGanhos, that.JogosGanhos) && Objects.equals(JogosPerdidos, that.JogosPerdidos) && Objects.equals(JogosEmpatados, that.JogosEmpatados) && Objects.equals(GolosMarcados, that.GolosMarcados) && Objects.equals(GolosSofridos, that.GolosSofridos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(classificacaonum, Pontos, Jornada, JogosGanhos, JogosPerdidos, JogosEmpatados, GolosMarcados, GolosSofridos);
    }
}