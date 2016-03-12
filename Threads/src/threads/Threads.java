package threads;
public class Threads {

    public static void main(String[] args) throws InterruptedException {
        
        ContaCorrente cc;
        cc = new ContaCorrente(2000000);
        
        PessoaRunnable p1;
        p1 = new PessoaRunnable(cc);
        PessoaRunnable p2;
        p2 = new PessoaRunnable(cc);
        
        Thread th1 = new Thread(p1);
        Thread th2 = new Thread(p2);
        
        th1.start();
        th2.start();
        
        th1.join();
        th2.join();
        
        System.out.println("Saldo final: "+ cc.getSaldo());
                
    }
    
}
