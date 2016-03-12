package threads;
public class ContaCorrente {
    
    private double saldo;


    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    public ContaCorrente(double saldoInicial){
        saldo = saldoInicial;
    }
    public void debitar(double valor){
        synchronized(this){
            saldo -= valor;
        }
    }
    
}
