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
import static com.example.leitorclima.Utils.FormataDataUtil.formataData;


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
        List<Map<String, String>> registros = new ArrayList<>();
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
            inserirArquivo(nomeArquivo,cidade,estacao);


            while ((line = br.readLine()) != null) {
                String[] values = line.split(";");
                if (i == 0) { // Primeira linha, determinar o número de colunas
                    indices = values; // Salvar os índices
                    indices[i] = values[i].replaceAll("^\"|\"$", "");
                } else { // Linhas subsequentes, processar valores

                    Map<String, String> rowValues = new LinkedHashMap<>();

                    for (int j = 0; j < indices.length; j++) {
                        if (j < values.length) {
                            String value = values[j].replaceAll("^\"|\"$", "");
                            rowValues.put(indices[j], value); // Adicionar o índice antes do valor
                        } else {
                            rowValues.put(indices[j], "");
                        }
                    }
                    rows.add(rowValues); // Adicionar a linha à lista de linhas



                }

                i++;
            }
            br.close();
            Map<String, String> registro;
            for (int y = 0; y < rows.size(); y++) {

                Map<String, String> mapa = rows.get(y);
                for (int z = 2; z < mapa.size(); z++) {
                    registro = new LinkedHashMap<>();
                    dta = formataData(mapa.values().toArray(new String[0])[0]);
                    hra = mapa.values().toArray(new String[0])[1];
                    arc = nomeArquivo;
                    if (mapa.size() == 19) {
                        if (z < mapa.size()) {
                            if (z == 3 || z == 6 || z == 9 || z == 12) {
                                String vf1 = mapa.values().toArray(new String[0])[z];
                                String vf2 = mapa.values().toArray(new String[0])[z+1];
                                if (!vf1.isEmpty() && !vf2.isEmpty()) {
                                    float v1 = Float.parseFloat(vf1.replace(",", "."));
                                    float v2 = Float.parseFloat(vf2.replace(",", "."));
                                    float aa = (v1 + v2) / 2;
                                    vla = String.valueOf(aa);
                                } else {
                                    vla = "";
                                }

                                if (indices[z].contains("Max")) {
                                    int str = indices[z].indexOf("Max");
                                    ind = indices[z].substring(0, str);

                                }
                                z++;
                            } else {
                                vla = mapa.values().toArray(new String[0])[z].replace(",", ".");
                                ind = indices[z];
                                 // Incrementa z após acessar o elemento
                            }
                        }
                    }else if(mapa.size()== 12){
                        dta = formataData(mapa.values().toArray(new String[0])[0]);
                        hra = mapa.values().toArray(new String[0])[1];
                        arc = nomeArquivo;
                        vla = mapa.values().toArray(new String[0])[z].replace(",", ".");
                        ind = indices[z];
                    }
                    registro.put("ind", ind);
                    registro.put("arc", arc);
                    registro.put("dta", dta);
                    registro.put("hra", hra);
                    registro.put("vla", vla);
                    registros.add(registro);

                }

            }
            inserirRegistro(registros);
            UploadCompleto();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        

    }
    //Popup de upload completo
    public void UploadCompleto() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Upload completo");
        alert.setHeaderText(null);
        alert.setContentText("Seu arquivo foi carregado com sucesso!");
    
        alert.showAndWait();
    }
    //Voltando ao menu main
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