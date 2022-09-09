package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class SuccessfullRegistrationController {
    @FXML
    Label nameLabel;
    public void displayName(String userName, String rnd){
        nameLabel.setText("You have been successfully register " + userName + ",\n Your pin is: " + rnd);
    }
}
