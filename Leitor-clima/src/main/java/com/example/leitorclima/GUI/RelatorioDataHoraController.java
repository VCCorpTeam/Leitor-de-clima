package com.example.leitorclima.GUI;

import com.example.leitorclima.Models.ModelRelatorioDH;
import com.example.leitorclima.Utils.DbUtils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import static com.example.leitorclima.Utils.DbUtils.geraCidadeComboBox;

public class RelatorioDataHoraController {

    @FXML
    private ComboBox<String> CityBox;
    @FXML
    private DatePicker dateInicio;
    @FXML
    private DatePicker dateFim;
    @FXML
    private TableView<ModelRelatorioDH> relatorioDH;
    @FXML
    private TableColumn<ModelRelatorioDH, String> dataColumn;
    @FXML
    private TableColumn<ModelRelatorioDH, String> horaColumn;
    @FXML
    private TableColumn<ModelRelatorioDH, String> umidadeColumn;
    @FXML
    private TableColumn<ModelRelatorioDH, String> pressaoColumn;
    @FXML
    private TableColumn<ModelRelatorioDH, String> chuvaColumn;
    @FXML
    private TableColumn<ModelRelatorioDH, String> temperaturaColumn;
    @FXML
    private TableColumn<ModelRelatorioDH, String> pontoOrvalhoColumn;
    @FXML
    private TableColumn<ModelRelatorioDH, String> radiacaoColumn;
    @FXML
    private TableColumn<ModelRelatorioDH, String> velocidadeVentoColumn;
    @FXML
    private TableColumn<ModelRelatorioDH, String> rajadaVentoColumn;
    @FXML
    private TableColumn<ModelRelatorioDH, String> insolacaoColumn;
    @FXML
    private TableColumn<ModelRelatorioDH, String> nebulosidadeColumn;
    @FXML
    private TableColumn<ModelRelatorioDH, String> direcaoVentoColumn;
    @FXML
    private Button filtrarButton;
    @FXML
    private Button backDH;

    private ObservableList<ModelRelatorioDH> relatorios = FXCollections.observableArrayList();
    private ObservableList<ModelRelatorioDH> todosRelatorios = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        dataColumn.setCellValueFactory(new PropertyValueFactory<>("data"));
        horaColumn.setCellValueFactory(new PropertyValueFactory<>("hora"));
        umidadeColumn.setCellValueFactory(new PropertyValueFactory<>("umidade"));
        pressaoColumn.setCellValueFactory(new PropertyValueFactory<>("pressao"));
        chuvaColumn.setCellValueFactory(new PropertyValueFactory<>("chuva"));
        temperaturaColumn.setCellValueFactory(new PropertyValueFactory<>("temperatura"));
        pontoOrvalhoColumn.setCellValueFactory(new PropertyValueFactory<>("pontoOrvalho"));
        radiacaoColumn.setCellValueFactory(new PropertyValueFactory<>("radiacao"));
        velocidadeVentoColumn.setCellValueFactory(new PropertyValueFactory<>("velocidadeVento"));
        rajadaVentoColumn.setCellValueFactory(new PropertyValueFactory<>("rajadaVento"));
        insolacaoColumn.setCellValueFactory(new PropertyValueFactory<>("insolacao"));
        nebulosidadeColumn.setCellValueFactory(new PropertyValueFactory<>("nebulosidade"));
        direcaoVentoColumn.setCellValueFactory(new PropertyValueFactory<>("direcaoVento"));

        relatorioDH.setItems(relatorios);

        filtrarButton.setOnAction(event -> filtrarDados());

        carregarDados();
    }

    private void carregarDados() {
        List<String> cidades = geraCidadeComboBox();
        CityBox.getItems().addAll(cidades);
        List<List<String>> dados = DbUtils.getAllRegistros();

        // Exemplo de como adicionar dados à tabela
        todosRelatorios.add(new ModelRelatorioDH("2023-06-01", "12:00", "45%", "1013hPa", "0mm", "25°C", "13°C", "800W/m²", "10km/h", "15km/h", "6h", "Clear", "N","90"));
        todosRelatorios.add(new ModelRelatorioDH("2023-06-01", "13:00", "50%", "1012hPa", "0mm", "26°C", "14°C", "850W/m²", "12km/h", "18km/h", "7h", "Partly Cloudy", "NE","90"));

        relatorios.addAll(todosRelatorios);
    }

    @FXML
    private void filtrarDados() {
        String cidadeesc = CityBox.getValue();
        LocalDate dataInicio = dateInicio.getValue();
        LocalDate dataFim = dateFim.getValue();

        Map<String, Map<String, ModelRelatorioDH>> dadosMapeados = new HashMap<>();

        for (List<String> dado : DbUtils.getAllRegistros()) {
            String indice = dado.get(0);
            String date = dado.get(1);
            String hora = dado.get(2);
            String cidade = dado.get(3).split("_")[1].replace(".csv", "");
            String valor = dado.get(4);

            if (!cidade.equals(cidadeesc)) {
                continue;
            }

            if (!dadosMapeados.containsKey(date)) {
                dadosMapeados.put(date, new HashMap<>());
            }
            Map<String, ModelRelatorioDH> horaMap = dadosMapeados.get(date);

            if (!horaMap.containsKey(hora)) {
                horaMap.put(hora, new ModelRelatorioDH(date, hora, "", "", "", "", "", "", "", "", "", "", "",""));
            }
            ModelRelatorioDH relatorio = horaMap.get(hora);

            if (indice.contains("Umi")) {
                relatorio.setUmidade(valor);
            } else if (indice.contains("Pressao")) {
                relatorio.setPressao(valor);
            } else if (indice.contains("Chuva")) {
                relatorio.setChuva(valor);
            } else if (indice.contains("Temp")) {
                relatorio.setTemperatura(valor);
            } else if (indice.contains("Pto Orvalho")) {
                relatorio.setPontoOrvalho(valor);
            } else if (indice.contains("Radiacao")) {
                relatorio.setRadiacao(valor);
            } else if (indice.contains("Vel.")) {
                relatorio.setVelocidadeVento(valor);
            } else if (indice.contains("Raj.")) {
                relatorio.setRajadaVento(valor);
            } else if (indice.contains("Inso")) {
                relatorio.setInsolacao(valor);
            } else if (indice.contains("Nebu")) {
                relatorio.setNebulosidade(valor);
            } else if (indice.contains("Dir.")) {
                relatorio.setDirecaoVento(valor);
            }
        }

        List<ModelRelatorioDH> filtrados = new ArrayList<>();
        for (Map.Entry<String, Map<String, ModelRelatorioDH>> entry : dadosMapeados.entrySet()) {
            LocalDate data = LocalDate.parse(entry.getKey());
            if ((data.isEqual(dataInicio) || data.isAfter(dataInicio)) && (data.isEqual(dataFim) || data.isBefore(dataFim))) {
                filtrados.addAll(entry.getValue().values());
            }
        }

        relatorios.setAll(filtrados);
    }
    public void voltarMenuDH() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/leitorclima/menu.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) backDH.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
