package com.example.leitorclima.GUI;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EstacaoController {

    @FXML
    private ComboBox<String> estacaoComboBox;

    private static final Logger LOGGER = Logger.getLogger(EstacaoController.class.getName());

    public void initialize() {
        carregarEstacoes();
    }

    private void carregarEstacoes() {
        ObservableList<String> estacoes = FXCollections.observableArrayList();
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT idEstacao FROM Estacao")) {

            while (resultSet.next()) {
                String idEstacao = resultSet.getString("idEstacao");
                if (idEstacao != null && !idEstacao.trim().isEmpty()) {
                    estacoes.add(idEstacao);
                } else {
                    LOGGER.log(Level.WARNING, "Valor inválido encontrado na coluna idEstacao: " + idEstacao);
                }
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Erro ao conectar ao banco de dados ou executar a query", e);
        }
        estacaoComboBox.setItems(estacoes);
    }

    public static Connection getConnection() throws SQLException {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/clima", "root", "fatec");
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }
}
