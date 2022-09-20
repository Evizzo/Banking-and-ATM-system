package com.example.demo.controllers;

import com.example.demo.models.ChoiceOfAccount;
import com.example.demo.services.RegisterService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

public class RegisterController {
    private final RegisterService rs = new RegisterService();
    // stodo uvek razdvajaj, retko zajedno!

    @FXML
    private TextField username;
    @FXML
    private TextField accountname;
    private String pin;
    public void registerButton(ActionEvent e) {
        rs.addUserToDatabase(username.getText(),accountname.getText(),choiceOFaccountController,e);
        SceneLoader sceneLoader = new SceneLoader();
        sceneLoader.loadSuccesfoulyRegistredScene(e,username.getText(),pin);
    }
    static ChoiceOfAccount choiceOFaccountController;

    public void setChooseAccountCreditCard(ActionEvent e) {
        choiceOFaccountController = ChoiceOfAccount.CREDIT_CARD;
    }
    public void setChooseAccountDebitCard(ActionEvent e) {
        choiceOFaccountController = ChoiceOfAccount.DEBIT_CARD;
    }
    public void setChooseAccountSavingsAccount(ActionEvent e) {
        choiceOFaccountController = ChoiceOfAccount.SAVINGS_ACCOUNT;
    }

    public void backButton(ActionEvent e){
            SceneLoader sceneLoader = new SceneLoader();
            sceneLoader.loadMainScreen(e);
    }
}
