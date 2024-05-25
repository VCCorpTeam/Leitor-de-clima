package com.example.leitorclima.Utils;

import com.example.leitorclima.Models.Arquivo;
import com.example.leitorclima.Models.Registro;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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
        String sql = "INSERT INTO registro (idarquivo, dia, hora,indice, valor,suspeito) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = getConnection(); PreparedStatement stmt = connection.prepareStatement(sql)) {

            for (Map<String, String> registro: registros) {

                stmt.setString(1, registro.get("arc"));
                stmt.setString(2, registro.get("dta"));
                stmt.setString(3, registro.get("hra"));
                stmt.setString(4, registro.get("ind"));
                stmt.setString(5, registro.get("vla"));
                stmt.setString(6, registro.get("sus"));

                // Add each record to the batch
                stmt.addBatch();
            }

            // Execute batch insert
            stmt.executeBatch();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void alteraArquivo(String valor, String data, String hora, String indice){
        String sql = "UPDATE registro SET valor = ?, suspeito = '0' WHERE data = ? AND hora = ? AND indice = ?";
        try (Connection connection = getConnection(); PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, valor);
            stmt.setString(2, data);
            stmt.setString(3, hora);
            stmt.setString(4, indice);

            int rowsAffected = stmt.executeUpdate();
            System.out.println("Rows affected: " + rowsAffected);
        } catch (SQLException e) {
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

    public static List<String> geraArquivoComboBox() {
        List<String> arquivos = new ArrayList<>();
        String sql = "select distinct Idarquivo from arquivo";

        try (Connection connection = getConnection(); PreparedStatement stmt = connection.prepareStatement(sql)) {

            try (ResultSet rs = stmt.executeQuery()) {
                if (!rs.isBeforeFirst()) throw new SQLException("User not found");
                while (rs.next()) {
                    String arquivo = rs.getString("Idarquivo");
                    arquivos.add(arquivo);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arquivos;
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


    public static List<Map<String, String>> getUltimosRegistros(String cidade) throws SQLException {
        List<Map<String, String>> registros = new ArrayList<>();

        String condition = "('";
        List<Registro> allEntries = new ArrayList<>();
        List<Arquivo> arquivoId = getArquivoCidade(cidade);
        int var = 0;
        for (Arquivo arquivo : arquivoId) {
            condition += arquivo.getIdArquivo();
            condition += "'";
            if (arquivoId.size()-1!= var) {
                condition += (",");
            }
            var++;
        }
        condition += ")";
        String sql = "SELECT * FROM (SELECT * FROM Registro WHERE (suspeito <> 1) AND Data = (SELECT MAX(Data) FROM Registro WHERE IdArquivo IN ? )) AS v WHERE Hora = (SELECT MAX(Hora) FROM Registro WHERE (suspeito <> 1) AND Data = (SELECT MAX(Data) FROM Registro WHERE IdArquivo IN ? ))";

        try (Connection connection = getConnection(); PreparedStatement stmt = connection.prepareStatement(sql)){

            stmt.setString(1, condition);
            stmt.setString(2, condition);
            try (ResultSet resultSet = stmt.executeQuery()) {



            }

//            while (resultSet.next()) {
//                Map<String, String> registro = new LinkedHashMap<>();
//                // Supondo que sua tabela tenha as colunas 'id', 'nome', 'descricao', 'data_criacao'
//                registro.put("id", resultSet.getString("id"));
//                registro.put("nome", resultSet.getString("nome"));
//                registro.put("descricao", resultSet.getString("descricao"));
//                registro.put("data_criacao", resultSet.getString("data_criacao"));
//                registros.add(registro);
//            }
        }

        return registros;
    }

    public static List<Registro> getListaRegistroSus(String arquivo) {
        List<Registro> registroSus = new ArrayList<>();
        String sql = "select * from registro where idArquivo = ? and suspeito = 1";

        try (Connection connection = getConnection(); PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, arquivo);
            try (ResultSet rs = stmt.executeQuery()) {
                if (!rs.isBeforeFirst()) throw new SQLException("User not found");
                while (rs.next()) {
                    Registro suspeito = new Registro(
                            rs.getString("Indice"),
                            rs.getString("Data"),
                            rs.getString("Hora"),
                            rs.getString("IdArquivo"),
                            rs.getString("Valor"));
                    registroSus.add(suspeito);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registroSus;
    }

    public static void inserirParametros(List<List<String>> parametros) {
        String sql = "INSERT INTO parametros(IndiceP, Minimo, Maximo) VALUES (?, ?, ?)";

        try (Connection connection = getConnection(); PreparedStatement stmt = connection.prepareStatement(sql)) {

            for (List<String> parametro : parametros) {

                stmt.setString(1, parametro.get(0));
                stmt.setString(2, parametro.get(1));
                stmt.setString(3, parametro.get(2));
                stmt.addBatch();
            }
            stmt.executeBatch();
            System.out.println("Dados inseridos com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao inserir dados no banco de dados.");
        }
    }

    public static List<List<String>> getParametros() {
        List<List<String>> parametrosR = new ArrayList<>();

        String sql = "SELECT IndiceP, Minimo, Maximo FROM parametros";

        try (Connection connection = getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String parametro = rs.getString("IndiceP");
                String valorMin = rs.getString("Maximo");
                String valorMax = rs.getString("Minimo");

                List<String> parametroList = new ArrayList<>();
                parametroList.add(parametro);
                parametroList.add(valorMin);
                parametroList.add(valorMax);

                parametrosR.add(parametroList);

            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao recuperar dados do banco de dados.");
        }
        return parametrosR;
    }
}


