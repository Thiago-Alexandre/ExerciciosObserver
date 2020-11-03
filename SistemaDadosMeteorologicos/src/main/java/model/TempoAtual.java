package model;

public class TempoAtual implements ComportamentoObservador, ComportamentoMostrarDados{

    private DadosMeteorologicos dadosTempo;
    private float temperaturaAtual;
    private float umidadeAtual;
    private float pressaoAtual;
    
    public TempoAtual(){
        dadosTempo = null;
    }
    
    @Override
    public void atualizarDados(ComportamentoSujeito sujeito) {
        dadosTempo = (DadosMeteorologicos) sujeito;
        temperaturaAtual = dadosTempo.getTemperatura();
        umidadeAtual = dadosTempo.getUmidade();
        pressaoAtual = dadosTempo.getPressao();
    }

    @Override
    public void mostrarDados() {
        System.out.println("------------------------------------------");
        if (dadosTempo != null) {
            System.out.println("Informações Atuais do Tempo:");
            System.out.println("Temperatura: " + temperaturaAtual);
            System.out.println("Umidade do Ar: " + umidadeAtual);
            System.out.println("Pressão Atmosférica: " + pressaoAtual);    
        } else{
            System.out.println("Não há dados atualizados para mostrar!");
        }
        System.out.println("------------------------------------------");
    }
}