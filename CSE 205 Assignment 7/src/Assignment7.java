// Assignment 7: Arizona State University CSE205
//         Name: Richard Marquez Cortes
//    StudentID: 1214775731
//      Lecture: TTh 1:30-2:45pm
//  Description: The Assignment7 class creates a DrawingPane object
//               on which we can draw lines with different
//               colors and widths and erase one or all, etc.


import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;

public class Assignment7 extends Application
{
   public void start(Stage primaryStage)
   {
      //create a DrawPane object. See DrawPane.java for details.
      DrawingPane gui = new DrawingPane();
      //Comparable s = new String();
      //put gui on top of the rootPane
      StackPane rootPane = new StackPane();
      rootPane.getChildren().add(gui);
   
      // Create a scene and place rootPane in the stage
      Scene scene = new Scene(rootPane, 600, 400);
      primaryStage.setTitle("Line Drawing"); 
      primaryStage.setScene(scene); // Place the scene in the stage
      primaryStage.show(); // Display the stage
   }
   public static void main(String[] args)
   {
      Application.launch(args);
   }
}
