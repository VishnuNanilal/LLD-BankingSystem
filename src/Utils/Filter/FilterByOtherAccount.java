package Utils.Filter;

import Account.Account;
import Transaction.Transaction;
import User.Customer;

import java.util.List;
import java.util.stream.Collectors;

public class FilterByOtherAccount implements FilterTransaction{
    Account otherAccount;
    FilterByOtherAccount(Transaction transaction){
        otherAccount=transaction.getOtherAccount();
    }
    @Override
    public List<Transaction> filter(List<Transaction> list) {
        return list.stream().filter(transaction -> transaction.getOtherAccount().equals(this.otherAccount)).collect(Collectors.toList());
    }
}
