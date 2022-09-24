package com.example.demo.controllers;

import com.example.demo.models.ChoiceOfAccount;
import com.example.demo.services.RegisterService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class NewAccountIdRegisterController {
    RegisterService rs = new RegisterService();
    private String pin,id,username; // OOOOOOOOOOOOPet klasika MORA static da ne bude mi null varijabla, nece bkv da se dodeli u metodi ako nije staticna var...
    @FXML
    private TextField accountname;

    public void initData(String id, String pin,String username) {
        this.id = id;
        this.pin = pin;
        this.username = username;
    }

    public void registerButton(ActionEvent e) {
        try {
            rs.addExistingUserAccountTypeToDatabase(username,pin,accountname.getText(),choiceOFaccountController,e,id);
            SceneLoader sceneLoader = new SceneLoader();
            sceneLoader.loadSuccesfoulyRegistredScene(e,username,pin);
        } catch (IOException ex) {
            throw new RuntimeException(ex+"Adding NEW user to database failed !");
        }
    }
    static ChoiceOfAccount choiceOFaccountController;

    public void SetChooseAccountCreditCard(ActionEvent e) throws IOException {
        choiceOFaccountController = ChoiceOfAccount.CREDIT_CARD;
    }
    public void SetChooseAccountDebitCard(ActionEvent e) throws IOException {
        choiceOFaccountController = ChoiceOfAccount.DEBIT_CARD;
    }
    public void SetChooseAccountSavingsAccount(ActionEvent e) throws IOException {
        choiceOFaccountController = ChoiceOfAccount.SAVINGS_ACCOUNT;
    }
}
