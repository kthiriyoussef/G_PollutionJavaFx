package com.example.pollutiondashboard;

import com.example.pollutiondashboard.Services.emissionServiceImpl;
import com.example.pollutiondashboard.Services.sourceServiceImpl;
import com.example.pollutiondashboard.entities.Emission;
import com.example.pollutiondashboard.entities.Source;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.util.converter.FloatStringConverter;
import javafx.util.converter.IntegerStringConverter;

import java.io.IOException;

public class consultDataControlleur {
    sourceServiceImpl sourceService=new sourceServiceImpl();
    emissionServiceImpl emissionService=new emissionServiceImpl();
    @FXML
    private Button HOME;
    @FXML
    private Button AddData;
    @FXML
    private Button calculEmission;
    @FXML
    private TableColumn<Source, Integer> idSouCol;
    @FXML
    private TableColumn<Source, String> sourceEmissionCol;

    @FXML
    private TableColumn<Source, String> limiteRegCol;
    @FXML
    private TableColumn<Source, String> ActiviteCol;
    @FXML
    private TableColumn<Source, String> TypeSourceCol;
    @FXML
    private TableColumn<Source, String> ResponsableCol;

    @FXML
    private TableColumn<Source, String> SourceCol;
    @FXML
    private TableColumn<Source, String> ETypeSourceCol;
    @FXML
    private TableColumn<Source, Float> EmissionCol;
    ObservableList<Source> dataS ;
    ObservableList<Emission> dataE ;
    @FXML
    private TableView<Source> tableSource;
    @FXML
    private TableView<Emission> tableEmission;

    @FXML
    private void initialize() {

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
        SourceCol.setCellValueFactory(new PropertyValueFactory<>("source"));
        SourceCol.setCellFactory(TextFieldTableCell.forTableColumn());
        SourceCol.setEditable(false);
        ETypeSourceCol.setCellValueFactory(new PropertyValueFactory<>("typeSource"));
        ETypeSourceCol.setCellFactory(TextFieldTableCell.forTableColumn());
        ETypeSourceCol.setEditable(true);
        EmissionCol.setCellValueFactory(new PropertyValueFactory<>("emission"));
        EmissionCol.setCellFactory(TextFieldTableCell.forTableColumn(new FloatStringConverter()));
        EmissionCol.setEditable(true);
        dataE = FXCollections.observableArrayList(emissionService.findAll());
        tableEmission.setItems(dataE);


    }
    private Stage stage;
    private Scene scene;
    private Parent root;
    public void HOME(javafx.event.ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("dash.fxml"));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void CalculData(javafx.event.ActionEvent actionEvent) throws IOException  {
        root = FXMLLoader.load(getClass().getResource("Calcul.fxml"));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void AddData(javafx.event.ActionEvent actionEvent) throws IOException  {
        root = FXMLLoader.load(getClass().getResource("Data.fxml"));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
