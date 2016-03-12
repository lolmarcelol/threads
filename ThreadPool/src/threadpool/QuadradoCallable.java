package threadpool;

import java.util.concurrent.Callable;

public class QuadradoCallable implements Callable<Integer> {

    private final int[] dados;

    public QuadradoCallable(int dados[]){
        this.dados = dados;
    }
    
    @Override
    public Integer call() throws Exception {
       int total =0;
        for(int i=0;i<dados.length;i++){
           total += dados[i] * dados[i];
       }
        return total;
    }
   
}
