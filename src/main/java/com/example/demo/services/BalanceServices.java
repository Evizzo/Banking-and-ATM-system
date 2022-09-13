package com.example.demo.services;

import com.example.demo.database.ConnectToDatabase;
import com.example.demo.database.MySqlQueries;
import com.example.demo.database.PrintSqlException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BalanceServices {
    private String id, choice;
    ConnectToDatabase ctdb = new ConnectToDatabase();
    PrintSqlException pseObject = new PrintSqlException();
    MySqlQueries msq = new MySqlQueries();
    public BalanceServices(String choice, String id){
        this.choice = choice;
        this.id = id;
    }

    public int balanceCheck(){
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

    public void withdrawBalance(int currBal, int withdrawT){
        int forInput = currBal - withdrawT;
        msq.updateWithThreePreparedStatement("ab_balances","ammout","id","account_id",forInput,id,choice);
    }

    public void depositBalance(int depositT, int currBal) {
        int forInput = depositT + currBal;
        msq.updateWithThreePreparedStatement("ab_balances","ammout","id","account_id",forInput,id,choice);
    }

    public String sumOfBalances(){
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

    public void pinChange(String forInput) {
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
