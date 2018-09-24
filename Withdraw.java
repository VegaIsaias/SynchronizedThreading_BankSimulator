// Created by Isaias Perez Vega
// ---------------------------------------
// Sinchronized-cooperating multithreading
// simulates banking transactions

package com.BankSimulator;
import java.util.Random;

public class Withdraw implements Runnable {

    private static Random generator = new Random();
    private Transaction sharedLocation;

    public Withdraw(Transaction shared) {
        sharedLocation = shared;
    }

    public void run() {
        int balance = 0;
        int amount = 0;
        boolean run = true;

        while (run){
            try {
                Thread.currentThread().setName("W" + (Thread.currentThread().getId() - 17));
                Thread.sleep(generator.nextInt(500));
                amount = generator.nextInt(50) + 1;
                balance = sharedLocation.getBalance() - amount;

                if (balance >= 0) {
                    sharedLocation.set(balance);
                    sharedLocation.setBalance(balance);
                    if (amount > 9) {
                        System.out.println("\t\t\t\t\t\t " + "Thread " + Thread.currentThread().getName() + " withdraws $" + amount + "\t" + " Balance $" + sharedLocation.get());
                    } else {
                        System.out.println("\t\t\t\t\t\t " + "Thread " + Thread.currentThread().getName() + " withdraws $" + amount + "\t\t" + " Balance $" + sharedLocation.get());
                    }
                } else {
                    if (amount > 9) {
                        System.out.println("\t\t\t\t\t\t " + "Thread " + Thread.currentThread().getName() + " withdraws $" + amount + " Withdrawal - Blocked - Insufficient Funds");
                    } else {
                        System.out.println("\t\t\t\t\t\t " + "Thread " + Thread.currentThread().getName() + " withdraws $" + amount + "  Withdrawal - Blocked - Insufficient Funds");
                    }

                }


            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        }
    }

}
