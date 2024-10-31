package Account;

import User.User;
import java.rmi.server.UID;
import java.util.Date;

public abstract class Account {
        UID accountId;
        protected User user;
        protected AccountType accountType;
//    private Customer customer;
        protected final Date createdDate;
        protected double balance;
        protected int maxTransactionNumbs;
        protected int transactionResetPeriod;

    public Account(User user, AccountType accountType, Date createdDate, int maxTransactionNumbs, int transactionResetPeriod) {
        this.accountId=new UID();
        this.user=user;
        this.accountType=accountType;
        this.createdDate=createdDate;
        this.maxTransactionNumbs=maxTransactionNumbs;
        this.transactionResetPeriod=transactionResetPeriod;
        this.balance=0;
    }

    public User getUser() {
        return user;
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

    public synchronized boolean deposit(double amount){
            if(amount<0)
                return false;

            balance+=amount;
            return true;
        }

    public synchronized boolean withdraw(double amount){
        if(amount<0)
            return false;

        balance-=amount;
        return true;
    }

    public synchronized boolean transfer(double amount, Account otherAccount){
            boolean success = this.withdraw(amount);
            if(!success)
                return false;
            success = otherAccount.deposit(amount);
            if(!success)
            {
                this.deposit(amount);
                return false;
            }
            return true;
        }

    public double checkBalance(){
            return balance;
    }
}
