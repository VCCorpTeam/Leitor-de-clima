package com.example.leitorclima.GUI;

import com.example.leitorclima.Utils.DbUtils;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

import static com.example.leitorclima.Utils.DbUtils.*;

public class CadastrosController implements Initializable {
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
    private Button btnMenuParam;

    @FXML
    private ComboBox<String> cbEstacao;
    @FXML
    private TextField tfNomeEstacao;
    @FXML
    private TextField tfLatitude;
    @FXML
    private TextField tfLongitude;
    @FXML
    private Button btnMenuEstacao;
    @FXML
    private Button btnGravaEstacao;

    @FXML
    private ComboBox<String> cbCidade;
    @FXML
    private TextField tfCidadeExtenso;
    @FXML
    private Button btnGravaCidade;
    @FXML
    private Button btnMenuCidade;

    boolean alteracaoCidade;
    boolean alteracaoEstacao;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        List<String> estacoes = new ArrayList<>();
        estacoes = geraEstacaoComboBox();
        cbEstacao.getItems().addAll(estacoes);

        List<String> cidades = new ArrayList<>();
        cidades = geraCidadeComboBox();
        cbCidade.getItems().addAll(cidades);

        carregarParametro();
    }

    @FXML
    private void carregarParametro() {
        List<List<String>> parametros  = DbUtils.getParametros();
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

    @FXML
    public void definirParametro() {
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

    @FXML
    public void selectEstacao() throws SQLException {
        alteracaoCidade = false;
        String estacao = cbEstacao.getValue();
        List<String> ListaEstacao = buscaEstacao(estacao);
        if (!ListaEstacao.isEmpty()){
            alteracaoEstacao = true;
            tfNomeEstacao.setText(ListaEstacao.get(1));
            tfLatitude.setText(ListaEstacao.get(2));
            tfLongitude.setText(ListaEstacao.get(3));
        }
    }

    @FXML
    public void selectCidade() throws SQLException {
        alteracaoCidade = false;
        String cidade = cbCidade.getValue();
        List<String> ListaCidade = buscaCidade(cidade);
        if (!ListaCidade.isEmpty()){
            alteracaoCidade = true;
            tfCidadeExtenso.setText(ListaCidade.get(1));
        }
    }

    @FXML
    public void gravaCidade(){
        String siglaCidade = cbCidade.getValue();
        String nomeCidade = tfCidadeExtenso.getText();
        if (!alteracaoCidade) {
            System.out.println("grava cidade");
            inserirCidade(siglaCidade, nomeCidade);

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Cidade gravada");
            alert.setHeaderText(null);
            alert.setContentText("Dados da cidade gravados com sucesso!");

            alert.showAndWait();
        } else {
            System.out.println("altera cidade");
            alteraCidade(siglaCidade,nomeCidade);
        }
    }

    @FXML
    public void gravaEstacao(){
        String idEstacao = cbEstacao.getValue();
        String nomeEstacao = tfNomeEstacao.getText();
        String latitude = tfLatitude.getText();
        String longitude = tfLongitude.getText();
        if (!alteracaoEstacao){
            System.out.println("grava estacao");
            inserirEstacao(idEstacao, nomeEstacao, latitude, longitude);

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Estação gravada");
            alert.setHeaderText(null);
            alert.setContentText("Dados da estação gravados com sucesso!");

            alert.showAndWait();

        } else {
            System.out.println("altera estacao");
            alteraEstacao(idEstacao,nomeEstacao,latitude,longitude);
        }


    }

    @FXML
    public void voltaMenuPar() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/leitorclima/menu.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) btnMenuParam.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void voltaMenuCid() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/leitorclima/menu.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) btnMenuCidade.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void voltaMenuEst() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/leitorclima/menu.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) btnMenuEstacao.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
