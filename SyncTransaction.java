//  Created by Isaias Perez Vega
//  ============================
//  Banking Simulator

package com.BankSimulator;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;


public class SyncTransaction implements Transaction {

    // Creating object access lock
    private Lock accessLock = new ReentrantLock();


    // Tread process control for transactions
    private Condition canWrite = accessLock.newCondition();
    private Condition canRead = accessLock.newCondition();
    private boolean occupied = false;

    // Initial balance value
    private int buffer = -1;
    public int balance = 0;
    int counter = 0;

    // *--------------------------* //
    //
    public void set(int value){

        // Exclude access to object for only this thread
        accessLock.lock();

        try {
            while (occupied) {
                System.out.println("Producer Tries to write");
                System.out.println("Counter: " + counter + " Thread: " + Thread.currentThread().getId());
                canWrite.await();
            }


            buffer = value;
            //( "Producer writes " + buffer );
            occupied = true;
            canRead.signal();
            //canRead.signalAll();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        } finally {
            accessLock.unlock();
        }
    }



    // *--------------------------* //
    //
    public int get(){

        int readValue = 0;
        accessLock.lock();


        try {

            while (!occupied) {
                counter = counter + 1;
                System.out.println("Counter: " + counter + " Thread: " + Thread.currentThread().getId());
                System.out.println("Consumer Tries to Read" );
                //displayState( "Buffer empty. Consumer waits." );
                canRead.await();

            }
            System.out.println("Made it outside of the While loop");
            occupied = false;
            readValue = buffer;
            //displayState("Consumer reads " + readValue);
            canWrite.signal();
            //canWrite.signalAll();

        } catch (InterruptedException exception) {
            exception.printStackTrace();
        } finally {
            accessLock.unlock();
        }

        return readValue;
    }


    // display current operation and buffer state
    public void displayState( String operation )
    {
        System.out.printf( "%-40s%d\t\t\t\t%b\n", operation, buffer,
                occupied );
    } // end method displayState

}
