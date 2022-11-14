package com.example.demo;
import com.example.demo.services.AdminServices;

import java.util.Scanner;
public class Main{
    // todo ubaci BTC u background.
    public static void main(String[] args) {
        while (true) {
            Scanner myObj = new Scanner(System.in);
            System.out.println("---");
            System.out.println("1. Show list of users.");
            System.out.println("2. Choose number of transactions.");
            System.out.println("0. Exit.");
            System.out.println("---");

            int choice = myObj.nextInt();

            if(choice == 0) break;

            if (choice == 1) {
                AdminServices as = new AdminServices(0);
                System.out.println(as.getAllUsers());
            } else if (choice == 2) {
                System.out.println("Set number of transactions: ");
                int numberOfTransactions = myObj.nextInt();
                for (int i = 0; i < numberOfTransactions; i++) {
                    // todo kreira se jedan servise, a ne više njih.
                    // todo ne startuju se SVI threadovi odjednom, nego koristiti pool
                    AdminServices as = new AdminServices(i);
                    as.start();
                }
            }
        }
    }
}