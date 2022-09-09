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
    SceneLoader sceneLoader = new SceneLoader();

    public void loginButton(ActionEvent e) throws IOException {
        LoginService ls = new LoginService(usernameTextField.getText(),pinTextField.getText(), loginLabel,usernameTextField,pinTextField);
        Hashing has = new Hashing();
        try {
            ls.logInCheck(e,usernameTextField.getText(), has.hashString(pinTextField.getText()));
            sceneLoader.loadScene(e,"LoggedIn.fxml");
        } catch (IOException ex) {
            throw new RuntimeException(ex+"LOGIN BUTTON FAILED !");
        }
    }
}
