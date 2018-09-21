package com.BankSimulator;


// *------------------------------------------* //
// Transaction interface specifies methods      //
// invoked by the Depost and Withdraw requests. //
public interface Transaction {

    public void deposit(double amount);
    public void withdraw(double amount);

}
