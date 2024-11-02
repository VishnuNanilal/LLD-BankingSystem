package Account;

import User.Customer;
import Utils.Exception.TransactionException;

import java.time.Instant;
import java.util.UUID;

public abstract class Account {
        UUID accountId;
        protected Customer user;
        protected AccountType accountType;
//    private Customer customer;
        protected final Instant createdDate;
        protected double balance;
        protected int maxTransactionNumbs;
        protected int transactionResetPeriod;

    public Account(Customer user, AccountType accountType, Instant createdDate, int maxTransactionNumbs, int transactionResetPeriod) {
        this.accountId= UUID.randomUUID();
        this.user=user;
        this.accountType=accountType;
        this.createdDate=createdDate;
        this.maxTransactionNumbs=maxTransactionNumbs;
        this.transactionResetPeriod=transactionResetPeriod;
        this.balance=0;
    }

    public Customer getUser() {
        return user;
    }

    public UUID getAccountId() {
        return accountId;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public int getMaxTransactionNumbs() {
        return maxTransactionNumbs;
    }
    public int getTransactionResetPeriod() {
        return transactionResetPeriod;
    }

    public synchronized boolean deposit(double amount) {
        try {
            if (amount < 0) {
                throw new IllegalArgumentException("Argument cannot be zero");
            }

            balance += amount;
            return true;
        } catch (IllegalArgumentException iae) {
            iae.printStackTrace();
            return false;
        }
    }

    public synchronized boolean withdraw(double amount){
        try {
            if (amount < 0){
                throw new TransactionException("Insufficient funds");
            }

            balance -= amount;
            return true;
        }
        catch(TransactionException te){
            te.printStackTrace();
            return false;
        }
    }

    public double checkBalance(){
            return balance;
    }
    public String toString(){
        return "Account type: "+accountType+" held by user: "+user.getName()+" created on: "+createdDate;
    }
}
