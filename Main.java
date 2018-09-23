// Created by Isaias Perez Vega
// ---------------------------------------
// Sinchronized-cooperating multithreading
// simulates banking transactions

package com.BankSimulator;


public class Main {

    public static void main(String[] args) {

        // Synchronized transaction
        Transaction accountBalance = new SyncTransaction();

        System.out.printf("Deposit Threads    \t\t Withdrawal Threads \t\t Balance\n");
        System.out.printf("------------------ \t\t ------------------ \t\t ------------------\n");

        // Creating 4 threads dedicated for deposits
        for (int i = 1; i < 5; i++) {
            Deposit dep = new Deposit(accountBalance);
            Thread t = new Thread(dep);
            t.start();
        }

        // Creating 6 threads dedicated for withdrawals
        for (int i = 1; i < 7; i++) {
            Withdraw with = new Withdraw(accountBalance);
            Thread t = new Thread(with);
            t.start();
        }

    }
}
