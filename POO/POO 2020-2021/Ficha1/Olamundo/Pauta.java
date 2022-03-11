
/**
 * Escreva a descrição da classe Pauta aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Pauta
{
   private int[][] notasTurma;
   
   public Pauta(int[][] valoreslidos){
    this.notasTurma = valoreslidos;
    }
    /**
     * alinea b
     */
    public int somaUC(int uc){
        int soma=0;
        for(int i=0; i<this.notasTurma.length;i++)
        soma+= this.notasTurma[i][uc];
        return soma;
    }
    
}
