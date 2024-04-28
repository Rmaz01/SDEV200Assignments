import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class M06ProgrammingAssignment2 extends Application {

    private static final String DB_URL = "jdbc:mysql://localhost/M06PA2";
    private static final String DB_USER = "Robert";
    private static final String DB_PASSWORD = "1234";

    @Override
    public void start(Stage primaryStage) {
        Button individualButton = new Button("Non-Batch Update");
        individualButton.setOnAction(e -> performInserts(false));

        Button batchButton = new Button("Batch Update");
        batchButton.setOnAction(e -> performInserts(true));

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20));
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.add(individualButton, 0, 0);
        gridPane.add(batchButton, 0, 1);

        Scene scene = new Scene(gridPane, 300, 150);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Database Performance Comparison");
        primaryStage.show();
    }

    private void performInserts(boolean batchUpdate) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO Temp(num1, num2, num3) VALUES (?, ?, ?)");

            long startTime = System.currentTimeMillis();

            if (!batchUpdate) {
                // Individual inserts
                for (int i = 0; i < 1000; i++) {
                    preparedStatement.setDouble(1, Math.random());
                    preparedStatement.setDouble(2, Math.random());
                    preparedStatement.setDouble(3, Math.random());
                    preparedStatement.executeUpdate();
                }
            } else {
                // Batch insert
                for (int i = 0; i < 1000; i++) {
                    preparedStatement.setDouble(1, Math.random());
                    preparedStatement.setDouble(2, Math.random());
                    preparedStatement.setDouble(3, Math.random());
                    preparedStatement.addBatch();
                }
                preparedStatement.executeBatch();
            }

            long endTime = System.currentTimeMillis();
            System.out.println("Time taken: " + (endTime - startTime) + " ms");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}