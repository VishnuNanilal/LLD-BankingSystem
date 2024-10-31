package Account;

import java.util.Date;

public class Current extends Account{
    Current(AccountType accountType,Date createdDate, int maxTransactionNumbs, int transactionResetPeriod) {
        super(accountType, createdDate, maxTransactionNumbs, transactionResetPeriod);
    }
}
