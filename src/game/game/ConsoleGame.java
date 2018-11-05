package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.Timer;

/*
 * The main controller of the game. Handles all the key inputs and manages the graphics, bird and *timer*(just for notes)
 * ***TO DO***
 * -Create a new frame for the proper window size 
 * -Implement a keyboard listener
 * 
 */
public class ConsoleGame extends JFrame implements ActionListener, KeyListener{
	
	//public static final int FPS = 60;
	public static final int WIDTH = 640;
	public static final int HEIGHT = 480;
	private Bird b;
	private Timer clock;
	private int scoreCounter;
	private boolean paused, gameStart, gameOver;

	
	public void start()
	{
		clock = new Timer(100, this);
		clock.start();
		scoreCounter = 0;
		paused = false;
		gameStart = false;
		gameOver = false;
	}
	
	public ConsoleGame() 
	{
		// TODO Auto-generated constructor stub
		
	}
	
	
	//added gravity! bird starts falling by 5! Also checks if bird touches sky or floor!
	public void Gravity()
	{
		b.setY(b.getY() + 5);
		if(b.getY() > 460 || b.getY() <= 0)
		{
			gameOver = true;
		}
	}

	public void ActionPerformed(ActionListener e) 
	{
		if(paused == false)
		{
			b.physics();
		}
	}

	@Override
	public void keyTyped(KeyEvent e) 
	{
		// TODO Auto-generated method stub
		
	}


	// Will read keyboard inputs 
	@Override
	public void keyPressed(KeyEvent e) 
	{
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_SPACE) 
		{
			b.jump();
		}
		else if(e.getKeyCode() == KeyEvent.VK_ESCAPE) 
		{
			paused = true;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) 
	{
		// TODO Auto-generated method stub
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
	}
	
	public void setScore()
	{
		scoreCounter++;
	}
	
	public int getScore()
	{
		return scoreCounter;
	}
}
