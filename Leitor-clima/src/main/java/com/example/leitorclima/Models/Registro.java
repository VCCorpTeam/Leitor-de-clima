package com.example.leitorclima.Models;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.control.CheckBox;

public class Registro {

    private String indice;
    private String data;
    private String hora;
    private String idArquivo;
    private String valor;
    private String unidMed;

    public Registro(String indice, String data, String hora, String idArquivo, String valor, String undiMed) {
        this.indice = indice;
        this.data = data;
        this.hora = hora;
        this.idArquivo = idArquivo;
        this.valor = valor;
        this.unidMed = undiMed;
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

    public String getUnidMed() { return unidMed; }

    public void setValor(String valor) {
        this.valor = valor;
    }
    public void setUnidMed(String unidMed) {
        this.unidMed = unidMed;
    }
}
