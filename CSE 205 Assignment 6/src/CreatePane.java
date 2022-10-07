// Assignment #: Arizona State University CSE205
//         Name: Richard Marquez Cortes
//    StudentID: 1214775731
//      Lecture: TTh 1:30-2:45pm
//  Description: CreatePane generates a pane where a user can enter
//  a movie information and create a list of available movies.

import java.util.ArrayList;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.geometry.*;

public class CreatePane extends HBox
{
    private ArrayList<Movie> movieList;
    
    //The relationship between CreatePane and ReviewPane is Aggregation
    private ReviewPane reviewPane;
    private Label msg; 
    private Label l1; 
    private Label l2;
    private Label l3;
    private TextField t1;
    private TextField t2;
    private TextField t3;
    private Button b1;
    private TextArea area;
    //constructor
    public CreatePane(ArrayList<Movie> list, ReviewPane rePane)
     {
        this.movieList = list;
        this.reviewPane = rePane;

        //Step #1: initialize each instance variable and set up the layout
        GridPane pane = new GridPane(); 
        
        msg = new Label(); 
        l1 = new Label("Title"); 
        l2 = new Label("Length");
        l3 = new Label("Year");
        t1 = new TextField();
        t2 = new TextField();
        t3 = new TextField();
        b1 = new Button("Create a Movie");
        area = new TextArea("No Movie");
        
        //create a GridPane hold those labels & text fields
        //consider using .setPadding() or setHgap(), setVgap()
        //to control the spacing and gap, etc. 
        pane.setPadding(new Insets(10, 50, 50, 25));	//grid pane padding
        pane.setHgap(10);
        pane.setVgap(10);
        
        //You might need to create a sub pane to hold the button
        StackPane subpane = new StackPane();
        subpane.getChildren().addAll(b1);
        VBox text = new VBox();
        text.getChildren().add(area);
        BorderPane main = new BorderPane();		//main pane 
        main.setLeft(pane);		//sets left and right side of border pane
        main.setRight(text);
        
        //Set up the layout for the left half of the CreatePane.
        pane.add(msg, 0, 0);
        pane.add(l1, 0, 1);
        pane.add(l2, 0, 2);
        pane.add(l3, 0, 3);		//sets components inside grid pane
        pane.add(t1, 1, 1);
        pane.add(t2, 1, 2);
        pane.add(t3, 1, 3);
        pane.add(subpane, 1, 4);
        //the right half of the InputPane is simply a TextArea object
        //Note: a ScrollPane will be added to it automatically when there are no
        //enough space
        
        //Add the left half and right half to the CreatePane
        //Note: CreatePane extends from HBox
        getChildren().addAll(main);
        
        //Step #3: register source object with event handler
        b1.setOnAction(new ButtonHandler());
    } //end of constructor

    //Step 2: Create a ButtonHandler class
    //ButtonHandler listens to see if the button "Create a Movie" is pushed or not,
    //When the event occurs, it get a movie's Title, Year, and Length
    //information from the relevant text fields, then create a new movie and add it inside
    //the movieList. Meanwhile it will display the movie's information inside the text area.
    //It also does error checking in case any of the textfields are empty or non-numeric string is typed
    private class ButtonHandler implements EventHandler<ActionEvent>
     {
        //Override the abstact method handle()
        public void handle(ActionEvent event)
        {
            //declare any necessary local variables here
        	Object source = event.getSource();
        	
            //when a text field is empty and the button is pushed
            if(source == b1 && t1.getText().isEmpty() || t2.getText().isEmpty() || t3.getText().isEmpty())
            {
                msg.setTextFill(Color.RED);		//if one textfield is empty, prints message
                msg.setText("Please fill all fields");
            }
            
            else if(t1.getText() != null && t2.getText() != null && t3.getText() != null)
            {
            	try {	//Also somewhere you will need to use try & catch block to catch the NumberFormatException
            	Movie mov = new Movie();
            	String title = t1.getText();
            	int length = Integer.parseInt(t2.getText());	//parses strings into integers
            	int year = Integer.parseInt(t3.getText());
            	mov.setMovieTitle(title);
            	mov.setLength(length);		//sets movie information
            	mov.setYear(year);
            	movieList.add(mov);					//at the end, don't forget to update the new arrayList 
            	reviewPane.updateMovieList(mov);	//information on the ListView of the ReviewPane
            	msg.setTextFill(Color.RED); 
                msg.setText("Movie added");
                t1.setText("");
            	t2.setText("");		//if movie is created, clears textfields
            	t3.setText("");	
            	
            	if(area.getText().contentEquals("No Movie"))
            	{
            		area.setText("");	//clears text area for new movies
            	}
            	area.appendText(mov.toString());
            	
            	}catch(Exception e) {
            		msg.setTextFill(Color.RED); 			//catches the error when entering a 
                	msg.setText("Incorrect data format");	//string for movie length and year
            	} 	
            }
         } //end of handle() method
   } //end of ButtonHandler class
}//main
