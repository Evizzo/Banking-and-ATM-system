package com.example.demo.services;

import com.example.demo.database.ConnectToDatabase;
import com.example.demo.database.PrintSqlException;
import com.example.demo.controllers.SuccessfullRegistrationController;
import com.example.demo.models.ChoiceOfAccount;
import com.example.demo.models.ab_accounts;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.UUID;

public class RegisterService {
    ConnectToDatabase ctdb = new ConnectToDatabase();
    PrintSqlException pseObject = new PrintSqlException();
//    private String id;
//    public RegisterService(){}
//    public RegisterService(String id){
//        this.id = id;
//    }

    public void addUserToDatabase(String username, String accountID, ChoiceOfAccount accountType, ActionEvent e) throws IOException, RuntimeException{
        Random random = new Random();
        UUID uuid = UUID.randomUUID();
        Hashing hash = new Hashing();
        String rnd = String.valueOf(random.nextInt(1000,9999));
        String rndmUnhased = rnd;
        rnd = hash.hashString(rnd);
        try{
            ctdb.Connect();
            String sql = "INSERT INTO ab_accounts (id, name, pin) VALUES(?,?,?)";
            PreparedStatement preparedStatement = ctdb.con.prepareStatement(sql);
            preparedStatement.setString(1,uuid.toString());
            preparedStatement.setString(2, username);
            preparedStatement.setString(3, rnd);
            int addedRows = preparedStatement.executeUpdate();
            if (addedRows == 0){
                throw new RuntimeException("ERROR Added Rows is equal to 0 !");
            }
            ab_accounts abaccounts = new ab_accounts();
            abaccounts.setUsername(username);
            abaccounts.setPin(rnd);
            ctdb.Disconnect();

            ctdb.Connect();
            sql = "INSERT INTO ab_balances (id,account_id,account_type,ammout) VALUES(?,?,?,?)";
            preparedStatement = ctdb.con.prepareStatement(sql);
            preparedStatement.setString(1, uuid.toString());
            preparedStatement.setString(2, accountID);
            preparedStatement.setString(3, String.valueOf(accountType));
            preparedStatement.setInt(4, 0);
            addedRows = preparedStatement.executeUpdate();
            if (addedRows == 0){
                throw new RuntimeException("ERROR Added Rows is equal to 0 !");
            }
            abaccounts.setBalance(0);
            ctdb.Disconnect();

            //ocajnicki pokusaj da radi
            new SuccessfullRegistrationController();
            SuccessfullRegistrationController urc;

            FXMLLoader loader = new FXMLLoader(getClass().getResource("SuccessfullRegistration.fxml"));
            Parent root = loader.load();

            urc = loader.getController();
            urc.displayName(username,rndmUnhased);
            Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        catch(SQLException sqe) {
            pseObject.printSQLException(sqe);
            throw new RuntimeException(sqe);
        }
    }

    public void addExistingUserAccountTypeToDatabase(String username, String rnd, String accountID, ChoiceOfAccount accountType, ActionEvent e, String id) throws IOException, RuntimeException{
        try{
            ctdb.Connect();
            //System.out.println(id);
            String sql = "SELECT * FROM ab_accounts WHERE id=?";
            PreparedStatement preparedStatement = ctdb.con.prepareStatement(sql);
            preparedStatement.setString(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            ab_accounts abaccounts = new ab_accounts();

            if (resultSet.next()) {
                abaccounts = new ab_accounts();
                abaccounts.setPin(resultSet.getString("pin"));
                abaccounts.setUsername(resultSet.getString("name"));
            }
            abaccounts.setUsername(username);
            abaccounts.setPin(rnd);
            ctdb.Disconnect();

            ctdb.Connect();
            sql = "INSERT INTO ab_accounts (id, name, pin) VALUES(?,?,?)";
            preparedStatement = ctdb.con.prepareStatement(sql);
            preparedStatement.setString(1,id);
            preparedStatement.setString(2, abaccounts.getUsername());
            preparedStatement.setString(3, abaccounts.getPin());
            int addedRows = preparedStatement.executeUpdate();
            if (addedRows == 0){
                throw new RuntimeException("ERROR Added Rows is equal to 0 !");
            }
            ctdb.Disconnect();

            ctdb.Connect();
            sql = "INSERT INTO ab_balances (id,account_id,account_type,ammout) VALUES(?,?,?,?)";
            preparedStatement = ctdb.con.prepareStatement(sql);
            preparedStatement.setString(1, id);
            preparedStatement.setString(2, accountID);
            preparedStatement.setString(3, String.valueOf(accountType));
            preparedStatement.setInt(4, 0);
            addedRows = preparedStatement.executeUpdate();
            if (addedRows == 0){
                throw new RuntimeException("ERROR Added Rows is equal to 0 !");
            }
            abaccounts.setBalance(0);
            ctdb.Disconnect();

            new SuccessfullRegistrationController();
            SuccessfullRegistrationController urc;

            FXMLLoader loader = new FXMLLoader(getClass().getResource("SuccessfullRegistration.fxml"));
            Parent root = loader.load();

            urc = loader.getController();
            urc.displayName("new account " + username,"is still the same");
            Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        catch(SQLException sqe) {
            pseObject.printSQLException(sqe);
            throw new RuntimeException(sqe);
        }
    }

}
