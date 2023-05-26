package com.example.pollutiondashboard;

import com.example.pollutiondashboard.connexion.connexion;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import java.io.IOException;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        connexion cnx=new connexion();

        if (cnx.getCn()==null) {
            System.out.println("null");}
        else

        {
            System.out.println("connected Sucesfully");
        }
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("dash.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 800);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }



    public static void main(String[] args) {
        launch();
    }
}