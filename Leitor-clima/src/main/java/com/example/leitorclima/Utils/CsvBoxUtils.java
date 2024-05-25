package com.example.leitorclima.Utils;

import com.example.leitorclima.Models.Boxplot;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvBoxUtils {

    public static void exportarBoxplotsParaCSV(Stage stage, String estacao, String data, List<Boxplot> listaBoxplot) throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Salvar Arquivo CSV");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV Files", "*.csv"));
        fileChooser.setInitialFileName("dados_boxplot.csv");
        fileChooser.setInitialDirectory(new java.io.File(System.getProperty("user.home")));
        
        java.io.File file = fileChooser.showSaveDialog(stage);
        if (file != null) {
            try (FileWriter writer = new FileWriter(file)) {
                writer.append("Estacao;Data;Indice;Limite Superior;Q3;Mediana (Q2);Q1;Limite Inferior\n");
                for (Boxplot boxplot : listaBoxplot) {
                    writer.append(estacao).append(";")
                          .append(data).append(";")
                          .append(boxplot.getIndice()).append(";")
                          .append(String.valueOf(boxplot.getLimiteSuperior())).append(";")
                          .append(String.valueOf(boxplot.getQ3())).append(";")
                          .append(String.valueOf(boxplot.getMediana())).append(";")
                          .append(String.valueOf(boxplot.getQ1())).append(";")
                          .append(String.valueOf(boxplot.getLimiteInferior())).append("\n");
                }
            }
        }
    }
}
