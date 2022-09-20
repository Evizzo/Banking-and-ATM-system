package com.example.demo.services;

import com.example.demo.AppException;
import com.example.demo.database.ConnectToDatabase;
import com.example.demo.database.PrintSqlException;
import com.example.demo.models.Accounts;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginService{
    private final ConnectToDatabase ctdb = new ConnectToDatabase();
    public Accounts logInCheck(String username, String pin) {
        Accounts abaccounts = null;
        try{
            ctdb.Connect();
            String sql = "SELECT * FROM ab_accounts WHERE name=? AND pin=?";
            PreparedStatement preparedStatement = ctdb.con.prepareStatement(sql);
            preparedStatement.setString(1, username);
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
            throw new AppException(sqe);
        }
        return abaccounts;
    }

}
