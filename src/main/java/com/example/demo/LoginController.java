package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginController {
    @FXML
    TextField usernameTextField;
    @FXML
    TextField pinTextField;
    @FXML
    Label loginLabel;

    public void loginButton(ActionEvent e){
        LoginService ls = new LoginService(usernameTextField.getText(),pinTextField.getText());
        Hashing has = new Hashing();
        try {
            ls.logInCheck(e,usernameTextField.getText(), has.hashString(pinTextField.getText()));
        } catch (IOException ex) {
            throw new RuntimeException(ex+"LOGIN BUTTON FAILED !");
        }
        loginLabel.setText(ls.fieldCheck(e));
    }
}
