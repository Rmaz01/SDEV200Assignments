
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class M05ProgrammingAssignment1 extends Application {
  @Override 
  public void start(Stage primaryStage) {

    GridPane pane = new GridPane();


    pane.add(new ImageView(new Image("germany.jpg")), 0, 0);
    pane.add(new ImageView(new Image("china.jpg")), 1, 0);
    pane.add(new ImageView(new Image("france.jpg")), 0, 1);
    pane.add(new ImageView(new Image("usa.jpg")), 1, 1);


    Scene scene = new Scene(pane);
    primaryStage.setTitle("Country Flags"); 
    primaryStage.setScene(scene); 
    primaryStage.show(); 
  }
}