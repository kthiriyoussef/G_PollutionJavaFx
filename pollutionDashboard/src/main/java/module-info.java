module com.example.pollutiondashboard {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;


    opens com.example.pollutiondashboard to javafx.fxml;
    opens com.example.pollutiondashboard.entities to javafx.base;
    exports com.example.pollutiondashboard;
}