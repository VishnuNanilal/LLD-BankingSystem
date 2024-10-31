package Utils;
import Transaction.Transaction;

public class Email implements INotification{
    @Override
    public boolean sendNotification(Transaction transaction) {
        //implement external API call to send Email
        return true;
    }
}
