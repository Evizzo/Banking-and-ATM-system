package com.example.demo.controllers;

import com.example.demo.database.ConnectToDatabase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class ChooseYourAccountTypeController {
    @FXML
    TextField accountTypeTxtField;

    private final ConnectToDatabase ctdb = new ConnectToDatabase();
    public void onContinoueButton(ActionEvent e){
//        System.out.println(accountTypeTxtField.getText() + " " + ctdb.getID(username,pin));
//        new AccountController(accountTypeTxtField.getText(),ctdb.getID(username,pin),username,pin);
        SceneLoader sceneLoader = new SceneLoader();
        sceneLoader.loadAccountScreenScene(e);
    }
}
