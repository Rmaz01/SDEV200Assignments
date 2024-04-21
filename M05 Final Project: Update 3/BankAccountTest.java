public class BankAccountTest {
    public static void main(String[] args) {
        // Test BankAccount 
        BankAccount account = new BankAccount("1234567890", "John Doe", "Savings", 0.05);
        account.deposit(1000);
        account.withdraw(500);
        System.out.println("Account balance: $" + account.getBalance());
    }
}