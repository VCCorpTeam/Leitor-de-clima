package com.example.leitorclima.GUI;

import com.example.leitorclima.Models.CSV;
import com.example.leitorclima.Models.Line;
import com.example.leitorclima.Utils.DbUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Window;

import java.io.*;
import java.net.URL;
import java.util.*;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static com.example.leitorclima.Utils.DbUtils.inserirArquivo;
import static com.example.leitorclima.Utils.DbUtils.inserirRegistro;


public class UploadController implements Initializable {
    public static String path;
    public Label selectTextField;
    @FXML
    private TextField txtPathFile;
    @FXML
    private Button btnSelectFile;
    @FXML
    private Button btnUploadFile;
    @FXML
    private Button selectedFileField;
    @FXML
    private Button btnReturnMenu;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        btnSelectFile.setOnMouseClicked((MouseEvent mouse) -> {
            if (mouse.getClickCount() == 1)
                selectFile();
        });

        btnUploadFile.setOnMouseClicked((MouseEvent mouse) -> {
            if (mouse.getClickCount() == 1)
                uploadFile();
        });

        btnReturnMenu.setOnMouseClicked((MouseEvent mouse) -> {
            if (mouse.getClickCount() == 1)
                returnToMenu();
        });
    }

    public void selectFile() {
        FileChooser fileChooser = new FileChooser();

        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("csv", "*.csv")
        );

        Window stage = null;
        File file = fileChooser.showOpenDialog(null);
        if (file != null) {
            path = file.getPath();
            txtPathFile.setText(path);
        }
    }
    public void uploadFile() {
        String line = "";
        String dta = null;
        String hra = null;
        String vla = null;
        String ind = null;
        String arc = null;
        ArrayList<Map<String, String>> rows;
        String[] indices;
        String nomeArquivo;
        String estacao;
        String cidade;
        try {
            rows = new ArrayList<>();
            BufferedReader br = new BufferedReader((new FileReader(path)));
            int i = 0;
            indices = null;
            System.out.println("Path: " + path);
            File arquivo = new File(path);
            nomeArquivo = arquivo.getName();
            int pos = nomeArquivo.indexOf("_");
            int ponto = nomeArquivo.indexOf(".");
            estacao = nomeArquivo.substring(0,pos);
            cidade = nomeArquivo.substring(pos +1,ponto);

            inserirArquivo(nomeArquivo,estacao,cidade);

            while ((line = br.readLine()) != null) {
                String[] values = line.split(";");
                if (i == 0) { // Primeira linha, determinar o número de colunas
                    indices = values; // Salvar os índices
                } else { // Linhas subsequentes, processar valores

                    Map<String, String> rowValues = new LinkedHashMap<>();

                    for (int j = 0; j < indices.length; j++) {
                        if (j < values.length) {
                            rowValues.put(indices[j], values[j]); // Adicionar o índice antes do valor
                        } else {
                            rowValues.put(indices[j], "");
                        }
                    }
                    rows.add(rowValues); // Adicionar a linha à lista de linhas



                }

                i++;
            }
            br.close();


            for (Map<String, String> row : rows) {

                for (Map.Entry<String, String> entry : row.entrySet()) {
//                    System.out.println(entry.getKey() + ": " + entry.getValue());
                }
//                System.out.println();
            }
//            System.out.println(nomeArquivo);

            for (int y = 0; y < rows.size(); y++) {
                Map<String, String> mapa = rows.get(y);
                for (int z = 2; z < mapa.size(); z++) {
                    dta = mapa.values().toArray(new String[0])[0];
                    hra = mapa.values().toArray(new String[0])[1];
                    vla = mapa.values().toArray(new String[0])[z];
                    ind = indices[z];
                    arc = nomeArquivo;

//                    inserirRegistro(ind, arc, dta, hra, vla);
//                    System.out.println(arc);
                }

            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
    //Voltando ao menu main - pablohgs05
    public void returnToMenu() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/leitorclima/menu.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) btnReturnMenu.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


