import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import cs110Graphics.DrawingPane;
import javafx.application.Application;
import javafx.scene.paint.Color;

/**
 * 
 * @author Andre Hansen
 *
 */
public class BeeWindow extends DrawingPane {
	private FollowBee[] bees1 = new FollowBee[100];
	private FollowBee[] bees2 = new FollowBee[100];
	private QueenBee queen1 = new QueenBee(this);
	private QueenBee queen2 = new QueenBee(this);
	/**
	 * Creates a window. The window has a specific background color, and 
	 * calls update at a specific interval (in milliseconds) specified
	 * via the parameters to the super class constructor called in 
	 * super(...).
	 */
	public BeeWindow() {
		super(50, Color.BLACK);
	}

	/**
	 * This method is called when the window has appeared, and is finished
	 * initializing.
	 */
	@Override
	public void start() {
		queen1.setColor(Color.ORANGE);
		queen2.setColor(Color.RED);
		for (int i = 0; i < bees1.length; i++) {
			bees1[i] = new FollowBee(this, queen1);
			bees1[i].setColor(Color.WHITE);
		}
		for (int i = 0; i < bees2.length; i++) {
			bees2[i] = new FollowBee(this, queen2);
			bees2[i].setColor(Color.AQUA);
		}
	}
	
	
	/**
	 * This method is called at regular intervals, according to the time
	 * interval set in the constructor.
	 */
	@Override
	public void update() {
		Color[] names = { Color.WHITE, Color.PINK, Color.ORANGE};
		Random rand = new Random();
		int x = rand.nextInt (3);
		Color color = names[x];
		
		queen1.update();
		queen2.update();
		for (FollowBee bee : bees1) {
			bee.update();
			bee.setColor(color);
			
		}
		for (FollowBee bee : bees2) {
			bee.update();
		}
	}
	
	/**
	 * Launch the window. When the window is ready, start() will be called. After
	 * start() is finished, update() will start to be called at regular intervals.
	 * @param args
	 */
	public static void main(String[] args) {
		Application.launch(args);
	}


}
