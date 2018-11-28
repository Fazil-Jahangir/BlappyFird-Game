/*
 * GameTest.java is the running Java Applet program
 */

package game;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
//import java.awt.Color;
import java.awt.event.*;

import javax.swing.Timer;
//import acm.util.RandomGenerator;

import acm.graphics.*;
//import acm.graphics.GOval;
import acm.program.*;

public class GameTest extends GraphicsPane implements ActionListener {
	
	private static final int WINDOW_HEIGHT = 535;
	private static final int WINDOW_WIDTH = 1000;

	/*
	 * private static int BIRD_SIZE = 50; private static final int BIRD_POSITION_X =
	 * 210; private static int BIRD_POSITION_Y = 300;
	 */

	private int NUMTIME = 0;
	private int backgroundSpeed = 2;
	private int score;
	private boolean gameEnded = false;
	private boolean paused = false;

	private Graphics background1 = new Graphics("background1.png", 0, 0, WINDOW_HEIGHT, WINDOW_WIDTH);
	private Graphics background2 = new Graphics("background2.png", 1280, 0, WINDOW_HEIGHT, WINDOW_WIDTH);
	
	private Timer timer;
	private MainApplication program;
	private Bird bird;
	private PipeGeneration pipes;
	private GLabel beginInstructions;
	private GLabel endGameLabel;
	private GLabel pauseMenuLabel;
	private GLabel scoreDisplay;
	private GLabel scoreLabel;
	
	private GButton restartGameButton;

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
		pipes = new PipeGeneration(app);
		timer = new Timer(1000 / 60, this);
		gameEnded = false;
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
		if (gameEnded != false) {
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
			//pipes.checkCollision2();
		
			//scoreManager();
		}
	}

	public void drawBackground() {
		background1.draw(program);
		background2.draw(program);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		/* if (gameEnded) {
		 * On Spacebar press, call birdJump() to make bird jump
		 * Spacebar when the game starts will allow the game to start
		 */
		
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			program.remove(beginInstructions);
			
			System.out.println("\nSPACEBAR pressed - calling jump()");
			gameEnded = true;
			bird.birdJump();
		}

		// Exit Pause menu
		if (paused == true) {
			if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
				System.out.println("\nCalling exitPauseMenu()");
				exitPauseMenu();
			}
		}
		
		// Enter Pause menu
		else if (paused == false) {
			if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
				System.out.println("\nESC pressed - calling pauseMenu()");
				pauseMenu();
			}
		}
		
		
	}
	//MOUSE PRESS FUNCTIONS

	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		
		if (obj == restartGameButton) {
			System.out.println("Restart Game button clicked");
			reset();
			restartGame();	
		}
	/*
		if (program.getElementAt(e.getX(), e.getY()) == returnLabel) {
			gameEnded = false;
			program.switchToMenu();
		} else {
			gameEnded = true;
			showContents();
		}
		*/
	}
	
	public void mouseReleased() {
		
	}
	
	public void mouseClicked() {
		
	}
	
	public void mouseEntered() {
		
	}
	
	public void mouseExited() {
		
	}
	
	
	public void scoreManager() {
		score++;
		
		scoreDisplay = new GLabel(Integer.toString(score), WINDOW_WIDTH / 2 - 200, WINDOW_HEIGHT / 2 - 80);
		scoreDisplay.setFont(new Font("Algerian", Font.BOLD, 30));
		scoreDisplay.setColor(Color.WHITE);
		program.add(scoreDisplay);
	}
	
	/*
	 * Helper method which displays "Press spacebar to begin"
	 * at beginning of the game
	 */
	public void beginGameInstructions() {
		beginInstructions = new GLabel("PRESS SPACEBAR TO BEGIN", WINDOW_WIDTH / 2 - 200, WINDOW_HEIGHT / 2);
		beginInstructions.setFont(new Font("Algerian", Font.BOLD, 26));
		beginInstructions.setColor(Color.WHITE);
		program.add(beginInstructions);
	}
	
	public void pauseMenu() {
		System.out.println("	pauseMenu() called\n");
		
		// Add pause menu title
		pauseMenuLabel = new GLabel("PAUSED", WINDOW_WIDTH / 2 - 70, WINDOW_HEIGHT / 2 - 50);
		pauseMenuLabel.setFont(new Font("Algerian", Font.BOLD, 44));
		pauseMenuLabel.setColor(Color.WHITE);
		program.add(pauseMenuLabel);
	
		paused = true;
		timer.stop();
	}
	
	public void exitPauseMenu() {		
		program.remove(pauseMenuLabel);
		paused = false;
		timer.start();
	}
	
	public void restartGame() {
		System.out.println("\nrestartGame() called");

		program.remove(endGameLabel);
		//program.remove(pauseMenuLabel);
		//program.remove(scoreDisplay);
		program.remove(scoreLabel);
		program.remove(restartGameButton);
		
		//drawBackground()
		gameEnded = false;
		beginGameInstructions();
		timer.restart();
		bird.drawBird();
	}
	
	public void endGame() {
		System.out.println("	endGame() called\n");
		gameEnded = true;
		
		// Add end game label
		endGameLabel = new GLabel("GAME ENDED!", WINDOW_WIDTH / 2 - 100, WINDOW_HEIGHT / 2 - 50);
		endGameLabel.setFont(new Font("Algerian", Font.BOLD, 26));
		endGameLabel.setColor(Color.WHITE);
		program.add(endGameLabel);
		
		timer.stop();
		
		// Add score label
		scoreLabel = new GLabel("Score: " + score, WINDOW_WIDTH / 2 - 50, WINDOW_HEIGHT / 2 - 10);
		scoreLabel.setFont(new Font("Algerian", Font.ITALIC, 18));
		scoreLabel.setColor(Color.WHITE);
		program.add(scoreLabel);
		
		// Add restart game button 
		
		restartGameButton = new GButton("Restart", WINDOW_WIDTH / 2 - 20, WINDOW_HEIGHT / 2 - 10, 100, 50);		
		program.add(restartGameButton);
		
		//program.remove(bird);
		
	}
	
	// Scrolling 2D background:
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
	
	public void reset()	{
		bird.birdReset();
		pipes.resetMap();
		resetBackground();
		drawBackground();
	}
	
	public void resetBackground() {
		background1.hideContents();
		background2.hideContents();
	}
	
	
	/*
	public boolean itemsCollisionTest(GImage image) {
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
	}
	*/

}
