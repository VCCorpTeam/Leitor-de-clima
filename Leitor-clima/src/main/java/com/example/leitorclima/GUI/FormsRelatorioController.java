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
import static com.example.leitorclima.Utils.DbUtils.getArquivo;
import static com.example.leitorclima.Utils.GeraPdfUtil.geraPdf;

public class FormsRelatorioController implements Initializable {

//    @FXML
//    private ComboBox<String> cbDado;
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
    float totalPressaoIns;
    float pressaoIns;
    float ptoOrvalho;
    float totalPtoOrvalho;
    float ptoOrvalhoIns;
    float totalPtoOrvalhoIns;
    float radiacao;
    float totalRadiacao;
    float rajVento;
    float totalRajVento;
    float temp;
    float totalTemp;
    float tempIns;
    float totalTempIns;
    float umi;
    float totalUmi;
    float umiIns;
    float totalUmiIns;
    float velVento;
    float totalVelVento;
    float medPressaoIns = 0;
    float medPtoOrvalho = 0;
    float medPtoOrvalhoIns = 0;
    float medRadiacao = 0;
    float medRajVento = 0;
    float medTemp = 0;
    float medTempIns = 0;
    float medVelVento = 0;
    float medUmi = 0;
    float medUmiIns = 0;





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
//        cbDado.getItems().addAll(listaDado);
    }

    private void geraRelatorio() {
        List<Registro> listaRegistro;
        String cidade = cbCidade.getValue();
//        String dado = cbDado.getValue();
        String dataInicio = String.valueOf(dpDataInicio.getValue());
        String dataFim = String.valueOf(dpDataFim.getValue());

        System.out.println(cidade);
//        System.out.println(dado);
        System.out.println(dataInicio);
        System.out.println(dataFim);

        listaRegistro = getArquivo(cidade,dataInicio,dataFim);


        for(Registro registro: listaRegistro ){
            if (registro.getIdArquivo().indexOf("A") == 0) {
                if(registro.getIndice().equals("Chuva (mm)")){
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
                }else if (registro.getIndice().equals("Pressao Ins. (hPa)")) {
                    pressaoIns++;
                    if (!registro.getValor().isEmpty()) {
                        totalPressaoIns += Float.parseFloat(registro.getValor());
                    } else {
                        totalPressaoIns += 0;
                    }
                }else if (registro.getIndice().equals("Pto Orvalho")) {
                    ptoOrvalho++;
                    if (!registro.getValor().isEmpty()) {
                        totalPtoOrvalho += Float.parseFloat(registro.getValor());
                    } else {
                        totalPtoOrvalho += 0;
                    }
                }else if (registro.getIndice().equals("Pressao")) {
                    pressao++;
                    if (!registro.getValor().isEmpty()) {
                        totalPresao += Float.parseFloat(registro.getValor());
                    } else {
                        totalPresao += 0;
                    }
                }else if (registro.getIndice().equals("Pto Orvalho Ins. (C)")) {
                    ptoOrvalhoIns++;
                    if (!registro.getValor().isEmpty()) {
                        totalPtoOrvalhoIns += Float.parseFloat(registro.getValor());
                    } else {
                        totalPtoOrvalhoIns += 0;
                    }
                }else if (registro.getIndice().equals("Radiacao (KJ/m²)")) {
                    radiacao++;
                    if (!registro.getValor().isEmpty()) {
                        totalRadiacao += Float.parseFloat(registro.getValor());
                    } else {
                        totalRadiacao += 0;
                    }
                }else if (registro.getIndice().equals("Raj. Vento (m/s)")) {
                    rajVento++;
                    if (!registro.getValor().isEmpty()) {
                        totalRajVento += Float.parseFloat(registro.getValor());
                    } else {
                        totalRajVento += 0;
                    }
                }else if (registro.getIndice().equals("Temp.")) {
                    temp++;
                    if (!registro.getValor().isEmpty()) {
                        totalTemp += Float.parseFloat(registro.getValor());
                    } else {
                        totalTemp += 0;
                    }
                }else if (registro.getIndice().equals("Temp. Ins. (C)")) {
                    tempIns++;
                    if (!registro.getValor().isEmpty()) {
                        totalTempIns += Float.parseFloat(registro.getValor());
                    } else {
                        totalTempIns += 0;
                    }
                }else if (registro.getIndice().equals("Umi.")) {
                    umi++;
                    if (!registro.getValor().isEmpty()) {
                        totalUmi += Float.parseFloat(registro.getValor());
                    } else {
                        totalUmi += 0;
                    }
                }else if (registro.getIndice().equals("Umi. Ins. (%)")) {
                    umiIns++;
                    if (!registro.getValor().isEmpty()) {
                        totalUmiIns += Float.parseFloat(registro.getValor());
                    } else {
                        totalUmiIns += 0;
                    }
                }else if (registro.getIndice().equals("Vel. Vento (m/s)")) {
                    velVento++;
                    if (!registro.getValor().isEmpty()) {
                        totalVelVento += Float.parseFloat(registro.getValor());
                    } else {
                        totalVelVento += 0;
                    }
                }

                if (chuva != 0) {
                    medChuva = totalChuva / chuva;
                } else {
                    medChuva = 0;
                }
                if (dirVento != 0) {
                    medDirVento = totalDirVento / dirVento;
                } else {
                    medDirVento = 0;
                }
                if (pressaoIns != 0) {
                    medPressaoIns = totalPressaoIns / pressaoIns;
                } else {
                    medPressaoIns = 0;
                }
                if (ptoOrvalho != 0) {
                    medPtoOrvalho = totalPtoOrvalho / ptoOrvalho;
                } else {
                    medPtoOrvalho = 0;
                }
                if (pressao != 0) {
                    medPressao = totalPresao / pressao;
                } else {
                    medPressao = 0;
                }
                if (ptoOrvalhoIns != 0) {
                    medPtoOrvalhoIns = totalPtoOrvalhoIns / ptoOrvalhoIns;
                } else {
                    medPtoOrvalhoIns = 0;
                }
                if (radiacao != 0) {
                    medRadiacao = totalRadiacao / radiacao;
                } else {
                    medRadiacao = 0;
                }
                if (rajVento != 0) {
                    medRajVento = totalRajVento / rajVento;
                } else {
                    medRajVento = 0;
                }
                if (temp != 0) {
                    medTemp = totalTemp / temp;
                } else {
                    medTemp = 0;
                }
                if (tempIns != 0) {
                    medTempIns = totalTempIns / tempIns;
                } else {
                    medTempIns = 0;
                }
                if (umi != 0) {
                    medUmi = totalUmi / umi;
                } else {
                    medUmi = 0;
                }
                if (umiIns != 0) {
                    medUmiIns = totalUmiIns / umiIns;
                } else {
                    medUmiIns = 0;
                }
                if (velVento != 0) {
                    medVelVento = totalVelVento / velVento;
                } else {
                    medVelVento = 0;
                }
            }
            else {
                if (registro.getIndice().equals("Chuva [Diaria] (mm)")) {
                    chuva++;
                    if (!registro.getValor().isEmpty()) {
                        totalChuva += Float.parseFloat(registro.getValor());
                    } else {
                        totalChuva += 0;
                    }
                } else if (registro.getIndice().equals("Dir. Vento (m/s)")) {
                    dirVento++;
                    if (!registro.getValor().isEmpty()) {
                        totalDirVento += Float.parseFloat(registro.getValor());
                    } else {
                        totalDirVento += 0;
                    }
                } else if (registro.getIndice().equals("Insolacao (h)")) {
                    insolacao++;
                    if (!registro.getValor().isEmpty()) {
                        totalInsolacao += Float.parseFloat(registro.getValor());
                    } else {
                        totalInsolacao += 0;
                    }
                } else if (registro.getIndice().equals("Nebulosidade (Decimos)")) {
                    nebulos++;
                    if (!registro.getValor().isEmpty()) {
                        totalNebulos += Float.parseFloat(registro.getValor());
                    } else {
                        totalNebulos += 0;
                    }
                } else if (registro.getIndice().equals("Pressao (hPa)")) {
                    pressao++;
                    if (!registro.getValor().isEmpty()) {
                        totalPresao += Float.parseFloat(registro.getValor());
                    } else {
                        totalPresao += 0;
                    }
                }else if (registro.getIndice().equals("Vel. Vento (m/s)")) {
                    velVento++;
                    if (!registro.getValor().isEmpty()) {
                        totalVelVento += Float.parseFloat(registro.getValor());
                    } else {
                        totalVelVento += 0;
                    }
                }else if (registro.getIndice().equals("Temp. [Hora] (K)")) {
                    temp++;
                    if (!registro.getValor().isEmpty()) {
                        totalTemp += Float.parseFloat(registro.getValor());
                    } else {
                        totalTemp += 0;
                    }
                }
                if (chuva != 0) {
                    medChuva = totalChuva / chuva;
                } else {
                    medChuva = 0;
                }
                if (dirVento != 0) {
                    medDirVento = totalDirVento / dirVento;
                } else {
                    medDirVento = 0;
                }
                if (insolacao != 0) {
                    medInsolacao = totalInsolacao / insolacao;
                } else {
                    medInsolacao = 0;
                }
                if (nebulos != 0) {
                    medNebulos = totalNebulos / nebulos;
                } else {
                    medNebulos = 0;
                }
                if (pressao != 0) {
                    medPressao = totalPresao / pressao;
                } else {
                    medPressao = 0;
                }
                if (velVento != 0) {
                    medVelVento = totalVelVento / velVento;
                } else {
                    medVelVento = 0;
                }
                if (temp != 0) {
                    medTemp = totalTemp / temp;
                } else {
                    medTemp = 0;
                }
            }
        }

        geraPdf(cidade,dataInicio,dataFim,medTemp,medTempIns,medUmi,medUmiIns,medPtoOrvalho,medPtoOrvalhoIns,medPressao,medPressaoIns,medVelVento,medDirVento,medRajVento,medRadiacao,medChuva,medNebulos,medInsolacao);

        System.out.println("--MEDIAS--");
        System.out.println("medChuva: " + medChuva);
        System.out.println("medDirVento: " + medDirVento);
        System.out.println("medPressaoIns: " + medPressaoIns);
        System.out.println("medPtoOrvalho: " + medPtoOrvalho);
        System.out.println("medPressao: " + medPressao);
        System.out.println("medPtoOrvalhoIns: " + medPtoOrvalhoIns);
        System.out.println("medRadiacao: " + medRadiacao);
        System.out.println("medRajVento: " + medRajVento);
        System.out.println("medTemp: " + medTemp);
        System.out.println("medTempIns: " + medTempIns);
        System.out.println("medUmi: " + medUmi);
        System.out.println("medUmiIns: " + medUmiIns);
        System.out.println("medVelVento: " + medVelVento);
        System.out.println("medInsolacao:" + medInsolacao);
        System.out.println("medNebulos:" + medNebulos);
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
