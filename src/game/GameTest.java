
/*
 * GameTest.java is the running Java Applet program
 */

package game;

import java.awt.Color;
import java.awt.Font;
//import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import javax.swing.Timer;
//import acm.util.RandomGenerator;

import acm.graphics.GImage;
import acm.graphics.GLabel;
//import acm.graphics.GOval;
import acm.program.GraphicsProgram;

public class GameTest extends GraphicsPane implements ActionListener {

	// WINDOW PANEL SIZE
	private static final int WINDOW_HEIGHT = 535;
	private static final int WINDOW_WIDTH = 1000;

	/*
	 * private static int BIRD_SIZE = 50; private static final int BIRD_POSITION_X =
	 * 210; private static int BIRD_POSITION_Y = 300;
	 */

	private Timer timer;

	private int NUMTIME = 0;
	private int backgroundSpeed = 2;
	private boolean gameEnded = false;
	private boolean removeStartLabel = false;

	private Graphics background1 = new Graphics("background1.png", 0, 0, WINDOW_HEIGHT, WINDOW_WIDTH);
	private Graphics background2 = new Graphics("background2.png", 1280, 0, WINDOW_HEIGHT, WINDOW_WIDTH);
	
	private MainApplication program;
	private Bird bird;
	private PipeGeneration pipes;
	private GLabel beginInstructions;

	// Window initialization. It will create the window dimensions for the game.
	/*public void init() {
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
	}*/
	
	public GameTest(MainApplication app) {
		program = app;
		drawBackground();
		bird = new Bird(app);	
		pipes = new PipeGeneration(app, bird);
		timer = new Timer(1000 / 60, this);
		gameEnded = false;
		
		// "Press Spacebar to begin"
		beginGameInstructions();
		
		timer.start();
		bird.drawBird();
	}
	@Override
	public void showContents() {
		program.add(bird);
		program.add(pipes);
	}
	@Override
	public void hideContents() {
		program.remove(bird);
		program.remove(pipes);
	}

	public void actionPerformed(ActionEvent e) {
		if (gameEnded == true) {
			scrollingBackground();
			
			// Checks if the bird hits the ground
			if (bird.birdGetY() >= WINDOW_HEIGHT) {
				System.out.println("\nCOLLISION DETECTED! @ Bottom of screen... calling endGame() now");
				endGame();
			}
			
			NUMTIME++;
			if (NUMTIME % 50 == 0) {
				pipes.drawPipes();
			}
			// TODO: Checks if bird hits a pipe
			pipes.movePipeImages();
			bird.birdPhysics();
			pipes.checkCollision2();
		}
	}

	public void drawBackground() {
		background1.draw(program);
		background2.draw(program);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		//if (gameEnded) {
		// On Spacebar press, call birdJump() to make bird jump
		// Spacebar when the game starts will allow the game to start
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			program.remove(beginInstructions);
			
			System.out.println("\nSPACEBAR pressed - calling jump()");
			gameEnded = true;
			bird.birdJump();
		}

		// On Escape press, call pauseMenu()
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			System.out.println("\nESC pressed - calling pauseMenu()");
			pauseMenu();
		}

		//}
	}
	//MOUSE PRESS FUNCTIONS
	/*public void mousePressed(MouseEvent e) {
		if (program.getElementAt(e.getX(), e.getY()) == returnLabel) {
			gameEnded = false;
			program.switchToMenu();
		} else {
			gameEnded = true;
			showContents();
		}
	}*/

	// Method when the the game is ended
	/*
	 * TODO MENU PANE
	 */
	public void endGame() {
		System.out.println("	endGame() called\n");
		gameEnded = true;
		GLabel endGameLabel = new GLabel("Game Ended!", WINDOW_WIDTH / 2 - 50, WINDOW_HEIGHT / 2);
		program.add(endGameLabel);
		timer.stop();
	}
	// Method to pause the game
	/*
	 * TODO MENU PANE
	 */

	public void pauseMenu() {
		System.out.println("	pauseGame() called\n");
		timer.stop();
	}
	
	/*
	 * Helper method which displays "Press spacebar to begin"
	 * at beginning of the game
	 */
	public void beginGameInstructions() {
		// "Press Spacebar to begin"
		beginInstructions = new GLabel("PRESS SPACEBAR TO BEGIN", WINDOW_WIDTH / 2 - 200, WINDOW_HEIGHT / 2);
		beginInstructions.setFont(new Font("Algerian", Font.BOLD, 26));
		beginInstructions.setColor(Color.WHITE);
		program.add(beginInstructions);
	}


	// scrolling 2D background:
	public void scrollingBackground() {
		// Moves background image:
		if (background1.getX() > -1260) {
			background1.changeLocation(background1.getX() - backgroundSpeed, background1.getY());
			System.out.println("BACKGROUND1x: " + background1.getX());
		} else {
			background1.changeLocation(1260, background1.getY());
		}
		if (background2.getX() > -1260) {
			background2.changeLocation(background2.getX() - backgroundSpeed, background2.getY());
			System.out.println("BACKGROUND2x: " + background2.getX());
		} else {
			background2.changeLocation(1260, background2.getY());
		}
	}
	
	
	
	/*public boolean itemsCollisionTest(GImage image) {
		return (monkey.getY() - image.getY() <= Y_MONKEY_COLLISION
				&& monkey.getY() - image.getY() >= -Y_MONKEY_COLLISION
				&& monkey.getX() - image.getX() <= X_MONKEY_COLLISION
				&& monkey.getX() - image.getX() >= -X_MONKEY_COLLISION);
	}
	
	public void checkForCollision() {
		for (Items item : listOfItems)
			if (item.getGImage().isVisible() && itemsCollisionTest(item.getGImage())) {
				checkForTypeScore(item);
				item.getGImage().setVisible(false);
			}
	}*/

}
