//This program demonstrate mouse press-dragged-release
//event handling. It draw a circle on screen.
//see also CirclePane.java

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;

public class MousePressDragReleaseDemo extends Application
{
    public void start(Stage primaryStage)
    {
   	  CirclePane gui = new CirclePane();
      StackPane rootPane = new StackPane();
      rootPane.getChildren().add(gui);

      // Create a scene and place rootPane in the stage
	  Scene scene = new Scene(rootPane, 400, 400);
	  primaryStage.setTitle("Mouse Drag Demo");
	  primaryStage.setScene(scene);
      primaryStage.show();
  }
    public static void main(String[] args)
    {
	     Application.launch(args);
    }
}
