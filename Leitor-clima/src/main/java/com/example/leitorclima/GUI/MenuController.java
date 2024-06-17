package com.example.leitorclima.GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;


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
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/leitorclima/cadastros.fxml")));
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
    @FXML
    private void testeRelDH (ActionEvent event) throws IOException {
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/leitorclima/relatorioDataHora.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
