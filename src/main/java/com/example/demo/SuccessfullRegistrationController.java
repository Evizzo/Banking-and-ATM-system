package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class SuccessfullRegistrationController {
    @FXML
    Label nameLabel;
    String rnd,username;
    public SuccessfullRegistrationController(){}
    public SuccessfullRegistrationController(String username,String rnd){
        this.username = username;
        this.rnd = rnd;
        System.out.println(rnd);
        System.out.println(username);
        nameLabel.setText("You have been successfully register " + username + ",\n Your pin is: " + rnd);
    }
//    @FXML
//    public void initialize() {
//        System.out.println(rnd);
//        System.out.println(username);
//        nameLabel.setText("You have been successfully register " + username + ",\n Your pin is: " + rnd);
//    }
}
