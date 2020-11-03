package model;

import java.util.ArrayList;
import java.util.List;

public class DadosMeteorologicos implements ComportamentoSujeito{

    private float temperatura;
    private float umidade;
    private float pressao;
    private boolean temperaturaAlterada;
    private boolean umidadeAlterada;
    private boolean pressaoAlterada;
    private List<ComportamentoObservador> observadores;
    
    public DadosMeteorologicos(){
        observadores = new ArrayList();
        temperaturaAlterada = false;
        umidadeAlterada = false;
        pressaoAlterada = false;
    }
    
    /**
     * Utilizei a abordagem de que o observador, ao ser registrado, já recebe a atualização dos dados.
     */
    @Override
    public void registrarObservador(ComportamentoObservador observador) {
        observadores.add(observador);
        observador.atualizarDados(this);
    }

    @Override
    public void removerObservador(ComportamentoObservador observador) {
        observadores.remove(observador);
    }

    /**
     * Utilizei a abordagem de que o observador irá receber um objeto do sujeito com os dados atualizados.
     * A atualização ocorre sempre que um novo dado for definido (métodos sets).
     * Além do sujeito controlar quais dados foram ou não atualizados e os observadores poderem usufruir 
     * desta informação, se acharem necessário.
     */
    @Override
    public void notificarObservadores() {
        for(ComportamentoObservador o : observadores){
            o.atualizarDados(this);
        }
        temperaturaAlterada = false;
        umidadeAlterada = false;
        pressaoAlterada = false;
    }

    public float getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(float temperatura) {
        this.temperatura = temperatura;
        temperaturaAlterada = true;
        System.out.println("Nova temperatura: " + temperatura);
        notificarObservadores();
    }

    public float getUmidade() {
        return umidade;
    }

    public void setUmidade(float umidade) {
        this.umidade = umidade;
        umidadeAlterada = true;
        System.out.println("Nova umidade: " + umidade);
        notificarObservadores();
    }

    public float getPressao() {
        return pressao;
    }

    public void setPressao(float pressao) {
        this.pressao = pressao;
        pressaoAlterada = true;
        System.out.println("Nova pressao: " + pressao);
        notificarObservadores();
    }

    public boolean isTemperaturaAlterada() {
        return temperaturaAlterada;
    }

    public void setTemperaturaAlterada(boolean temperaturaAlterada) {
        this.temperaturaAlterada = temperaturaAlterada;
    }

    public boolean isUmidadeAlterada() {
        return umidadeAlterada;
    }

    public void setUmidadeAlterada(boolean umidadeAlterada) {
        this.umidadeAlterada = umidadeAlterada;
    }

    public boolean isPressaoAlterada() {
        return pressaoAlterada;
    }

    public void setPressaoAlterada(boolean pressaoAlterada) {
        this.pressaoAlterada = pressaoAlterada;
    }
}