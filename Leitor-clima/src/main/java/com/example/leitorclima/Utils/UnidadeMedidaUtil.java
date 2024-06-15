package com.example.leitorclima.Utils;

import com.example.leitorclima.Models.Registro;

import java.util.List;

public class UnidadeMedidaUtil {

    private static double valorAntes;
    private static String valorDepois;

    public static List<Registro> alteraUnid(List<Integer> listaUnid,List<Registro> listaRegistros){

        for( int i = 0; i<listaRegistros.size(); i++){
            String indice = listaRegistros.get(i).getIndice();

            if (indice.contains("Temp"))  {
                switch (listaUnid.get(0)) { //temp
                    case 1: // Celsius
                        continue;
                    case 2: // Kelvin
                        valorAntes = Double.valueOf(listaRegistros.get(i).getValor());
                        valorDepois = String.valueOf(valorAntes + 273);
                        listaRegistros.get(i).setValor(valorDepois);
                        listaRegistros.get(i).setUnidMed("K");
                    case 3: // Fahrenheit
                        valorAntes = Double.valueOf(listaRegistros.get(i).getValor());
                        valorDepois = String.valueOf((valorAntes - 32)/9 );
                        listaRegistros.get(i).setValor(valorDepois);
                        listaRegistros.get(i).setUnidMed("F");
                }
            } else if (indice.contains("Pto")) {
                switch (listaUnid.get(1)) { //Pto Orvalho
                    case 1: // Celsius
                        continue;
                    case 2: // Kelvin
                        valorAntes = Double.valueOf(listaRegistros.get(i).getValor());
                        valorDepois = String.valueOf(valorAntes + 273);
                        listaRegistros.get(i).setValor(valorDepois);
                        listaRegistros.get(i).setUnidMed("K");
                    case 3: // Fahrenheit
                        valorAntes = Double.valueOf(listaRegistros.get(i).getValor());
                        valorDepois = String.valueOf((valorAntes - 32)/9 );
                        listaRegistros.get(i).setValor(valorDepois);
                        listaRegistros.get(i).setUnidMed("F");
                }
            } else if (indice.contains("Vel")) {
                switch (listaUnid.get(2)) { //Vel. Vento
                    case 1: // m/s
                        continue;
                    case 2: // km/h
                        valorAntes = Double.valueOf(listaRegistros.get(i).getValor());
                        valorDepois = String.valueOf(valorAntes*3.6 );
                        listaRegistros.get(i).setValor(valorDepois);
                        listaRegistros.get(i).setUnidMed("km/h");
                }
            } else if (indice.contains("Raj")) {
                switch (listaUnid.get(3)) { //Raj. Vento
                    case 1: // m/s
                        continue;
                    case 2: // km/h
                        valorAntes = Double.valueOf(listaRegistros.get(i).getValor());
                        valorDepois = String.valueOf(valorAntes*3.6 );
                        listaRegistros.get(i).setValor(valorDepois);
                        listaRegistros.get(i).setUnidMed("km/h");
                }
            } else if (indice.contains("Dir")) {
                switch (listaUnid.get(1)) { //Dir. Vento
                    case 1: // m/s
                        continue;
                    case 2: // km/h
                        valorAntes = Double.valueOf(listaRegistros.get(i).getValor());
                        valorDepois = String.valueOf(valorAntes*3.6 );
                        listaRegistros.get(i).setValor(valorDepois);
                        listaRegistros.get(i).setUnidMed("km/h");
                }
            }
        }

        return listaRegistros;
    }

}
