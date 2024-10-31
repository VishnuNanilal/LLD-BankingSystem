package User;
import Account.*;
import java.util.Set;
import java.util.HashSet;

public class User {
    protected String name;
    protected String email;
    protected String password;
    protected int age;

    Set<Account> accounts;


    User(String name, String email, String password){
        this.name=name;
        this.email= email;
        this.password=password;
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
}
