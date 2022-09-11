package com.example.demo;

import javafx.event.ActionEvent;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginService {
    ConnectToDatabase ctdb = new ConnectToDatabase();
    PrintSqlException pseObject = new PrintSqlException();

    String pinTextField;
    String loginLabel;
    public LoginService(){}
    public LoginService(String pinTextField, String loginLabel){
        this.pinTextField = pinTextField;
        this.loginLabel = loginLabel;
    }
    public ab_accounts abaccounts;
    public ab_accounts logInCheck(ActionEvent e,String un, String pin) throws IOException, SQLException {
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
        return abaccounts;
    }

}
