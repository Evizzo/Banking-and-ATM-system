package com.example.demo.controllers;

import com.example.demo.database.ConnectToDatabase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ChooseYourAccountTypeController {
    @FXML
    TextField accountTypeTxtField;

    private final ConnectToDatabase ctdb = new ConnectToDatabase();

    public void onContinoueButton(ActionEvent e){
        SceneLoader sceneLoader = new SceneLoader();
        var accountController = sceneLoader.loadAccountScreenScene(e);
        accountController.initData("nalog2", "savings", "nalog2", "2222");
    }
}
