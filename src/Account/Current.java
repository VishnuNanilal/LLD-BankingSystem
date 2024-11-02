package Account;

import User.*;

import java.time.Instant;

public class Current extends Account{
    public Current(Customer user, AccountType accountType, Instant createdDate, int maxTransactionNumbs, int transactionResetPeriod) {
        super(user, accountType, createdDate, maxTransactionNumbs, transactionResetPeriod);
    }
}
