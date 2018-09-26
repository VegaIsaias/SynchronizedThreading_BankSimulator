# Bank Simulatior

Program simulates the transactions made to a single fictitious bank account. During the simulation random deposts and withrawals will be generated. In this case the deposits and withdrawals will be made by synchronized threads. 

## Synchronized Threading

Synchronizaton is required for two reasons:

1. Mutual Exlcusion (Updates cannot be lost)
2. A withdrawal cannot occur if there are incufficient funds in the account.

All threads have the same priority.

Synchronized-cooperation is handled by using Locks and Conditions. 

This means that access to the account (shared object) must be synchronized. This application required cooperation and communication amongst the various threads (cooperating synchronized threads). 

## Multithreading

The program uses 4 threads for deposts and 6 threads for withdraw requests.

## Transactions

**Deposits**

Each deposts will range between $1 to $200

Each depost thread is put to sleep for some random milliseconds to allow other threads to execute.
The goal is to have the withdrawal requests blocked because of insufficient funds. 

**Withdrawals**

Each withdraw request will range between $1 to $50

## Sample Output


```
Deposit Threads    		 Withdrawal Threads 		 Balance
------------------ 		 ------------------ 		 ------------------
				Thread W4 withdraws $2  Withdrawal - Blocked - Insufficient Funds
				Thread W3 withdraws $12 Withdrawal - Blocked - Insufficient Funds
				Thread W1 withdraws $47 Withdrawal - Blocked - Insufficient Funds
				Thread W3 withdraws $2  Withdrawal - Blocked - Insufficient Funds
				Thread W3 withdraws $35 Withdrawal - Blocked - Insufficient Funds
				Thread W6 withdraws $33 Withdrawal - Blocked - Insufficient Funds
				Thread W2 withdraws $14 Withdrawal - Blocked - Insufficient Funds
Thread D3 deposits $50						Balance is $50
				Thread W5 withdraws $12	        Balance $38
				Thread W1 withdraws $48 Withdrawal - Blocked - Insufficient Funds
Thread D1 deposits $87						Balance is $125
				Thread W4 withdraws $24	        Balance $101
				Thread W1 withdraws $2		      Balance $99
				Thread W2 withdraws $49	        Balance $50
				Thread W3 withdraws $6		      Balance $44
				Thread W6 withdraws $22	        Balance $22
				Thread W5 withdraws $34 Withdrawal - Blocked - Insufficient Funds
				Thread W4 withdraws $5		      Balance $17
				Thread W2 withdraws $29 Withdrawal - Blocked - Insufficient Funds
				Thread W3 withdraws $32 Withdrawal - Blocked - Insufficient Funds
				Thread W6 withdraws $44 Withdrawal - Blocked - Insufficient Funds
				Thread W2 withdraws $38 Withdrawal - Blocked - Insufficient Funds
				Thread W1 withdraws $43 Withdrawal - Blocked - Insufficient Funds
Thread D1 deposits $142						Balance is $159
				Thread W3 withdraws $11	        Balance $148
Thread D4 deposits $154						Balance is $302
				Thread W2 withdraws $46	        Balance $256
				Thread W5 withdraws $33	        Balance $223
Thread D3 deposits $177						Balance is $400
Thread D2 deposits $81						Balance is $481
				Thread W3 withdraws $18	        Balance $463
				Thread W1 withdraws $31	        Balance $432
				Thread W4 withdraws $31	        Balance $401

```

