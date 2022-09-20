package com.example.demo.controllers;

import com.example.demo.bitcoinvalueapi.BitcoinValueService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class MainScreenController implements Initializable {
    @FXML
    Label bitcoinValue;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        BitcoinValueService btcVS = new BitcoinValueService();
        bitcoinValue.setText(btcVS.bitcoinValue()+"€");
    }
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