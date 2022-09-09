package com.example.demo;

public class BalanceServices {
    private String id;
    ConnectToDatabase ctdb = new ConnectToDatabase();
    PrintSqlException pseObject = new PrintSqlException();
    public BalanceServices(String id){
        this.id = id;
    }

}
