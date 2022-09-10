package com.example.demo;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ChooseYourAccountTypeController implements Initializable {
    @FXML
    ListView<String> accountTypes;
    String[] listOfAccounts = {};
    String currentSelection;
    static String username, pin; // opet smara za static da ne bude null u funkciji dole

    public ChooseYourAccountTypeController() {
    }

    public ChooseYourAccountTypeController(String username, String pin) {
        this.username = username;
        this.pin = pin;
    }

    ChooseYourAccountType cyat = new ChooseYourAccountType(username, pin);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            accountTypes.getItems().addAll(cyat.ChooseYourAccountType(username, pin));
        } catch (SQLException sqe) {
            PrintSqlException pse = new PrintSqlException();
            pse.printSQLException(sqe);
        }
        accountTypes.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {

                currentSelection = accountTypes.getSelectionModel().getSelectedItem();

                System.out.println(currentSelection);

            }
        });
    }
}
