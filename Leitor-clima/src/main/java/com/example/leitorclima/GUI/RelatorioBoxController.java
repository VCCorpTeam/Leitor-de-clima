package com.example.leitorclima.GUI;

import com.example.leitorclima.Models.Registro;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import static com.example.leitorclima.GUI.FormsRelatorioController.enviaDados;
import static com.example.leitorclima.Utils.DbBoxUtils.getDadosBox;
import static com.example.leitorclima.Utils.DbBoxUtils.getIndice;
import static com.example.leitorclima.Utils.DbUtils.geraArquivoComboBox;

public class RelatorioBoxController implements Initializable {

    @FXML
    private TextField tfEstacaoBox;
    @FXML
    private TextField tfDataBox;
    @FXML
    private TableView<Registro> tableDadosBox;
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

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        List<String> listaDados = enviaDados();
        tfEstacaoBox.setText(listaDados.get(0));
        tfDataBox.setText(listaDados.get(1));

        List<String> listaIndice = getIndice();
        for(String indice : listaIndice) {
            switch (indice) {
                case "Chuva (mm)" -> {
                    listaChuva = getDadosBox(listaDados.get(0), listaDados.get(1), indice);
                }
                case "Dir. Vento (m/s)" -> {
                    listaDirVento = getDadosBox(listaDados.get(0), listaDados.get(1), indice);
                }
                case "Pto Orvalho" -> {
                    listaPtoOrvalho = getDadosBox(listaDados.get(0), listaDados.get(1), indice);
                }
                case "Pressao" -> {
                    listaPressao = getDadosBox(listaDados.get(0), listaDados.get(1), indice);
                }
                case "Radiacao (KJ/m²)" -> {
                    listaRadia = getDadosBox(listaDados.get(0), listaDados.get(1), indice);
                }
                case "Raj. Vento (m/s)" -> {
                    listaRajVento = getDadosBox(listaDados.get(0), listaDados.get(1), indice);
                }
                case "Temp. " -> {
                    listaTemp = getDadosBox(listaDados.get(0), listaDados.get(1), indice);
                }
                case "Umi." -> {
                    listaUmidade = getDadosBox(listaDados.get(0), listaDados.get(1), indice);
                }
                case "Vel. Vento (m/s)" -> {
                    listaVelVento = getDadosBox(listaDados.get(0), listaDados.get(1), indice);
                }
                case "Insolacao (h)" -> {
                    listaInsola = getDadosBox(listaDados.get(0), listaDados.get(1), indice);
                }
                case "Nebulosidade (Decimos)" -> {
                    listaNebulosidade = getDadosBox(listaDados.get(0), listaDados.get(1), indice);
                }
            }
        }
        colunaIndiceBox.setCellValueFactory(
                new PropertyValueFactory<>("Data"));
        colunaLimSupBox.setCellValueFactory(
                new PropertyValueFactory<>("Hora"));
        colunaQ3Box.setCellValueFactory(
                new PropertyValueFactory<>("Indice"));
        colunaMedBox.setCellValueFactory(
                new PropertyValueFactory<>("Valor"));

    }
}
