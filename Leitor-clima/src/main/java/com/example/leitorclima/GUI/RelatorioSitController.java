package com.example.leitorclima.GUI;

import com.example.leitorclima.Models.Boxplot;
import com.example.leitorclima.Models.Registro;
import com.example.leitorclima.Utils.CsvExporter;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static com.example.leitorclima.GUI.FormsRelatorioController.enviaDadosSit;
import static com.example.leitorclima.Utils.DbUtils.*;
import static com.example.leitorclima.Utils.UnidadeMedidaUtil.*;

public class RelatorioSitController implements Initializable {

    @FXML
    private TextField tfCidadeSit;
    @FXML
    private Button btnVoltaRelSit;
    @FXML
    private Button btnExportaCsvSit;
    @FXML
    private TableView<Registro> tableDadosSit;
    @FXML
    private TableColumn<Registro,String> colunaIndiceSit;
    @FXML
    private TableColumn<Registro,String> colunaValorSit;
    @FXML
    private TableColumn<Registro,String> colunaUnidSit;
    @FXML
    private TableColumn<Registro,String> colunaDataSit;
    @FXML
    private TableColumn<Registro,String> colunaHoraSit;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        List<String> listaDados = enviaDadosSit().getDados();
        List<Integer> listaUnid = enviaDadosSit().getListaUnidSit();

        tfCidadeSit.setText(listaDados.get(0));
        List<Registro> listaSituacional = getUltimosRegistros(listaDados.get(0));
        List<Registro> listaSitFinal = alteraUnid(listaUnid,listaSituacional);

        colunaIndiceSit.setCellValueFactory(new PropertyValueFactory<>("indice"));
        colunaValorSit.setCellValueFactory(new PropertyValueFactory<>("valor"));
        colunaUnidSit.setCellValueFactory(new PropertyValueFactory<>("unidMed"));
        colunaDataSit.setCellValueFactory(new PropertyValueFactory<>("data"));
        colunaHoraSit.setCellValueFactory(new PropertyValueFactory<>("hora"));

        tableDadosSit.getItems().addAll(listaSitFinal);

        btnExportaCsvSit.setOnAction(event -> {
            Stage stage = (Stage) btnExportaCsvSit.getScene().getWindow();
            CsvExporter.exportToCsvSit(new ArrayList<>(tableDadosSit.getItems()), stage);
        });
    }

    @FXML
    private void voltaRelSit() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/leitorclima/formsRelatorio.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) btnVoltaRelSit.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


