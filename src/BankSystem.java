import Account.*;
import Account.AccountType;
import Transaction.*;
import User.Customer;
import User.User;
import Utils.Exception.TransactionException;

import java.time.Instant;
import java.util.*;
public class BankSystem {
    Map<UUID, Customer> customers = new HashMap<>();
    public boolean addCustomer(String name, String email, String password, int age){
        //need to implement password encryption
        if(name.length()<3 || !email.contains("@") || password.length()<5||age<15)
            throw new IllegalArgumentException("Illegal Argument");

        Customer newCustomer = new Customer(name, email, password, age);
        customers.put(newCustomer.getId(), newCustomer);
        return true;
    }

    public boolean removeCustomer(UUID id){
        if(!checkCustomer(id)){
            return false;
        }
        customers.remove(id);
        return true;
    }

    public boolean checkCustomer(UUID id){
        return customers.containsKey(id);
    }
    public boolean addAccountToCustomer(UUID customerId, AccountType accountType, Instant createdDate, int maxTransactionNumbs, int transactionResetPeriod,
                                        float interestRate, boolean autoReinvest, int interestCompoundNumbs, int matureYearCount) {
        if(!checkCustomer(customerId))
            return false;

        Customer customer=customers.get(customerId);
        Account newAccount=null;
        switch(accountType) {
            case CURRENT:
                newAccount = new Current(customer, accountType, createdDate, maxTransactionNumbs, transactionResetPeriod);
            case FIXED:
                newAccount = new Fixed(customer, accountType, createdDate, maxTransactionNumbs, transactionResetPeriod, interestRate, autoReinvest, interestCompoundNumbs, matureYearCount);
            case SAVINGS:
                newAccount = new Savings(customer, accountType, createdDate, maxTransactionNumbs, transactionResetPeriod, interestRate, autoReinvest);
        }
        return customer.addAccount(newAccount);
    }

    public boolean removeAccountFromCustomer(UUID customerId, UUID accountId){
        return customers.get(customerId).removeAccount(accountId);
    }

    public boolean makeTransaction(double amount, Account senderAccount, Account receiverAccount){
        try {
            if (amount < 0) {
                throw new TransactionException("Amount cannot be zero");
            }
            boolean success = senderAccount.withdraw(amount);
            if (!success)
                return false;
            success = receiverAccount.deposit(amount);
            if (!success) {
                senderAccount.deposit(amount);
                return false;
            }
            Customer sender = senderAccount.getUser();
            sender.addTransaction(new Transaction(TransactionType.DEBIT, senderAccount, receiverAccount, amount));
            Customer receiver = senderAccount.getUser();
            receiver.addTransaction(new Transaction(TransactionType.CREDIT, receiverAccount, senderAccount, amount));
            return true;
        }
        catch(TransactionException te){
            te.printStackTrace();
            return false;
        }
    }

    public List<Transaction> filterTransactionByAmount(Customer customer, double amount){
        return customer.filterTransactionByAmount(amount);
    }
    public List<Transaction> filterTransactionByOtherAccount(Customer customer, Account otherAccount){
        return customer.filterTransactionByOtherAccount(otherAccount);
    }
}