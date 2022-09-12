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
import java.util.UUID;

public class RegisterController {
    RegisterService rs = new RegisterService();
    @FXML
    private TextField username, accountname;
    private static String pin;
    public RegisterController(){}
    public RegisterController(String id){
        this.pin = id;

    }
    public void registerButton(ActionEvent e) throws IOException {
        rs.addUserToDatabase(username.getText(),accountname.getText(),choiceOFaccountController,e);

        new SuccessfullRegistrationController();
        SuccessfullRegistrationController urc;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/demo/SuccessfullRegistration.fxml"));
        Parent root = loader.load();

        urc = loader.getController();
        urc.displayName(username.getText(),pin);
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
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
