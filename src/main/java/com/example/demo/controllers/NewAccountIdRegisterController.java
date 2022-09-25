package com.example.demo.controllers;

import com.example.demo.AppException;
import com.example.demo.models.ChoiceOfAccount;
import com.example.demo.services.RegisterService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;


import java.io.IOException;

public class NewAccountIdRegisterController {
    RegisterService rs = new RegisterService();
    private String pin,id,username;
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
        } catch (AppException ex) {
            throw new AppException("Adding NEW user to database failed !",ex);
        }
    }
    static ChoiceOfAccount choiceOFaccountController;

    public void SetChooseAccountCreditCard(){
        choiceOFaccountController = ChoiceOfAccount.CREDIT_CARD;
    }
    public void SetChooseAccountDebitCard(){
        choiceOFaccountController = ChoiceOfAccount.DEBIT_CARD;
    }
    public void SetChooseAccountSavingsAccount(){
        choiceOFaccountController = ChoiceOfAccount.SAVINGS_ACCOUNT;
    }
}
