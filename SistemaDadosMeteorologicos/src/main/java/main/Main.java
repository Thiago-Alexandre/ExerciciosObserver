package main;

import model.DadosMeteorologicos;
import model.TempoAtual;
import model.TempoEstatisticas;
import model.TempoPrevisao;
import model.TempoPrevisaoComDelay;

public class Main {
    
    public static void main(String[] args){
        System.out.println("------------------------------------------");
        System.out.println("Carregando Dados Meteorologicos...");
        DadosMeteorologicos dados = new DadosMeteorologicos();
        dados.setTemperatura(20f);
        dados.setUmidade(60f);
        dados.setPressao(30f);
        System.out.println("------------------------------------------");
        
        System.out.println("Carregando Módulo de Tempo Atual...");
        TempoAtual atual = new TempoAtual();
        atual.mostrarDados();
        System.out.println("Carregando Módulo de Estatísticas de Tempo...");
        TempoEstatisticas estatisticas = new TempoEstatisticas();
        estatisticas.mostrarDados();
        System.out.println("Carregando Módulo de Previsão de Tempo...");
        TempoPrevisao previsao = new TempoPrevisao();
        previsao.mostrarDados();
        System.out.println("Carregando Módulo de Previsão de Tempo com delay...");
        TempoPrevisaoComDelay previsaoDelay = new TempoPrevisaoComDelay();
        previsaoDelay.mostrarDados();
        
        System.out.println("Iniciando a sincronização de dados com os módulos...");
        dados.registrarObservador(atual);
        dados.registrarObservador(estatisticas);
        dados.registrarObservador(previsao);
        dados.registrarObservador(previsaoDelay);
        System.out.println("------------------------------------------");
        
        System.out.println("Mostrando dados dos módulos...");
        atual.mostrarDados();
        estatisticas.mostrarDados();
        previsao.mostrarDados();
        previsaoDelay.mostrarDados();
        
        System.out.println("Atualizando dados...");
        dados.setTemperatura(25f);
        dados.setUmidade(70f);
        dados.setPressao(40f);
        
        System.out.println("Mostrando dados dos módulos...");
        atual.mostrarDados();
        estatisticas.mostrarDados();
        previsao.mostrarDados();
        previsaoDelay.mostrarDados();
        
        System.out.println("Atualizando dados...");
        dados.setTemperatura(28f);
        dados.setUmidade(80f);
        dados.setPressao(48f);
        
        System.out.println("Mostrando dados dos módulos...");
        atual.mostrarDados();
        estatisticas.mostrarDados();
        previsao.mostrarDados();
        previsaoDelay.mostrarDados();
        
        System.out.println("Atualizando dados...");
        dados.setTemperatura(35f);
        dados.setUmidade(90f);
        dados.setPressao(90f);
        
        System.out.println("Mostrando dados dos módulos...");
        atual.mostrarDados();
        estatisticas.mostrarDados();
        previsao.mostrarDados();
        previsaoDelay.mostrarDados();
        
        System.out.println("Atualizando dados...");
        dados.setTemperatura(40f);
        dados.setUmidade(95f);
        dados.setPressao(95f);
        
        System.out.println("Mostrando dados dos módulos...");
        atual.mostrarDados();
        estatisticas.mostrarDados();
        previsao.mostrarDados();
        previsaoDelay.mostrarDados();
        
        System.out.println("Removendo módulo de Tempo Atual...");
        dados.removerObservador(atual);
        System.out.println("------------------------------------------");
        
        System.out.println("Atualizando dados...");
        dados.setTemperatura(20f);
        
        System.out.println("Mostrando dados dos módulos...");
        atual.mostrarDados();
        estatisticas.mostrarDados();
        previsao.mostrarDados();
        previsaoDelay.mostrarDados();
        
        System.out.println("Atualizando dados...");
        dados.setUmidade(55f);
        
        System.out.println("Mostrando dados dos módulos...");
        atual.mostrarDados();
        estatisticas.mostrarDados();
        previsao.mostrarDados();
        previsaoDelay.mostrarDados();
        
        System.out.println("Atualizando dados...");
        dados.setPressao(68f);
        
        System.out.println("Mostrando dados dos módulos...");
        atual.mostrarDados();
        estatisticas.mostrarDados();
        previsao.mostrarDados();
        previsaoDelay.mostrarDados();
        
        System.out.println("Adicionando módulo de Tempo Atual...");
        dados.registrarObservador(atual);
        System.out.println("------------------------------------------");
        
        System.out.println("Atualizando dados...");
        dados.setTemperatura(31f);
        dados.setUmidade(41f);
        dados.setPressao(95f);
        
        System.out.println("Mostrando dados dos módulos...");
        atual.mostrarDados();
        estatisticas.mostrarDados();
        previsao.mostrarDados();
        previsaoDelay.mostrarDados();
        
        System.out.println("Finalizando o Sistema...");
    }
}