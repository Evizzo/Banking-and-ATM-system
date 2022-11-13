package com.example.demo.services;

import com.example.demo.AppException;
import com.example.demo.database.ConnectToDatabase;
import com.example.demo.database.PrintSqlException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AdminServices {
    private final ConnectToDatabase ctdb = new ConnectToDatabase();
    private final PrintSqlException pseObject = new PrintSqlException();

    public ArrayList<String> showAllUsers(){
        try {
            ctdb.Connect();
            String sql = "SELECT name FROM ab_accounts";
            PreparedStatement preparedStatement = ctdb.con.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            ArrayList<String> name= new ArrayList<String>();
            while (rs.next()) {

                name.add(rs.getString("name"));
            }
            ctdb.Disconnect();
            return name;
        } catch (SQLException sqe) {
            pseObject.printSQLException(sqe);
            throw new AppException(sqe);
        }
    }
}
