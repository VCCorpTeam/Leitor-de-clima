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
    private ComboBox<String> cbCidadeMed;
    @FXML
    private DatePicker dpDataInicioMed;
    @FXML
    private DatePicker dpDataFimMed;
    @FXML
    private Button btnGeraRelatorioMed;
    @FXML
    private Button btnVoltaMenuMed;
    private List<String> listaCidade;

    //COMPONENTES RELATÓRIO SITUACIONAL



    //COMPONENTES RELATÓRIO BOXPLOT
    @FXML
    private ComboBox<String> cbEstacaoBox;
    @FXML
    private ComboBox<String> dpDataBox;
    @FXML
    private Button btnGeraRelatorioBox;
    @FXML
    private Button btnVoltaMenuBox;


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        //INICIALIZA RELATÓRIO MÉDIA

        btnGeraRelatorioMed.setOnMouseClicked((MouseEvent mouse) -> {
            if (mouse.getClickCount() == 1)
                geraRelatorioMed();
        });

        btnVoltaMenuMed.setOnMouseClicked((MouseEvent mouse) -> {
            if (mouse.getClickCount() == 1)
                voltaMenuMed();
        });

        listaCidade = geraCidadeComboBox();

        cbCidadeMed.getItems().addAll(listaCidade);

        //INICIALIZA RELATÓRIO SITUACIONAL



        //INICIALIZA RELATÓRIO BOXPLOT


    }

    //GERA RELATORIO MÉDIA
    private void geraRelatorioMed() {
        String cidade = cbCidadeMed.getValue();
        String dataInicio = String.valueOf(dpDataInicioMed.getValue());
        String dataFim = String.valueOf(dpDataFimMed.getValue());

        geraRelatorioMedia(cidade,dataInicio,dataFim);
    }

    private void voltaMenuMed() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/leitorclima/menu.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) btnVoltaMenuMed.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //GERA RELATORIO SITUACIONAL



    //GERA RELATORIO BOXPLOT
}
