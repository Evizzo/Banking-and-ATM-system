package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

public class RegisterController {
    RegisterService rs = new RegisterService();
    SceneLoader sceneLoader = new SceneLoader();
    @FXML
    private TextField username, accountname;
    public void registerButton(ActionEvent e){
        try {
            rs.addUserToDatabase(username.getText(),accountname.getText(),choiceOFaccountController,e);
        } catch (IOException ex) {
            throw new RuntimeException(ex+"Adding user to database failed !");
        }
        try {
            sceneLoader.loadScene(e,"SuccessfullRegistration.fxml");
        } catch (IOException ex) {
            throw new RuntimeException(ex+"Loading SuccessfullRegistration.fxml failed !");
        }
    }
    static String choiceOFaccountController;
//    public enum choiceOfAccountENUM{
//        CREDITCARD,
//        DEBITCARD,
//        SAVINGSACCOUNT,
//    }
    public void SetChooseAccountCreditCard(ActionEvent e) throws IOException {
        choiceOFaccountController = "credit_card";
    }
    public void SetChooseAccountDebitCard(ActionEvent e) throws IOException {
        choiceOFaccountController = "debit_card";
    }
    public void SetChooseAccountSavingsAccount(ActionEvent e) throws IOException {
        choiceOFaccountController = "savings_account";
    }
}
