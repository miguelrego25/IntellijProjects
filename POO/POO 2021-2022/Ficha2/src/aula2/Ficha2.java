package aula2;

import java.util.Arrays;

public class Ficha2 {

    public int minimo(int a[]){
        int min = Integer.MAX_VALUE;
        for (int j : a) {
            if (j < min) {
                min = j;
            }
        }
        return min;
    }

    public int minimo2(int a[]){
        int min = Integer.MAX_VALUE;
        for(int elem: a){
            if(elem<min){
                min = elem;
            }
        }
        return min;
    }
    public int[] arrayEntre(int[] a, int id1 ,int id2){
        if (id1<0 || id1 > a.length || id2<0 || id2> a.length ||id2 < id1 ){
            return null;
        }
        int[] res = new int[id2-id1+1];
        System.arraycopy(a,id1,res,0,id2-id1+1);
        return res;
    }

    public int[]comuns (int[] a, int[] b){
        Arrays.sort(a);
        Arrays.sort(b);

        int [] res = new int [Math.min(a.length, b.length )];
        int p = 0;

        for(int i = 0; i < a.length; i++) {

            if(i!=0 || a[i] != a[i-1]){
                boolean found = False;
                for(int j = 0; j < b.length; j++){
                if ( a[i] == b[j] ) {
                    res[p++] = a[i];
                    found = True;
                }
            }
        }
    }
    int[] res2 = new int[p];
    System.arraycopy(res,0,res2,0,p);
    return res2;
}
