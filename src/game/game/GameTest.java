package game;

//import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.Timer;
//import acm.util.RandomGenerator;

import acm.graphics.GLabel;
//import acm.graphics.GOval;
import acm.program.GraphicsProgram;

/*
 * RUN THIS PROGRAM
 */

public class GameTest extends GraphicsProgram implements ActionListener {

	// WINDOW PANEL SIZE
	private static final int WINDOW_HEIGHT = 576;
	private static final int WINDOW_WIDTH = 1024;

	/*
	 * private static int BIRD_SIZE = 50; private static final int BIRD_POSITION_X =
	 * 210; private static int BIRD_POSITION_Y = 300;
	 */

	private Timer timer;

	private int NUMTIME = 0;
	private boolean gameEnded = false;

	private Graphics background = new Graphics("background.png", 0, 0, WINDOW_HEIGHT, WINDOW_WIDTH);
	private Bird bird;
	private PipeGeneration pipes;

	// Window initialization. It will create the window dimensions for the game.
	public void init() {
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
	}

	public void run() {
		drawBackground();
		bird = new Bird(this);
		pipes = new PipeGeneration(this);
		timer = new Timer(1000 / 60, this);
		timer.start();
		bird.drawBird();
		addKeyListeners();

	}

	public void actionPerformed(ActionEvent e) {
		
		//Checks if the bird hits the ground
		if (bird.birdGetY() >= WINDOW_HEIGHT) {
			System.out.println("\nCOLLISION DETECTED! @ Bottom of screen... calling endGame() now");
			endGame();
		}
		
		NUMTIME++;
		if (NUMTIME % 150 == 0) {
			pipes.drawPipes();
		}
		pipes.movePipeImages();
		bird.birdPhysics();

	}

	public void drawBackground() {
		background.draw(this);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (gameEnded == false) {
			// On Spacebar press, call birdJump() to make bird jump
			if (e.getKeyCode() == KeyEvent.VK_SPACE) {
				System.out.println("\nSPACEBAR pressed - calling jump()");
				bird.birdJump();
			}

			
			 //On Escape press, call pauseMenu() 
			if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
				System.out.println("\nESC pressed - calling pauseMenu()");
				pauseMenu();
			}
			 
		}
	}
	
	//Method when the the game is ended
	/*
	 * TODO
	 * MENU PANE
	 */
	public void endGame() {
		System.out.println("	endGame() called\n");
		gameEnded = true;
		GLabel endGameLabel = new GLabel("Game Ended!", WINDOW_WIDTH / 2 - 50, WINDOW_HEIGHT / 2);
        add(endGameLabel);
        timer.stop();
	}
	//Method to pause the game
	/*
	 * TODO
	 * MENU PANE
	 */
	
	public void pauseMenu() {
		System.out.println("	pauseGame() called\n");
		timer.stop();
	}
	
	public void getScore() {
		
	}

}
