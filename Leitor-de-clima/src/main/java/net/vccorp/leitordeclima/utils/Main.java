package net.vccorp.leitordeclima.utils-de-clima.utils;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;


    public class Main extends Application { //codigo-base da interface inicial

        @Override
        public void start(Stage primaryStage) {
            primaryStage.setTitle("Upload de Arquivo CSV");

            Button uploadButton = new Button("Selecionar Arquivo CSV");
            uploadButton.setOnAction(event -> uploadCSVFile());

            VBox vbox = new VBox(10);
            vbox.getChildren().add(uploadButton);

            Scene scene = new Scene(vbox, 300, 200);
            primaryStage.setScene(scene);
            primaryStage.show();
        }

        private void uploadCSVFile() {
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Arquivos CSV", "*.csv"));
            File file = fileChooser.showOpenDialog(null);

            if (file != null) {
            }
        }



        public static void main(String[] args) {
            launch(args);
        }
    }