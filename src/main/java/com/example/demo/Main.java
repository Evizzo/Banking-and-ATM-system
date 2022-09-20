package com.example.demo;

import com.example.demo.bitcoinvalueapi.BitcoinValueService;
import com.example.demo.controllers.SceneLoader;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class Main extends Application{
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) {
        // baca error kada pozovem funkc iz SceneLoader.java .............
        Parent root = null;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("MainScreen.fxml")));
        } catch (IOException e) {
            throw new AppException(" loadMainScreen function failed ",e);
        }
        stage.setTitle("Banking and ATM system");
        Image icon = new Image("logoatm.png");
        stage.getIcons().add(icon);
        stage.setScene(new Scene(root));
        stage.show();
    }
}