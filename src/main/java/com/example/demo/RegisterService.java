package com.example.demo;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;
import java.util.UUID;

public class RegisterService {
    UserService us = new UserService();
    ConnectToDatabase ctdb = new ConnectToDatabase();
    PrintSqlException pseObject = new PrintSqlException();


    public void addUserToDatabase(String username, String accountID, String accountType) throws IOException, RuntimeException{
        Random random = new Random();
        UUID uuid = UUID.randomUUID();
        Hashing hash = new Hashing();
        String rnd = String.valueOf(random.nextInt(1000,9999));
        new SuccessfullRegistrationController(username, rnd);
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
            ab_accounts abaccounts = new ab_accounts();
            abaccounts.setUsername(username);
            abaccounts.setPin(rnd);
            ctdb.Disconnect();
            ctdb.Connect();
            sql = "INSERT INTO ab_balances (id,account_id,account_type,ammout) VALUES(?,?,?,?)";
            preparedStatement = ctdb.con.prepareStatement(sql);
            preparedStatement.setString(1, uuid.toString());
            preparedStatement.setString(2, accountID);
            preparedStatement.setString(3, accountType);
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

