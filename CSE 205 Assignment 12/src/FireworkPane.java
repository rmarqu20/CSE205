// Assignment #: Arizona State University CSE205 #12
//         Name: Richard Marquez Cortes
//    StudentID: 1214775731
//      Lecture: TTh 1:30-2:45pm
//  Description: The FireworkPane creates the pane for the animation and creates the 
// 				 the arcs for the fireworks. Sets up methods to play, pause, etc for animation. 

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.util.Duration;

public class FireworkPane extends Pane
{
	//components of the Firework 
	private double centerX; 
	private double centerY;
	private double radius = 25; 
	private double radiusLimit; 
	private Color color; 
	private int beamNum = 8;
	private double step = 2.0; 
	private double angleSize;
	private Timeline timeline1; 
	
	//Constructor to create all components and create arcs
	public FireworkPane(Color initialColor, int width) 
	{
		color = initialColor; 
		centerX = width/2; 
		centerY = width/2; 
		radius = 25;
		beamNum = 8;
		step = 2.0;
		radiusLimit = (width-10)/(4.0);
		angleSize = 360/(beamNum*2);
		setStyle("-fx-background-color: black");	//sets background to black
		
		for(int currentAngle=0; currentAngle <= 360; currentAngle += 2*angleSize)
		{
			Arc arc1 = new Arc(centerX, centerY, radius, radius, currentAngle, angleSize);	//creates arc
		    arc1.setFill(color);
		    arc1.setStroke(color);
		    arc1.setType(ArcType.ROUND);
		    this.getChildren().add(arc1);
		}
		
		KeyFrame key = new KeyFrame(Duration.millis(500), new FireworkHandler());
		timeline1 = new Timeline(key);
		timeline1.setCycleCount(Timeline.INDEFINITE);
	    timeline1.setRate(20);   //default rate = 20
	    timeline1.play();
	}
	
	//plays the animation
	public void resume()
	{
		radius = 0;
		timeline1.play();	
	}
	
	//pauses the animation
	public void suspend()
	{
		timeline1.pause();	
	}
	
	//changes the color of firework
	public void changeColor(Color anotherColor)
	{
		color = anotherColor;	
	}
	
	//changes number of beams
	public void setBeamNumber(int beam)
	{
		beamNum = beam;
		angleSize = (360.0)/(beamNum*2);	
	}
	
	//sets speed
	public void setRate(int rate)
	{
		timeline1.setRate(rate);	
	}
	
	//clears and creates fireworks
	private class FireworkHandler implements EventHandler<ActionEvent>
	{
		public void handle(ActionEvent event)
		{
			getChildren().clear();	//clears arcs
			radius = radius + step; 
			angleSize = 360/(beamNum*2);
		    for (int currentAngle=0; currentAngle <= 360; currentAngle += 2*angleSize)
		    {
		        Arc arc1 = new Arc(centerX, centerY, radius, radius, currentAngle, angleSize);	//creates new arcs
		        arc1.setFill(color);
		        arc1.setStroke(color);
		        arc1.setType(ArcType.ROUND);
		        getChildren().add(arc1);
		    }
		    if(radius >= radiusLimit)	//if radius exceeds limit, sets radius to 0
		    {
		    	radius = 0;
		    }
		}
	}
}