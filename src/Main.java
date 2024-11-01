import Account.*;
import User.Customer;

import java.rmi.server.UID;
import java.time.Instant;

public class Main {
    public static void main(String[] args) {
        Customer c1 = new Customer("VISHNU N P", "vishnunlal@gmail.com", "pass1");
        Customer c2 = new Customer("PARVATHY N P", "parvathynlal@gmail.com", "pass2");
        Savings savings = new Savings(c1, AccountType.SAVINGS, Instant.now(), 3, 30, .02f, true);
        UID accountId = savings.getAccountId();
        c1.addAccount(savings);
//        c1.removeAccount(savings);
        Account acc = c1.getAccountById(accountId);
        if(acc!=null) {
            System.out.print(acc.getUser().getName()+"---"+acc.getUser().getEmail()+"---"+acc.getUser().getAge());
        }
    }
}