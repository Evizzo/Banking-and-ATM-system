package com.example.demo;

public class ab_balances {
    private int credit_card_balance=1;
    private int debit_card_balance=2;
    private int savings_account_balance=3;

    public int getCredit_card_balance() {
        return credit_card_balance;
    }

    public void setCredit_card_balance(int credit_card_balance) {
        this.credit_card_balance = credit_card_balance;
    }

    public int getDebit_card_balance() {
        return debit_card_balance;
    }

    public void setDebit_card_balance(int debit_card_balance) {
        this.debit_card_balance = debit_card_balance;
    }

    public int getSavings_account_balance() {
        return savings_account_balance;
    }

    public void setSavings_account_balance(int savings_account_balance) {
        this.savings_account_balance = savings_account_balance;
    }
}
