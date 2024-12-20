package User;
import Account.Account;
import Transaction.*;
import Utils.*;
import Utils.Filter.FilterTransactionByOtherAccount;
import Utils.Filter.FilterTransactionByAmount;
import Utils.SMS;

import java.util.*;

public class Customer extends User {
    Map<UUID, Account> accounts;
    Queue<Transaction> transactions;
    Set<INotification> notificationModes;
    public Customer(String name, String email, String password, int age) {
        super(name, email, password, age);
        accounts=new HashMap<UUID, Account>();
        transactions = new LinkedList<Transaction>();
        notificationModes = new HashSet<>();
        addDefaultNotificationModes();
    }

    private void addDefaultNotificationModes(){
        notificationModes.add(new SMS());
        notificationModes.add(new Email());
    }
    public boolean addAccount(Account account){
        if(checkAccountExists(account.getAccountId())){
            System.out.println("Customer already contains account");
            return false;
        }
        accounts.put(account.getAccountId(), account);
        return true;
    }
    public boolean removeAccount(UUID accountId){
        if(!checkAccountExists(accountId)){
            System.out.println("Customer doesn't contain account");
            return false;
        }
        accounts.remove(accountId);
        return true;
    }

    public List<Account> getAccounts(){
        List<Account> ans = new ArrayList<Account>();
        for(UUID id: accounts.keySet())
            ans.add(accounts.get(id));
        return ans;
    }

    public boolean checkAccountExists(UUID accountId){
        return accounts.containsKey(accountId);
    }
    public Account getAccountById(UUID id){
        if(!accounts.containsKey(id)){
            System.err.println("Customer doesn't contain Account");
            return null;
        }
        System.out.println("Account found, fetching...");
        return accounts.get(id);
    }

    public void addTransaction(Transaction transaction){
        if(transactions.size()==25){
            transactions.remove(); //dequeue from transactions
        }
        transactions.add(transaction);
    }

    public List<Transaction> getTransactionHistory(){
        return new ArrayList<Transaction>(transactions);
    }

    public boolean sendNotifications(Transaction transaction){
        for(INotification notificationMode: notificationModes){
            if(!notificationMode.sendNotification(transaction))
                return false;
        }
        return true;
    }

    public boolean addNotificationMode(NotificationType type){
        if(type==NotificationType.SMS){
            return notificationModes.add(new SMS());
        }
        else if(type==NotificationType.Email){
            return notificationModes.add(new Email());
        }
        else if(type==NotificationType.Fax){
            return notificationModes.add(new Fax());
        }
        return false;
    }
    public boolean removeNotificationMode(NotificationType type){
        if(type==NotificationType.SMS){
            return notificationModes.remove(new SMS());
        }
        else if(type==NotificationType.Email){
            return notificationModes.remove(new Email());
        }
        else if(type==NotificationType.Fax){
            return notificationModes.remove(new Fax());
        }
        return false;
    }

    public List<Transaction> filterTransactionByAmount(double amount){
        FilterTransactionByAmount filter = new FilterTransactionByAmount(amount);
        return filter.filter(new ArrayList<Transaction>(transactions));
    }

    public List<Transaction> filterTransactionByOtherAccount(Account otherAccount){
        FilterTransactionByOtherAccount filter = new FilterTransactionByOtherAccount(otherAccount.getAccountId());
        return filter.filter(new ArrayList<Transaction>(transactions));
    }
}
