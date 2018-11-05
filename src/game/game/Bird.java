package game;

import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;


/*
 * The class bird will be in charge of how the bird will behave.
 * TODO
 * -Implement the physics class
 * 
 */
public class Bird 
{
	
	public float x, y;
	public float vx, vy;
	private Physics p;
	
	
	public Bird()
	{
		x = ConsoleGame.WIDTH/2;
		y = ConsoleGame.HEIGHT/2;
		
	}
	
	//Method will make the bird fly/jump. 
	public void jump() 
	{
		vy += -8;
	}
	
	//Can use a separate physics class to handle physics.
	public void physics() 
	{
		x += vx;
		y += vy;
		vy += 0.5f;
		/*float x = p.getX();
		float y = p.getY();
		x += vx;
		y += vy;*/
		
	}
	
	//Method will reset the bird's location
	public void reset() 
	{
		x = 640/2;
		y = 480/2;
		vx = vy = 0;
	}
	
	//add the bird to 0,0 location. 
	public void draw(Graphics temp)
	{
		ImageIcon birdPic = new ImageIcon("path-location");
		temp.drawImage(birdPic.getImage(), 0, 0, null);
	}
	
	public void setX(float x)
	{
		this.x = x;
	}
	
	public void setY(float y)
	{
		this.y = y;
	}
	
	public float getX()
	{
		return x;
	}
	
	public float getY()
	{
		return y;
	}
	


	
	
	

}
