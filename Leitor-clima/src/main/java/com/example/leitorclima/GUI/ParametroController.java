package com.example.leitorclima.GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

import javafx.scene.control.Button;

public class ParametroController {

    private Stage stage;
    @FXML
    private Button BtParametro;

    public void trocarParaParametros(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("ParametrosSuspeitos.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void trocarParaMenu() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/leitorclima/ParametrosSuspeitos.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) BtParametro.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
