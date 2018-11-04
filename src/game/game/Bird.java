package game;

import java.awt.Color;
import acm.graphics.GOval;
import acm.program.GraphicsProgram;
import java.awt.Graphics;
//TEMP
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


/*
 * The class bird will be in charge of how the bird will behave.
 * TODO
 * -Implement the physics class
 * 
 */
public class Bird {
	
	public float x, y;
	public float vx, vy;
	
	private GOval bird;
	private Physics p;
	
	
	public Bird()  {
		// TODO Auto-generated constructor stub
		
		x = ConsoleGame.WIDTH/2;
		y = ConsoleGame.HEIGHT/2;
		//TEMP Bird will be shape
		bird = new GOval(0,ConsoleGame.HEIGHT/2,25,25);
		
		

		
		
		
		
	}
	//Method will make the bird fly/jump. 
	public void jump() {
		vy += -8;
	}
	
	//Can use a separate physics class to handle physics.
	public void physics() {
		x += vx;
		y += vy;
		vy += 0.5f;
		/*float x = p.getX();
		float y = p.getY();
		x += vx;
		y += vy;*/
		
	}
	//Method will reset the bird's location
	public void reset() {
		x = 640/2;
		y = 480/2;
		vx = vy = 0;
	}
	
	
	


	
	
	

}
