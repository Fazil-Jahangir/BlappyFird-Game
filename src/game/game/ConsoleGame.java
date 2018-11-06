package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;

import acm.graphics.GOval;
import acm.program.GraphicsProgram;

/* The main controller of the game. Handles all the key inputs and manages the graphics, bird and *timer*(just for notes)
 * TODO: 
 * 	Create a JFrame for the proper window size 
 *  Implement a keyboard listener
 */
public class ConsoleGame extends GraphicsProgram implements ActionListener, KeyListener{
	
	//public static final int FPS = 60;
	private Bird b;
	private GOval bird;
	private Timer clock;
	private int scoreCounter;
	private boolean paused, gameStart, gameOver;
	
	private static final int WINDOW_HEIGHT = 740;
	private static final int WINDOW_WIDTH = 620;
	private static final int BIRD_SIZE = 50;
	private static final int BIRD_OFFSET_X= 80;
	private static final int BIRD_OFFSET_Y= 300;
	
	public void run()
	{
		clock = new Timer(100, this);
		
		clock.start();
		
		bird = new GOval(BIRD_OFFSET_X, BIRD_OFFSET_Y, BIRD_SIZE, BIRD_SIZE);	
		
		b = new Bird();
		
		add(bird);
		
		scoreCounter = 0;
		paused = false;
		gameStart = false;
		gameOver = false;
		
		//KeyListener listener = new KeyListener();
		addKeyListeners();
	}
	
	/* TODO: Test out   the gravity multipliers
	 * added gravity! bird starts falling by 5.
	 * Also checks if bird touches sky or floor.
	 */
	public void Gravity()
	{
		b.setY(b.getY() + 5);
		if(b.getY() > 460 || b.getY() <= 0)
		{
			gameOver = true;
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		/* TODO: 
		 * draw pillars here
		 */
		
		//System.out.println("actionPerformed called");
		
		if (paused == false)
		{
			b.birdPhysics();
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e) 
	{
		//System.out.println(e);
  
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_SPACE) 
		{
			b.birdJump();
		}
		else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) 
		{
			System.out.println("paused = true set, esc button pressed");
			paused = true;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) 
	{
		// TODO Auto-generated method stub
	}
	

	@Override
	public void keyTyped(KeyEvent e) 
	{
		// TODO Auto-generated method stub
		
	}
	
	public int getScore() {
		return scoreCounter;
	}
	
	public void setScore() {
		scoreCounter++;
	}
	
	public void init() {
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
	}
}
