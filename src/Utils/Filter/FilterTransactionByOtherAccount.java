package Utils.Filter;

import Transaction.Transaction;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class FilterTransactionByOtherAccount implements FilterTransaction{
    UUID otherAccountId;
    public FilterTransactionByOtherAccount(UUID otherAccountId){
        this.otherAccountId = otherAccountId;
    }
    @Override
    public List<Transaction> filter(List<Transaction> list) {
        return list.stream().filter(transaction -> transaction.getOtherAccount().getAccountId().equals(this.otherAccountId)).collect(Collectors.toList());
    }
}
