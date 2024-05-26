package com.example.leitorclima.GUI;

import com.example.leitorclima.Models.Boxplot;
import com.example.leitorclima.Models.Registro;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RelatorioSitController implements Initializable {

    @FXML
    private Button btnVoltaRelSit;
    @FXML
    private TableView<Boxplot> tableDadosSit;
    @FXML
    private TableColumn<Registro,String> colunaIndiceSit;
    @FXML
    private TableColumn<Registro,String> colunaValorSit;
    @FXML
    private TableColumn<Registro,String> colunaDataSit;
    @FXML
    private TableColumn<Registro,String> colunaHoraSit;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        colunaIndiceSit.setCellValueFactory(
                new PropertyValueFactory<>("indice"));
        colunaValorSit.setCellValueFactory(
                new PropertyValueFactory<>("limiteSuperior"));
        colunaDataSit.setCellValueFactory(
                new PropertyValueFactory<>("q3"));
        colunaHoraSit.setCellValueFactory(
                new PropertyValueFactory<>("mediana"));

        tableDadosSit.getItems().addAll();
    }

    @FXML
    private void voltaRelSit() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/leitorclima/formsRelatorio.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) btnVoltaRelSit.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}



