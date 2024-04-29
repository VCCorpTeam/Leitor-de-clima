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


import java.io.File;
import java.io.IOException;

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
}
