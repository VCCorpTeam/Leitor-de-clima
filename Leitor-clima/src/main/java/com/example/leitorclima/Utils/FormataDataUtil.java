package com.example.leitorclima.Utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FormataDataUtil {
    public static String formataData(String dataInserida) {
        String dataString = dataInserida;

        // Define o formato da data de entrada
        DateTimeFormatter formatoEntrada = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Converte a string de data para LocalDate usando o formato de entrada
        LocalDate data = LocalDate.parse(dataString, formatoEntrada);

        // Define o formato da data de saída
        DateTimeFormatter formatoSaida = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // Converte a data para o formato desejado
        String dataFormatada = data.format(formatoSaida);

        return dataFormatada;
    }

}
