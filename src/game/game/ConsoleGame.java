package game;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.Timer;

import acm.graphics.GLabel;
import acm.graphics.GOval;
import acm.program.GraphicsProgram;

public class ConsoleGame extends GraphicsProgram implements ActionListener 
{
    private static final int WINDOW_HEIGHT = 740;
    private static final int WINDOW_WIDTH = 620;

    private GOval birdOval;
    private Timer timer;

    private boolean gameEnded;
    private boolean paused;
    private int yMovement;

    private static int BIRD_SIZE = 50;
    private static final int BIRD_POSITION_X = 210;
    private static int BIRD_POSITION_Y = 300;
    
    private Graphics robot = new Graphics("robot head.jpg", 100, 100, WINDOW_HEIGHT, WINDOW_WIDTH);

    public void run() 
    {
        timer = new Timer(100, this);

        birdOval = new GOval(BIRD_POSITION_X, BIRD_POSITION_Y, BIRD_SIZE, BIRD_SIZE);
        birdOval.setFillColor(Color.green);
        birdOval.setFilled(true);
        add(birdOval);
        robot.draw(this);

        addKeyListeners();

        timer.start();
    }
    
    public void drawBackground()
    {
    	
    }

    public void birdJump() 
    {
        System.out.println("	jump() called\n");
        // Move the bird upwards
        yMovement -= 100;
        // Update the bird's location
        birdOval.setLocation(BIRD_POSITION_X, BIRD_POSITION_Y + yMovement);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //System.out.println("actionPerformed() called");

    	// Validate if the bird hit the bottom of the screen
        if (birdOval.getY() >= WINDOW_HEIGHT) {
            System.out.println("\nCOLLISION DETECTED! @ Bottom of screen... calling endGame() now");

            endGame();
        } 
        
        else if (gameEnded == false) {

            /* yMovement is simulating gravity's downforce 
             * here, constantly pushing the bird down towards
             * the ground
             */
            yMovement += 5;

            // Update the bird's location now
            birdOval.setLocation(BIRD_POSITION_X,  BIRD_POSITION_Y + yMovement);

            System.out.println("Bird X: " + birdOval.getX() + " Bird Y: " + birdOval.getY());
        } 
        
        else if (!gameEnded) {
        	// Reset the yMovement variable
            yMovement = 0;
        }
    }
    
    
    /*
     * resetBirdLocation() is a helper function to 
     * quickly reset the bird back to the starting position
     */
    public void resetBirdLocation() {
        System.out.println("Bird location reset to original");

        birdOval.setLocation(BIRD_POSITION_X, BIRD_POSITION_Y);
    }
    
    
    // TODO: Implement pauseMenu()
    public void pauseMenu() {
        System.out.println("	pauseMenu() called\n");

        paused = true;
    }

    
    /*
     * endGame() is a feature function which runs specific
     * tasks when the game ends
     */
    public void endGame() {
        System.out.println("	endGame() called\n");

        gameEnded = true;

        // Set bird's location to the bottom of the screen
        birdOval.setLocation(WINDOW_HEIGHT, WINDOW_WIDTH);

        GLabel endGameLabel = new GLabel("Game Ended!", WINDOW_WIDTH / 2 - 50, WINDOW_HEIGHT / 2);
        add(endGameLabel);
    }

    public void repaint(Graphics g) {
        System.out.println("repaint() called");

        //birdOval.fillOval(BIRD_POSITION_X, BIRD_POSITION_Y, BIRD_SIZE, BIRD_SIZE);
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (gameEnded == false) {
        	
            // On Spacebar press, call birdJump() to make bird jump
        	if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                System.out.println("\nSPACEBAR pressed - calling jump()");

                birdJump();
            }
            
        	// On Escape press, call pauseMenu()
            if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                System.out.println("\nESC pressed - calling pauseMenu()");

                pauseMenu();
            }
        }
    }

    public void init() {
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
    }
}