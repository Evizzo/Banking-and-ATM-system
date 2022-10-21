package com.example.demo.controllers;

import com.example.demo.bitcoinvalueapi.BitcoinValueService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.Timer;
import java.util.TimerTask;

public class MainScreenController {
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