package threads;

public class PessoaRunnable implements Runnable {
    private final ContaCorrente conta;
    
    public PessoaRunnable(ContaCorrente conta){
        this.conta = conta;
    }
    
    @Override
    public void run() {
        synchronized(conta){
            for(int i=0;i<1000000;i++){
                conta.debitar(1.0);
            }
        }
    }
    
}
