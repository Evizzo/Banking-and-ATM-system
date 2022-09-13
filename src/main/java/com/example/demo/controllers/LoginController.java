package com.example.demo.controllers;

import com.example.demo.models.Accounts;
import com.example.demo.services.Hashing;
import com.example.demo.services.LoginService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;

public class LoginController {

    @FXML
    TextField usernameTextField;
    @FXML
    TextField pinTextField;
    @FXML
    Label loginLabel;

    public void loginButton(ActionEvent e) { // Nisam jos smislio kako da odvojim proveru u LoginSerbice xD
        LoginService ls = new LoginService(usernameTextField.getText(),pinTextField.getText());
        Hashing has = new Hashing();

        Accounts abaccounts;
        try {
            abaccounts = ls.logInCheck(e,usernameTextField.getText(), has.hashString(pinTextField.getText()));
        } catch (IOException ex) {
            throw new RuntimeException(ex+"LOGIN BUTTON FAILED !");
        }
        if (abaccounts != null){
            new ChooseYourAccountTypeController(usernameTextField.getText(), has.hashString(pinTextField.getText()));
            SceneLoader sceneLoader = new SceneLoader();
            sceneLoader.loadScene(e,"ChooseAccountID.fxml");
        }
        else if (usernameTextField.getText().isEmpty() && pinTextField.getText().isEmpty()) {
            loginLabel.setText("Please fill in both fields.");
        }
        else {
            loginLabel.setText("Wrong USERNAME or PIN !");
        }
    }
}
