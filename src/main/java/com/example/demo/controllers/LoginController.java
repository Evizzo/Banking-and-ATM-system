package com.example.demo.controllers;

import com.example.demo.AppException;
import com.example.demo.models.Accounts;
import com.example.demo.services.Hashing;
import com.example.demo.services.LoginService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LoginController {
    @FXML
    TextField usernameTextField;
    @FXML
    TextField pinTextField;
    @FXML
    Label loginLabel;
    public void backButton(ActionEvent e){
        SceneLoader sceneLoader = new SceneLoader();
        sceneLoader.loadMainScreen(e);
    }
    public Accounts abaccounts;
    public void loginButton(ActionEvent e) {
        LoginService ls = new LoginService();
        Hashing has = new Hashing();
        try {
            abaccounts = ls.logInCheck(usernameTextField.getText(), has.hashString(pinTextField.getText()));
            //System.out.println(abaccounts.getPin()+abaccounts.getUsername());
        }
        catch (Exception ex) {
            throw new AppException(" !! LOGIN BUTTON FAILED  !! " , ex) ;
        }
        if (abaccounts != null){
            SceneLoader sceneLoader = new SceneLoader();
            sceneLoader.loadChooseAccountIDScene(e);
        }
        else if (usernameTextField.getText().isEmpty() && pinTextField.getText().isEmpty()) {
            loginLabel.setText("Please fill in both fields.");
        }
        else {
            loginLabel.setText("Wrong USERNAME or PIN !");
        }
    }
}
