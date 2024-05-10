package com.example.leitorclima.GUI;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class DadosSuspeitosController implements Initializable {

    @FXML
    private ComboBox<String> cbArquivo;
//    @FXML
//    private TableView<String> tableDadosSus;
//    @FXML
//    private TableColumn<String> colunaData;
//    @FXML
//    private TableColumn<String> colunaHora;
//    @FXML
//    private TableColumn<String> colunaIndice;
//    @FXML
//    private TableColumn<String> colunaValor;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        cbArquivo.getItems().addAll("1","2","3");
    }
}
