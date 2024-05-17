package com.example.leitorclima.Utils;

import com.example.leitorclima.Models.Arquivo;
import com.example.leitorclima.Models.Registro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbUtils {

    public static Connection getConnection() throws SQLException {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/clima", "root", "1234");
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    public static void inserirArquivo(String arquivo, String cidade, String estacao) {
        String sql = "INSERT INTO arquivo (idarquivo, cidade, estacao) VALUES (?,?,?)";

        try (Connection connection = getConnection(); PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, arquivo);
            stmt.setString(2, cidade);
            stmt.setString(3, estacao);
            stmt.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void inserirRegistro(List<Map<String, String>> registros) {
        // Batch insert for improved performance
        String sql = "INSERT INTO registro (indice, idarquivo, data, hora, valor) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = getConnection(); PreparedStatement stmt = connection.prepareStatement(sql)) {

            for (Map<String, String> registro: registros) {
                stmt.setString(1, registro.get("ind"));
                stmt.setString(2, registro.get("arc"));
                stmt.setString(3, registro.get("dta"));
                stmt.setString(4, registro.get("hra"));
                stmt.setString(5, registro.get("vla"));

                // Add each record to the batch
                stmt.addBatch();
            }

            // Execute batch insert
            stmt.executeBatch();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<String> geraCidadeComboBox() {
        List<String> cidades = new ArrayList<>();
        String sql = "SELECT distinct cidade FROM arquivo";

        try (Connection connection = getConnection(); PreparedStatement stmt = connection.prepareStatement(sql)) {

            try (ResultSet rs = stmt.executeQuery()) {
                if (!rs.isBeforeFirst()) throw new SQLException("User not found");
                while (rs.next()) {
                    String cidade = rs.getString("cidade");
                    cidades.add(cidade);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cidades;
    }

    public static List<String> geraDadoComboBox() {
        List<String> dados = new ArrayList<>();
        String sql = "select distinct indice from registro;";

        try (Connection connection = getConnection(); PreparedStatement stmt = connection.prepareStatement(sql)) {

            try (ResultSet rs = stmt.executeQuery()) {
                if (!rs.isBeforeFirst()) throw new SQLException("User not found");
                while (rs.next()) {
                    String dado = rs.getString("indice");
                    dados.add(dado);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dados;
    }


    public static List<Registro> getArquivo(String cidade,String dataInicio,String dataFim){
        String nomeArquivo = null;
        String condition = "('";
        List<Registro> allEntries = new ArrayList<>();
        List<Arquivo> arquivoId = getArquivoCidade(cidade);
        int var = 0;
        for (Arquivo arquivo : arquivoId) {
            nomeArquivo = arquivo.getIdArquivo();
            condition += arquivo.getIdArquivo();
            condition += "'";
            if (arquivoId.size()-1!= var) {
                condition += (",");
            }
            var++;
        }
        condition += ")";
        System.out.println(condition);
        String sql = "SELECT indice,data,hora,idArquivo,valor FROM registro where idArquivo = ? and data between ? and ?";

        try (Connection connection = getConnection(); PreparedStatement stmt = connection.prepareStatement(sql)){

            
            stmt.setString(1, nomeArquivo);
            stmt.setString(2, dataInicio);
            stmt.setString(3, dataFim);
            try(ResultSet rs = stmt.executeQuery()) {
                if (!rs.isBeforeFirst()) throw new SQLException("User not found");
                while (rs.next()) {
                    String indice = rs.getString("indice");
                    String data = rs.getString("data");
                    String hora = rs.getString("hora");
                    String idArquivo = rs.getString("idArquivo");
                    String valor = rs.getString("valor");
                    Registro registro = new Registro(indice,data,hora,idArquivo,valor);
                    allEntries.add(registro);
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        return allEntries;
    }
    public static List<Arquivo> getArquivoCidade(String cidade){
        String sql = "select idArquivo,cidade,estacao from arquivo where cidade=?";
        List<Arquivo> listaArquivos = new ArrayList<>();

        try (Connection connection = getConnection(); PreparedStatement stmt = connection.prepareStatement(sql)){

            stmt.setString(1, cidade);
            try(ResultSet rs = stmt.executeQuery()) {
                if (!rs.isBeforeFirst()) throw new SQLException("User not found");
                while (rs.next()) {
                    String idArquivo = rs.getString("idArquivo");
                    String cidadeQry = rs.getString("cidade");
                    String estacao = rs.getString("estacao");
                    Arquivo arquivo = new Arquivo(idArquivo,cidadeQry,estacao);
                    listaArquivos.add(arquivo);
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return listaArquivos;
    }

    public static List<Map<String, String>> getUltimosRegistros(int quantidade) throws SQLException {
        String query = "SELECT * FROM sua_tabela ORDER BY data_criacao DESC LIMIT ?";
        List<Map<String, String>> registros = new ArrayList<>();

        try (Connection connection = DbUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, quantidade);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Map<String, String> registro = new LinkedHashMap<>();
                // Supondo que sua tabela tenha as colunas 'id', 'nome', 'descricao', 'data_criacao'
                registro.put("id", resultSet.getString("id"));
                registro.put("nome", resultSet.getString("nome"));
                registro.put("descricao", resultSet.getString("descricao"));
                registro.put("data_criacao", resultSet.getString("data_criacao"));
                registros.add(registro);
            }
        }

        return registros;
    }

}
