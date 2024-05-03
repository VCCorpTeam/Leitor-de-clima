package com.example.leitorclima.GUI;

import com.example.leitorclima.Models.Registro;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import static com.example.leitorclima.Utils.DbUtils.*;
//import static com.example.leitorclima.Utils.DbUtils.getArquivo;

public class FormsRelatorioController implements Initializable {

    @FXML
    private ComboBox<String> cbDado;
    @FXML
    private ComboBox<String> cbCidade;
    @FXML
    private DatePicker dpDataInicio;
    @FXML
    private DatePicker dpDataFim;
    @FXML
    private Button btnGeraRelatorio;
    @FXML
    private Button btnVoltaMenu;
    private List<String> listaCidade;
    private List<String> listaDado;
    float chuva;
    float dirVento;
    float insolacao;
    float nebulos;
    float pressao;
    float totalChuva;
    float totalDirVento;
    float totalInsolacao;
    float totalNebulos;
    float totalPresao;
    float medPressao = 0;
    float medChuva = 0;
    float medDirVento = 0;
    float medInsolacao = 0;
    float medNebulos = 0;


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        btnGeraRelatorio.setOnMouseClicked((MouseEvent mouse) -> {
            if (mouse.getClickCount() == 1)
                geraRelatorio();
        });

        btnVoltaMenu.setOnMouseClicked((MouseEvent mouse) -> {
            if (mouse.getClickCount() == 1)
                voltaMenu();
        });

        listaCidade = geraCidadeComboBox();
        listaDado = geraDadoComboBox();

        cbCidade.getItems().addAll(listaCidade);
        cbDado.getItems().addAll(listaDado);
    }

    private void geraRelatorio() {
        List<Registro> listaRegistro;
        String cidade = cbCidade.getValue();
        String dado = cbDado.getValue();
        String dataInicio = String.valueOf(dpDataInicio.getValue());
        String dataFim = String.valueOf(dpDataFim.getValue());

        System.out.println(cidade);
        System.out.println(dado);
        System.out.println(dataInicio);
        System.out.println(dataFim);

        listaRegistro = getArquivo(cidade,dataInicio,dataFim);

        for(Registro registro: listaRegistro ){
            if(registro.getIndice().equals("Chuva [Diaria] (mm)")){
                chuva ++;
                if (!registro.getValor().isEmpty()) {
                    totalChuva += Float.parseFloat(registro.getValor());
                } else {
                    totalChuva += 0;
                }
            }else if (registro.getIndice().equals("Dir. Vento (m/s)")){
                dirVento ++;
                if (!registro.getValor().isEmpty()) {
                    totalDirVento += Float.parseFloat(registro.getValor());
                } else {
                    totalDirVento += 0;
                }
            }else if (registro.getIndice().equals("Insolacao (h)")) {
                insolacao++;
                if (!registro.getValor().isEmpty()) {
                    totalInsolacao += Float.parseFloat(registro.getValor());
                } else {
                    totalInsolacao += 0;
                }
            }else if (registro.getIndice().equals("Nebulosidade (Decimos)")) {
                nebulos++;
                if (!registro.getValor().isEmpty()) {
                    totalNebulos += Float.parseFloat(registro.getValor());
                } else {
                    totalNebulos += 0;
                }
            }else if (registro.getIndice().equals("Pressao (hPa)")) {
                pressao ++;
                if (!registro.getValor().isEmpty()) {
                    totalPresao += Float.parseFloat(registro.getValor());
                } else {
                    totalPresao += 0;
                }
            }
        }
        if (chuva != 0) {
            medChuva = totalChuva/chuva;
        }  else {
            medChuva = 0;
        }
        if (dirVento != 0) {
            medDirVento = totalDirVento/dirVento;
        }  else {
            medDirVento = 0;
        }
        if (insolacao != 0) {
            medInsolacao = totalInsolacao/insolacao;
        }  else {
            medInsolacao = 0;
        }
        if (nebulos != 0) {
            medNebulos = totalNebulos/nebulos;
        }  else {
            medNebulos = 0;
        }
        if (pressao != 0) {
            medPressao = totalPresao/pressao;
        }  else {
            medPressao = 0;
        }


        System.out.println("--MEDIAS--");
        System.out.println(medChuva);
        System.out.println(medDirVento);
        System.out.println(medInsolacao);
        System.out.println(medNebulos);
        System.out.println(medPressao);
    }

    private void voltaMenu() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/leitorclima/menu.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) btnVoltaMenu.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
