package com.example.leitorclima.Models;

public class Arquivo {

    private String idArquivo;
    private String cidade;
    private String estacao;

    public Arquivo(String idArquivo, String cidade, String estacao) {
        this.idArquivo = idArquivo;
        this.cidade = cidade;
        this.estacao = estacao;
    }

    public String getIdArquivo() {
        return idArquivo;
    }
}
