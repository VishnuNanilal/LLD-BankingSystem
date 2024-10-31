package Account;

import java.util.Date;

public class Fixed extends InterestAccount{
    private int interestCompoundNumbs;
    private int matureYearCount;
    Fixed(AccountType accountType,
          Date createdDate,
          int maxTransactionNumbs,
          int transactionResetPeriod,
          float interestRate,
          boolean autoReinvest,
          int interestCompoundNumbs,
          int matureYearCount){
        super(accountType, createdDate, maxTransactionNumbs, transactionResetPeriod, interestRate, autoReinvest);
        this.interestCompoundNumbs=interestCompoundNumbs;
        this.matureYearCount=matureYearCount;
    }

    @Override
    public void interestAddition() {
        double interest = balance*Math.pow(1+(annualInterestRate/interestCompoundNumbs), interestCompoundNumbs*matureYearCount);
        if(autoReinvest){
            balance+=interest;
        }
        else{
            interestAmount+=interest;
        }
    }

    public void addInterestToPrinciple(){
        balance+=interestAmount;
    }
}
