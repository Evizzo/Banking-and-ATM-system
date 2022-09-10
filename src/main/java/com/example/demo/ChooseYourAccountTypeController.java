package com.example.demo;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
                                    //implements Initializable
public class ChooseYourAccountTypeController {
    @FXML
    TextField accountTypeTxtField;

    static String username,pin; // mora static inace je null u funkciji onContBut...
    ConnectToDatabase ctdb = new ConnectToDatabase();
    public ChooseYourAccountTypeController() {}
                                        public ChooseYourAccountTypeController(String username, String pin) {
                                            this.username = username;
                                            this.pin = pin;
                                        }
    public void onContinoueButton(ActionEvent e) throws IOException {
        System.out.println(accountTypeTxtField.getText() + " " + ctdb.getID(username,pin));
        new LoggedInController(accountTypeTxtField.getText(),ctdb.getID(username,pin));
        SceneLoader sceneLoader = new SceneLoader();
        sceneLoader.loadScene(e,"LoggedIn.fxml");
    }









//    @FXML
//    ListView<String> accountTypes;
//    String[] listOfAccounts = {};
//    String currentSelection;
//    static String username, pin; // opet smara za static da ne bude null u funkciji dole
//


//    ChooseYourAccountType cyat = new ChooseYourAccountType(username, pin);

//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//        try {
//            accountTypes.getItems().addAll(cyat.ChooseYourAccountType(username, pin));
//        } catch (SQLException sqe) {
//            PrintSqlException pse = new PrintSqlException();
//            pse.printSQLException(sqe);
//        }
//        accountTypes.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
//
//            @Override
//            public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
//
//                currentSelection = accountTypes.getSelectionModel().getSelectedItem();
//
//                System.out.println(currentSelection);
//
//            }
//        });
//    }
}
