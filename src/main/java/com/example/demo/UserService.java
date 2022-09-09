package com.example.demo;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class UserService {
    ConnectToDatabase ctdb = new ConnectToDatabase();
    PrintSqlException pseObject = new PrintSqlException();
    private String id;
    public UserService(){}
    public UserService(String id){
        this.id = id;
    }

    public void addExistingUserAccountTypeToDatabase(String username, String rnd, String accountID, String accountType) throws IOException, RuntimeException{
        try{
            ctdb.Connect();
            System.out.println(id);
            String sql = "SELECT * FROM ab_accounts WHERE id=?";
            PreparedStatement preparedStatement = ctdb.con.prepareStatement(sql);
            preparedStatement.setString(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            ab_accounts abaccounts;
            abaccounts = null;

            if (resultSet.next()) {
                abaccounts = new ab_accounts();
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
