import java.util.Random;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

/*
 * FollowBee Class
 * @author Andre Hansen
 */
public class FollowBee extends Bee{
	
	/*
	 * Initializing variables
	 */
	private QueenBee queen1;
	private Point2D targetDirection;
	private double p;
	private Point2D newDirection;
	private double speed;
	private double distanceToQueen;

	/*
	 * FollowBee Constructor
	 */
	public FollowBee(BeeWindow window, QueenBee queen1) {
		// TODO Auto-generated constructor stub
		super(window);
		p = Math.random()*0.3;
		distanceToQueen = queen1.getLocation().distance(this.getLocation());
		this.queen1 = queen1;
		targetDirection = queen1.getLocation().subtract(this.getLocation()).normalize();
		newDirection = (targetDirection.multiply(p).add(getDirection().multiply(1-p)).normalize());
		speed = Math.min(p*distanceToQueen,10);
		setSpeed(speed);
		setDirection(newDirection);
		move();
	}
	/*
	 * FollowBee Update Method
	 */
	@Override
	public void update(){
		p = Math.random()*0.3;
		distanceToQueen = queen1.getLocation().distance(this.getLocation());
		targetDirection = queen1.getLocation().subtract(this.getLocation()).normalize();
		newDirection = (targetDirection.multiply(p).add(getDirection().multiply(1-p)).normalize());
		speed = Math.min(p*distanceToQueen,15);
		setSpeed(speed);
		setDirection(newDirection);
		move();
	}

}
