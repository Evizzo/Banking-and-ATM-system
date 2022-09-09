package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneLoader {
    private Stage stage;
    private Scene scene;
    private Parent root;
    public void loadScene(ActionEvent e,String FxmlFileName) throws IOException {
        root = FXMLLoader.load(getClass().getResource(FxmlFileName));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
