package com.example.demo.database;

import com.example.demo.AppException;

import java.sql.*;

public class ConnectToDatabase {
    final String DB_URL = "jdbc:mysql://localhost:3306/sys";
    final String USERNAME = "root";
    final String PASSWORD = "password";
    public Connection con;
    public Statement stmt;
    public void Connect(){
        try {
            con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            stmt = con.createStatement();
        } catch(SQLException ex) {
            throw new AppException(ex);
        }
    }
    public void Disconnect(){
        try {
            stmt.close();
        } catch(SQLException sqe) {
            throw new AppException(sqe);
        }
        try {
            con.close();
        } catch (SQLException sqe) {
            throw new AppException(sqe);
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
        } catch(SQLException sqe) {
            throw new AppException(sqe);
        }
    }
}
