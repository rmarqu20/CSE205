//This program allow user to press, drag, then release
//the mouse key to draw multiple blue circles on screen.
//Driver program: MousePressDragReleaseDemo.java

import javafx.scene.layout.StackPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.event.EventHandler;		//***need to import
import javafx.scene.input.MouseEvent;	//***need to import

class CirclePane extends StackPane
{
	//point(x1,y1) is where we click the mouse key
	//and (x2,y2) is where we release the mouse key
	private double x1, y1, x2, y2;
	private Circle c1;		//a Circle object
	private Pane pane;

	public CirclePane()
	{
		//step #1: initialize each instance variable and set up layout
		x1 = y1 = x2 = y2 = 0;
		c1 = null;
		pane = new Pane();
		pane.setStyle("-fx-background-color: beige;"); //css
		this.getChildren().add(pane);

		//Step #3: Register the pane with the mouse handler object
		//Note: here you need to register all 3 events - pressed, dragged & released
		pane.setOnMousePressed(new CircleHandler());
		pane.setOnMouseDragged(new CircleHandler());
		pane.setOnMouseReleased(new CircleHandler());
	}
	//Step #2: Write a MouseEvent handling class
	private class CircleHandler implements EventHandler<MouseEvent>
	{
		public void handle(MouseEvent event)
		{
			if(event.getEventType()== MouseEvent.MOUSE_PRESSED)
            {
				//get the x & y coordinates where we click the mouse
				x1 = event.getX();
				y1 = event.getY();

				//create a circle object, put its center at (x1,y1)
				c1 = new Circle();
				c1.setCenterX(x1);
				c1.setCenterY(y1);

				//A non-finished cicle always has white color with black outline
				c1.setFill(Color.WHITE);
				c1.setStroke(Color.BLACK);

				//Add the circle on pane
				pane.getChildren().add(c1) ;
			}
			else if(event.getEventType() == MouseEvent.MOUSE_DRAGGED)
			{
				//During dragging, (tempX, tempY) is the point where
				//mouse key dragged to, it keeps changing.
				double tempX = event.getX();
				double tempY = event.getY();

				//The distance between (x1,y1) and (tempX, tempY) will be
				//the radius of the circle during dragging procedure
                double dx = Math.abs(tempX - x1);
                double dy = Math.abs(tempY - y1);
                double radius = Math.sqrt(dx*dx + dy*dy);

                //set circle's new radius during dragging
                c1.setRadius(radius);
			}
            else if (event.getEventType()== MouseEvent.MOUSE_RELEASED )
            {
				//Now the drawing of the circle is finished.
				//will need to set the final color of the circle.
				c1.setFill(Color.BLUE) ;
			}
		} //end handle()
	}//end DotsHandler class
}