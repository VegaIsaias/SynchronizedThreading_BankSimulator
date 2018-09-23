// Created by Isaias Perez Vega
// ---------------------------------------
// Sinchronized-cooperating multithreading
// simulates banking transactions

package com.BankSimulator;
import java.util.concurrent.locks.*;


public class SyncTransaction implements Transaction {

    // Creating object access lock
    private Lock accessLock = new ReentrantLock();


    // Tread process control conditions for transactions
    private Condition canWrite = accessLock.newCondition();
    private Condition canRead = accessLock.newCondition();
    private boolean occupied = false;

    // synchronized-cooperating buffer
    private int buffer = 0;
    public int balance = 0;


    public void set(int value){

        // Exclude access to object for only this thread
        accessLock.lock();

        try {

            // The buffer is full
            while (occupied) {
                //System.out.println("Producer Tries to write");
                canWrite.await();

            }

            // Set new value and signal a read thread
            buffer = value;
            occupied = true;
            canRead.signal();

        } catch (InterruptedException exception) {
            exception.printStackTrace();

        } finally {
            accessLock.unlock();
        }
    }


    public int get(){

        // Obtaining access lock
        int readValue = 0;
        accessLock.lock();


        try {

            // The buffer is empty, can't read until it is full
            while (!occupied) {

                //System.out.println("Consumer Tries to Read" );
                canRead.await();
            }

            // Get buffer value and signal write, buffer empty
            occupied = false;
            readValue = buffer;
            canWrite.signal();

        } catch (InterruptedException exception) {
            exception.printStackTrace();
        } finally {
            accessLock.unlock();
        }

        return readValue;
    }



    public int getBalance() {
        return this.balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
