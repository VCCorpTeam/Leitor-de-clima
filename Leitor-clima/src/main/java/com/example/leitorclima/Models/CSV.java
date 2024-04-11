package com.example.leitorclima.Models;

import java.util.ArrayList;

public class CSV {

    private ArrayList<Line> minhaLista;

    public CSV(ArrayList<Line> minhaLista) {
        this.minhaLista = minhaLista;
    }

    public ArrayList<Line> getMinhaLista() {
        return minhaLista;
    }

    public void setMinhaLista(ArrayList<Line> minhaLista) {
        this.minhaLista = minhaLista;
    }

    public void adicionarElemento(Line x) {
        this.minhaLista.add(x);
    }

}
