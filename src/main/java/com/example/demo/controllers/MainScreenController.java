package com.example.demo.controllers;

import com.example.demo.bitcoinvalueapi.BitcoinValueService;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.Timer;
import java.util.TimerTask;

public class MainScreenController {
    //private volatile boolean exit = false;
    @FXML
    public void initialize(){
        final BitcoinValueService btcVS = new BitcoinValueService();
        final TimerTask task = new TimerTask() {
            @Override public void run() {
                Platform.runLater(() -> bitcoinValue.setText(btcVS.bitcoinValue()));
            }
        };
        new Timer().schedule(task, 0, 5000);
    }
    @FXML
    Label bitcoinValue;
    public void actionForRegisterButton(ActionEvent e) {
        SceneLoader sceneLoader = new SceneLoader();
        sceneLoader.loadRegisterScene(e);
    }
    public void actionForLoginButton(ActionEvent e) {
        SceneLoader sceneLoader = new SceneLoader();
        sceneLoader.loadLoginScene(e);
    }
    public void actionForAdminButton(ActionEvent e) {
        SceneLoader sceneLoader = new SceneLoader();
        sceneLoader.loadAdminScene(e);
    }
}