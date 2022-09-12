package com.example.demo.controllers;

import com.example.demo.models.ChoiceOfAccount;
import com.example.demo.services.RegisterService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

public class RegisterController {
    RegisterService rs = new RegisterService();
    @FXML
    private TextField username, accountname;
    public void registerButton(ActionEvent e){
        try {
            rs.addUserToDatabase(username.getText(),accountname.getText(),choiceOFaccountController,e);
        } catch (IOException ex) {
            throw new RuntimeException(ex+"Adding user to database failed !");
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
