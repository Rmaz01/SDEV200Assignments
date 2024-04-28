import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class M06FinalProjectUpdate4 extends Application {

    private BankAccount currentAccount;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Bank Account Management");

        // Create UI components
        Label accountNumberLabel = new Label("Account Number:");
        TextField accountNumberField = new TextField();
        Label nameLabel = new Label("Account Holder Name:");
        TextField nameField = new TextField();
        Label typeLabel = new Label("Account Type:");
        TextField typeField = new TextField();
        Label balanceLabel = new Label("Balance:");
        TextField balanceField = new TextField();
        Label amountLabel = new Label("Amount:");
        TextField amountField = new TextField();
        Button depositButton = new Button("Deposit");
        Button withdrawButton = new Button("Withdraw");

        // Layout
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);
        grid.add(accountNumberLabel, 0, 0);
        grid.add(accountNumberField, 1, 0);
        grid.add(nameLabel, 0, 1);
        grid.add(nameField, 1, 1);
        grid.add(typeLabel, 0, 2);
        grid.add(typeField, 1, 2);
        grid.add(balanceLabel, 0, 3);
        grid.add(balanceField, 1, 3);
        grid.add(amountLabel, 0, 4);
        grid.add(amountField, 1, 4);
        grid.add(depositButton, 0, 5);
        grid.add(withdrawButton, 1, 5);

        depositButton.setOnAction(e -> {
            double amount = Double.parseDouble(amountField.getText());
            currentAccount.deposit(amount);
            updateBalanceField(balanceField);
        });

        withdrawButton.setOnAction(e -> {
            double amount = Double.parseDouble(amountField.getText());
            currentAccount.withdraw(amount);
            updateBalanceField(balanceField);
        });

        Scene scene = new Scene(grid, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void updateBalanceField(TextField balanceField) {
        balanceField.setText(String.valueOf(currentAccount.getBalance()));
    }
}
