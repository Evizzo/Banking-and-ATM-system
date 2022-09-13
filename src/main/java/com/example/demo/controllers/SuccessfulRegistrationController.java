package com.example.demo.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class SuccessfulRegistrationController {
    @FXML
    Label nameLabel;

    public void displayName(String userName, String rnd) {
        nameLabel.setText("You have been successfully register " + userName + ",\n Your pin is: " + rnd);
    }
}
