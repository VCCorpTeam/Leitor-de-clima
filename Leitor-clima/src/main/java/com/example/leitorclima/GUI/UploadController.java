package com.example.leitorclima.GUI;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.ResourceBundle;

import com.example.leitorclima.Utils.DbUtils;
import static com.example.leitorclima.Utils.DbUtils.inserirArquivo;
import static com.example.leitorclima.Utils.DbUtils.inserirRegistro;
import com.example.leitorclima.Utils.FileUploadManager;
import static com.example.leitorclima.Utils.FormataDataUtil.formataData;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

public class UploadController implements Initializable {
    public static String path;
    private FileUploadManager fileUploadManager = new FileUploadManager(); // Instância de FileUploadManager
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
    @FXML
    private ProgressIndicator progressIndicator;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        btnSelectFile.setOnMouseClicked((MouseEvent mouse) -> {
            if (mouse.getClickCount() == 1)
                selectFile();
        });

        btnUploadFile.setOnMouseClicked((MouseEvent mouse) -> {
            if (mouse.getClickCount() == 1) {
                if (!DbUtils.checkparametros()) {
                    try {
                        abrirParametrosFXML();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    uploadFile();
                }
            }
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
        progressIndicator.setVisible(true);

        new Thread(() -> {
            try {
                File file = new File(path);
                String fileContentHash = calculateFileHash(file);

                if (fileUploadManager.hasFileBeenUploaded(fileContentHash)) {
                    javafx.application.Platform.runLater(() -> {
                        progressIndicator.setVisible(false);
                        fileUploadManager.showAlreadyUploadedPopup();
                    });
                    return;
                }

                String line = "";
                String dta = null;
                String hra = null;
                String vla = null;
                String ind = null;
                String arc = null;
                String sus = null;
                ArrayList<Map<String, String>> rows;
                List<Map<String, String>> registros = new ArrayList<>();
                String[] indices;
                String nomeArquivo;
                String estacao;
                String cidade;

                rows = new ArrayList<>();
                BufferedReader br = new BufferedReader(new FileReader(path));
                int i = 0;
                indices = null;
                System.out.println("Path: " + path);
                File arquivo = new File(path);
                nomeArquivo = arquivo.getName();
                int pos = nomeArquivo.indexOf("_");
                int ponto = nomeArquivo.indexOf(".");
                estacao = nomeArquivo.substring(0, pos);
                cidade = nomeArquivo.substring(pos + 1, ponto);
                inserirArquivo(nomeArquivo, cidade, estacao);

                while ((line = br.readLine()) != null) {
                    String[] values = line.split(";");
                    if (i == 0) {
                        indices = values;
                        indices[i] = values[i].replaceAll("^\"|\"$", "");
                    } else {
                        Map<String, String> rowValues = new LinkedHashMap<>();
                        for (int j = 0; j < indices.length; j++) {
                            if (j < values.length) {
                                String value = values[j].replaceAll("^\"|\"$", "");
                                rowValues.put(indices[j], value);
                            } else {
                                rowValues.put(indices[j], "");
                            }
                        }
                        rows.add(rowValues);
                    }
                    i++;
                }

                List<List<String>> paramar = DbUtils.getParametros();
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
                                    String vf2 = mapa.values().toArray(new String[0])[z + 1];
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
                                }
                            }
                        } else if (mapa.size() == 12) {
                            dta = formataData(mapa.values().toArray(new String[0])[0]);
                            hra = mapa.values().toArray(new String[0])[1];
                            arc = nomeArquivo;
                            vla = mapa.values().toArray(new String[0])[z].replace(",", ".");
                            ind = indices[z];
                        }

                        if (vla.isEmpty()) {
                            sus = "1";
                        } else {
                            for (List<String> parametro : paramar) {
                                String paraind = parametro.get(0);

                                if (ind.contains(paraind)) {
                                    float min = Float.parseFloat(parametro.get(2));
                                    float max = Float.parseFloat(parametro.get(1));
                                    float vlr = Float.parseFloat(vla);

                                    if (vlr < min || vlr > max) {
                                        sus = "1";
                                    } else {
                                        sus = "0";
                                    }
                                    break;
                                }
                            }
                        }

                        registro.put("arc", arc);
                        registro.put("dta", dta);
                        registro.put("hra", hra);
                        registro.put("ind", ind);
                        registro.put("vla", vla);
                        registro.put("sus", sus);
                        registros.add(registro);
                    }
                }

                inserirRegistro(registros);
                fileUploadManager.addUploadedFile(fileContentHash);

                javafx.application.Platform.runLater(() -> {
                    progressIndicator.setVisible(false);
                    UploadCompleto();
                });
            } catch (IOException | NoSuchAlgorithmException e) {
                javafx.application.Platform.runLater(() -> {
                    progressIndicator.setVisible(false);
                    showErrorAlert("Erro ao fazer upload do arquivo", e.getMessage());
                });
                throw new RuntimeException(e);
            }
        }).start();
    }

    private String calculateFileHash(File file) throws IOException, NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        try (InputStream is = new FileInputStream(file)) {
            byte[] buffer = new byte[1024];
            int read;
            while ((read = is.read(buffer)) != -1) {
                md.update(buffer, 0, read);
            }
        }
        byte[] digest = md.digest();
        StringBuilder sb = new StringBuilder();
        for (byte b : digest) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    private void abrirParametrosFXML() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/leitorclima/cadastros.fxml")));
        Stage stage = (Stage) btnUploadFile.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void UploadCompleto() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Upload completo");
        alert.setHeaderText(null);
        alert.setContentText("Seu arquivo foi carregado com sucesso!");

        alert.showAndWait();
    }

    private void showErrorAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);

        alert.showAndWait();
    }

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
