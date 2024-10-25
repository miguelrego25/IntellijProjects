package Ex5;


import java.sql.Time;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class SistemadeSuporte {

    ArrayList<PedidodeSuporte> pedidos;

    // CONSTRUTORES //

    public SistemadeSuporte() {
        this(new ArrayList<PedidodeSuporte>());
    }

    public SistemadeSuporte(ArrayList<PedidodeSuporte> ps) {
        this.pedidos = new ArrayList<PedidodeSuporte>();
        for (PedidodeSuporte elem : ps)
            this.pedidos.add(elem.clone());
    }

    public SistemadeSuporte(SistemadeSuporte s) {
        this(s.pedidos);
    }

    // GETTER'S & SETTER'S //

    public List<PedidodeSuporte> getPedidos() {
        return this.pedidos.stream().map(PedidodeSuporte::clone).collect(Collectors.toList());
    }

    public void setPedidos(List<PedidodeSuporte> pedidos) {
        this.pedidos = new ArrayList<>();

        for (PedidodeSuporte p : pedidos) {
            this.pedidos.add(p.clone());
        }
    }


    // OUTROS MÉTODOS QUE TODAS AS CLASSES DEVEM CONTER //

    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || this.getClass() != o.getClass()) return false;

        SistemadeSuporte s = (SistemadeSuporte) o;
        boolean same = true;
        if (this.pedidos.size() != s.pedidos.size()) return false;

        for (int i = 0; same && i < this.pedidos.size(); i++) {
            same = this.pedidos.get(i).equals(s.pedidos.get(i));
        }

        return same;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Pedidos: ");

        for (PedidodeSuporte elem : this.pedidos) {
            sb.append(elem.toString());
            sb.append("\n");
        }
        return sb.toString();
    }

    public SistemadeSuporte clone() {
        return new SistemadeSuporte(this);
    }

    //METODOS

    //i. public void inserePedido(PedidodeSuporte pedido), que insere um novo pedido de suporte no sistema

    public void inserePedido(PedidodeSuporte pedido) {
        this.pedidos.add(pedido);
    }

    //public PedidodeSuporte procuraPedido(String user,
    //LocalDateTime data), que procura um pedido de suporte
    //dada a identificação de quem o criou e a instante em que foi
    //criado

    public PedidodeSuporte procuraPedido(String user, LocalDateTime data) {
        return this.pedidos.stream().filter(p -> p.getNome().equals(user)).filter(p -> p.getDate().equals(data)).findFirst().orElse(null);
    }

    //iii. public void resolvePedido(PedidodeSuporte pedido, String tecnico, String info),
    //que resolve um pedido de suporte indicando o técnico e a informação relacionada com o pedido.
    //Este método é responsável por preencher a informação de data/hora de resolução do pedido

    public void resolvePedido(PedidodeSuporte pedido, String tecnico, String info) {
        boolean enc = false;
        int i = 0;
        for (i = 0; !enc && i < this.pedidos.size(); i++) {
            enc = this.pedidos.get(i).equals(pedido);
        }
        if (enc) i--;                   // porque encontrou o pedido na posição atrás
        else {
            this.pedidos.add(pedido);
            i = this.pedidos.size() - 1;
        }
        pedido.setTratado(tecnico);
        pedido.setResposta(info);
        pedido.setDataTratado(LocalDateTime.now());
        this.pedidos.set(i, pedido);
    }

    //iv. public List<PedidodeSuporte> resolvidos(), que devolve todos os pedidos já resolvidos.
    // Crie uma versão comiteradores externos e outra com iteradores internos.

    //externo
    public List<PedidodeSuporte> resolvidos() {
        List<PedidodeSuporte> resolvs = new ArrayList<>();
        for (PedidodeSuporte pedido : pedidos) {
            if (!(pedido.getTratado().equals(""))) {
                resolvs.add(pedido);
            }
        }
        return resolvs;
    }

    //interno
    public List<PedidodeSuporte> resolvidos1() {
        return this.pedidos.stream().filter(pedido -> pedido.getTratado().equals("")).collect(Collectors.toList());
    }

    //v. public String colaboradorTop(), que devolve o colaborador que resolveu mais pedidos de suporte.
    //Crie uma versão com iteradores externos e outra com iteradores internos.

    //interno
    public String colaboradorTop() {
        ArrayList<PedidodeSuporte> lista = new ArrayList<>(this.pedidos);
        int max = -1;
        String colab = "";
        int resolvidos;
        for (PedidodeSuporte ped : lista) {
            resolvidos = (int) lista.stream().filter(a -> a.getTratado().equals(ped.getTratado())).count();
            if (resolvidos > max) {
                max = resolvidos;
                colab = ped.getTratado();
            }
        }
        return colab;
    }
    //externo

    //vi. public List<PedidodeSuporte> resolvidos(LocalDateTime inicio, LocalDateTime fim),
    //que devolve os pedidos resolvidos num determinado período de tempo.
    //Crie uma versão com iteradores externos e outra com iteradores internos.

    //externo
    public List<PedidodeSuporte> resolvidos(LocalDateTime inicio, LocalDateTime fim) {
        List<PedidodeSuporte> listaresolv = new ArrayList<>();
        for (PedidodeSuporte pedido : pedidos) {
            if (pedido.getDataTratado().isAfter(inicio) && pedido.getDataTratado().isBefore(fim)) {
                listaresolv.add(pedido);
            }
        }
        return listaresolv;
    }

    //interno
    public List<PedidodeSuporte> resolvidos1(LocalDateTime inicio, LocalDateTime fim) {
        return this.pedidos.stream().filter(pedido -> pedido.getDataTratado().isAfter(inicio) && pedido.getDataTratado().isBefore(fim)).collect(Collectors.toList());
    }

    //vii. public double tempoMedioResolucao(), que calcula a média em minutos do tempo de resolução dos pedidos.
    //Crie uma versão com iteradores externos e outra com iteradores internos.

    public double tempoMedioResolucao() {
        DoubleStream lista =  this.pedidos.stream().filter(a->!a.getTratado().equals("")).mapToDouble(a->ChronoUnit.MINUTES.between(a.getDate(), a.getDataTratado()));
        return lista.sum() / lista.count();
    }


    //viii. public double tempoMedioResolucao(LocalDateTime inicio, LocalDateTime fim),
    //que calcula a média em minutos do tempo de resolução dos pedidos concluídos num determinado período

    public double tempoMedioResolucao(LocalDateTime inicio, LocalDateTime fim) {
        DoubleStream lista =  this.pedidos.stream().filter(a->a.getDate().isAfter(inicio) && a.getDate().isBefore(fim)).filter(a->!a.getTratado().equals("")).mapToDouble(a->ChronoUnit.MINUTES.between(a.getDate(), a.getDataTratado()));
        return lista.sum() / lista.count();
    }

    //ix. public PedidodeSuporte pedidoMaisLongo(), que devolve o pedido de suporte que demorou mais tempo a ser resolvido

    public PedidodeSuporte pedidoMaisLongo() {
        return this.pedidos.stream().filter(a -> !a.getTratado().equals("")).max((p1, p2) -> p1.getDate().compareTo(p2.getDataTratado())).orElse(null);
    }


    //x. public PedidodeSuporte pedidoMaisLongo(LocalDateTime inicio, LocalDateTime fim),
    //que devolve, dos pedidos resolvidos num determinado intervalo, o que demorou mais tempo a ser resolvido

    public PedidodeSuporte pedidoMaisLongo(LocalDateTime inicio, LocalDateTime fim) {
        return this.pedidos.stream().filter(a->a.getDate().isAfter(inicio) && a.getDate().isBefore(fim)).filter(a -> !a.getTratado().equals("")).max((p1, p2) -> p1.getDate().compareTo(p2.getDataTratado())).orElse(null);
    }

    //xi. public PedidodeSuporte pedidoMaisCurto(), que devolve o pedido de suporte que demorou menos tempo a ser resolvido

    public PedidodeSuporte pedidoMaisCurto() {
        return this.pedidos.stream().filter(a -> !a.getTratado().equals("")).min((p1, p2) -> p1.getDate().compareTo(p2.getDataTratado())).orElse(null);
    }

    //xii. public PedidodeSuporte pedidoMaisCurto(LocalDateTime inicio, LocalDateTime fim),
    //que devolve, dos pedidos resolvidos num determinado intervalo, o que demorou menos tempo a ser resolvido

    public PedidodeSuporte pedidoMaisCurto(LocalDateTime inicio, LocalDateTime fim) {
        ArrayList<PedidodeSuporte> lista = new ArrayList<>(this.pedidos).stream()
                .filter(a -> !a.getTratado().equals("") && a.getDataTratado().isAfter(inicio) && a.getDataTratado().isBefore(fim))
                .sorted(Comparator.comparing(a -> ChronoUnit.MINUTES.between(a.getDate(), a.getDataTratado())))
                .collect(Collectors.toCollection(ArrayList::new));

        if (lista.isEmpty()) return null;

        return lista.stream().findFirst().orElse(null).clone();
    }

}
