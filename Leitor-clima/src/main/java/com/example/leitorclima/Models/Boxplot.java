package com.example.leitorclima.Models;

public class Boxplot {

    private String indice;
    private double limiteSuperior;
    private double q3;
    private double mediana;
    private double q1;
    private double limiteInferior;

    public Boxplot(String indice, double limiteSuperior, double q3, double mediana, double q1, double limiteInferior) {
        this.indice = indice;
        this.limiteSuperior = limiteSuperior;
        this.q3 = q3;
        this.mediana = mediana;
        this.q1 = q1;
        this.limiteInferior = limiteInferior;
    }

    public String getIndice() {
        return indice;
    }

    public double getLimiteSuperior() {
        return limiteSuperior;
    }

    public double getQ3() {
        return q3;
    }

    public double getMediana() {
        return mediana;
    }

    public double getQ1() {
        return q1;
    }

    public double getLimiteInferior() {
        return limiteInferior;
    }
}
