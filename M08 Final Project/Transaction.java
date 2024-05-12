import java.util.Date;

public class Transaction {
    private String transactionId;
    private Date date;
    private String type;
    private double amount;

    public Transaction(String type, double amount) {
        this.transactionId = generateTransactionId();
        this.date = new Date();
        this.type = type;
        this.amount = amount;
    }

    private String generateTransactionId() {
        return "TXN-" + Math.random();
    }
}