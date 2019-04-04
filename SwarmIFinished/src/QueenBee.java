import java.util.Random;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

/*
 * QueenBee Class
 */
public class QueenBee extends Bee{
	private BeeWindow window;
	
	/*
	 * QueenBee Constructor
	 */
	public QueenBee (BeeWindow window) {
		/**
		 * Initializes the objects used by the default constructor
		 */
		super(window);
		this.window = window;
		getBeeLine().setStrokeWidth(4);
	}
	
	/**
	 * Method to update QueenBee.
	 */
	@Override
	public void update() {
		setSpeed(10);
		double xDir = getDirection().getX() + Math.random()-0.5;
		double yDir = getDirection().getY() + Math.random()-0.5;
		/**
		 * If statement for x-bounds of the screen in order for the bee to bounce.
		 */
		if (getBeeLine().getEndX() < 0) {
			xDir = Math.abs(xDir);
		}
	    if (getBeeLine().getEndX() > window.xWindowSize()) {
	    	xDir = -Math.abs(xDir);
		}
	    /**
		 * If statement for y-bounds of the screen in order for the bee to bounce.
		 */
		if (getBeeLine().getEndY() < 0) {
			yDir = Math.abs(yDir);	
		}
		if (getBeeLine().getEndY() > window.yWindowSize()) {
			yDir = -Math.abs(yDir);
		}
		setDirection(new Point2D(xDir,yDir));
		setSpeed(getSpeed() * 1.05);
		move();
	}

}