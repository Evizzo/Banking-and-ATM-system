package com.example.demo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ChooseYourAccountType {
    ConnectToDatabase ctdb = new ConnectToDatabase();
    private String username, pin;
    public ChooseYourAccountType(String username, String pin){
        this.username = username;
        this.pin = pin;
    }

    public String[] ChooseYourAccountType(String username, String pin) throws SQLException {
        ctdb.Connect();
        try {
            String sql = "SELECT account_type FROM ab_balances WHERE id=?";
            PreparedStatement preparedStatement = ctdb.con.prepareStatement(sql);
            preparedStatement.setString(1, ctdb.getID(username, pin));
            ResultSet rs = preparedStatement.executeQuery(sql);
            String[] listOfAccountTypes={};
            int counter=0;
            while (rs.next()) {
                listOfAccountTypes[counter] = rs.getString("account_type");
                counter++;
            }
            for (String str : listOfAccountTypes){
                System.out.println(str);
            }
            return listOfAccountTypes;

        }
        catch (SQLException sqe){
            PrintSqlException pse = new PrintSqlException();
            pse.printSQLException(sqe);
        }
        ctdb.Disconnect();
        return null;

    }

//    public void showAccountTypes() throws SQLException {
//        ctdb.Connect();
//        System.out.println(ctdb.getID(abAccounts.getUsername(),abAccounts.getPin()));
//        String sql = "SELECT account_type FROM ab_balances WHERE id=?";
//        PreparedStatement preparedStatement = ctdb.con.prepareStatement(sql);
//        preparedStatement.setString(1, ctdb.getID(abAccounts.getUsername(),abAccounts.getPin()));
//        ResultSet rs = preparedStatement.executeQuery();
//        rs.next();
//        String sum = rs.getString(1);
//        System.out.println(sum);
//
//        ctdb.Disconnect();
//    }
}
