import Account.*;
import User.Customer;

import java.util.UUID;
import java.time.Instant;

public class Main {
    public static void main(String[] args) {
        Customer c1 = new Customer("VISHNU N P", "vishnunlal@gmail.com", "pass1", 28);
        Customer c2 = new Customer("PARVATHY N P", "parvathynlal@gmail.com", "pass2", 26);
        Savings savings1 = new Savings(c1, AccountType.SAVINGS, Instant.now(), 3, 30, .02f, true);
        Savings savings2 = new Savings(c1, AccountType.SAVINGS, Instant.now(), 10, 30, .02f, true);
        Savings savings3 = new Savings(c1, AccountType.SAVINGS, Instant.now(), 20, 30, .02f, true);
        UUID accountId1 = savings1.getAccountId();
        UUID accountId2 = savings2.getAccountId();
        UUID accountId3 = savings3.getAccountId();

        c1.addAccount(savings1);
        c1.addAccount(savings2);
        c1.addAccount(savings3);

        Account a1 = c1.getAccountById(savings2.getAccountId());
        System.out.println(">>>"+a1.toString());
//        Account acc = c1.getAccountById(accountId1);
//        if(acc!=null) {
//            System.out.print(acc.getUser().getName()+"---"+acc.getUser().getEmail()+"---"+acc.getUser().getAge());
//        }
    }
}