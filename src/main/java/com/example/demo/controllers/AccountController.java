package com.example.demo.controllers;

import com.example.demo.database.ConnectToDatabase;
import com.example.demo.models.Accounts;
import com.example.demo.services.BalanceServices;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

import static java.lang.Integer.parseInt;

public class AccountController implements Initializable {
    @FXML
    Label balanceLabel;
    @FXML
    Label feedbackLabel;
    @FXML
    TextField withdrawInput;
    @FXML
    TextField depositInput;
    @FXML
    TextField pinChangeInput;
    private final BalanceServices bs = new BalanceServices();
    private String id, choice, username, pin;
//    public void initData(String id, String choice, String username, String pin) {
//        this.id = id;
//        this.choice = choice;
//        this.username = username;
//        this.pin = pin;
//    }
    private final ConnectToDatabase ctdb = new ConnectToDatabase();
    public void balanceCheckButton() {
        balanceLabel.setText(String.valueOf(bs.balanceCheck(choice, id)));
    }
    public void withdrawBalanceButton() {

        try{
            if(withdrawInput.getText().isEmpty()){
                feedbackLabel.setText("Field cannot be empty !");
            }
            else {
                //UNOS
                if(bs.balanceCheck(choice,id) >=parseInt(withdrawInput.getText()) && bs.balanceCheck(choice,id)!=0) {
                    bs.withdrawBalance(bs.balanceCheck(choice,id), parseInt(withdrawInput.getText()),choice,id);
                    feedbackLabel.setText("You have successfully withdrawn " + withdrawInput.getText() + "$, Your current balance is: " + bs.balanceCheck(choice,id) + "$");
                }
                else{
                    feedbackLabel.setText("Not enought money available !");
                }
            }
        } catch (Exception es){
            es.printStackTrace();
        }
    }
    public void depositBalanceButton(){
        try{
            if(depositInput.getText().isEmpty()){
                feedbackLabel.setText("Field cannot be empty !");
            }
            else {
                bs.depositBalance(parseInt(depositInput.getText()), bs.balanceCheck(choice,id),choice,id);
                feedbackLabel.setText("You have successfully deposited " + depositInput.getText() + "$, Your current balance is: " + bs.balanceCheck(choice,id)+"$");
            }
        } catch (Exception es){
            es.printStackTrace();
        }
    }
    public void pinChangeButton(){
        try{
            if(pinChangeInput.getText().length() == 4) {
                bs.pinChange(pinChangeInput.getText(),id);
                feedbackLabel.setText("Pin has been successfully changed to " + pinChangeInput.getText() + ", please login again.");
            }
            else if(pinChangeInput.getText().isEmpty()){
                feedbackLabel.setText("Field cannot be empty !");
            }
            else {
                feedbackLabel.setText("Pin has to be 4 digit number !");
            }
        } catch (Exception es){
            es.printStackTrace();
        }
    }
    public void createNewAccountId(ActionEvent e){
        NewAccountIdRegisterController nair = new NewAccountIdRegisterController();
        SceneLoader sceneLoader = new SceneLoader();
        sceneLoader.loadCreateNewAccountIdScene(e);
    }
    public void logOutButton(ActionEvent e){
        SceneLoader sceneLoader = new SceneLoader();
        sceneLoader.loadLogOutButton(e);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        feedbackLabel.setText("Your overall accounts sum is: " + bs.sumOfBalances(id));
    }
}
