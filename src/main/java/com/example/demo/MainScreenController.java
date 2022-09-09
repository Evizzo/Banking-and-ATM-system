package com.example.demo;

import javafx.event.ActionEvent;

import java.io.IOException;

public class MainScreenController {
    SceneLoader sceneLoader = new SceneLoader();
    public void actionForRegisterButton(ActionEvent e){
        try {
            sceneLoader.loadScene(e,"Register.fxml");
        } catch (IOException ex) {
            throw new RuntimeException(ex + "actionForRegisterButton METHOD FAILED !");
        }
    }
    public void actionForLoginButton(ActionEvent e){
        try {
            sceneLoader.loadScene(e,"Login.fxml");
        } catch (IOException ex) {
            throw new RuntimeException(ex + "actionForLoginButton METHOD FAILED !");
        }
    }
}