module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.net.http;


    opens com.example.demo to javafx.fxml;
    exports com.example.demo;
    exports com.example.demo.models;
    opens com.example.demo.models to javafx.fxml;
    exports com.example.demo.services;
    opens com.example.demo.services to javafx.fxml;
    exports com.example.demo.controllers;
    opens com.example.demo.controllers to javafx.fxml;
    exports com.example.demo.database;
    opens com.example.demo.database to javafx.fxml;
}