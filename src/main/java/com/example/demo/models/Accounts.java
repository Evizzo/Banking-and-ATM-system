package com.example.demo.models;

public class Accounts {
    private String username;
    private String pin;
    private int balance;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
