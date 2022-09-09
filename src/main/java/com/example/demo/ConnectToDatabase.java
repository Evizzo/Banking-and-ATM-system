package com.example.demo;

import java.sql.*;

public class ConnectToDatabase {
    final String DB_URL = "jdbc:mysql://localhost:3306/accs";
    final String USERNAME = "root";
    final String PASSWORD = "163135"; // PK TABLE: ab_accounts - id / name / pin ||| FK TABLE: ab_balances - id / CreditCardBalance / DebitCardBalance / SavingsAccountBalance
    public Connection con;
    public Statement stmt;
    PrintSqlException pseObject = new PrintSqlException();
    public void Connect(){
        try {
            con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            stmt = con.createStatement();
        } catch(SQLException sqe) {
            pseObject.printSQLException(sqe);
            throw new RuntimeException(sqe);
        }
    }
    public void Disconnect(){
        try {
            stmt.close();
        } catch(SQLException sqe) {
            pseObject.printSQLException(sqe);
            throw new RuntimeException(sqe);
        }
        try {
            con.close();
        } catch (SQLException sqe) {
            pseObject.printSQLException(sqe);
            throw new RuntimeException(sqe);
        }
    }
    public String getID(String nick, String pin){
        try {
            Connect();
            String sql = "SELECT id FROM ab_accounts WHERE name=? AND pin=?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, nick);
            preparedStatement.setString(2, pin);
            ResultSet rs = preparedStatement.executeQuery();
            String id = "METHOD getID FAILED";
            while (rs.next()) {
                id = rs.getString("id");
            }
            Disconnect();
            return id;
        }catch(SQLException sqe) {
            pseObject.printSQLException(sqe);
            throw new RuntimeException(sqe);
        }
    }
}
