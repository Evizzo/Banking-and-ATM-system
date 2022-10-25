package com.example.demo;

import com.example.demo.bitcoinvalueapi.BitcoinValueService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

public class Main extends Application {
    public static BitcoinValueService btcVS = new BitcoinValueService();
    public static void main(String[] args) {
        startService();
        launch(args);
    }
    @Override
    public void start(Stage stage) {
//        // baca error (nullpointerexception) kada pozovem funkc iz SceneLoader.java .............
        Parent root;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("MainScreen.fxml")));
        } catch (IOException e) {
            throw new AppException("loadMainScreen function failed", e);
        }
        stage.setTitle("Banking and ATM system");
        Image icon = new Image("logoatm.png");
        stage.getIcons().add(icon);
        stage.setScene(new Scene(root));
        stage.show();
    }

    public static void startService() {

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if(btcVS.bitcoinValue() != null){
                    System.out.println(btcVS.bitcoinValue());
                }
            }
        }, 0, 5000);
    }
}