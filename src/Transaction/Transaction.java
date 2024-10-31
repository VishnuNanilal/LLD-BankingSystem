package Transaction;

import Account.Account;

public class Transaction {
    TransactionType type;
    Account currAccount;
    Account otherAccount;
    float amount;
    Transaction(TransactionType type, Account currAccount, Account otherAccount, float amount){
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

    public float getAmount() {
        return amount;
    }
}
