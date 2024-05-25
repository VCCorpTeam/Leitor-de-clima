package com.example.leitorclima.GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

import javafx.scene.control.Button;

public class ParametroController {

    private Stage stage;
    @FXML
    private Button BtParametro;

    @FXML
    private TextField umidMinField;
    @FXML
    private TextField umidMaxField;
    // Adicione os outros TextFields para os outros campos aqui...

    private Connection connection;

    @FXML
    private void initialize() {
        // Inicialização, se necessário
        try {
            // Estabelecer a conexão com o banco de dados
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/seubanco", "seuusuario", "suasenha");
        } catch (SQLException e) {
            e.printStackTrace();
            // Lidar com erros de conexão
        }
    }

    @FXML
    private void handleDefinirButtonAction(ActionEvent event) {
        // Obter os valores dos campos de texto
        String umidMin = umidMinField.getText();
        String umidMax = umidMaxField.getText();
        // Obtenha os valores dos outros campos de texto

        // Executar a lógica de salvar os dados no banco de dados
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO Parametros (IndiceP, Minimo, Maximo) VALUES (?, ?, ?)");
            statement.setString(1, "Umid"); // Ou o valor real do índice
            statement.setInt(2, Integer.parseInt(umidMin));
            statement.setInt(3, Integer.parseInt(umidMax));
            // Defina os outros parâmetros

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Lidar com erros de SQL
        }
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
