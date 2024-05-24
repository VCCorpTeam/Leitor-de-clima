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
import static com.example.leitorclima.Utils.GeraRelatorioMediaUtil.geraRelatorioMedia;

public class FormsRelatorioController implements Initializable {

    //COMPONENTES RELATÓRIO MÉDIA
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

    //COMPONENTES RELATÓRIO SITUACIONAL



    //COMPONENTES RELATÓRIO BOXPLOT



    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        //INICIALIZA RELATÓRIO MÉDIA

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

        //INICIALIZA RELATÓRIO SITUACIONAL



        //INICIALIZA RELATÓRIO BOXPLOT


    }

    //GERA RELATORIO MÉDIA
    private void geraRelatorio() {
        String cidade = cbCidade.getValue();
        String dataInicio = String.valueOf(dpDataInicio.getValue());
        String dataFim = String.valueOf(dpDataFim.getValue());

        geraRelatorioMedia(cidade,dataInicio,dataFim);
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

    //GERA RELATORIO SITUACIONAL



    //GERA RELATORIO BOXPLOT
}
