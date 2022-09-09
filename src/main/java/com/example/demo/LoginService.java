package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginService {
    ConnectToDatabase ctdb = new ConnectToDatabase();
    PrintSqlException pseObject = new PrintSqlException();
    SceneLoader sceneLoader = new SceneLoader();
    String usernameTextField, pinTextField;
//    @FXML

    TextField usernameTextField;
    TextField pinTextField;
    Label loginLabel;
    public LoginService(){}
    public LoginService(String usernameTextField, String pinTextField, Label loginLabel, TextField usernameTextField,TextField pinTextField ){
        this.usernameTextField = usernameTextField;
        this.pinTextField = pinTextField;
        this.loginLabel = loginLabel;
    }
    public ab_accounts abaccounts;
    public void logInCheck(ActionEvent e,String un, String pin) throws IOException {
        ab_accounts abaccounts;
        abaccounts = null;
        try{
            ctdb.Connect();
            String sql = "SELECT * FROM ab_accounts WHERE name=? AND pin=?";
            PreparedStatement preparedStatement = ctdb.con.prepareStatement(sql);
            preparedStatement.setString(1, un);
            preparedStatement.setString(2, pin);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                abaccounts = new ab_accounts();
                abaccounts.setPin(resultSet.getString("pin"));
                abaccounts.setUsername(resultSet.getString("name"));
            }
            ctdb.Disconnect();
        }
        catch(SQLException sqe) {
            pseObject.printSQLException(sqe);
            throw new RuntimeException(sqe);
        }

        try{
            if(abaccounts != null) {
                loginLabel.setText("Filled !");
            }
            else if(usernameTextField.getText().isEmpty() && pinTextField.getText().isEmpty()) {
                loginLabel.setText("Please fill in both fields.");
            }
            else {
                loginLabel.setText("Wrong USERNAME or PIN !");
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return abaccounts;
    }
}
