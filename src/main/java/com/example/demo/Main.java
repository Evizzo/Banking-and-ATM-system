package com.example.demo;
import com.example.demo.services.AdminServices;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);

        System.out.println("1. Show list of users.");
        System.out.println("2. Choose number of transactions.");

        int choice = myObj.nextInt();

        if (choice == 1){
            AdminServices as = new AdminServices();

            System.out.println(as.showAllUsers());
        }
    }
}