package com.example.demo.services;

import com.example.demo.database.ConnectToDatabase;
import com.example.demo.database.PrintSqlException;
import com.example.demo.models.Accounts;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginService {
    ConnectToDatabase ctdb = new ConnectToDatabase();
    PrintSqlException pseObject = new PrintSqlException();

    String pinTextField;
    String loginLabel;

    // todo login servisu ne trebaju polja!
    public LoginService(String pinTextField, String loginLabel){
        this.pinTextField = pinTextField;
        this.loginLabel = loginLabel;
    }

    // todo login servise ne treba ActionEvent
    public Accounts logInCheck(String un, String pin) throws IOException {
        Accounts abaccounts = null;
        try{
            ctdb.Connect();
            String sql = "SELECT * FROM ab_accounts WHERE name=? AND pin=?";
            PreparedStatement preparedStatement = ctdb.con.prepareStatement(sql);
            preparedStatement.setString(1, un);
            preparedStatement.setString(2, pin);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                abaccounts = new Accounts();
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
