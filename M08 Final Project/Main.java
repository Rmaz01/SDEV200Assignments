import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Pos;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main extends Application {

  private Label balanceLabel;

    private static final String ACCOUNTS_FILE = "accounts.txt";
    private List<BankAccount> accounts = new ArrayList<>();
    private BankAccount currentAccount;

    public static void main(String[] args) {
        launch(args);
    }
  
  
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Bank Account Management");

        // Main menu scene
        VBox mainMenuBox = new VBox(10);
        Button createAccountButton = new Button("Create Account");
        Button loginButton = new Button("Login");
        mainMenuBox.getChildren().addAll(createAccountButton, loginButton);
        mainMenuBox.setAlignment(Pos.CENTER);
        Scene mainMenuScene = new Scene(mainMenuBox, 400, 300);

        // Create account scene
      GridPane createAccountGrid = new GridPane();
      createAccountGrid.setPadding(new Insets(10, 10, 10, 10));
      createAccountGrid.setVgap(8);
      createAccountGrid.setHgap(10);
      Label nameLabel = new Label("Account Holder Name:");
      TextField nameField = new TextField();
      Label typeLabel = new Label("Account Type:");
      ComboBox<String> typeComboBox = new ComboBox<>(FXCollections.observableArrayList("Checking", "Savings"));
      Label passwordLabel = new Label("Password:");
      PasswordField passwordField = new PasswordField();
      Button createAccountSubmitButton = new Button("Create");
      createAccountGrid.addRow(0, nameLabel, nameField);
      createAccountGrid.addRow(1, typeLabel, typeComboBox);
      createAccountGrid.addRow(2, passwordLabel, passwordField);
      createAccountGrid.addRow(3, createAccountSubmitButton);
      Scene createAccountScene = new Scene(createAccountGrid, 400, 300);


        // Login scene
      GridPane loginGrid = new GridPane();
      loginGrid.setPadding(new Insets(10, 10, 10, 10));
      loginGrid.setVgap(8);
      loginGrid.setHgap(10);
      Label nameLabel2 = new Label("Account Holder Name:");
      TextField nameField2 = new TextField();
      Label passwordLabel2 = new Label("Password:");
      PasswordField passwordField2 = new PasswordField();
      Button loginSubmitButton = new Button("Login");
      loginGrid.addRow(0, nameLabel2, nameField2);
      loginGrid.addRow(1, passwordLabel2, passwordField2);
      loginGrid.addRow(2, loginSubmitButton);
      Scene loginScene = new Scene(loginGrid, 400, 300);

        // Transaction scene
        GridPane transactionGrid = new GridPane();
        transactionGrid.setPadding(new Insets(10, 10, 10, 10));
        transactionGrid.setVgap(8);
        transactionGrid.setHgap(10);
        balanceLabel = new Label();
        Label messageLabel = new Label();
        Label amountLabel = new Label("Amount:");
        TextField amountField = new TextField();
        Button depositButton = new Button("Deposit");
        Button withdrawButton = new Button("Withdraw");
        transactionGrid.addRow(0, balanceLabel);
        transactionGrid.addRow(1, messageLabel);
        transactionGrid.addRow(2, amountLabel, amountField);
        transactionGrid.addRow(3, depositButton, withdrawButton);
        Scene transactionScene = new Scene(transactionGrid, 400, 300);

      // Switch to main menu scene initially
      primaryStage.setScene(mainMenuScene);
      primaryStage.show();

      createAccountButton.setOnAction(e -> primaryStage.setScene(createAccountScene));

      createAccountSubmitButton.setOnAction(e -> {
          String accountHolderName = nameField.getText();
          String accountType = typeComboBox.getValue();
          String password = passwordField.getText(); // Retrieve password
          currentAccount = new BankAccount(generateAccountNumber(), accountHolderName, accountType, 0.0, password); // Pass password
          accounts.add(currentAccount);
          saveAccounts();
          primaryStage.setScene(mainMenuScene);
      });

      loginButton.setOnAction(e -> {
          primaryStage.setScene(loginScene);
      });

      loginSubmitButton.setOnAction(e -> {
          String accountHolderName = nameField2.getText();
          String password = passwordField2.getText().trim();
          boolean found = false;
          for (BankAccount account : accounts) {
              if (account.getAccountHolderName().equals(accountHolderName) && account.getPassword().equals(password)) {
                  currentAccount = account;
                  primaryStage.setScene(transactionScene);
                  found = true;
                  break;
              }
          }
          if (!found) {
              Alert alert = new Alert(Alert.AlertType.ERROR);
              alert.setTitle("Login Error");
              alert.setHeaderText(null);
              alert.setContentText("Invalid account holder name or password!");
              alert.showAndWait();
          }
      });

        depositButton.setOnAction(e -> {
            try {
                double amount = Double.parseDouble(amountField.getText());
                currentAccount.deposit(amount);
                updateBalance();
                saveAccounts();
                messageLabel.setText("Deposit successful.");
            } catch (NumberFormatException ex) {
                messageLabel.setText("Invalid amount.");
            }
        });

        withdrawButton.setOnAction(e -> {
            try {
                double amount = Double.parseDouble(amountField.getText());
                currentAccount.withdraw(amount);
                updateBalance();
                saveAccounts();
                messageLabel.setText("Withdrawal successful.");
            } catch (NumberFormatException ex) {
                messageLabel.setText("Invalid amount.");
            } catch (InsufficientFundsException ex) {
                messageLabel.setText("Insufficient funds.");
            }
        });
    }

  private void updateBalance() {
      // Update balance display
      if (currentAccount != null) {
          balanceLabel.setText("Balance: $" + currentAccount.getBalance());
      }
  }

    private String generateAccountNumber() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 7; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }

    private void saveAccounts() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(ACCOUNTS_FILE))) {
            for (BankAccount account : accounts) {
                writer.println(account.getAccountNumber() + "," +
                        account.getAccountHolderName() + "," +
                        account.getAccountType() + "," +
                        account.getBalance() + "," +
                        account.getPassword());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadAccounts() {
        accounts.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(ACCOUNTS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String accountNumber = parts[0];
                String accountHolderName = parts[1];
                String accountType = parts[2];
                double balance = Double.parseDouble(parts[3]);
                String password = parts[4];
                accounts.add(new BankAccount(accountNumber, accountHolderName, accountType, balance, password));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}