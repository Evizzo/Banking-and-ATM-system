package com.example.demo;

import com.example.demo.bitcoinvalueapi.BitcoinValueService;
import com.example.demo.controllers.AccountController;
import com.example.demo.controllers.MainScreenController;
import com.example.demo.controllers.SceneLoader;
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
import java.util.concurrent.Callable;

public class Main extends Application implements Callable<String> {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) {
//        // baca error (nullpointerexception) kada pozovem funkc iz SceneLoader.java .............
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

    @Override
    public String call() throws Exception {
        BitcoinValueService btcVS = new BitcoinValueService();
        Timer timer = new Timer();
        String resoult;
        timer.schedule(new TimerTask() {
            @Override
            public String run() {
                if(btcVS.bitcoinValue() != null){
                    System.out.println(btcVS.bitcoinValue());
                    return "aa";
                }
            }
        }, 0, 5000);

    }
}