package game;

import javax.swing.*;

/*
 * The Bird class will be in charge of the bird's behavior
 */
public class Bird {
	
	public float x, y;
	public float xspeed, yspeed;
	private Physics p;
	
	// Height and Width are to model the iPhone 6 Plus, rounded up
	private static final int WINDOW_HEIGHT = 420;
	private static final int WINDOW_WIDTH= 740;
	
	
	public Bird() 
	{
		x = ConsoleGame.WIDTH/2;
		y = ConsoleGame.HEIGHT/2;
		
	}
	
	/* birdJump() will make the bird fly/jump. 
	 * All that should be needed here is an downwards
	 * motion, hence yspeed iteration down. The bird will
	 * start falling down as gravity acts upon it
	 */
	public void birdJump() 
	{
		yspeed += 0;
	}
	
	/*
	 * The plan of attack in birdPhysics() is to simply create
	 * and use two instance variables, x/y, xspeed/yspeed, which
	 * both interact to determine initial location which then
	 * is added by the xspeed and yspeed multiplier
	 */
	
	// TODO: Implement PVector in birdPhysics() instead of integers
	// https://processing.org/tutorials/pvector/
	public void birdPhysics() 
	{
		// Original position is incremented by speed multiplier
		x += xspeed;
		y += yspeed;
		
		/* TODO: Test out the y-speed below, which
		 * will act as the downward gravity upon the bird
		 */
		yspeed += 0;
	}
	
	// resetBirdLocation() will reset the bird's location to original
	public void resetBirdLocation() 
	{
		x = WINDOW_HEIGHT/2;
		y = WINDOW_WIDTH/2;
		xspeed = yspeed = 0;
	}
	
	
	/* TODO: Add the bird to 0,0 location,
	 * we may need to think about using an 
	 * instance variable here
	 */
	public void draw(Graphics temp)
	{
		ImageIcon birdPic = new ImageIcon("path-location");

		// TODO: Get Bird picture
		//temp.drawImage(birdPic.getImage(), 0, 0, null);
	}
	
	public float getX() {
		return x;
	}
	
	public float getY() {
		return y;
	}
	
	public void setX(float x) {
		this.x = x;
	}
	
	public void setY(float y) {
		this.y = y;
	}
}
