package com.example.leitorclima.GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Parent;
import com.example.leitorclima.Utils.DbUtils;
import java.util.List;
import java.util.Map;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.geometry.Insets;
import javafx.scene.text.Text;
import java.sql.SQLException;


import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class MenuController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    public void uploadArquivo (ActionEvent event) throws IOException {
        try {
            root = FXMLLoader.load(getClass().getResource("/com/example/leitorclima/upload.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

//    private void gerarRelatorioSituacional(ActionEvent event) {
//        try {
//            List<Map<String, String>> registros = DbUtils.getUltimosRegistros(10); // Por exemplo, os 10 registros mais recentes
//            StringBuilder relatorio = new StringBuilder();
//
//            for (Map<String, String> registro : registros) {
//                relatorio.append("ID: ").append(registro.get("id")).append("\n");
//                relatorio.append("Nome: ").append(registro.get("nome")).append("\n");
//                relatorio.append("Descrição: ").append(registro.get("descricao")).append("\n");
//                relatorio.append("Data de Criação: ").append(registro.get("data_criacao")).append("\n");
//                relatorio.append("-----------\n");
//            }
//
//            // Cria uma nova janela para mostrar o relatório
//            Stage stage = new Stage();
//            VBox vbox = new VBox();
//            vbox.setPadding(new Insets(10));
//            TextArea textArea = new TextArea(relatorio.toString());
//            textArea.setEditable(false);
//            vbox.getChildren().add(textArea);
//            Scene scene = new Scene(new ScrollPane(vbox), 400, 600);
//            stage.setScene(scene);
//            stage.setTitle("Relatório Situacional");
//            stage.show();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setTitle("Erro ao gerar relatório");
//            alert.setHeaderText(null);
//            alert.setContentText("Houve um erro ao gerar o relatório. Por favor, tente novamente.");
//            alert.showAndWait();
//        }
//    }

    @FXML
    private void gerarRelatorio (ActionEvent event) throws IOException {
        try {
            root = FXMLLoader.load(getClass().getResource("/com/example/leitorclima/formsRelatorio.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void trocarParaParametros(ActionEvent event) throws IOException {
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/leitorclima/ParametrosSuspeitos.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    private void mudarDadosSus (ActionEvent event) throws IOException {
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/leitorclima/dadosSuspeitos.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
