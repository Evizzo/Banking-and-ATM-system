package com.example.demo.services;

import com.example.demo.AppException;
import com.example.demo.database.ConnectToDatabase;
import com.example.demo.database.PrintSqlException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

// todo Servis nikada nije thread!
// todo Sav rad za konekcijama (ctdb) mora da bude u TRANSAKCIJI. Pogledaj transakcije za baze.
public class AdminServices extends Thread{
    private final ConnectToDatabase ctdb = new ConnectToDatabase();
    private final PrintSqlException pseObject = new PrintSqlException();
    int threadNUmber;
    public AdminServices(int threadNUmber){
        this.threadNUmber = threadNUmber;
    }

    public ArrayList<String> getAllUsers(){
        try {
            ctdb.Connect();
            String sql = "SELECT name FROM ab_accounts";
            PreparedStatement preparedStatement = ctdb.con.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            ArrayList<String> names = new ArrayList<String>();
            while (rs.next()) {
                names.add(rs.getString("name"));
            }
            ctdb.Disconnect();
            return names;
        } catch (SQLException sqe) {
            pseObject.printSQLException(sqe);
            throw new AppException(sqe);
        }
    }
    public ArrayList<String> getAllUUID(){
        try {
            ctdb.Connect();
            String sql = "SELECT id FROM ab_accounts";
            PreparedStatement preparedStatement = ctdb.con.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            ArrayList<String> uuids = new ArrayList<String>();
            while (rs.next()) {
                uuids.add(rs.getString("id"));
            }
            ctdb.Disconnect();
            return uuids;
        } catch (SQLException sqe) {
            pseObject.printSQLException(sqe);
            throw new AppException(sqe);
        }
    }
    public ArrayList<String> getAccountTypes(String uuid){
        ArrayList<String> accountTypes = new ArrayList<String>();
        try {
            ctdb.Connect();
            String sql = "SELECT account_id FROM ab_balances WHERE id=?";
            PreparedStatement preparedStatement = ctdb.con.prepareStatement(sql);
            preparedStatement.setString(1, uuid);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                accountTypes.add(rs.getString("account_id"));
            }
            ctdb.Disconnect();
            return accountTypes;
        } catch (SQLException sqe) {
            pseObject.printSQLException(sqe);
            throw new AppException(sqe);
        }
    }
    public void randomTransactions(String firstUuid, String secondUuid, String firstAccountType, String secondAccountType){
        final BalanceServices bs = new BalanceServices();
        final Random rand = new Random();

        // todo najvise paznje ovde u vezi transakcija.
        if (bs.balanceCheck(firstAccountType, firstUuid) > bs.balanceCheck(secondAccountType, secondUuid)){
            // todo ovo su sve potencijalne nove metode
            int randomNumber = rand.nextInt(bs.balanceCheck(firstAccountType, firstUuid));
            bs.withdrawBalance(bs.balanceCheck(firstAccountType, firstUuid), randomNumber, firstAccountType, firstUuid);

            bs.depositBalance(bs.balanceCheck(secondAccountType, secondUuid), randomNumber, secondAccountType, secondUuid);

        }
        else{
            // todo gledaj da nemas if/else jer se sve ponavalja, vec samo jedan blok.
            int randomNumber = rand.nextInt(bs.balanceCheck(secondAccountType, secondUuid));
            bs.withdrawBalance(bs.balanceCheck(secondAccountType, secondUuid), randomNumber, secondAccountType, secondUuid);

            bs.depositBalance(bs.balanceCheck(firstAccountType, firstUuid), randomNumber, firstAccountType, firstUuid);

        }

    }
    @Override
    public void run(){
        final Random rand = new Random();
        // todo ovde kreiras 3 nepotrebne liste
        ArrayList<String> shuffledUUIDs = new ArrayList<String>();
        shuffledUUIDs = getAllUUID();
        Collections.shuffle(shuffledUUIDs);

        ArrayList<String> accountTypesOfFirstUser = new ArrayList<String>();
        ArrayList<String> accountTypesOfSecondUser = new ArrayList<String>();

        String randomUuidOfFirstUser = shuffledUUIDs.get(rand.nextInt(shuffledUUIDs.size()));
        accountTypesOfFirstUser = getAccountTypes(randomUuidOfFirstUser);

        String randomUuidOfSecondUser = shuffledUUIDs.get(rand.nextInt(shuffledUUIDs.size()));
        accountTypesOfSecondUser = getAccountTypes(randomUuidOfSecondUser);

        String randomAccountTypesOfFirstUserr = accountTypesOfFirstUser.get(rand.nextInt(accountTypesOfFirstUser.size()));

        String randomAccountTypesOfSecondUser = accountTypesOfSecondUser.get(rand.nextInt(accountTypesOfSecondUser.size()));

        System.out.println(accountTypesOfFirstUser + randomUuidOfFirstUser + "   FROM THREAD: " + threadNUmber);
        System.out.println(accountTypesOfSecondUser + randomUuidOfSecondUser + "   FROM THREAD: " + threadNUmber);

        randomTransactions(randomUuidOfFirstUser,randomUuidOfSecondUser,randomAccountTypesOfFirstUserr,randomAccountTypesOfSecondUser);
    }

}
