//M05 Programming Assignment (3)
//Ivy Tech Community College
//SDEV 200 - Java
//Professor Bumgardner
//Nativida Muhammad
// 21 April 2024

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application {

  @Override
  public void start(Stage primaryStage) {
    ClockPane clock = new ClockPane();

    // Text fields for setting hours, minutes, and seconds
    TextField tfHour = new TextField();
    tfHour.setPrefColumnCount(2); // Adjust width to accommodate two characters
    TextField tfMinute = new TextField();
    tfMinute.setPrefColumnCount(2);
    TextField tfSecond = new TextField();
    tfSecond.setPrefColumnCount(2);

    // Set clock time button
    Label lblSetTime = new Label("Set Clock Time");
    lblSetTime.setOnMouseClicked(e -> {
      try {
        int hour = Integer.parseInt(tfHour.getText());
        int minute = Integer.parseInt(tfMinute.getText());
        int second = Integer.parseInt(tfSecond.getText());
        clock.setHour(hour);
        clock.setMinute(minute);
        clock.setSecond(second);
      } catch (NumberFormatException ex) {
        System.out.println("Please enter valid numbers for hour, minute, and second.");
      }
    });

    HBox hbox = new HBox(10);
    hbox.getChildren().addAll(
        new Label("Hour: "), tfHour,
        new Label("Minute: "), tfMinute,
        new Label("Second: "), tfSecond,
        lblSetTime);

    BorderPane borderPane = new BorderPane();
    borderPane.setCenter(clock);
    borderPane.setBottom(hbox);

    Scene scene = new Scene(borderPane, 300, 300);
    primaryStage.setTitle("Set Clock Time");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
