package threadpool;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
public class ThreadPool {
    
    public static void preencher(int m[][]){
        Random rnd = new Random();
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                m[i][j] = rnd.nextInt(10);
            }
        }
    }
    public static void imprimir(int m[][]){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.print(m[i][j]+"   ");
            }
            System.out.println(" ");
        }
    }
    
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        
        int m[][] = new int[3][3];
        preencher(m);
        imprimir(m);
        System.out.println("  ");
        QuadradoCallable linha1 = new QuadradoCallable(m[0]);
        QuadradoCallable linha2 = new QuadradoCallable(m[1]);
        QuadradoCallable linha3 = new QuadradoCallable(m[2]);
        
        ExecutorService pool;
        pool = Executors.newWorkStealingPool();
        
        Future<Integer> r1 = pool.submit(linha1);
        Future<Integer> r2 = pool.submit(linha2);
        Future<Integer> r3 = pool.submit(linha3);
        System.out.println(r1.get());
        System.out.println(r2.get());
        System.out.println(r3.get());
        pool.shutdown();
    }
    
}
