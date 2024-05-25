package com.example.leitorclima.GUI;

import com.example.leitorclima.Models.Boxplot;
import com.example.leitorclima.Models.Registro;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

import static com.example.leitorclima.GUI.FormsRelatorioController.enviaDados;
import static com.example.leitorclima.Utils.DbBoxUtils.getDadosBox;
import static com.example.leitorclima.Utils.DbBoxUtils.getIndice;
import static com.example.leitorclima.Utils.DbUtils.geraArquivoComboBox;
import static com.example.leitorclima.Utils.DbUtils.getListaRegistroSus;

public class RelatorioBoxController implements Initializable {

    @FXML
    private TextField tfEstacaoBox;
    @FXML
    private TextField tfDataBox;
    @FXML
    private TableView<Boxplot> tableDadosBox;
    @FXML
    private TableColumn<Registro,String> colunaIndiceBox;
    @FXML
    private TableColumn<Registro,String> colunaLimSupBox;
    @FXML
    private TableColumn<Registro,String> colunaQ3Box;
    @FXML
    private TableColumn<Registro,String> colunaMedBox;
    @FXML
    private TableColumn<Registro,String> colunaQ1Box;
    @FXML
    private TableColumn<Registro,String> colunaLimInfBox;
    private List<Registro> listaUmidade;
    private List<Registro> listaPressao;
    private List<Registro> listaChuva;
    private List<Registro> listaTemp;
    private List<Registro> listaPtoOrvalho;
    private List<Registro> listaRadia;
    private List<Registro> listaVelVento;
    private List<Registro> listaRajVento;
    private List<Registro> listaInsola;
    private List<Registro> listaNebulosidade;
    private List<Registro> listaDirVento;
    private String indiceBox;
    private double limInfTeo;
    private double limSupTeo;
    private double q3;
    private double q1;
    private double mediana;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        List<List<Registro>> listaListas = new ArrayList<>();
        List<String> listaDados = enviaDados();
        tfEstacaoBox.setText(listaDados.get(0));
        tfDataBox.setText(listaDados.get(1));

        List<String> listaIndice = getIndice();
        for(String indice : listaIndice) {
            switch (indice) {
                case "Chuva (mm)","Chuva [Diaria] (mm)" -> {
                    listaChuva = getDadosBox(listaDados.get(0), listaDados.get(1), indice);
                    listaListas.add(listaChuva);
                }
                case "Dir. Vento (m/s)" -> {
                    listaDirVento = getDadosBox(listaDados.get(0), listaDados.get(1), indice);
                    listaListas.add(listaDirVento);
                }
                case "Pto Orvalho" -> {
                    listaPtoOrvalho = getDadosBox(listaDados.get(0), listaDados.get(1), indice);
                    listaListas.add(listaPtoOrvalho);

                }
                case "Pressao","Pressao (hPa)" -> {
                    listaPressao = getDadosBox(listaDados.get(0), listaDados.get(1), indice);
                    listaListas.add(listaPressao);

                }
                case "Radiacao (KJ/m²)" -> {
                    listaRadia = getDadosBox(listaDados.get(0), listaDados.get(1), indice);
                    listaListas.add(listaRadia);

                }
                case "Raj. Vento (m/s)" -> {
                    listaRajVento = getDadosBox(listaDados.get(0), listaDados.get(1), indice);
                    listaListas.add(listaRajVento);

                }
                case "Temp. ","Temp. [Hora] (K)" -> {
                    listaTemp = getDadosBox(listaDados.get(0), listaDados.get(1), indice);
                    listaListas.add(listaTemp);

                }
                case "Umi." -> {
                    listaUmidade = getDadosBox(listaDados.get(0), listaDados.get(1), indice);
                    listaListas.add(listaUmidade);

                }
                case "Vel. Vento (m/s)" -> {
                    listaVelVento = getDadosBox(listaDados.get(0), listaDados.get(1), indice);
                    listaListas.add(listaVelVento);

                }
                case "Insolacao (h)" -> {
                    listaInsola = getDadosBox(listaDados.get(0), listaDados.get(1), indice);
                    listaListas.add(listaInsola);

                }
                case "Nebulosidade (Decimos)" -> {
                    listaNebulosidade = getDadosBox(listaDados.get(0), listaDados.get(1), indice);
                    listaListas.add(listaNebulosidade);

                }
            }
        }

        List<Boxplot> listaBoxplot = new ArrayList<>();

        for (List<Registro> lista : listaListas){
            if (lista.size() == 0) {
                continue;
            }else if(lista.size() % 2 == 0 ){ //quant registros par
                indiceBox = lista.get(0).getIndice();
                if (lista.size() < 3 ) {
                    mediana = 0;
                    q3 = 0;
                    q1 = 0;
                    double ampInter = q1 - q3;
                    limInfTeo = q1 - (1.5 * ampInter);
                    limSupTeo = q3 + (1.5 * ampInter);
                }else{
                    int met1 = (lista.size()) / 2;
                    int met2 = ((lista.size()) / 2) + 1;
                    if(met1 % 2 != 0) {//metade for ímpar
                        mediana = (Float.parseFloat(lista.get(met1).getValor()) + Float.parseFloat(lista.get(met2).getValor())) / 2;
                        q3 = Float.parseFloat(lista.get(((met1 + 1) / 2) - 1).getValor());
                        q1 = Float.parseFloat(lista.get((3 * (met1 + 1) / 2) - 2).getValor());
                        double ampInter = q1 - q3;
                        limInfTeo = q1 - (1.5 * ampInter);
                        limSupTeo = q3 + (1.5 * ampInter);
                    }else {
                        mediana = (Float.parseFloat(lista.get(met1).getValor()) + Float.parseFloat(lista.get(met2).getValor())) / 2;
                        q3 = Float.parseFloat(lista.get( (met1 / 2) - 1).getValor()) + Float.parseFloat(lista.get( (met1 / 2) + 1).getValor());
                        q1 = Float.parseFloat(lista.get(( 3*met1 / 2) ).getValor()) + Float.parseFloat(lista.get(( 3*met1 / 2)-1 ).getValor());
                        double ampInter = q1 - q3;
                        limInfTeo = q1 - (1.5 * ampInter);
                        limSupTeo = q3 + (1.5 * ampInter);
                    }
                }
            } else{ //quant registros impar
                indiceBox = lista.get(0).getIndice();
                if (lista.size() < 3 ) {
                    mediana = 0;
                    q3 = 0;
                    q1 = 0;
                    double ampInter = q1 - q3;
                    limInfTeo = q1 - (1.5 * ampInter);
                    limSupTeo = q3 + (1.5 * ampInter);
                } else {
                    int met = (lista.size() + 1) / 2;
                    Float mediana = (Float.parseFloat(lista.get(met - 1).getValor()));
                    q3 = Float.parseFloat(lista.get((met / 2) - 1).getValor());
                    q1 = Float.parseFloat(lista.get((3 * met / 2) - 1).getValor());
                    double ampInter = q1 - q3;
                    limInfTeo = q1 - (1.5 * ampInter);
                    limSupTeo = q3 + (1.5 * ampInter);
                }
            }
            limSupTeo = Math.round(limSupTeo * 100.0) / 100.0;
            mediana = Math.round(mediana * 100.0) / 100.0;
            q3 = Math.round(q3 * 100.0) / 100.0;
            q1 = Math.round(q1 * 100.0) / 100.0;
            limInfTeo = Math.round(limInfTeo * 100.0) / 100.0;
            Boxplot boxplot = new Boxplot(indiceBox,limSupTeo,q3,mediana,q1,limInfTeo);
            listaBoxplot.add(boxplot);
        }

        colunaIndiceBox.setCellValueFactory(
                new PropertyValueFactory<>("indice"));
        colunaLimSupBox.setCellValueFactory(
                new PropertyValueFactory<>("limiteSuperior"));
        colunaQ3Box.setCellValueFactory(
                new PropertyValueFactory<>("q3"));
        colunaMedBox.setCellValueFactory(
                new PropertyValueFactory<>("mediana"));
        colunaQ1Box.setCellValueFactory(
                new PropertyValueFactory<>("q1"));
        colunaLimInfBox.setCellValueFactory(
                new PropertyValueFactory<>("limiteInferior"));

        tableDadosBox.getItems().addAll(listaBoxplot);
    }
}
