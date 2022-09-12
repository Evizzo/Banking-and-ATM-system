package com.example.demo.controllers;

import com.example.demo.database.ConnectToDatabase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

public class ChooseYourAccountTypeController {
    @FXML
    TextField accountTypeTxtField;

    static String username,pin; // mora static inace je null u funkciji onContBut...
    ConnectToDatabase ctdb = new ConnectToDatabase();
    public ChooseYourAccountTypeController() {}
                                        public ChooseYourAccountTypeController(String username, String pin) {
                                            this.username = username;
                                            this.pin = pin;
                                        }
    public void onContinoueButton(ActionEvent e) throws IOException {
        System.out.println(accountTypeTxtField.getText() + " " + ctdb.getID(username,pin));
        new LoggedInController(accountTypeTxtField.getText(),ctdb.getID(username,pin),username,pin);
        SceneLoader sceneLoader = new SceneLoader();
        sceneLoader.loadScene(e,"LoggedIn.fxml");
    }
}
