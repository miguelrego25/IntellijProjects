import java.util.ArrayList;


public class Equipa
{
    // variáveis de instância 
    private String NomeEquipa;
    private double HabilidadeEquipa;
    private int numJogadores;
    private int Classificação;
    private String Nacionalidade;
    private ArrayList<Jogador> Jogadores;
    private ArrayList<Jogador> Titulares;
    private ArrayList<Jogador> Suplentes; 
    
    
    //construtores
    
    public Equipa()
    {
        // inicializa variáveis de instância
        this.NomeEquipa = "";
        this.HabilidadeEquipa = 0;
        this.numJogadores = 0;
        this.Classificação = 0;
        this.Nacionalidade = "";
        this.Jogadores= new ArrayList<Jogador>();
        this.Titulares = new ArrayList<Jogador>();
        this.Suplentes = new ArrayList<Jogador>();
    }

    public Equipa(String n, double HaEq, int nJ, int Cla, String na, ArrayList<Jogador> Jgd, ArrayList<Jogador> Tit, ArrayList<Jogador> Sup)
    {
        // inicializa variáveis de instância
        this.NomeEquipa = n;
        this.HabilidadeEquipa = HaEq;
        this.numJogadores = nJ;
        this.Classificação = Cla;
        this.Nacionalidade = na;
        this.Jogadores= Jgd;
        this.Titulares= Tit;
        this.Suplentes= Sup;
    }
    
    public Equipa (Equipa nE){
        
             this.NomeEquipa = nE.getNomeEquipa();
             this.HabilidadeEquipa=nE.getHabilidadeEquipa();
             this.numJogadores=nE.getnumJogadores();
             this.Classificação=nE.getClassificação();
             this.Nacionalidade=nE.getNacionalidade();
             this.Jogadores=nE.getJogadores();
             this.Titulares=nE.getTitulares();
             this.Suplentes=nE.getSuplentes();
    }
    
    //getters and setters
    
    public String getNomeEquipa(){
        return this.NomeEquipa;
    }
    
    public double getHabilidadeEquipa(){
        return this.HabilidadeEquipa;
    }
    
    public int getnumJogadores(){
        return this.numJogadores;
    }
    
    public int getClassificação(){
        return this.Classificação;
    }   
    
    public String getNacionalidade(){
        return this.Nacionalidade;
    }
    
    public ArrayList<Jogador> getJogadores(){
        return this.Jogadores;
    }  
    
    public ArrayList<Jogador> getTitulares(){
        return this.Titulares;
    }  
    
    public ArrayList<Jogador> getSuplentes(){
        return this.Suplentes;
    }  
    
    public void setNomeEquipa(String a){
        this.NomeEquipa= a;
    }
    
    public void setHabilidadeEquipa(int a){
        this.HabilidadeEquipa= a;
    }
    
    public void setnumJogadores(int a){
        if (a > 18) System.out.print("Number of players must be under or equal to 18");
        else this.numJogadores= a;
    }
    
    public void setClassificação(int a){
        this.Classificação= a;
    }
    
    public void setNacionalidade(String a){
        this.Nacionalidade= a;
    }
    
    public void setJogadores(ArrayList<Jogador> a){
        this.Jogadores= new ArrayList<>();
        for (Jogador Jog : a ) {
            this.Jogadores.add(Jog.clone());
        }    
    } 
    
    public void setTitulares(ArrayList<Jogador> a){
        this.Titulares= new ArrayList<>();
        for (Jogador Tit : a ) {
            this.Titulares.add(Tit.clone());
        }    
    } 
    
    public void setSuplentes(ArrayList<Jogador> a){
        this.Suplentes= new ArrayList<>();
        for (Jogador Sup : a ) {
            this.Suplentes.add(Sup.clone());
        }    
    } 
    
    // equals, to string, clone
    
    public boolean equals(Object obj) {
        if(obj==this) return true;
        if(obj==null || obj.getClass() != this.getClass()) return false;
        Equipa mE = (Equipa) obj;
        return mE.getNomeEquipa().equals(this.NomeEquipa) &&
              mE.getHabilidadeEquipa()==(this.HabilidadeEquipa) && 
              mE.getnumJogadores()==(this.numJogadores)&&
              mE.getClassificação()==(this.Classificação) &&
              mE.getNacionalidade().equals(this.Nacionalidade)&&
              mE.getJogadores().equals(this.Jogadores)&&
              mE.getTitulares().equals(this.Titulares)&&
              mE.getSuplentes().equals(this.Suplentes);
    }
    
    public Equipa clone(){
            return new Equipa(this);
    }
    
    public String toString(){
        return "O nome da equipa:" + getNomeEquipa(); "com a habilidade de" + getHabilidadeEquipa(); "com" + getnumJogadores(); "jogadores, que está na:" +getClassificação(); "posição";
    
    }
    
    //metodos
    //adiciona um jogador a equipa
    public void AdicionaJogador(Jogador j, Equipa l){
        
        this.Jogadores = new ArrayList<>();
        j.add(Jogadores);
    
    }
    //remove jogador da equipa
    public void removeJogador(Jogador j){
        
        Jogadores.remove(j);
    
    }
    //poe jogador a titular
    public void putTitular(Jogador j){
        
        this.Titulares = new ArrayList<>();
        Titulares.add.
    
    }
    //poe jogador a suplente
    public void putSuplente(Jogador j){
        
        this.Suplentes = new ArrayList<>();
        Suplentes.add.
    
    }
    //calcula habilidade da equipa
    public void calcHabilidadeEquipa(){
        
        //ciclo for q percorre lista de Jogadores, retira habilidade e adiciona (+=) 
        //a variavel pre existente, apos isso fazer a media;
    
    }
    //calcula numero de jogadores da equipa
    public void calcJogadores(){
        
        //ciclo que percorre lista de jogadores e faz count a cada um que passa
        //return conta no fim;
    
    }
    
    
    
    
    
    
    
    
}
