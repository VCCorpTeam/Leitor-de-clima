package com.example.leitorclima.Models;

public class Line {
    private String data;
    private String hora;
    private String tempIns;
    private String tempMax;
    private String tempMin;
    private String umiIns;
    private String umiMax;
    private String umiMin;
    private String ptoOrvalhoIns;
    private String ptoOrvalhoMax;
    private String ptoOrvalhoMin;
    private String pressaoIns;
    private String pressaoMax;
    private String pressaoMin;
    private String velVento;
    private String dirVento;
    private String rajVento;
    private String radiacao;
    private String chuva;

    public Line(String data, String hora, String tempIns, String tempMax, String tempMin, String umiIns, String umiMax, String umiMin, String ptoOrvalhoIns, String ptoOrvalhoMax, String ptoOrvalhoMin, String pressaoIns, String pressaoMax, String pressaoMin, String velVento, String dirVento, String rajVento, String radiacao, String chuva) {
        this.data = data;
        this.hora = hora;
        this.tempIns = tempIns;
        this.tempMax = tempMax;
        this.tempMin = tempMin;
        this.umiIns = umiIns;
        this.umiMax = umiMax;
        this.umiMin = umiMin;
        this.ptoOrvalhoIns = ptoOrvalhoIns;
        this.ptoOrvalhoMax = ptoOrvalhoMax;
        this.ptoOrvalhoMin = ptoOrvalhoMin;
        this.pressaoIns = pressaoIns;
        this.pressaoMax = pressaoMax;
        this.pressaoMin = pressaoMin;
        this.velVento = velVento;
        this.dirVento = dirVento;
        this.rajVento = rajVento;
        this.radiacao = radiacao;
        this.chuva = chuva;
    }
}
