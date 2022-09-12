package com.example.demo.controllers;

import com.example.demo.models.ChoiceOfAccount;
import com.example.demo.services.RegisterService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

public class NewAccountIdRegisterController {
    RegisterService rs = new RegisterService();
    static String pin,id,username; // OOOOOOOOOOOOPet klasika MORA static da ne bude mi null varijabla, nece bkv da se dodeli u metodi ako nije staticna var...
    @FXML
    private TextField accountname;
    public NewAccountIdRegisterController(){}
    public NewAccountIdRegisterController(String username, String pin,String id){
        this.username = username;
        this.pin = pin;
        this.id = id;
    }
    public void registerButton(ActionEvent e){
        try {

            rs.addExistingUserAccountTypeToDatabase(username,pin,accountname.getText(),choiceOFaccountController,e,id);
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
