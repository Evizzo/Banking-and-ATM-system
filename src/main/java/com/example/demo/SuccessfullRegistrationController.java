package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class SuccessfullRegistrationController {
    @FXML
    Label nameLabel;
    private Stage stage;
    private Scene scene;
    private Parent root;
    public void displayName(String userName, String rnd){
        nameLabel.setText("You have been successfully register " + userName + ",\n Your pin is: " + rnd);
    }
}
