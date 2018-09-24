
// Created by Isaias Perez Vega
// ---------------------------------------
// Sinchronized-cooperating multithreading
// simulates banking transactions


package com.BankSimulator;
import java.util.Random;

public class Deposit implements Runnable{

    private static Random generator = new Random();
    private Transaction sharedLocation;

    // constructor
    public Deposit( Transaction shared )
    {
        sharedLocation = shared;
    }


    public void run() {
        int balance = 0;
        int amount = 0;
        boolean run = true;

        while (run) {
            try {
                Thread.currentThread().setName("D" + (Thread.currentThread().getId() - 13));
                Thread.sleep(generator.nextInt(2000));
                amount = generator.nextInt(200) + 1;
                balance = sharedLocation.getBalance() + amount;
                sharedLocation.set(balance);
                sharedLocation.setBalance(balance);

                System.out.println("Thread " + Thread.currentThread().getName() + " deposits $" + amount + "\t\t\t\t\t\t\t\t " + "Balance is $" + sharedLocation.get());

            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        }

    }
}
