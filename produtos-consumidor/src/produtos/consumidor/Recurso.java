package produtos.consumidor;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Recurso {
    
    String mensagem;
    private boolean vazia = true;
    
    public synchronized void colocar(String mensagem){
        
        while( ! vazia){
            
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Recurso.class.getName()).log(Level.SEVERE, null, ex);
            }
        vazia = false;
        this.mensagem = mensagem;
        notifyAll();
        }
    }
}
    

