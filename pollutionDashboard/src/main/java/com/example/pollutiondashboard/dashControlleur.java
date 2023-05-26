package com.example.pollutiondashboard;
import javafx.scene.Node;
import javafx.stage.Stage;
import com.example.pollutiondashboard.Services.emissionServiceImpl;
import com.example.pollutiondashboard.Services.sourceServiceImpl;
import com.example.pollutiondashboard.entities.Emission;
import com.example.pollutiondashboard.entities.Source;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class dashControlleur {
    sourceServiceImpl sourceService=new sourceServiceImpl();
    emissionServiceImpl emissionService=new emissionServiceImpl();
    private Button HOME;
    @FXML
    private Button ajouterdata;
    @FXML
    private Button calculEmission;

    @FXML
    private Button consulterData;

    @FXML
    private TableView<Source> table;
    @FXML
    private BarChart<String, Number> barChart;

    @FXML
    private CategoryAxis xAxis;

    @FXML
    private NumberAxis yAxis;
    @FXML
    private TableColumn<Source, Integer> idSouCol;
    @FXML
    private TableColumn<Source, String> sourceEmissionCol;
    ObservableList<Source> dataS ;
    @FXML
    private TableView<Source> tableSource;
    @FXML
    private TableColumn<Source, String> limiteRegCol;
    @FXML
    private TableColumn<Source, String> ActiviteCol;
    @FXML
    private TableColumn<Source, String> TypeSourceCol;
    @FXML
    private TableColumn<Source, String> ResponsableCol;
    @FXML
    private TextField nbSource;
    @FXML
    private TextField maxEm;
    @FXML
    private Button addData;
    private HelloApplication mainapplication;

    public void initialize() {
        // Initialize the chart with data and configure its appearance
       /* XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.getData().add(new XYChart.Data<>("Category 1", 10));
        series.getData().add(new XYChart.Data<>("Category 2", 20));
        series.getData().add(new XYChart.Data<>("Category 3", 30));

        barChart.getData().add(series);*/

        // Set axis labels
        idSouCol.setCellValueFactory(new PropertyValueFactory<>("idSource"));
        idSouCol.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        idSouCol.setEditable(false);
        sourceEmissionCol.setCellValueFactory(new PropertyValueFactory<>("sourceEmission"));
        sourceEmissionCol.setCellFactory(TextFieldTableCell.forTableColumn());
        sourceEmissionCol.setEditable(true);
        TypeSourceCol.setCellValueFactory(new PropertyValueFactory<>("TypeSource"));
        TypeSourceCol.setCellFactory(TextFieldTableCell.forTableColumn());
        TypeSourceCol.setEditable(true);
        limiteRegCol.setCellValueFactory(new PropertyValueFactory<>("limiteReglementaire"));
        limiteRegCol.setCellFactory(TextFieldTableCell.forTableColumn());
        limiteRegCol.setEditable(true);
        ActiviteCol.setCellValueFactory(new PropertyValueFactory<>("Activite"));
        ActiviteCol.setCellFactory(TextFieldTableCell.forTableColumn());
        ActiviteCol.setEditable(true);
        ResponsableCol.setCellValueFactory(new PropertyValueFactory<>("responsable"));
        ResponsableCol.setCellFactory(TextFieldTableCell.forTableColumn());
        ResponsableCol.setEditable(true);
        tableSource.setEditable(true);
        dataS = FXCollections.observableArrayList(sourceService.findAll());
        tableSource.setItems(dataS);
        maxEm.setEditable(false);
        int nbsou=sourceService.nbSource();
        nbSource.setEditable(false);
        nbSource.setText(Integer.toString(nbsou));;
        float max=emissionService.maxEm();
        maxEm.setText(Float.toString(max));
    }
    private Stage stage;
    private Scene scene;
    private Parent root;


    public void switchToADD(ActionEvent event) throws IOException {

    }

    public void switchToADD(javafx.event.ActionEvent actionEvent) throws IOException  {
        root = FXMLLoader.load(getClass().getResource("Data.fxml"));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void consultData(javafx.event.ActionEvent actionEvent) throws IOException  {
        root = FXMLLoader.load(getClass().getResource("consultData.fxml"));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void CalculEmission(javafx.event.ActionEvent actionEvent) throws IOException  {
        root = FXMLLoader.load(getClass().getResource("Calcul.fxml"));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
