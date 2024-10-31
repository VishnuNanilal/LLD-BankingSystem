package User;
import Account.Account;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
public class Customer extends User {
    Set<Account> accounts;

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
}
