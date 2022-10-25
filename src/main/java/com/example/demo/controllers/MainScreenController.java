package com.example.demo.controllers;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.Timer;
import java.util.TimerTask;

import static com.example.demo.Main.btcVS;

public class MainScreenController {

    @FXML
    public void initialize(){
        var task = new TimerTask() {
            @Override public void run() {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        bitcoinValue.setText(btcVS.bitcoinValue());
                    }
                });
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