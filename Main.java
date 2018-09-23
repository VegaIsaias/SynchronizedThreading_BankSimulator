//  Created by Isaias Perez Vega
//  ============================
//  Banking Simulator

package com.BankSimulator;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Main {

    public static void main(String[] args) {

        ExecutorService application = Executors.newFixedThreadPool(10);

        //ExecutorService dep = Executors.newFixedThreadPool(4);
        //ExecutorService with = Executors.newFixedThreadPool(6);

        Transaction accountBalance = new SyncTransaction();

        System.out.printf("Deposit Threads \t Withdrawal Threads \t\t Balance\n");
        System.out.printf("--------------- \t ------------------ \t\t -----------\n");

        try {
            //dep.execute(new Deposit(accountBalance));
            //with.execute(new Withdraw(accountBalance));
            application.execute(new Deposit(accountBalance));
            application.execute(new Withdraw(accountBalance));


        } catch (Exception e) {
            e.printStackTrace();
        }
        application.shutdown();
        //dep.shutdown();
        //with.shutdown();
    }
}
