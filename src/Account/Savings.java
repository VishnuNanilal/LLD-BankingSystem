package Account;

import User.User;

import java.util.Date;

public class Savings extends InterestAccount{
    private double dailyInterestSum=0;
    Savings(User user, AccountType accountType, Date createdDate, int maxTransactionNumbs, int transactionResetPeriod, float interestRate, boolean autoReinvest) {
        super(user, accountType, createdDate, maxTransactionNumbs, transactionResetPeriod, interestRate, autoReinvest);
    }

    public void interestDailyCalculation(){
        dailyInterestSum += (balance*(annualInterestRate/365));
    }
    public void interestAddition(){
        if(autoReinvest){
            balance+=dailyInterestSum;
        }
        else{
            interestAmount+=dailyInterestSum;
        }
        dailyInterestSum=0;
    }
    public void addInterestToPrinciple(){
        balance+=interestAmount;
    }
}
