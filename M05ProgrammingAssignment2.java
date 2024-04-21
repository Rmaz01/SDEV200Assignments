import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class M05ProgrammingAssignment2 extends Application {
  @Override
  public void start(Stage primaryStage) {
   
    StackPane pane = new StackPane();

    // Create a circle and set its properties
    Circle circle = new Circle(50);
    circle.setFill(Color.WHITE);
    circle.setStroke(Color.BLACK);
    pane.getChildren().add(circle);

  
    pane.setOnMousePressed(e -> {
      circle.setFill(Color.BLACK);
    });

    pane.setOnMouseReleased(e -> {
      circle.setFill(Color.WHITE);
      circle.setStroke(Color.BLACK);
    });

    
    Scene scene = new Scene(pane, 120, 120);
    primaryStage.setTitle("Mouse Click Circle"); 
    primaryStage.setScene(scene); 
    primaryStage.show(); 

  }
}
