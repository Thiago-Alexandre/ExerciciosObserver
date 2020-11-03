package model;

public interface ComportamentoSujeito {
    
    public void registrarObservador(ComportamentoObservador observador);
    
    public void removerObservador(ComportamentoObservador observador);
    
    public void notificarObservadores();
}