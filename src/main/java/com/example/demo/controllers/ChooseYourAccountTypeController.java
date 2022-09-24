package com.example.demo.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ChooseYourAccountTypeController {
    @FXML
    TextField accountTypeTxtField;
    private String id,username,pin;
    public void initData(String id,String username, String pin) {
        this.id = id;
        this.pin = pin;
        this.username = username;
    }
    public void onContinoueButton(ActionEvent e){
        SceneLoader sceneLoader = new SceneLoader();
        AccountController accountController = sceneLoader.loadAccountScreenScene(e);
        accountController.initData(id, accountTypeTxtField.getText(),pin,username);
    }
}
