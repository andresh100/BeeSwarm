package cs110Graphics;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * Creates an application window with a drawing pane.
 * @author pipWolfe 
 */
public abstract class DrawingPane extends Application {
    public static final int PANE_X_DIM = 1000;
    public static final int PANE_Y_DIM = 600;
    private int millisec = 100;
    Pane pane;
    private Scene scene;

    /**
     * Construct the window with the specified background color and
     * animation speed.
     * @param millisec Animation speed, in thousandths of a second.
     * @param backgroundColor Background color for the drawing pane.
     */
    public DrawingPane(int millisec, Color backgroundColor) {
        pane = new Pane();
        BackgroundFill myBF = new BackgroundFill(backgroundColor, new CornerRadii(1),
         new Insets(0.0,0.0,0.0,0.0));// or null for the padding
        pane.setBackground(new Background(myBF));
        this.millisec = millisec;
        scene = new Scene(pane, PANE_X_DIM, PANE_Y_DIM);

    }
    

    /**
     * Called when the window is ready.
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Project"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage

        setUpAnimation(); // set up a timeline
        primaryStage.show(); // Display the stage
        start(); // let the subclasses know that everything is ready.
    }

    /**
     * Sets up an animation with no fixed termination time.
     */
    protected void setUpAnimation() {
        // Create a handler
        EventHandler<ActionEvent> eventHandler = (ActionEvent e) -> {
            update();
        };
        // Create an animation for alternating text
        Timeline animation = new Timeline(new KeyFrame(Duration.millis(millisec), eventHandler));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();
    }

    
    /**
     * The size of the window in the x dimension
     * @return the window's x dimension
     */
    public int xWindowSize() {
        return (int) pane.getWidth();
    }

    /**
     * The size of the window in the y dimension.
     * @return the window's y dimension
     */
    public int yWindowSize() {
        return (int) pane.getHeight();
    }

    /**
     * Adds a circle to the drawing pane, causing it to show
     * up in the window.
     * @param circle to be added to window
     */
    public void addShape(Shape shape) {
        pane.getChildren().add(shape);
    }

    
    /**
     * This method is called periodically by the animation. Override in subclasses
     * to do something useful.
     */
    abstract public void update();

    /**
     * This method is called when the window is ready (javafx start has finished).
     */
    abstract public void start();

}
