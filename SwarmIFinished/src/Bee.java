import java.util.Random;


import cs110Graphics.DrawingPane;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

/**
 * Models a Bee, which moves around the screen. The Bee is drawn 
 * as a line which traces its path from one point to another.
 * @author Andre Hansen
 *
 */
public class Bee {
	
	Bee() {
		
	}
	
	private BeeWindow window;
	private Line beeLine;
	private double speed;
	private Point2D direction;

	/**
	 * Creates a Bee in the specified window. The Bee starts
	 * out at a random location, with speed 2 and a direction
	 * at a 45 degree angle.
	 * @param window
	 */
	public Bee(BeeWindow window) {
		this.window = window;
		Random random = new Random();
		double startX = random.nextInt(window.xWindowSize());
		double startY = random.nextInt(window.yWindowSize());
		beeLine = new Line(startX, startY, startX, startY);
		setSpeed(2);
		setDirection(new Point2D(1, 1));
		move();
		window.addShape(beeLine);
		beeLine.setStrokeWidth(2);
		beeLine.setStroke(Color.WHITE);
		
	}
	
	/**
	 * Moves the Bee by the Bee's current direction and speed. 
	 * The Bee's line is drawn from its old location to its 
	 * new location after moving.
	 */
	public void move() {
		// get the old location
		double oldX = beeLine.getEndX();
		double oldY = beeLine.getEndY();
		
		// get the new location
		Point2D movement = direction.multiply(speed);
		double newX = oldX + movement.getX();
		double newY = oldY + movement.getY();
		
		// update the line ends
		beeLine.setStartX(oldX);
		beeLine.setStartY(oldY);
		beeLine.setEndX(newX);
		beeLine.setEndY(newY);
	}
	
	/**
	 * Gets the Bee's location
	 * @return the latest location of the bee.
	 */
	Point2D getLocation() {
		return new Point2D(beeLine.getEndX(), beeLine.getEndY());
	}
	
	public Line getBeeLine(){
		return beeLine;
	}
	
	public Point2D getDirection() {
		  return direction;
		}
	
	/**
	 * Sets the Bee's speed.
	 * @param speed
	 */
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	
	/**
	 * Gets the Bee's current speed
	 * @return the current speed
	 */
	public double getSpeed() {
		return speed;
	}
	
	/**
	 * Sets the direction of the Bee.
	 * @param direction
	 */
	public void setDirection(Point2D direction) {
		this.direction = direction.normalize();
	}
	
	public DrawingPane window(){
		return window;
	}
	
	public void setColor(Color color) {
        beeLine.setStroke(color);
    }
	
	/**
	 * Take out the code below, or override it in the subclasses.
	 */
	public void update() {
		// get the components of the old direction
		double xDir = direction.getX() + Math.random()-0.5;
		double yDir = direction.getY() + Math.random()-0.5;
		
		// update, if beyond one of the edges
		if (beeLine.getEndX() < 0) {
			xDir = Math.abs(xDir);	
			beeLine.setStroke(Color.DARKSLATEBLUE);
			setSpeed(2);
		}
	    if (beeLine.getEndX() > window.xWindowSize()) {
			xDir = -Math.abs(xDir);
			beeLine.setStroke(Color.BLUEVIOLET);
			setSpeed(2);
		}
		if (beeLine.getEndY() < 0) {
			yDir = Math.abs(yDir);
			beeLine.setStroke(Color.MIDNIGHTBLUE);
			setSpeed(2);			
		}
		if (beeLine.getEndY() > window.yWindowSize()) {
			yDir = -Math.abs(yDir);
			beeLine.setStroke(Color.DARKGREEN);
			setSpeed(2);
		}
		// apply the updates
		setDirection(new Point2D(xDir, yDir));
		setSpeed(getSpeed()*1.05);
		move();
	}

}
