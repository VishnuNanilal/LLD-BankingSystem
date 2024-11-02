package Transaction;

import Account.Account;

public class Transaction {
    TransactionType type;
    Account currAccount;
    Account otherAccount;
    double amount;
    public Transaction(TransactionType type, Account currAccount, Account otherAccount, double amount){
        this.type=type;
        this.currAccount=currAccount;
        this.otherAccount=otherAccount;
        this.amount=amount;
    }

    public TransactionType getType() {
        return type;
    }

    public Account getCurrAccount() {
        return currAccount;
    }

    public Account getOtherAccount() {
        return otherAccount;
    }

    public double getAmount() {
        return amount;
    }
}
