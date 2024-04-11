package com.example.leitorclima.GUI;

import com.example.leitorclima.Models.CSV;
import com.example.leitorclima.Models.Line;
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
import java.util.ArrayList;
import java.util.ResourceBundle;


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
    }

    public void selectFile() {
        FileChooser fileChooser = new FileChooser();

        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("csv", "*.csv")
        );

        Window stage = null;
        File file = fileChooser.showOpenDialog(null);
        if (file != null) {
            txtPathFile.setText(file.getPath());
            path = file.getPath();
        }
    }

    public void uploadFile() {
        String line = "";

        try {
            ArrayList<Line> lines = new ArrayList<>();
            CSV csv = new CSV(lines);
            BufferedReader br = new BufferedReader((new FileReader(path)));
            int i = 0;

            while ((line = br.readLine()) != null) {
                if (i != 0) {
                    String[] values = line.split(";");
                    System.out.println("Data: " + values[0] + ", Hora (UTC): " + values[1] + ", Temp. Ins. (C): " + values[2] + ", Temp. Max. (C): " + values[3] + ", Temp. Min. (C): " + values[4] + ", Umi. Ins. (%) : " + values[5] + ", Umi. Max. (%) : " + values[6] + ", Umi. Min. (%): " + values[7] + ", Pto Orvalho Ins. (C): " + values[8] + ", Pto Orvalho Max. (C): " + values[9] + ", Pto Orvalho Min. (C): " + values[10] + ", Pressao Ins. (hPa): " + values[11] + ", Pressao Max. (hPa): " + values[12] + ", Pressao Min. (hPa): " + values[13] + ", Vel. Vento (m/s): " + values[14] + ", Dir. Vento (m/s): " + values[15] + ", Raj. Vento (m/s): " + values[16] + ", Radiacao (KJ/m²): " + values[17] + ", Chuva (mm): " + values[18]);
                    Line registro = new Line(values[0], values[1], values[2], values[3], values[4], values[5], values[6], values[7], values[8], values[9], values[10], values[11], values[12], values[13], values[14], values[15], values[16], values[17], values[18]);
                    csv.adicionarElemento(registro);
                    i++;
                } else {
                    String[] indice = line.split(";");
                    i++;
                }
            }
            br.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}