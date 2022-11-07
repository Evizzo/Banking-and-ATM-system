package com.example.demo.controllers;

import com.example.demo.AppException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneLoader {

    private static final String RESOURCE_PATH = "/com/example/demo/";
    private <T> T loadScene(ActionEvent e, String fxmlFileName) {
        var resource = getClass().getResource(RESOURCE_PATH + fxmlFileName);
        FXMLLoader fxmlLoader = new FXMLLoader(resource);
        Parent root;
        try {
            root = fxmlLoader.load();
        } catch (IOException ex) {
            throw new AppException("Loading failed: " + fxmlFileName, ex);
        }
        Stage stage = (Stage) ((Node) (e).getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        return fxmlLoader.getController();
    }

    public void loadRegisterScene(ActionEvent e) {
        loadScene(e,"Register.fxml");
    }
    public void loadLoginScene(ActionEvent e) {
        loadScene(e,"Login.fxml");
    }

    public void loadAdminScene(ActionEvent e) {
        loadScene(e,"AdminScreen.fxml");
    }

    public void loadSuccesfoulyRegistredScene(ActionEvent e,String username, String pin){
        SuccessfulRegistrationController urc;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/demo/SuccessfullRegistration.fxml"));
        Parent root;
        try {
            root = loader.load();
        } catch (IOException ex) {
            throw new AppException("loadSuccesfoulyRegistredScene function failed: " , ex);
        }

        urc = loader.getController();
        urc.displayName(username,pin);
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public ChooseYourAccountTypeController loadChooseAccountIDScene(ActionEvent e){
        return loadScene(e,"ChooseAccountID.fxml");
    }
    public NewAccountIdRegisterController loadCreateNewAccountIdScene(ActionEvent e){
        return loadScene(e, "RegisterNewAccountId.fxml");
    }
    public AccountController loadAccountScreenScene(ActionEvent e) {
        return loadScene(e,"AccountScreen.fxml");
    }
    public void loadLogOutButton(ActionEvent e){
        loadScene(e,"MainScreen.fxml");
    }
    public void loadMainScreen(ActionEvent e){
        loadScene(e,"MainScreen.fxml");
    }

}
