package com.example.leitorclima.Utils;

import java.util.HashSet;
import javafx.scene.control.Alert;

public class FileUploadManager {
    private HashSet<String> uploadedFiles = new HashSet<String>();

    public boolean hasFileBeenUploaded(String fileName) {
        return uploadedFiles.contains(fileName);
    }

    public void addUploadedFile(String fileName) {
        uploadedFiles.add(fileName);
    }

    public void showAlreadyUploadedPopup() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Upload não realizado");
        alert.setHeaderText(null);
        alert.setContentText("Não é possível fazer upload de um arquivo repetido");

        alert.showAndWait();
    }
}