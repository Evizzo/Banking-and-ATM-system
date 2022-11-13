module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.net.http;
    requires com.google.gson;


    opens com.example.demo to javafx.fxml;
    exports com.example.demo;
    exports com.example.demo.models;
    exports com.example.demo.bitcoinvalueapi to com.google.gson; // Dodao sam zbog errora, komentar cisto da zapamtim ako mi zatreba...
    opens com.example.demo.bitcoinvalueapi to com.google.gson; // ^^^^^^^^^^^
    opens com.example.demo.models to javafx.fxml;
    exports com.example.demo.services;
    opens com.example.demo.services to javafx.fxml;
    exports com.example.demo.database;
    opens com.example.demo.database to javafx.fxml;
}