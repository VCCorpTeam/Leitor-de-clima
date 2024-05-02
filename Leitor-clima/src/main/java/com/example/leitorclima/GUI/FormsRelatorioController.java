package com.example.leitorclima.GUI;

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
import java.util.ResourceBundle;

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

        cbCidade.getItems().add("a");
        cbDado.getItems().add("b");
    }

    private void geraRelatorio() {
        String cidade = cbCidade.getValue();
        String dado = cbDado.getValue();
        String dataInicio = String.valueOf(dpDataInicio.getValue());
        String dataFim = String.valueOf(dpDataFim.getValue());

        System.out.println(cidade);
        System.out.println(dado);
        System.out.println(dataInicio);
        System.out.println(dataFim);
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
