package model;

public class TempoEstatisticas implements ComportamentoObservador, ComportamentoMostrarDados{

    private DadosMeteorologicos dadosTempo;
    private float mediaTemperatura;
    private float minTemperatura;
    private float maxTemperatura;
    private float mediaUmidade;
    private float minUmidade;
    private float maxUmidade;
    private float mediaPressao;
    private float minPressao;
    private float maxPressao;
    private boolean atualizado;
    
    public TempoEstatisticas(){
        dadosTempo = null;
        atualizado = false;
    }
    
    @Override
    public void atualizarDados(ComportamentoSujeito sujeito) {
        dadosTempo = (DadosMeteorologicos) sujeito;
        
        /**
         * Deverá ser verificado se foi a primeira atualização dos dados,
         * sendo, assim, definidos os valores de estatísticas diretamente.
         * Deverá ser verificado se houve atualização dos dados, senão será calculada a média de forma incorreta, 
         * ou seja, será somado a média com um valor não atualizado e uma nova média será obtida, distorcendo a estatística.
         */
        if (!atualizado) {
            minTemperatura = dadosTempo.getTemperatura();
            minUmidade = dadosTempo.getUmidade();
            minPressao = dadosTempo.getPressao();
            maxTemperatura = dadosTempo.getTemperatura();
            maxUmidade = dadosTempo.getUmidade();
            maxPressao = dadosTempo.getPressao();
            mediaTemperatura = dadosTempo.getTemperatura();
            mediaUmidade = dadosTempo.getUmidade();
            mediaPressao = dadosTempo.getPressao();
            atualizado = true;
        } else{
            
            if (dadosTempo.isTemperaturaAlterada()) {
                
                if (dadosTempo.getTemperatura() < minTemperatura) {
                    minTemperatura = dadosTempo.getTemperatura();
                }
                if (dadosTempo.getTemperatura() > maxTemperatura) {
                    maxTemperatura = dadosTempo.getTemperatura();
                }
                mediaTemperatura = (mediaTemperatura + dadosTempo.getTemperatura())/2;
            }
            
            if (dadosTempo.isUmidadeAlterada()) {
                
                if (dadosTempo.getUmidade() < minUmidade) {
                    minUmidade = dadosTempo.getUmidade();
                }
                if (dadosTempo.getUmidade() > maxUmidade) {
                    maxUmidade = dadosTempo.getUmidade();
                }
                mediaUmidade = (mediaUmidade + dadosTempo.getUmidade())/2;
            }
            
            if (dadosTempo.isPressaoAlterada()) {
                
                if (dadosTempo.getPressao() < minPressao) {
                    minPressao = dadosTempo.getPressao();
                }
                if (dadosTempo.getPressao() > maxPressao) {
                    maxPressao = dadosTempo.getPressao();
                }
                mediaPressao = (mediaPressao + dadosTempo.getPressao())/2;
            }
        }
    }

    @Override
    public void mostrarDados() {
        System.out.println("------------------------------------------");
        if (dadosTempo != null) {
            System.out.println("Estatísticas do Tempo:");
            System.out.println("Temperatura mínima: " + minTemperatura);
            System.out.println("Temperatura máxima: " + maxTemperatura);
            System.out.println("Média Temperatura: " + mediaTemperatura);
            System.out.println("Mínima da Umidade do Ar: " + minUmidade);
            System.out.println("Máxima da Umidade do Ar: " + maxUmidade);
            System.out.println("Média da Umidade do Ar: " + mediaUmidade);
            System.out.println("Pressão Atmosférica mínima: " + minPressao);
            System.out.println("Pressão Atmosférica máxima: " + maxPressao);
            System.out.println("Média da Pressão Atmosférica: " + mediaPressao);
        } else{
            System.out.println("Não há dados atualizados para mostrar!");
        }
        System.out.println("------------------------------------------");
    }
}