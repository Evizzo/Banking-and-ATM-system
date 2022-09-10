package com.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

import static java.lang.Integer.parseInt;

public class LoggedInController implements Initializable {
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
    private static String id, choice;
    public LoggedInController(){}
    public LoggedInController(String choice, String id){
        this.choice = choice;
        this.id = id;
    }
    BalanceServices bs = new BalanceServices(choice,id);

    public void balanceCheckButton(){
//        System.out.println(id + " - " + choice);
        balanceLabel.setText(String.valueOf(bs.balanceCheck()));
    }

    public void withdrawBalanceButton(){  // Jos nisam otkrio kako da setam tekst za labele u non-controller klasama V2.
        try{
            if(withdrawInput.getText().isEmpty()){
                feedbackLabel.setText("Field cannot be empty !");
            }
            else {
                //UNOS
                if(bs.balanceCheck()>=parseInt(withdrawInput.getText()) && bs.balanceCheck()!=0) {
                    bs.withdrawBalance(bs.balanceCheck(), parseInt(withdrawInput.getText()));
                    feedbackLabel.setText("You have successfully withdrawn " + withdrawInput.getText() + "$, Your current balance is: " + bs.balanceCheck() + "$");
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
                bs.depositBalance(parseInt(depositInput.getText()), bs.balanceCheck());
                feedbackLabel.setText("You have successfully deposited " + depositInput.getText() + "$, Your current balance is: " + bs.balanceCheck()+"$");
            }
        } catch (Exception es){
            es.printStackTrace();
        }
    }
    public void pinChangeButton(){
        try{
            if(pinChangeInput.getText().length() == 4) {
                bs.pinChange(pinChangeInput.getText());
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
          feedbackLabel.setText("Your overall accounts sum is: " + bs.sumOfBalances());
    }
}
