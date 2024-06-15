package com.example.leitorclima.Models;

import java.util.List;

public class DadosEnvio {
    private List<String> dados;
    private List<Integer> listaUnidSit;

    public DadosEnvio(List<String> dados, List<Integer> listaUnidSit) {
        this.dados = dados;
        this.listaUnidSit = listaUnidSit;
    }

    public List<String> getDados() {
        return dados;
    }

    public List<Integer> getListaUnidSit() {
        return listaUnidSit;
    }
}
