package com.example.demo.database;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MySqlQueries { // there are mysql queries that repeat
    ConnectToDatabase ctdb = new ConnectToDatabase();
    PrintSqlException pseObject = new PrintSqlException();
    public void updateWithThreePreparedStatement(String table, String set, String firstWhere, String secondWhere, int forInput, String second, String third){
        // Jel mogu ovo nekako da stavim da je nezavisno od toga koliko ima preparedStatementa i nezavisno
        // od kolicine where parametra ?
        try {
            ctdb.Connect();
            String sql = "UPDATE ab_balances SET ammout=? WHERE id=? AND account_id=?";
            PreparedStatement preparedStatement = ctdb.con.prepareStatement(sql);
            preparedStatement = ctdb.con.prepareStatement(sql);
            preparedStatement.setInt(1, forInput);
            preparedStatement.setString(2, second); // usually id
            preparedStatement.setString(3, third); // usually choice
            preparedStatement.executeUpdate();
            ctdb.Disconnect();
        } catch(SQLException sqe) {
            pseObject.printSQLException(sqe);
            throw new RuntimeException(sqe);
        }
    }
}
