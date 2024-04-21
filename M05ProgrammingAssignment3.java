import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class M05ProgrammingAssignment3 extends Application {
    private Text text = new Text("!Wow Colors!");
    private Slider slRed = new Slider(0.0, 1.0, 0.0);
    private Slider slGreen = new Slider(0.0, 1.0, 0.0);
    private Slider slBlue = new Slider(0.0, 1.0, 0.0);
    private Slider slOpacity = new Slider(0.0, 1.0, 1.0);

    @Override
    public void start(Stage primaryStage) {
        slRed.valueProperty().addListener((ov, oldValue, newValue) -> setColor());
        slGreen.valueProperty().addListener((ov, oldValue, newValue) -> setColor());
        slBlue.valueProperty().addListener((ov, oldValue, newValue) -> setColor());
        slOpacity.valueProperty().addListener((ov, oldValue, newValue) -> setColor());

        GridPane paneForSliders = new GridPane();
        paneForSliders.setAlignment(Pos.CENTER);
        paneForSliders.setVgap(5);
        paneForSliders.setHgap(5);
        paneForSliders.add(new Label("Red"), 0, 0);
        paneForSliders.add(slRed, 1, 0);
        paneForSliders.add(new Label("Green"), 0, 1);
        paneForSliders.add(slGreen, 1, 1);
        paneForSliders.add(new Label("Blue"), 0, 2);
        paneForSliders.add(slBlue, 1, 2);
        paneForSliders.add(new Label("Opacity"), 0, 3);
        paneForSliders.add(slOpacity, 1, 3);

        BorderPane pane = new BorderPane();
        pane.setTop(new BorderPane(text)); //Center the text
        pane.setCenter(paneForSliders);

        Scene scene = new Scene(pane, 250, 150);
        primaryStage.setTitle("Color Slider");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void setColor() {
        text.setFill(new Color(slRed.getValue(), slGreen.getValue(), 
                slBlue.getValue(), slOpacity.getValue()));
    }

    public static void main(String[] args) {
        launch(args);
    }
}