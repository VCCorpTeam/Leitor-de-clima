package com.example.leitorclima.Models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ModelRelatorioDH {
    private final StringProperty data;
    private final StringProperty hora;
    private final StringProperty umidade;
    private final StringProperty pressao;
    private final StringProperty chuva;
    private final StringProperty temperatura;
    private final StringProperty pontoOrvalho;
    private final StringProperty radiacao;
    private final StringProperty velocidadeVento;
    private final StringProperty rajadaVento;
    private final StringProperty insolacao;
    private final StringProperty nebulosidade;
    private final StringProperty cidade;
    private final StringProperty direcaoVento;

    public ModelRelatorioDH(String data, String hora, String umidade, String pressao, String chuva,
                            String temperatura, String pontoOrvalho, String radiacao, String velocidadeVento,
                            String rajadaVento, String insolacao, String nebulosidade, String cidade, String direcaoVento) {
        this.data = new SimpleStringProperty(data);
        this.hora = new SimpleStringProperty(hora);
        this.umidade = new SimpleStringProperty(umidade);
        this.pressao = new SimpleStringProperty(pressao);
        this.chuva = new SimpleStringProperty(chuva);
        this.temperatura = new SimpleStringProperty(temperatura);
        this.pontoOrvalho = new SimpleStringProperty(pontoOrvalho);
        this.radiacao = new SimpleStringProperty(radiacao);
        this.velocidadeVento = new SimpleStringProperty(velocidadeVento);
        this.rajadaVento = new SimpleStringProperty(rajadaVento);
        this.insolacao = new SimpleStringProperty(insolacao);
        this.nebulosidade = new SimpleStringProperty(nebulosidade);
        this.cidade = new SimpleStringProperty(cidade);
        this.direcaoVento = new SimpleStringProperty(direcaoVento);
    }

    // Getters
    public String getData() {
        return data.get();
    }

    public String getHora() {
        return hora.get();
    }

    public String getUmidade() {
        return umidade.get();
    }

    public String getPressao() {
        return pressao.get();
    }

    public String getChuva() {
        return chuva.get();
    }

    public String getTemperatura() {
        return temperatura.get();
    }

    public String getPontoOrvalho() {
        return pontoOrvalho.get();
    }

    public String getRadiacao() {
        return radiacao.get();
    }

    public String getVelocidadeVento() {
        return velocidadeVento.get();
    }

    public String getRajadaVento() {
        return rajadaVento.get();
    }

    public String getInsolacao() {
        return insolacao.get();
    }

    public String getNebulosidade() {
        return nebulosidade.get();
    }

    public String getCidade() {
        return cidade.get();
    }

    public String getDirecaoVento() {
        return direcaoVento.get();
    }

    // Setters
    public void setData(String data) {
        this.data.set(data);
    }

    public void setHora(String hora) {
        this.hora.set(hora);
    }

    public void setUmidade(String umidade) {
        this.umidade.set(umidade);
    }

    public void setPressao(String pressao) {
        this.pressao.set(pressao);
    }

    public void setChuva(String chuva) {
        this.chuva.set(chuva);
    }

    public void setTemperatura(String temperatura) {
        this.temperatura.set(temperatura);
    }

    public void setPontoOrvalho(String pontoOrvalho) {
        this.pontoOrvalho.set(pontoOrvalho);
    }

    public void setRadiacao(String radiacao) {
        this.radiacao.set(radiacao);
    }

    public void setVelocidadeVento(String velocidadeVento) {
        this.velocidadeVento.set(velocidadeVento);
    }

    public void setRajadaVento(String rajadaVento) {
        this.rajadaVento.set(rajadaVento);
    }

    public void setInsolacao(String insolacao) {
        this.insolacao.set(insolacao);
    }

    public void setNebulosidade(String nebulosidade) {
        this.nebulosidade.set(nebulosidade);
    }

    public void setCidade(String cidade) {
        this.cidade.set(cidade);
    }

    public void setDirecaoVento(String direcaoVento) {
        this.direcaoVento.set(direcaoVento);
    }

    // Properties
    public StringProperty dataProperty() {
        return data;
    }

    public StringProperty horaProperty() {
        return hora;
    }

    public StringProperty umidadeProperty() {
        return umidade;
    }

    public StringProperty pressaoProperty() {
        return pressao;
    }

    public StringProperty chuvaProperty() {
        return chuva;
    }

    public StringProperty temperaturaProperty() {
        return temperatura;
    }

    public StringProperty pontoOrvalhoProperty() {
        return pontoOrvalho;
    }

    public StringProperty radiacaoProperty() {
        return radiacao;
    }

    public StringProperty velocidadeVentoProperty() {
        return velocidadeVento;
    }

    public StringProperty rajadaVentoProperty() {
        return rajadaVento;
    }

    public StringProperty insolacaoProperty() {
        return insolacao;
    }

    public StringProperty nebulosidadeProperty() {
        return nebulosidade;
    }

    public StringProperty cidadeProperty() {
        return cidade;
    }

    public StringProperty direcaoVentoProperty() {
        return direcaoVento;
    }
}
