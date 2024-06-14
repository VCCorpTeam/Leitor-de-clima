package com.example.leitorclima.GUI;

import com.example.leitorclima.Models.Registro;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import java.time.LocalDate;
import java.util.*;

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

    @FXML
    private ComboBox<String> cbCidadeSit;
    @FXML
    private Button btnGeraRelatorioSit;
    @FXML
    private Button btnVoltaMenuSit;

    //COMPONENTES RELATÓRIO BOXPLOT
    @FXML
    private ComboBox<String> cbEstacaoBox;
    @FXML
    private DatePicker dpDataBox;
    @FXML
    private Button btnGeraRelatorioBox;
    @FXML
    private Button btnVoltaMenuBox;
    private List<String> listaEstacao;

    //COMPONENTES UNIDADE DE MEDIDA
    @FXML
    private Button btnVoltaMenuUnid;
    @FXML
    private Button btnDefUnid;
    @FXML
    private ComboBox<String> cbUmid;
    @FXML
    private ComboBox<String> cbPressao;
    @FXML
    private ComboBox<String> cbChuva;
    @FXML
    private ComboBox<String> cbTemp;
    @FXML
    private ComboBox<String> cbOrv;
    @FXML
    private ComboBox<String> cbRadiacao;
    @FXML
    private ComboBox<String> cbVelVento;
    @FXML
    private ComboBox<String> cbRajVento;
    @FXML
    private ComboBox<String> cbInsolacao;
    @FXML
    private ComboBox<String> cbNebulos;
    @FXML
    private ComboBox<String> cbDirVento;

    private List<Integer> listaUnidade;


    private static FormsRelatorioController instance;

    public FormsRelatorioController() {
        instance = this;
    }

    public static FormsRelatorioController getInstance() {
        return instance;
    }



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

        cbCidadeSit.getItems().addAll(listaCidade);

        //INICIALIZA RELATÓRIO BOXPLOT
        listaEstacao = geraEstacaoComboBox();
        cbEstacaoBox.getItems().addAll(listaEstacao);

        //INICIALIZA UNIDADE MEDIDAS
        int[] listaUnidade = {1,1,1,1,1,1,1,1,1,1,1};
        cbUmid.setValue("%");
        cbPressao.setValue("hPa");
        cbChuva.setValue("mm");
        cbTemp.getItems().addAll("C","K","F");
        cbOrv.getItems().addAll("C","K","F");
        cbRadiacao.setValue("KJ/m²");
        cbVelVento.getItems().addAll("m/s","km/h");
        cbRajVento.getItems().addAll("m/s","km/h");
        cbInsolacao.setValue("h");
        cbNebulos.setValue("decimos");
        cbDirVento.getItems().addAll("m/s","km/h");
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

    @FXML
    private void geraRelatorioSit() {
        String cidade = cbCidadeSit.getValue();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/leitorclima/relatorioSit.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) btnGeraRelatorioSit.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void voltaMenuSit() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/leitorclima/menu.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) btnVoltaMenuSit.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<String> enviaDadosSit() {
        FormsRelatorioController controller = FormsRelatorioController.getInstance();
        List<String> dados = new ArrayList<>();
        String cidade = controller.cbCidadeSit.getValue();
        dados.add(cidade);

        return dados;
    }


    //GERA RELATORIO BOXPLOT
    @FXML
    private void geraRelatorioBox() {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/leitorclima/relatorioBox.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) btnGeraRelatorioBox.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void voltaMenuBox() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/leitorclima/menu.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) btnVoltaMenuBox.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<String> enviaDadosBox() {
        FormsRelatorioController controller = FormsRelatorioController.getInstance();
        List<String> dados = new ArrayList<>();
        String estacao = controller.cbEstacaoBox.getValue();
        String data = String.valueOf(controller.dpDataBox.getValue());
        dados.add(estacao);
        dados.add(data);

        return dados;
    }

    //DEFINE MEDIDAS
    @FXML
    private void voltaMenuUnid() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/leitorclima/menu.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) btnVoltaMenuUnid.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void defineUnidMedida() {
        Map<String, Integer> tempOptionNum = new HashMap<>();
        tempOptionNum.put("C", 1);
        tempOptionNum.put("K", 2);
        tempOptionNum.put("F", 3);
        int tempValue = tempOptionNum.get(cbTemp.getValue());
    }


}
