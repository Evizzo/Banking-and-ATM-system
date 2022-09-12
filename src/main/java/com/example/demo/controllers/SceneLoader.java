package com.example.demo.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class SceneLoader {
    public void loadScene(ActionEvent e, String fxmlFileName) throws IOException {
        var resource = getClass().getResource("/com/example/demo/" + fxmlFileName);
        Parent root = FXMLLoader.load(Objects.requireNonNull(resource));
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
