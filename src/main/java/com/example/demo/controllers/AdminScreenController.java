package com.example.demo.controllers;

import com.example.demo.database.MySqlToCvs;
import javafx.event.ActionEvent;

public class AdminScreenController {
    public void sqlToCvsButton(ActionEvent e){
        MySqlToCvs mySqlToCvs = new MySqlToCvs();
        mySqlToCvs.export("ab_accounts");
        mySqlToCvs.export("ab_balances");
    }
}