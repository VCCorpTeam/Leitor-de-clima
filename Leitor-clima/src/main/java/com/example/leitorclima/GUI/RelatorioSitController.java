//package com.example.leitorclima.GUI;
//
//import com.example.leitorclima.Models.Boxplot;
//import com.example.leitorclima.Models.Registro;
//import javafx.fxml.FXML;
//import javafx.fxml.Initializable;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableView;
//import javafx.scene.control.TextField;
//import javafx.scene.control.cell.PropertyValueFactory;
//
//import java.net.URL;
//import java.util.ResourceBundle;
//
//public class RelatorioSitController implements Initializable {
//
//    @FXML
//    private TableView<Boxplot> tableDadosBox;
//    @FXML
//    private TableColumn<Registro,String> colunaIndiceBox;
//    @FXML
//    private TableColumn<Registro,String> colunaLimSupBox;
//    @FXML
//    private TableColumn<Registro,String> colunaQ3Box;
//    @FXML
//    private TableColumn<Registro,String> colunaMedBox;
//    @FXML
//    private TableColumn<Registro,String> colunaQ1Box;
//    @FXML
//    private TableColumn<Registro,String> colunaLimInfBox;
//
//    @Override
//    public void initialize(URL arg0, ResourceBundle arg1) {
//
//        colunaIndiceBox.setCellValueFactory(
//                new PropertyValueFactory<>("indice"));
//        colunaLimSupBox.setCellValueFactory(
//                new PropertyValueFactory<>("limiteSuperior"));
//        colunaQ3Box.setCellValueFactory(
//                new PropertyValueFactory<>("q3"));
//        colunaMedBox.setCellValueFactory(
//                new PropertyValueFactory<>("mediana"));
//        colunaQ1Box.setCellValueFactory(
//                new PropertyValueFactory<>("q1"));
//        colunaLimInfBox.setCellValueFactory(
//                new PropertyValueFactory<>("limiteInferior"));
//
//        tableDadosBox.getItems().addAll();
//    }
//}
