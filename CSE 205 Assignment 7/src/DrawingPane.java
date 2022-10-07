// Assignment 7: Arizona State University CSE205
//         Name: Richard Marquez Cortes
//    StudentID: 1214775731
//      Lecture: TTh 1:30-2:45pm
//  Description: The DrawingPane class creates a canvas where we can use
//               mouse key to draw lines with different colors and widths.
//               We can also use the the two buttons to erase the last
//				     drawn line or clear them all.

//import any classes necessary here
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Line;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent; 	
import java.util.ArrayList;

public class DrawingPane extends BorderPane
{
   //declare any other necessary instance variables here  
   private ComboBox<String> colorCombo, widthCombo;
   private ArrayList<Line> lineList;
   private ObservableList<String> combos;
   private Button undoButton, eraseButton;
   private Pane canvas;
   private Line line;
   private double x1, y1, x2, y2;
   private int colorTemp, widthTemp; 
   
   //Constructor
   public DrawingPane()
   {
      //Step #1: initialize instance variable and set up layout
      undoButton = new Button("Undo");
      eraseButton = new Button("Erase");
      undoButton.setMinWidth(80.0);		//sets size of button
      eraseButton.setMinWidth(80.0);

      //Create the color comboBox and width comboBox,
      colorCombo = new ComboBox<String>(); 
      colorCombo.getItems().addAll("Black","Blue","Red","Yellow","Green");	//color options
      colorCombo.getSelectionModel().selectFirst();
      widthCombo = new ComboBox<String>(); 
      widthCombo.getItems().addAll("1","3","5","7");	//width options
      widthCombo.getSelectionModel().selectFirst();
      
      //initialize lineList, it is a data structure we used
      //to track the lines we created
      lineList = new ArrayList<Line>();		//arraylist that will hold all lines
      combos = FXCollections.observableArrayList();
      
      //topPane should contain two combo boxes and two buttons
      HBox topPane = new HBox();		//HBox that will hold all buttons and combo boxes
      topPane.setSpacing(40);
      topPane.setPadding(new Insets(10, 10, 10, 10));
      topPane.setStyle("-fx-border-color: black");
      topPane.getChildren().addAll(colorCombo, widthCombo, undoButton, eraseButton); 
      //canvas is a Pane where we will draw lines
      
      canvas = new Pane();		//drawing canvas
      canvas.setStyle("-fx-background-color: white;");		//default background white
            
      //add the canvas at the center of the pane and top panel
      //should have two combo boxes and two buttons
      this.setCenter(canvas);	//sets canvas in the center
      this.setTop(topPane);		//sets HBox on top
      
      //Step #3: Register the source nodes with its handler objects
      canvas.setOnMousePressed(new MouseHandler());		
      canvas.setOnMouseDragged(new MouseHandler());		//mouse handlers
      canvas.setOnMouseReleased(new MouseHandler());
      undoButton.setOnAction(new ButtonHandler());		//button handlers
      eraseButton.setOnAction(new ButtonHandler());
      colorCombo.setOnAction(new ColorHandler()); 		//combo box handlers
      widthCombo.setOnAction(new WidthHandler()); 
   }
    //Step #2(A) - MouseHandler
    private class MouseHandler implements EventHandler<MouseEvent>
    {
        public void handle(MouseEvent event)
        {
            //handle MouseEvent here
            //Note: you can use if(event.getEventType()== MouseEvent.MOUSE_PRESSED)
            //to check whether the mouse key is pressed, dragged or released   
            if(event.getEventType() == MouseEvent.MOUSE_PRESSED)
            {
            	x1 = event.getX();		//original mouse press location
				y1 = event.getY();		
				line = new Line(x1,y1,x1,y1);		//creates line
				if(colorTemp == 1)
				{
					line.setStroke(Color.BLACK);		
				}
				else if(colorTemp == 2)
				{
					line.setStroke(Color.BLUE);		
				}
				else if(colorTemp == 3)
				{
					line.setStroke(Color.RED);		//sets color to chosen color option
				}
				else if(colorTemp == 4)
				{
					line.setStroke(Color.YELLOW);		
				}
				else if(colorTemp == 5)
				{
					line.setStroke(Color.GREEN);		
				}
				if(widthTemp == 1)
				{
					line.setStrokeWidth(1.0);		
				}
				else if(widthTemp == 2)
				{
					line.setStrokeWidth(3.0);		
				}
				else if(widthTemp == 3)				//sets width to chosen width option
				{
					line.setStrokeWidth(5.0);		
				}
				else if(widthTemp == 4)
				{
					line.setStrokeWidth(7.0);		
				}
				canvas.getChildren().add(line);
            }	
            else if(event.getEventType() == MouseEvent.MOUSE_DRAGGED)
            {          		
            	x2 = event.getX();		//ending location 
				y2 = event.getY();		
				line.setEndX(x2);		//overrides line end location
				line.setEndY(y2);
           	}
            else if(event.getEventType() == MouseEvent.MOUSE_RELEASED)
            {          		
            	lineList.add(line);		//adds line to arraylist
           	}                
        }//end handle()
    }//end MouseHandler
    
    //Step #2(B)- A handler class used to handle events from Undo & Erase buttons
    private class ButtonHandler implements EventHandler<ActionEvent>
    {
        public void handle(ActionEvent event)
        {
        	Object source = event.getSource();        	
        	if(source == undoButton)
        	{        		
        		canvas.getChildren().remove(lineList.get(lineList.size()-1));		//removes last line created
        		lineList.remove(lineList.size()-1);
        	}
        	else if(source == eraseButton)
        	{
        		canvas.getChildren().clear();		//clears the entire arraylist; erasing all lines
        	}           
        }
    }//end ButtonHandler

   //Step #2(C)- A handler class used to handle colors
   private class ColorHandler implements EventHandler<ActionEvent>
   {
       public void handle(ActionEvent event)
       {   	    
    	   	if(colorCombo.getValue() == "Black") 
       		{
    	   		colorTemp = 1; 
       		}
       		else if(colorCombo.getValue() == "Blue") 
       		{
       			colorTemp = 2; 
       		}
       		else if(colorCombo.getValue() == "Red")		//sets values for each color
       		{
       			colorTemp = 3;
       		}
       		else if(colorCombo.getValue() == "Yellow") 
       		{
       			colorTemp = 4;
       		} 
       		else if(colorCombo.getValue() == "Green") 
       		{
       			colorTemp = 5;
       		} 
       }
   }//end ColorHandler
    
    //Step #2(D)- A handler class used to handle widths of lines
    private class WidthHandler implements EventHandler<ActionEvent>
    {
        public void handle(ActionEvent event)
        {
        	if(widthCombo.getValue() == "1") 
        	{
        		widthTemp = 1;
        	}
        	else if(widthCombo.getValue() == "3")
        	{
        		widthTemp = 2;							//sets values for each width
        	}
        	else if(widthCombo.getValue() == "5") 
        	{
        		widthTemp = 3;
        	}
        	else if(widthCombo.getValue() == "7") 
        	{
        		widthTemp = 4;
        	}      
        }
    }//end WidthHandler
}//end class DrawingPane
