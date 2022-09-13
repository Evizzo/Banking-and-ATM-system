package com.example.demo.controllers;

import com.example.demo.AppException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

// todo klasa radi SAMO ucitavanje scena, tj. stageova!
// todo sva imanea FXML fajlovi su ovde!
public class SceneLoader {

    public static final String RESOURCE_PATH = "/com/example/demo/";

    // todo promeni ime
    private Parent foo(String fxmlFileName) {
        var resource = getClass().getResource(RESOURCE_PATH + fxmlFileName);
        try {
            return FXMLLoader.load(Objects.requireNonNull(resource));
        } catch (IOException ex) {
            throw new AppException("Loading failed: " + fxmlFileName, ex);
        }
    }

    // todo ne genericko, nego metoda za svaku!
    // todo: gledaj da NE saljes ActionEvent, nego Scenu.
    public void loadScene(ActionEvent e, String fxmlFileName) {
        Parent root = foo(fxmlFileName);
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public Stage loadAccountScreen(/* args */) {
        // ono sa diskorda
        return null;
    }
}
