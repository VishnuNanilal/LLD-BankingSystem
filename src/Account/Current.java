package Account;

import User.User;

import java.util.Date;

public class Current extends Account{
    Current(User user, AccountType accountType, Date createdDate, int maxTransactionNumbs, int transactionResetPeriod) {
        super(user, accountType, createdDate, maxTransactionNumbs, transactionResetPeriod);
    }
}
