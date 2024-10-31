package Utils;
import Transaction.Transaction;
public class Fax implements INotification{
    @Override
    public boolean sendNotification(Transaction transaction) {
        //implement external API call to send Fax
        return true;
    }
}
