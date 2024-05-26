package com.example.leitorclima.GUI;

import com.example.leitorclima.Utils.DbUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.Connection;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static com.example.leitorclima.Utils.DbUtils.inserirParametros;

public class ParametroController {
    @FXML
    private TextField UmidMin;
    @FXML
    private TextField pressMin;
    @FXML
    private TextField ChuvaMin;
    @FXML
    private TextField TempMin;
    @FXML
    private TextField Ptomin;
    @FXML
    private TextField RadMin;
    @FXML
    private TextField VelVmin;
    @FXML
    private TextField DirVMin;
    @FXML
    private TextField RajVmin;
    @FXML
    private TextField InsMin;
    @FXML
    private TextField UmidMax;
    @FXML
    private TextField pressMax;
    @FXML
    private TextField ChuvaMax;
    @FXML
    private TextField TempMax;
    @FXML
    private TextField Ptomax;
    @FXML
    private TextField RadMax;
    @FXML
    private TextField VelVmax;
    @FXML
    private TextField DirVMax;
    @FXML
    private TextField RajVMax;
    @FXML
    private TextField InsMax;
    @FXML
    private TextField NebMin;
    @FXML
    private TextField NebMax;
    @FXML

    private Stage stage;
    @FXML
    private Button BtParametro;
    @FXML
    private Button btDefinir;

    private Connection connection;


    @FXML
    private void initialize() {
        carregarParametro();
        btDefinir.setOnAction(event -> definirParametro());
        BtParametro.setOnAction(event -> trocarParaMenu());
    }

    private void carregarParametro() {
        List<List<String>> parametros  = DbUtils.getParametros();;
        for (List<String> parametro : parametros) {
            String indiceP = parametro.get(0);
            String minimo = parametro.get(2);
            String maximo = parametro.get(1);

            switch (indiceP) {
                case "Umi":
                    UmidMin.setText(minimo);
                    UmidMax.setText(maximo);
                    break;
                case "Pressao":
                    pressMin.setText(minimo);
                    pressMax.setText(maximo);
                    break;
                case "Chuva":
                    ChuvaMin.setText(minimo);
                    ChuvaMax.setText(maximo);
                    break;
                case "Temp":
                    TempMin.setText(minimo);
                    TempMax.setText(maximo);
                    break;
                case "Pto Orvalho":
                    Ptomin.setText(minimo);
                    Ptomax.setText(maximo);
                    break;
                case "Vel. Vento":
                    VelVmin.setText(minimo);
                    VelVmax.setText(maximo);
                    break;
                case "Radiacao":
                    RadMin.setText(minimo);
                    RadMax.setText(maximo);
                    break;
                case "Raj. Vento":
                    RajVmin.setText(minimo);
                    RajVMax.setText(maximo);
                    break;
                case "Insolacao":
                    InsMin.setText(minimo);
                    InsMax.setText(maximo);
                    break;
                case "Nebulosidade":
                    NebMin.setText(minimo);
                    NebMax.setText(maximo);
                    break;
                case "Dir. Vento":
                    DirVMin.setText(minimo);
                    DirVMax.setText(maximo);
                    break;
                default:
                    break;
            }
        }
    }

    private void definirParametro() {
        List<List<String>> parametros = new ArrayList<>();
        parametros.add(List.of("Umi",UmidMin.getText(),UmidMax.getText() ));
        parametros.add(List.of("Pressao",pressMin.getText(),pressMax.getText() ));
        parametros.add(List.of("Chuva",ChuvaMin.getText(),ChuvaMax.getText() ));
        parametros.add(List.of("Temp",TempMin.getText(),TempMax.getText() ));
        parametros.add(List.of("Pto Orvalho",Ptomin.getText(),Ptomax.getText() ));
        parametros.add(List.of("Vel. Vento",VelVmin.getText(),VelVmax.getText() ));
        parametros.add(List.of("Radiacao",RadMin.getText(),RadMax.getText() ));
        parametros.add(List.of("Raj. Vento",RajVmin.getText(),RajVMax.getText() ));
        parametros.add(List.of("Insolacao",InsMin.getText(),InsMax.getText() ));
        parametros.add(List.of("Nebulosidade",NebMin.getText(),NebMax.getText() ));
        parametros.add(List.of("Dir. Vento",DirVMin.getText(),DirVMax.getText() ));
        inserirParametros(parametros);

        //Mostrar popup
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Parâmetros definidos");
        alert.setHeaderText(null);
        alert.setContentText("Parâmetros definidos com sucesso!");
        alert.showAndWait();

    }

    public void trocarParaParametros(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("ParametrosSuspeitos.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void trocarParaMenu() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/leitorclima/menu.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) BtParametro.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
