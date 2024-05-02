package com.example.leitorclima.Models;

public class Registro {

    private String indice;
    private String data;
    private String hora;
    private String idArquivo;
    private String valor;

    public Registro(String indice, String data, String hora, String idArquivo, String valor) {
        this.indice = indice;
        this.data = data;
        this.hora = hora;
        this.idArquivo = idArquivo;
        this.valor = valor;
    }
}
