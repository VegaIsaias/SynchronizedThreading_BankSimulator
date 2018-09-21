//  Created by Isaias Perez Vega
//  ============================
//  Banking Simulator

package com.BankSimulator;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;


public class SyncTransaction implements Transaction {

    // Creating object access lock
    private Lock accessLock = new ReentrantLock(false);


    // Tread process control for transactions
    private Condition canDeposit = accessLock.newCondition();
    private Condition canWithdraw = accessLock.newCondition();
    private boolean occupied = false;

    // Initial balance value
    private int balance = -1;


    // *--------------------------* //
    //
    public void deposit(double amount){

        // Exclude access to object for only this thread
        accessLock.lock();

        try {
            while (occupied) {

            }
        } catch () {

        } finally {

        }
    }



    // *--------------------------* //
    //
    public void withdraw(double amount){

    }

}
