package com.example.leitorclima.GUI;

import com.example.leitorclima.Models.DadosEnvio;
import com.example.leitorclima.Models.Registro;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import javax.swing.*;
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
    private static boolean defineUnid = false;
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

    private static List<Integer> listaUnidade;


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



        listaCidade = geraCidadeComboBox();


        //INICIALIZA RELATÓRIO SITUACIONAL

        cbCidadeSit.getItems().addAll(listaCidade);

        //INICIALIZA RELATÓRIO BOXPLOT
        listaEstacao = geraEstacaoComboBox();
        cbEstacaoBox.getItems().addAll(listaEstacao);

        //INICIALIZA UNIDADE MEDIDAS
        int[] listaUnidade = {1, 1, 1, 1, 1};
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
    public static DadosEnvio enviaDadosSit() {
        List<Integer> listaUnidSit = new ArrayList<>();
        listaUnidSit = List.of(new Integer[]{1, 1, 1, 1, 1});
        if (defineUnid) {
            listaUnidSit = listaUnidade;
        }
        FormsRelatorioController controller = FormsRelatorioController.getInstance();
        List<String> dados = new ArrayList<>();
        String cidade = controller.cbCidadeSit.getValue();
        dados.add(cidade);

        return new DadosEnvio(dados,listaUnidSit);
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
    public static DadosEnvio enviaDadosBox() {
        FormsRelatorioController controller = FormsRelatorioController.getInstance();
        List<Integer> listaUnidBox = new ArrayList<>();
        listaUnidBox = List.of(new Integer[]{1, 1, 1, 1, 1});
        if (defineUnid) {
            listaUnidBox = listaUnidade;
        }
        List<String> dados = new ArrayList<>();
        String estacao = controller.cbEstacaoBox.getValue();
        String data = String.valueOf(controller.dpDataBox.getValue());
        dados.add(estacao);
        dados.add(data);

        return new DadosEnvio(dados,listaUnidBox);
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
        defineUnid = true;

        Map<String, Integer> tempOptionNum = new HashMap<>();
        tempOptionNum.put("C", 1);
        tempOptionNum.put("K", 2);
        tempOptionNum.put("F", 3);

        Map<String, Integer> orvOptionNum = new HashMap<>();
        orvOptionNum.put("C", 1);
        orvOptionNum.put("K", 2);
        orvOptionNum.put("F", 3);

        Map<String, Integer> velVentoOptionNum = new HashMap<>();
        velVentoOptionNum.put("m/s", 1);
        velVentoOptionNum.put("km/h", 2);

        Map<String, Integer> rajVentoOptionNum = new HashMap<>();
        rajVentoOptionNum.put("m/s", 1);
        rajVentoOptionNum.put("km/h", 2);

        Map<String, Integer> dirVentoOptionNum = new HashMap<>();
        dirVentoOptionNum.put("m/s", 1);
        dirVentoOptionNum.put("km/h", 2);

        Integer tempValue = tempOptionNum.get(cbTemp.getValue());
        Integer orvValue  = orvOptionNum.get(cbOrv.getValue());
        Integer velVentoValue = velVentoOptionNum.get(cbVelVento.getValue());
        Integer rajVentoValue = rajVentoOptionNum.get(cbRajVento.getValue());
        Integer dirVentoValue = dirVentoOptionNum.get(cbDirVento.getValue());
        List<Integer> listaDefUnid = new ArrayList<>();
        listaDefUnid = List.of(new Integer[]{tempValue, orvValue, velVentoValue, rajVentoValue, dirVentoValue});

        listaUnidade = listaDefUnid;

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Unidade definidas");
        alert.setHeaderText(null);
        alert.setContentText("Unidades de medida definidas!");
        alert.show();
    }


}
