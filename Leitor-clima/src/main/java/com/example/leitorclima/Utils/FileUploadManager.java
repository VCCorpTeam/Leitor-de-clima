package com.example.leitorclima.Utils;

import java.util.HashSet;
import java.util.Set;

import javafx.scene.control.Alert;

public class FileUploadManager {
    private Set<String> uploadedFiles = new HashSet<>();

    public void addUploadedFile(String fileHash) {
        uploadedFiles.add(fileHash);
    }

    public boolean hasFileBeenUploaded(String fileHash) {
        return uploadedFiles.contains(fileHash);
    }

    public void showAlreadyUploadedPopup() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Arquivo já carregado");
        alert.setHeaderText(null);
        alert.setContentText("Este arquivo já foi carregado anteriormente.");

        alert.showAndWait();
    }
}
