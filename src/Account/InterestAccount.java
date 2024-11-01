package Account;

import User.User;

import java.time.Instant;
import java.util.Date;

public abstract class InterestAccount extends Account {
    protected double interestAmount;
    protected float annualInterestRate;
    protected boolean autoReinvest;

    InterestAccount(User user, AccountType accountType, Instant createdDate, int maxTransactionNumbs, int transactionResetPeriod, float annualInterestRate, boolean autoReinvest){
        super(user, accountType, createdDate, maxTransactionNumbs, transactionResetPeriod);
        this.annualInterestRate=annualInterestRate;
        this.autoReinvest=autoReinvest;
    }
    public abstract void interestAddition();
    public abstract void addInterestToPrinciple();
}
