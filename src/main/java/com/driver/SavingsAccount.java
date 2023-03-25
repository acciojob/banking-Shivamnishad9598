package com.driver;

public class SavingsAccount extends BankAccount{
    private final double rate;
  private final double maxWithdrawalLimit;

    public SavingsAccount(String name, double balance, double maxWithdrawalLimit, double rate) {
        // minimum balance is 0 by default
        super(name, balance,0);
        this.maxWithdrawalLimit =maxWithdrawalLimit;
        this.rate = rate;
    }
   @Override
    public void withdraw(double amount) throws Exception {
        // Might throw the following errors:
        // 1. "Maximum Withdraw Limit Exceed" : If the amount exceeds maximum withdrawal limit
        // 2. "Insufficient Balance" : If the amount exceeds balance
         if(amount <= maxWithdrawalLimit){
             super.withdraw(amount);
         } else{
             throw  new Exception("Maximum Withdraw Limit Exceeded");

         }
    }

    public double getSimpleInterest(int years){
        // Return the final amount considering that bank gives simple interest on current amount
          return getBalance() * (1 + rate * years /100);
    }


    public double getCompoundInterest(int timesPerYear, int years){
        // Return the final amount considering that bank gives compound interest on current amount given times per year
         return getBalance() * Math.pow(1+ rate/ (100 * timesPerYear) , timesPerYear * years);
    }
    public double getRate(){
        return rate;
    }

    public  double getMaxWithdrawalLimit(){
        return getMaxWithdrawalLimit();
    }

}
