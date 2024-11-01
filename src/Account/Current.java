package Account;

import User.User;

import java.time.Instant;

public class Current extends Account{
    public Current(User user, AccountType accountType, Instant createdDate, int maxTransactionNumbs, int transactionResetPeriod) {
        super(user, accountType, createdDate, maxTransactionNumbs, transactionResetPeriod);
    }
}
