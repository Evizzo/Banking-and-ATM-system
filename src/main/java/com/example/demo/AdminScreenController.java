package com.example.demo;

import javafx.event.ActionEvent;

public class AdminScreenController {
    public void sqlToCvsButton(ActionEvent e){
        MySqlToCvs mySqlToCvs = new MySqlToCvs();
        mySqlToCvs.export("ab_accounts");
        mySqlToCvs.export("ab_balances");
    }
}
