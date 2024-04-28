import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.sql.*;
import javafx.geometry.Insets;

public class M06ProgrammingAssignment1 extends Application {

    private TextField idField = new TextField();
    private TextField lastNameField = new TextField();
    private TextField firstNameField = new TextField();
    private TextField miField = new TextField();
    private TextField addressField = new TextField();
    private TextField cityField = new TextField();
    private TextField stateField = new TextField();
    private TextField telephoneField = new TextField();
    private TextField emailField = new TextField();

    private Connection connection;

    @Override
    public void start(Stage primaryStage) {
        initializeDB();

        Button viewButton = new Button("View");
        viewButton.setOnAction(e -> viewRecord());

        Button insertButton = new Button("Insert");
        insertButton.setOnAction(e -> insertRecord());

        Button updateButton = new Button("Update");
        updateButton.setOnAction(e -> updateRecord());

        GridPane inputGrid = new GridPane();
        inputGrid.addRow(0, new Label("ID:"), idField);
        inputGrid.addRow(1, new Label("Last Name:"), lastNameField);
        inputGrid.addRow(2, new Label("First Name:"), firstNameField);
        inputGrid.addRow(3, new Label("MI:"), miField);
        inputGrid.addRow(4, new Label("Address:"), addressField);
        inputGrid.addRow(5, new Label("City:"), cityField);
        inputGrid.addRow(6, new Label("State:"), stateField);
        inputGrid.addRow(7, new Label("Telephone:"), telephoneField);
        inputGrid.addRow(8, new Label("Email:"), emailField);

        HBox buttonBox = new HBox(10, viewButton, insertButton, updateButton);

        VBox root = new VBox(10, inputGrid, buttonBox);
        root.setPadding(new Insets(10));

        primaryStage.setScene(new Scene(root, 400, 300));
        primaryStage.setTitle("Staff Database App");
        primaryStage.show();
    }

    private void initializeDB() {
        final String DB_URL = "jdbc:mysql://localhost/M06StaffDatabase";
        final String USER = "Robert";
        final String PASS = "1234";

        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void viewRecord() {
        String id = idField.getText();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Staff WHERE id='" + id + "'");
            if (resultSet.next()) {
                lastNameField.setText(resultSet.getString("lastName"));
                firstNameField.setText(resultSet.getString("firstName"));
                miField.setText(resultSet.getString("mi"));
                addressField.setText(resultSet.getString("address"));
                cityField.setText(resultSet.getString("city"));
                stateField.setText(resultSet.getString("state"));
                telephoneField.setText(resultSet.getString("telephone"));
                emailField.setText(resultSet.getString("email"));
            } else {
                clearFields();
                System.out.println("Record with ID " + id + " not found.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void insertRecord() {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO Staff VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
            statement.setString(1, idField.getText());
            statement.setString(2, lastNameField.getText());
            statement.setString(3, firstNameField.getText());
            statement.setString(4, miField.getText());
            statement.setString(5, addressField.getText());
            statement.setString(6, cityField.getText());
            statement.setString(7, stateField.getText());
            statement.setString(8, telephoneField.getText());
            statement.setString(9, emailField.getText());

            int affectedRows = statement.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Record inserted successfully.");
            } else {
                System.out.println("Failed to insert record.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void updateRecord() {
        String id = idField.getText();
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE Staff SET lastName=?, firstName=?, mi=?, address=?, city=?, state=?, telephone=?, email=? WHERE id=?");
            statement.setString(1, lastNameField.getText());
            statement.setString(2, firstNameField.getText());
            statement.setString(3, miField.getText());
            statement.setString(4, addressField.getText());
            statement.setString(5, cityField.getText());
            statement.setString(6, stateField.getText());
            statement.setString(7, telephoneField.getText());
            statement.setString(8, emailField.getText());
            statement.setString(9, id);

            int affectedRows = statement.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Record updated successfully.");
            } else {
                System.out.println("Failed to update record with ID " + id);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void clearFields() {
        lastNameField.clear();
        firstNameField.clear();
        miField.clear();
        addressField.clear();
        cityField.clear();
        stateField.clear();
        telephoneField.clear();
        emailField.clear();
    }

    public static void main(String[] args) {
        launch(args);
    }
}