package User;
import Account.Account;
import Transaction.*;
import Utils.*;
import Utils.SMS;

import java.util.*;

public class Customer extends User {
    Set<Account> accounts;
    Queue<Transaction> transactions = new LinkedList<>();
    Set<INotification> notificationModes = new HashSet<>();
    Customer(String name, String email, String password) {
        super(name, email, password);
        accounts=new HashSet<Account>();
    }
    public void addAccount(Account account){
        //TODO data check
        accounts.add(account);
    }
    public void removeAccount(Account account){
        //TODO data check
        accounts.remove(account);
    }

    public List<Account> getAccounts(){
        return new ArrayList<Account>(accounts);
    }

    public void addTransaction(Transaction transaction){
        if(transactions.size()==25){
            transactions.remove();
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
}
