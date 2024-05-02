package com.example.leitorclima.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbUtils {

    public static void inserirDados() {
        // conexão com o banco estabelecida
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/bancodedados", "root", "");

            // desativando o modo AutoCommit
            connection.setAutoCommit(false);

            // inserção de dados
            Statement statement = connection.createStatement();
            String sql = "INSERT INTO tabelateste (nome, sobrenome, idade, email) VALUES ('pedro' , 'souza' , '12' , 'pedro@gmail.com')";
            int rowsAffected = statement.executeUpdate(sql);

            // if-else que verifica se a inserção/conexão foi bem sucedida
            if (rowsAffected > 0) {
                System.out.println("Inserção realizada com sucesso!");
                connection.commit();
            } else {
                System.out.println("Falha ao inserir os dados.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // fechando a conexão com o banco
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        inserirDados();
    }
}