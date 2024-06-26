package com.example.leitorclima.Utils;

import com.example.leitorclima.Models.Boxplot;
import com.example.leitorclima.Models.ModelRelatorioDH;
import com.example.leitorclima.Models.Registro;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

public class CsvExporter {

    public static void exportToCsvBox(List<Boxplot> data, Stage stage) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Salvar Arquivo CSV");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV Files", "*.csv"));

        File file = fileChooser.showSaveDialog(stage);
        if (file != null) {
            try (FileWriter writer = new FileWriter(file)) {
                writer.append("Indice;Limite Superior;Q3;Mediana;Q1;Limite Inferior\n");
                for (Boxplot boxplot : data) {
                    writer.append(boxplot.getIndice()).append(';')
                            .append(String.valueOf(boxplot.getLimiteSuperior())).append(';')
                            .append(String.valueOf(boxplot.getQ3())).append(';')
                            .append(String.valueOf(boxplot.getMediana())).append(';')
                            .append(String.valueOf(boxplot.getQ1())).append(';')
                            .append(String.valueOf(boxplot.getLimiteInferior())).append('\n');
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void exportToCsvSit(List<Registro> data, Stage stage) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Salvar Arquivo CSV");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV Files", "*.csv"));

        File file = fileChooser.showSaveDialog(stage);
        if (file != null) {
            try (FileWriter writer = new FileWriter(file)) {
                writer.append("Indice;Valor;Unidade de Medida;Data;Horário\n");
                for (Registro registro : data) {
                    writer.append(registro.getIndice()).append(';')
                            .append(String.valueOf(registro.getValor())).append(';')
                            .append(String.valueOf(registro.getUnidMed())).append(';')
                            .append(String.valueOf(registro.getData())).append(';')
                            .append(String.valueOf(registro.getHora())).append('\n');
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    public static void exportToCsvDH(List<ModelRelatorioDH> data, Stage stage) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Salvar Arquivo CSV");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV Files", "*.csv"));

        File file = fileChooser.showSaveDialog(stage);
        if (file != null) {
            try (FileWriter writer = new FileWriter(file)) {
                writer.append("DATA;HORA;Umid.;Pressao;Chuva;Temp.;Pto Orvalho;Radiacao;Vel.Vento;Raj.Vento;Insolacao;Nebulosidade;Dir.Vento\n");
                for (ModelRelatorioDH registro : data) {
                    writer.append(registro.getData()).append(';')
                            .append(registro.getHora()).append(';')
                            .append(registro.getUmidade()).append(';')
                            .append(registro.getPressao()).append(';')
                            .append(registro.getChuva()).append(';')
                            .append(registro.getTemperatura()).append(';')
                            .append(registro.getPontoOrvalho()).append(';')
                            .append(registro.getRadiacao()).append(';')
                            .append(registro.getVelocidadeVento()).append(';')
                            .append(registro.getRajadaVento()).append(';')
                            .append(registro.getInsolacao()).append(';')
                            .append(registro.getNebulosidade()).append(';')
                            .append(registro.getDirecaoVento()).append('\n');
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}