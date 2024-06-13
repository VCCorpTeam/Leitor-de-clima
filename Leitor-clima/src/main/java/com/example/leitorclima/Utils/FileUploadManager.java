package com.example.leitorclima.Utils;

import java.util.HashSet;
import javafx.scene.control.Alert;

public class FileUploadManager {
    private HashSet<String> uploadedFileHashes = new HashSet<String>();

    public boolean hasFileBeenUploaded(String fileHash) {
        return uploadedFileHashes.contains(fileHash);
    }

    public void addUploadedFile(String fileHash) {
        uploadedFileHashes.add(fileHash);
    }

    public void showAlreadyUploadedPopup() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Upload não realizado");
        alert.setHeaderText(null);
        alert.setContentText("Não é possível fazer upload de um arquivo repetido");

        alert.showAndWait();
    }
}