package com.example.demo.controllers;

import com.example.demo.services.BalanceServices;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

import static java.lang.Integer.parseInt;

public class AccountController {
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
    private String id, choice,pin,username;
    public void initData(String id, String choice,String pin,String username) {
        this.id = id;
        this.choice = choice;
        this.pin = pin;
        this.username = username;
        feedbackLabel.setText("Your overall accounts sum is: " + bs.sumOfBalances(id));
    }
    public void balanceCheckButton() {
        balanceLabel.setText(String.valueOf(bs.balanceCheck(choice, id)));
        feedbackLabel.setText("Your balnce has been showen.");
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
        SceneLoader sceneLoader = new SceneLoader();
        NewAccountIdRegisterController newAccountIdRegisterController = sceneLoader.loadCreateNewAccountIdScene(e);
        newAccountIdRegisterController.initData(id,pin,username);
    }
    public void logOutButton(ActionEvent e){
        SceneLoader sceneLoader = new SceneLoader();
        sceneLoader.loadLogOutButton(e);
    }
}
