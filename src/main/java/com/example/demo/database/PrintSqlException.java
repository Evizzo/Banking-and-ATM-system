package com.example.demo.database;

import com.example.demo.AppException;

import java.sql.SQLException;

public class PrintSqlException {
    public void printSQLException(SQLException sqe){
        System.out.println("Error Code = " + sqe.getErrorCode());
        System.out.println("SQL state = " + sqe.getSQLState());
        System.out.println("Message = " + sqe.getMessage());
        System.out.println("printTrace /n");
        throw new AppException(" mysql failed " , sqe);
    }
}
