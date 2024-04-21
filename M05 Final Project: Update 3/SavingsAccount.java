public class SavingsAccount extends BankAccount {
    private double minimumBalance;
    private double interestEarned;

    public SavingsAccount(String accountNumber, String accountHolderName, String accountType, double interestRate, double minimumBalance) {
        super(accountNumber, accountHolderName, accountType, interestRate);
        this.minimumBalance = minimumBalance;
    }

    public double calculateInterest() {
        // Implementation for calculating interest
        return getBalance() * getInterestRate();
    }
}