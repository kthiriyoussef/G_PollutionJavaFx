package com.example.pollutiondashboard;


import com.example.pollutiondashboard.Services.sourceServiceImpl;
import com.example.pollutiondashboard.entities.Source;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.ComboBox;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.io.IOException;


public class AddDataControlleur {
    sourceServiceImpl sourceService=new sourceServiceImpl();
    @FXML
    private Button HOME;
    @FXML
    private Button AddData;
    @FXML
    private Button calculEmission;
    @FXML
    private Button delete;
    @FXML
    private Button consulterData;

    @FXML
    private TextField sourceEmission;
    @FXML
    private TextField LimiteReg;
    @FXML
    private TextField emplacement;
    @FXML
    private TextField responsable;
    @FXML
    private RadioButton ActiveO;
    @FXML
    private RadioButton ActiveN;
    @FXML
    private TableView<Source> table;
    @FXML
    private TableColumn<Source, Integer> idSou;
    @FXML
    private TableColumn<Source, String> sourceEmissionCol;
    @FXML
    private TableColumn<Source, String> emplacementCol;
    @FXML
    private TableColumn<Source, String> responsableCol;
    @FXML
    private TableColumn<Source, String> limiteRegCol;
    @FXML
    private TableColumn<Source, String> ActiviteCol;
    @FXML
    private TableColumn<Source, String> TypeSourceCol;
    @FXML
    private Button calculer;
    @FXML
    private Button update;
    @FXML
    private ComboBox  typeSource;
    @FXML
    private Button limiteReg;
    ObservableList<Source> data ;
    @FXML
    private void initialize() {
        ObservableList<String> list = FXCollections.observableArrayList("Cheminee principale", "Chaudiere ", "Four industriel ", "Reacteur chimique","Système de combustion");
        typeSource.setItems(list);
        idSou.setCellValueFactory(new PropertyValueFactory<>("idSource"));
        idSou.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

        idSou.setEditable(false);
        sourceEmissionCol.setCellValueFactory(new PropertyValueFactory<>("sourceEmission"));
        sourceEmissionCol.setCellFactory(TextFieldTableCell.forTableColumn());
        sourceEmissionCol.setEditable(true);
        TypeSourceCol.setCellValueFactory(new PropertyValueFactory<>("TypeSource"));
        TypeSourceCol.setCellFactory(TextFieldTableCell.forTableColumn());
        TypeSourceCol.setEditable(true);
        responsableCol.setCellValueFactory(new PropertyValueFactory<>("responsable"));
        responsableCol.setCellFactory(TextFieldTableCell.forTableColumn());
        responsableCol.setEditable(true);
        limiteRegCol.setCellValueFactory(new PropertyValueFactory<>("limiteReglementaire"));
        limiteRegCol.setCellFactory(TextFieldTableCell.forTableColumn());
        limiteRegCol.setEditable(true);
        ActiviteCol.setCellValueFactory(new PropertyValueFactory<>("Activite"));
        ActiviteCol.setCellFactory(TextFieldTableCell.forTableColumn());
        ActiviteCol.setEditable(true);
        table.setEditable(true);
        data = FXCollections.observableArrayList(sourceService.findAll());
        table.setItems(data);





    }

    public void close(ActionEvent ae){

    }
    @FXML
    public void AddData(javafx.event.ActionEvent actionEvent) {
        String selectedCombo = typeSource.getSelectionModel().getSelectedItem().toString();
        String activite ="";
        int id=sourceService.lastId();;
        if (ActiveO.isSelected())
        {
            activite="oui";
        }
        else
            activite="non";

        Source E=new Source(id, sourceEmission.getText(),selectedCombo,responsable.getText(),LimiteReg.getText(),activite);
        boolean isCreated= sourceService.create(E);
        data.add(E);
        table.refresh();

    }
   @FXML
   public void delete(javafx.event.ActionEvent actionEvent) {
       Source selectedItem = table.getSelectionModel().getSelectedItem();
       if (selectedItem != null) {
           // Delete item from the database
           boolean isDeleted = sourceService.delete(selectedItem);

           if (isDeleted) {
               // Remove item from the TableView
               System.out.println(true);
               table.refresh();
               table.getItems().remove(selectedItem);
           }
       }

   }
   @FXML
    public void update(javafx.event.ActionEvent actionEvent){

       String selectedCombo = typeSource.getSelectionModel().getSelectedItem().toString();
       String activite ="";
       int id=0;
       if (ActiveO.isSelected())
       {
           activite="oui";
       }
       else
           activite="non";
       Source selectedSource = table.getSelectionModel().getSelectedItem();
       if (selectedSource != null) {
           int selectedId = selectedSource.getIdSource();
           id=selectedId;
       }
       Source E=new Source(id,sourceEmission.getText(),selectedCombo,responsable.getText(),LimiteReg.getText(),activite);
       boolean isCreated= sourceService.update(E);
       table.refresh();

   }


    public void rowClicked(javafx.scene.input.MouseEvent mouseEvent) {
        Source clickedSource = table.getSelectionModel().getSelectedItem();
        sourceEmission.setText(String.valueOf(clickedSource.getSourceEmission()));
        LimiteReg.setText(String.valueOf(clickedSource.getLimiteReglementaire()));
        responsable.setText(String.valueOf(clickedSource.getResponsable()));
    }
    private Stage stage;
    private Scene scene;
    private Parent root;
    public void HOME(javafx.event.ActionEvent actionEvent) throws IOException  {
        root = FXMLLoader.load(getClass().getResource("dash.fxml"));
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