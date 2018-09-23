// Created by Isaias Perez Vega
// ---------------------------------------
// Sinchronized-cooperating multithreading
// simulates banking transactions

package com.BankSimulator;


// *------------------------------------------* //
// Transaction interface specifies methods      //
// invoked by the Depost and Withdraw requests. //
public interface Transaction {

    public void set(int amount);
    public int get();

    public int getBalance();
    public void setBalance(int balance);

}
