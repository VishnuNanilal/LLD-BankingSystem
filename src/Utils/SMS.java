package Utils;
import Account.Account;
import Transaction.Transaction;
import Transaction.TransactionType;
public class SMS implements INotification{
    @Override
    public boolean sendNotification(Transaction transaction) {
        String currAccName=transaction.getCurrAccount().getUser().getName();
        String otherAccName=transaction.getOtherAccount().getUser().getName();
        float amt = transaction.getAmount();
        //implement external API call to send SMS
        if(transaction.getType()== TransactionType.CREDIT)
            System.out.println(currAccName+ " was credited by "+amt+" from "+otherAccName);
        else
            System.out.println(currAccName+ " was debited by "+amt+" from "+otherAccName);

        return true;
    }
}
