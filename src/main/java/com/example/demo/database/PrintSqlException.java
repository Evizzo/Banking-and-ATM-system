package com.example.demo.database;

import java.sql.SQLException;

public class PrintSqlException {
    public void printSQLException(SQLException sqe){
        System.out.println("Error Code = " + sqe.getErrorCode());
        System.out.println("SQL state = " + sqe.getSQLState());
        System.out.println("Message = " + sqe.getMessage());
        System.out.println("printTrace /n");
       // throw new RuntimeException(sqe); //-> missing return statemet iako u funkciji imam, mora van izgleda
    }
}
