package Account;

import java.util.Date;

public abstract class InterestAccount extends Account {
    protected double interestAmount;
    protected float annualInterestRate;
    protected boolean autoReinvest;

    InterestAccount(AccountType accountType, Date createdDate, int maxTransactionNumbs, int transactionResetPeriod, float annualInterestRate, boolean autoReinvest){
        super(accountType, createdDate, maxTransactionNumbs, transactionResetPeriod);
        this.annualInterestRate=annualInterestRate;
        this.autoReinvest=autoReinvest;
    }
    public abstract void interestAddition();
    public abstract void addInterestToPrinciple();
}
