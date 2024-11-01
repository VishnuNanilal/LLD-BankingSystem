import Account.*;
import Account.AccountType;
import User.Customer;
import User.User;

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
    public boolean addAccountToCustomer(UUID customerId, User user, AccountType accountType, Instant createdDate, int maxTransactionNumbs, int transactionResetPeriod,
                                        float interestRate, boolean autoReinvest, int interestCompoundNumbs, int matureYearCount) {
        if(!checkCustomer(customerId))
            return false;

        Customer customer=customers.get(customerId);
        Account newAccount=null;
        switch(accountType) {
            case CURRENT:
                newAccount = new Current(user, accountType, createdDate, maxTransactionNumbs, transactionResetPeriod);
            case FIXED:
                newAccount = new Fixed(user, accountType, createdDate, maxTransactionNumbs, transactionResetPeriod, interestRate, autoReinvest, interestCompoundNumbs, matureYearCount);
            case SAVINGS:
                newAccount = new Savings(user, accountType, createdDate, maxTransactionNumbs, transactionResetPeriod, interestRate, autoReinvest);
        }
        return customer.addAccount(newAccount);
    }

    public boolean removeAccountFromCustomer(UUID customerId, UUID accountId){
        return customers.get(customerId).removeAccount(accountId);
    }


}

