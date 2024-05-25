package com.example.leitorclima.GUI;

import com.example.leitorclima.Models.Registro;
import com.example.leitorclima.Utils.DbUtils;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import org.controlsfx.control.action.Action;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

import static com.example.leitorclima.Utils.DbUtils.*;

public class DadosSuspeitosController implements Initializable {

    private ObservableList<String> teste;
    private List<String> listaArquivo;
    @FXML
    private Button btnVoltaMenu;
    @FXML
    private ComboBox<String> cbArquivo;
    @FXML
    private TableView<Registro> tableDadosSus;
    @FXML
    private TableColumn<Registro,String> colunaData;
    @FXML
    private TableColumn<Registro,String> colunaHora;
    @FXML
    private TableColumn<Registro,String> colunaIndice;
    @FXML
    private TableColumn<Registro,String> colunaValor;
    @FXML
    private TextField tfEdicao;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        listaArquivo = geraArquivoComboBox();

        cbArquivo.getItems().addAll(listaArquivo);

        colunaData.setCellValueFactory(
                new PropertyValueFactory<>("Data"));
        colunaHora.setCellValueFactory(
                new PropertyValueFactory<>("Hora"));
        colunaIndice.setCellValueFactory(
                new PropertyValueFactory<>("Indice"));
        colunaValor.setCellValueFactory(
                new PropertyValueFactory<>("Valor"));

    }

    @FXML
    public void select(){
        tableDadosSus.getItems().clear();
        if (getListaRegistroSus(cbArquivo.getValue()) == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Dados suspeitos não encontrados");
            alert.setHeaderText(null);
            alert.setContentText("Não há dados suspeitos no arquivo selecionado!");
        }
        tableDadosSus.getItems().addAll(Objects.requireNonNull(getListaRegistroSus(cbArquivo.getValue())));
    }

    @FXML
    public void editaDadoSus(){

        String textEdit = tfEdicao.getText();
        Registro itemSelecionado = tableDadosSus.getSelectionModel().getSelectedItem();

        if (textEdit.isEmpty() || itemSelecionado == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Edição não concluída");
            alert.setHeaderText(null);
            alert.setContentText("Edição só é concluída quando campo é preenchido e registro é selecionado!");

            alert.showAndWait();
        } else{
            String data = itemSelecionado.getData();
            String hora = itemSelecionado.getHora();
            String indice = itemSelecionado.getIndice();

            alteraArquivo(textEdit, data, hora, indice);

            tableDadosSus.getItems().removeAll(itemSelecionado);

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Edição concluída");
            alert.setHeaderText(null);
            alert.setContentText("Campo editado com sucesso!");

            alert.showAndWait();
        }
    }

    @FXML
    private void voltaMenu() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/leitorclima/menu.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) btnVoltaMenu.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
