package com.example.leitorclima.Utils;

import com.example.leitorclima.Models.Registro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbUtils {

    public static Connection getConnection() throws SQLException {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/clima", "root", "D1m2s3l4");
        }catch (SQLException exception){
            throw new RuntimeException(exception);
        }
    }

    public static void inserirRegistro(String indice, String arquivo, String data, String hora, String valor) {
        String sql = "INSERT INTO registro (indice, idarquivo, data, hora,valor) VALUES (?,?,?,?,?)";

        try (Connection connection =  getConnection(); PreparedStatement stmt = connection.prepareStatement(sql)){

            stmt.setString(1, indice);
            stmt.setString(2, arquivo);
            stmt.setString(3, data);
            stmt.setString(4, hora);
            stmt.setString(5, valor);
            stmt.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Registro> getRegistros(String cidade){
        List<Registro> allEntries = new ArrayList<>();
        String arquivoId = getArquivoCidade(cidade);
        String sql = "SELECT valor FROM activity_register WHERE Id=?";

        try (Connection connection = getConnection(); PreparedStatement stmt = connection.prepareStatement(sql)){

            stmt.setString(1, arquivoId);
            try(ResultSet rs = stmt.executeQuery()) {
                if (!rs.isBeforeFirst()) throw new SQLException("User not found");
                while (rs.next()) {
                    String id = rs.getString("user_id");
                    String title = rs.getString("title");
                    String date = rs.getString("access");
//                    Registro entry = new Registro(id, title, date);
//                    allEntries.add(entry);
                }
            }

        } catch (SQLException e){
            e.printStackTrace();
        }

        return allEntries;
    }
    public static String getArquivoCidade(String cidade){
        String sql = "SELECT IdArquivo from Arquivos where username=?";
        try (Connection connection = getConnection(); PreparedStatement stmt = connection.prepareStatement(sql)){

            stmt.setString(1, cidade);
            try(ResultSet rs = stmt.executeQuery()) {
                if (!rs.isBeforeFirst()) return null;
                rs.next();
                return rs.getString("user_id");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}