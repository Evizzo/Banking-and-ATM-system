package com.example.demo.controllers;

import javafx.event.ActionEvent;

import java.io.IOException;

public class MainScreenController {

    public void actionForRegisterButton(ActionEvent e) {
        SceneLoader sceneLoader = new SceneLoader();
        sceneLoader.loadRegisterScene();
    }
    public void actionForLoginButton(ActionEvent e) {
        SceneLoader sceneLoader = new SceneLoader();
        sceneLoader.loadScene(e,"Login.fxml");
    }
    public void actionForAdminButton(ActionEvent e) {
        SceneLoader sceneLoader = new SceneLoader();
        sceneLoader.loadScene(e,"AdminScreen.fxml");
    }
}