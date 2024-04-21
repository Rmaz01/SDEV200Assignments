public class CheckingAccount extends BankAccount {
    private double overdraftLimit;
    private double overdraftFee;

    public CheckingAccount(String accountNumber, String accountHolderName, String accountType, double interestRate, double overdraftLimit, double overdraftFee) {
        super(accountNumber, accountHolderName, accountType, interestRate);
        this.overdraftLimit = overdraftLimit;
        this.overdraftFee = overdraftFee;
    }

    @Override
    public void withdraw(double amount) {
        if (getBalance() + overdraftLimit >= amount) {
            super.withdraw(amount);
            if (getBalance() < 0) {
                deductOverdraftFee();
            }
        } else {
            System.out.println("Overdraft limit exceeded.");
        }
    }

    private void deductOverdraftFee() {
        balance -= overdraftFee;
        transactionHistory.add(new Transaction("Overdraft fee", overdraftFee));
    }
}