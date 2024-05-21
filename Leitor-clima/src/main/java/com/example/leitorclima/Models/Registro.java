package com.example.leitorclima.Models;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.control.CheckBox;

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

    public String getIndice() {
        return indice;
    }

    public String getData() {
        return data;
    }

    public String getHora() {
        return hora;
    }

    public String getIdArquivo() {
        return idArquivo;
    }

    public String getValor() {
        return valor;
    }
}
