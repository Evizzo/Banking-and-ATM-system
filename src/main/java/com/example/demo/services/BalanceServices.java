package com.example.demo.services;

import com.example.demo.controllers.LoginController;
import com.example.demo.database.ConnectToDatabase;
import com.example.demo.database.PrintSqlException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BalanceServices extends LoginController {
    private final ConnectToDatabase ctdb = new ConnectToDatabase();
    private final PrintSqlException pseObject = new PrintSqlException();
    LoginController lc = new LoginController();
    public int balanceCheck(String choice, String id){
        try {
            ctdb.Connect();
            String sql = "SELECT ammout FROM ab_balances WHERE id=? AND account_id=?";
            PreparedStatement preparedStatement = ctdb.con.prepareStatement(sql);
            preparedStatement.setString(1, id);
            preparedStatement.setString(2, choice);
            ResultSet rs = preparedStatement.executeQuery();
            int currBal = 0;
            while (rs.next()) {
                currBal = rs.getInt("ammout");
            }
            ctdb.Disconnect();
            return currBal;
        } catch (SQLException sqe) {
            pseObject.printSQLException(sqe);
            throw new RuntimeException(sqe);
        }
    }

    public void withdrawBalance(int currBal, int withdrawT, String choice, String id){
        try {
            ctdb.Connect();
            int forInput = currBal - withdrawT;
            String sql = "UPDATE ab_balances SET ammout=? WHERE id=? AND account_id=?";
            PreparedStatement preparedStatement = ctdb.con.prepareStatement(sql);
            preparedStatement = ctdb.con.prepareStatement(sql);
            preparedStatement.setInt(1, forInput);
            preparedStatement.setString(2, id);
            preparedStatement.setString(3, choice);
            preparedStatement.executeUpdate();
            ctdb.Disconnect();
        } catch(SQLException sqe) {
            pseObject.printSQLException(sqe);
            throw new RuntimeException(sqe);
        }
    }

    public void depositBalance(int depositT, int currBal, String choice, String id) {
        try {
            ctdb.Connect();
            int forInput = depositT + currBal;
            String sql = "UPDATE ab_balances SET ammout=? WHERE id=? AND account_id=?";
            PreparedStatement preparedStatement = ctdb.con.prepareStatement(sql);
            preparedStatement = ctdb.con.prepareStatement(sql);
            preparedStatement.setInt(1, forInput);
            preparedStatement.setString(2, id);
            preparedStatement.setString(3, choice);
            preparedStatement.executeUpdate();
            ctdb.Disconnect();
        }
        catch(SQLException sqe) {
            pseObject.printSQLException(sqe);
            throw new RuntimeException(sqe);
        }
    }

    public String sumOfBalances(String id){
        try {
            ctdb.Connect();

            String sql = "SELECT SUM(ammout) FROM ab_balances WHERE id=?";
            PreparedStatement preparedStatement = ctdb.con.prepareStatement(sql);
            preparedStatement.setString(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            rs.next();
            String sum = rs.getString(1);
            System.out.println(sum);

            ctdb.Disconnect();
            return sum;
        } catch (SQLException sqe) {
            pseObject.printSQLException(sqe);
            throw new RuntimeException(sqe);
        }
    }

    public void pinChange(String forInput, String id) {
        try {
            ctdb.Connect();
            Hashing has = new Hashing();
            String sql = "UPDATE ab_accounts SET pin=? WHERE id=?";
            PreparedStatement preparedStatement = ctdb.con.prepareStatement(sql);
            preparedStatement.setString(1, has.hashString(forInput));
            preparedStatement.setString(2, id);
            preparedStatement.executeUpdate();
            ctdb.Disconnect();
        }
        catch(SQLException sqe) {
            pseObject.printSQLException(sqe);
            throw new RuntimeException(sqe);
        }
    }

}
