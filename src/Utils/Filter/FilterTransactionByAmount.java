package Utils.Filter;

import Transaction.Transaction;

import java.util.List;
import java.util.stream.Collectors;

public class FilterTransactionByAmount implements FilterTransaction{
    float lowerLimit, upperLimit;
    FilterTransactionByAmount(float amount){
        this.lowerLimit=amount;
        this.upperLimit=amount;
    }
    FilterTransactionByAmount(float lowerLimit, float upperLimit){
        this.lowerLimit= lowerLimit;
        this.upperLimit=upperLimit;
    }
    @Override
    public List<Transaction> filter(List<Transaction> list) {
        return list.stream().filter(transaction -> transaction.getAmount()>=lowerLimit && transaction.getAmount()<=upperLimit).collect(Collectors.toList());
    }
}
