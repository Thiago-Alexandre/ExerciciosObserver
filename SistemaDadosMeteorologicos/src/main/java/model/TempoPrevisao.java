package model;

public class TempoPrevisao implements ComportamentoObservador, ComportamentoMostrarDados{

    private DadosMeteorologicos dadosTempo;
    private int probabilidadeChuva;
    private int probabilidadeSol;
    private int probabilidadeNublado;
    private int probabilidadeTempestade;
    
    public TempoPrevisao(){
        dadosTempo = null;
    }
    
    @Override
    public void atualizarDados(ComportamentoSujeito sujeito) {
        dadosTempo = (DadosMeteorologicos) sujeito;
        
        /**
         * Apenas uma simulação do uso dos dados para gerar uma "previsão do tempo".
         * Neste caso, não será necessário verificar se algum dado não foi atualizado, pois a previsão do tempo poderá ser alterada ....
         */
        if (dadosTempo.getTemperatura() > 35 && dadosTempo.getUmidade() > 90 && dadosTempo.getPressao() > 90) {
            probabilidadeTempestade = 60;
            probabilidadeChuva = 30;
            probabilidadeNublado = 8;
            probabilidadeSol = 2;
        } else if (dadosTempo.getTemperatura() > 30 && dadosTempo.getUmidade() > 80 && dadosTempo.getPressao() > 80){
            probabilidadeTempestade = 10;
            probabilidadeChuva = 70;
            probabilidadeNublado = 15;
            probabilidadeSol = 5;
        } else if (dadosTempo.getTemperatura() > 25 && dadosTempo.getUmidade() > 70 && dadosTempo.getPressao() > 40){
            probabilidadeTempestade = 2;
            probabilidadeChuva = 40;
            probabilidadeNublado = 40;
            probabilidadeSol = 18;
        } else if (dadosTempo.getTemperatura() > 20 && dadosTempo.getUmidade() > 60 && dadosTempo.getPressao() > 30){
            probabilidadeTempestade = 0;
            probabilidadeChuva = 10;
            probabilidadeNublado = 30;
            probabilidadeSol = 60;
        } else{
            probabilidadeTempestade = 0;
            probabilidadeChuva = 10;
            probabilidadeNublado = 50;
            probabilidadeSol = 40;
        }
    }

    @Override
    public void mostrarDados() {
        System.out.println("------------------------------------------");
        if (dadosTempo != null) {
            System.out.println("Previsão do Tempo:");
            System.out.println("Probabilidade de Sol: " + probabilidadeSol + "%");
            System.out.println("Probabilidade de Chuva: " + probabilidadeChuva + "%");
            System.out.println("Probabilidade de Tempo nublado: " + probabilidadeNublado + "%");
            System.out.println("Probabilidade de Tempestade: " + probabilidadeTempestade + "%");
        } else{
            System.out.println("Não há dados atualizados para mostrar!");
        }
        System.out.println("------------------------------------------");
    }
}