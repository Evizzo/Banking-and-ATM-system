package com.example.demo.services;

import com.example.demo.controllers.RegisterController;
import com.example.demo.database.ConnectToDatabase;
import com.example.demo.database.PrintSqlException;
import com.example.demo.models.ChoiceOfAccount;
import com.example.demo.models.Accounts;
import javafx.event.ActionEvent;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.UUID;

public class RegisterService {

    private final ConnectToDatabase ctdb = new ConnectToDatabase();
    private final PrintSqlException pseObject = new PrintSqlException();

    public void addUserToDatabase(String username, String accountID, ChoiceOfAccount accountType, ActionEvent e) {
        Random random = new Random();
        UUID uuid = UUID.randomUUID();
        Hashing hash = new Hashing();
        String rnd = String.valueOf(random.nextInt(1000,9999));
        String rndmUnhased = rnd;
        rnd = hash.hashString(rnd);
        try{
            ctdb.Connect();
            String sql = "INSERT INTO ab_accounts (id, name, pin) VALUES(?,?,?)";
            PreparedStatement preparedStatement = ctdb.con.prepareStatement(sql);
            preparedStatement.setString(1,uuid.toString());
            preparedStatement.setString(2, username);
            preparedStatement.setString(3, rnd);
            int addedRows = preparedStatement.executeUpdate();
            if (addedRows == 0){
                throw new RuntimeException("ERROR Added Rows is equal to 0 !");
            }
            Accounts abaccounts = new Accounts();
            abaccounts.setUsername(username);
            abaccounts.setPin(rnd);
            ctdb.Disconnect();

            ctdb.Connect();
            sql = "INSERT INTO ab_balances (id,account_id,account_type,ammout) VALUES(?,?,?,?)";
            preparedStatement = ctdb.con.prepareStatement(sql);
            preparedStatement.setString(1, uuid.toString());
            preparedStatement.setString(2, accountID);
            preparedStatement.setString(3, String.valueOf(accountType));
            preparedStatement.setInt(4, 0);
            addedRows = preparedStatement.executeUpdate();
            if (addedRows == 0){
                throw new RuntimeException("ERROR Added Rows is equal to 0 !");
            }
            abaccounts.setBalance(0);

            ctdb.Disconnect();
        }
        catch(SQLException sqe) {
            pseObject.printSQLException(sqe);
            throw new RuntimeException(sqe);
        }
    }

    public void addExistingUserAccountTypeToDatabase(String username, String rnd, String accountID, ChoiceOfAccount accountType, ActionEvent e, String id) throws IOException, RuntimeException{
        try{
            ctdb.Connect();
            //System.out.println(id);
            String sql = "SELECT * FROM ab_accounts WHERE id=?";
            PreparedStatement preparedStatement = ctdb.con.prepareStatement(sql);
            preparedStatement.setString(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            Accounts abaccounts = new Accounts();

            if (resultSet.next()) {
                abaccounts = new Accounts();
                abaccounts.setPin(resultSet.getString("pin"));
                abaccounts.setUsername(resultSet.getString("name"));
            }
            abaccounts.setUsername(username);
            abaccounts.setPin(rnd);
            ctdb.Disconnect();

            ctdb.Connect();
            sql = "INSERT INTO ab_accounts (id, name, pin) VALUES(?,?,?)";
            preparedStatement = ctdb.con.prepareStatement(sql);
            preparedStatement.setString(1,id);
            preparedStatement.setString(2, abaccounts.getUsername());
            preparedStatement.setString(3, abaccounts.getPin());
            int addedRows = preparedStatement.executeUpdate();
            if (addedRows == 0){
                throw new RuntimeException("ERROR Added Rows is equal to 0 !");
            }
            ctdb.Disconnect();

            ctdb.Connect();
            sql = "INSERT INTO ab_balances (id,account_id,account_type,ammout) VALUES(?,?,?,?)";
            preparedStatement = ctdb.con.prepareStatement(sql);
            preparedStatement.setString(1, id);
            preparedStatement.setString(2, accountID);
            preparedStatement.setString(3, String.valueOf(accountType));
            preparedStatement.setInt(4, 0);
            addedRows = preparedStatement.executeUpdate();
            if (addedRows == 0){
                throw new RuntimeException("ERROR Added Rows is equal to 0 !");
            }
            abaccounts.setBalance(0);
            ctdb.Disconnect();
        }
        catch(SQLException sqe) {
            pseObject.printSQLException(sqe);
            throw new RuntimeException(sqe);
        }
    }

}

