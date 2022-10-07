// Assignment #: Arizona State University CSE205
//         Name: Richard Marquez Cortes
//    StudentID: 1214775731
//      Lecture: TTh 1:30-2:45pm
//  Description: ReviewPane displays a list of available movies
//  from which a user can select to reviw.

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.event.ActionEvent;	//**Need to import to handle event
import javafx.event.EventHandler;	//**Need to import to handle event
import java.util.ArrayList;
import javafx.scene.layout.HBox;

//import all other necessary javafx classes here

public class ReviewPane extends VBox
{
   //A ListView to display movies created
   private ArrayList<Movie> movieList;
   private ListView<Movie> movieListView;
   private ObservableList<Movie> choices;
   
   //declare all other necessary GUI variables here
   private Label result;
   private Label header;
   private Button submit;
   private RadioButton r1;
   private RadioButton r2;
   private RadioButton r3;
   private RadioButton r4;
   private RadioButton r5;
   private int select;
   
   Review review;	//review object
   
   //constructor
   public ReviewPane(ArrayList<Movie> list)
   {
       //initialize instance variables
       this.movieList = list;
       movieListView = new ListView<Movie>();
       choices = FXCollections.observableArrayList();
       movieListView.setItems(choices);
       review = new Review();
       
       //set up the layout       
       VBox box = new VBox();
       HBox box2 = new HBox();
       
       result = new Label();
       header = new Label("Choose a movie to give a review, and select a rating:");
       submit = new Button("Submit Review");
       r1 = new RadioButton("1 Poor ");
       r2 = new RadioButton("2 Fair ");
       r3 = new RadioButton("3 Average ");	//sets radio button labels
       r4 = new RadioButton("4 Good ");
       r5 = new RadioButton("5 Excellent ");
       
       ToggleGroup tg = new ToggleGroup();	
       r1.setToggleGroup(tg);
       r2.setToggleGroup(tg);
       r3.setToggleGroup(tg);	//adds all radio buttons to group
       r4.setToggleGroup(tg);
       r5.setToggleGroup(tg);
       
       box2.getChildren().addAll(r1,r2,r3,r4,r5);	//adds add radio buttons to one pane
       box.getChildren().addAll(result,header,movieListView,box2,submit);	//adds everything to a single pane
       
       //ReviewPane is a VBox - add the components here
       getChildren().add(box); 
       
       //Step #3: Register the button with its handler class
       submit.setOnAction(new RatingHandler());	//registers button      
   } //end of constructor

 //This method refresh the ListView whenever there's new movie added in CreatePane
 //you will need to update the underline ObservableList object in order for ListView
 //object to show the updated movie list
 public void updateMovieList(Movie newMovie)
 {
	 movieList.add(newMovie);
	 choices = FXCollections.observableArrayList(movieList);	//updates movie list
	 movieListView.getItems().add(newMovie);
 }

 //Step 2: Create a RatingHandler class
 private class RatingHandler implements EventHandler<ActionEvent>
    {	 
        //Override the abstact method handle()
        public void handle(ActionEvent event)
        {
            //When "Submit Review" button is pressed and a movie is selected from
            //the list view's average rating is updated by adding a additional
            //rating specified by a selected radio button
        	Object source = event.getSource();
        	try {
            if (source == submit && movieList.isEmpty() == false)
            {
            	select = movieListView.getSelectionModel().getSelectedIndex() * 2;
            	
            	if(r1.isSelected())
                {
            		movieList.get(select).addRating(1.0);	//first radio button
            		result.setText("");
                }
            	else if(r2.isSelected())
                {
            		movieList.get(select).addRating(2.0);	//second radio button
            		result.setText("");
                }
            	else if(r3.isSelected())
                {
            		movieList.get(select).addRating(3.0);	//third radio button
            		result.setText("");
                }
            	else if(r4.isSelected())
                {
            		movieList.get(select).addRating(4.0);	//fourth radio button
            		result.setText("");
                }
            	else if(r5.isSelected())
                {
            		movieList.get(select).addRating(5.0);	//fifth radio button
            		result.setText("");
                }
            	else 
            	{
            		result.setTextFill(Color.RED);			//if no radio button is pressed, 
                	result.setText("Please select rating");	//it will ask for a rating
            	}
            	movieListView.refresh();            	
            }
        }catch(Exception e) 
        	{
    		result.setTextFill(Color.RED);	//catches the error and asks for movie selection
        	result.setText("Please select a movie");
    		}
        }
    } //end of RatingHandler
} //end of ReviewPane class