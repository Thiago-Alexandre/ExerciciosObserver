package model;

/**
 * Esta classe realiza as mesmas operações da classe TempoPrevisao,
 * porém, esta classe só irá atualizar os dados na primeira vez que
 * for notificada ou após ser notificada 10 vezes. Ou seja, ela realiza 
 * a previsão do tempo quando possuir mais dados atualizados e não a cada
 * novo dado obtido pela classe DadosMeteorologicos.
 */
public class TempoPrevisaoComDelay implements ComportamentoObservador, ComportamentoMostrarDados{
    
    private DadosMeteorologicos dadosTempo;
    private int probabilidadeChuva;
    private int probabilidadeSol;
    private int probabilidadeNublado;
    private int probabilidadeTempestade;
    private int contador;
    
    public TempoPrevisaoComDelay(){
        dadosTempo = null;
        contador = -1;
    }
    
    @Override
    public void atualizarDados(ComportamentoSujeito sujeito) {
        dadosTempo = (DadosMeteorologicos) sujeito;
        
        if (contador == -1 || contador == 10) {
            
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
            contador = 0;
        } else{
            contador++;
        }
    }

    @Override
    public void mostrarDados() {
        System.out.println("------------------------------------------");
        if (dadosTempo != null) {
            System.out.println("Previsão do Tempo (Atualizada a cada 10 novos dados):");
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