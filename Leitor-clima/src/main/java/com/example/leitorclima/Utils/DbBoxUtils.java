package com.example.leitorclima.Utils;

import com.example.leitorclima.Models.Arquivo;
import com.example.leitorclima.Models.Registro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.example.leitorclima.Utils.DbUtils.getConnection;

public class DbBoxUtils {

    public static List<String> getArquivoEstacao(String estacao){
        String sql = "select idArquivo from arquivo where estacao = ?";
        List<String> listaArquivo = new ArrayList<>();

        try (Connection connection = getConnection(); PreparedStatement stmt = connection.prepareStatement(sql)){

            stmt.setString(1, estacao);
            try(ResultSet rs = stmt.executeQuery()) {
                if (!rs.isBeforeFirst()) throw new SQLException("User not found");
                while (rs.next()) {
                    String idArquivo = rs.getString("idArquivo");
                    listaArquivo.add(idArquivo);
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return listaArquivo;
    }

    public static List<Registro> getDadosBox(String estacao, String data, String indice) {
        List<String> listaArquivo;
        listaArquivo = getArquivoEstacao(estacao);
        String condition = "";
        int var = 0;
        for (String nomeArquivo : listaArquivo) {
            condition += nomeArquivo;
            if (listaArquivo.size() - 1 != var) {
                condition += (",");
            }
            var++;
        }

        String sql = "SELECT idArquivo,data,hora,indice,valor FROM registro where idArquivo in ( ? ) and data = ? and indice = ? and suspeito = 0 ";

        List<Registro> listaDados = new ArrayList<>();
        try (Connection connection = getConnection(); PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, condition);
            stmt.setString(2, data);
            stmt.setString(3, indice);

            try (ResultSet rs = stmt.executeQuery()) {
                if (!rs.isBeforeFirst()) throw new SQLException("User not found");
                while (rs.next()) {
                    String idArquivoReg = rs.getString("idArquivo");
                    String dataReg = rs.getString("data");
                    String horaReg = rs.getString("hora");
                    String indiceReg = rs.getString("indice");
                    String valorReg = rs.getString("valor");
                    Registro registro = new Registro(indiceReg, dataReg, horaReg, idArquivoReg, valorReg);
                    listaDados.add(registro);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaDados;
    }

    public static List<String> getIndice() {
        List<String> indices = new ArrayList<>();
        String sql = "SELECT distinct indice FROM registro";

        try (Connection connection = getConnection(); PreparedStatement stmt = connection.prepareStatement(sql)) {

            try (ResultSet rs = stmt.executeQuery()) {
                if (!rs.isBeforeFirst()) throw new SQLException("User not found");
                while (rs.next()) {
                    String indice = rs.getString("indice");
                    indices.add(indice);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return indices;
    }
}
