package com.example.demo.controllers;

import com.example.demo.AppException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

// todo klasa radi SAMO ucitavanje scena, tj. stageova!
// todo sva imanea FXML fajlovi su ovde!
public class SceneLoader {
    public static final String RESOURCE_PATH = "/com/example/demo/";

    // todo promeni ime
    private Parent fxmlLoad(String fxmlFileName) {
        var resource = getClass().getResource(RESOURCE_PATH + fxmlFileName);
        try {
            return FXMLLoader.load(Objects.requireNonNull(resource));
        } catch (IOException ex) {
            throw new AppException("Loading failed: " + fxmlFileName, ex);
        }
    }

    // todo ne genericko, nego metoda za svaku!
    // todo: gledaj da NE saljes ActionEvent, nego Scenu.
    public void loadScene(ActionEvent e, String fxmlFileName) {
        Parent root = fxmlLoad(fxmlFileName);
        Stage stage = (Stage) ((Node) (e).getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

//        Parent root = null;
//        try {
//            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(fxmlFileName)));
//        } catch (IOException e) {
//            throw new AppException(" SceneLoader function failed ", e);
//        }
//        stage.setScene(new Scene(root));
//        stage.show();
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
        new SuccessfulRegistrationController();
        SuccessfulRegistrationController urc;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/demo/SuccessfullRegistration.fxml"));
        Parent root = null;
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
    public void loadChooseAccountIDScene(ActionEvent e){
        SceneLoader sceneLoader = new SceneLoader();
        sceneLoader.loadScene(e,"ChooseAccountID.fxml");
    }
    public void loadCreateNewAccountIdScene(ActionEvent e){
        loadScene(e, "RegisterNewAccountId.fxml");
    }
    public void loadAccountScreenScene(ActionEvent e){
        loadScene(e,"AccountScreen.fxml");
    }
    public void loadLogOutButton(ActionEvent e){
        loadScene(e,"MainScreen.fxml");
    }
    public void loadMainScreen(ActionEvent e){
        loadScene(e,"MainScreen.fxml");
    }

    //public void loadMainScreen(Stage stage){
//        Parent root = null;
//        try {
//            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("MainScreen.fxml")));
//        } catch (IOException e) {
//            throw new AppException(" loadMainScreen function failed ",e);
//        }
//        stage.setTitle("Banking and ATM system");
//        Image icon = new Image("logoatm.png");
//        stage.getIcons().add(icon);
//        stage.setScene(new Scene(root));
//        stage.show();
//    }
}
