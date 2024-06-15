package com.example.leitorclima.Models;

public class Estacao {
    private String idEstacao;
    private String nomeEstacao;
    private String latitude;
    private String longitude;

    public Estacao(String nomeEstacao, String latitude, String longitude) {
        this.nomeEstacao = nomeEstacao;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getNomeEstacao() {
        return nomeEstacao;
    }

    public void setNomeEstacao(String nomeEstacao) {
        this.nomeEstacao = nomeEstacao;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}