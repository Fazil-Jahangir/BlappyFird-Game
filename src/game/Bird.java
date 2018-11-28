package game;

import javax.swing.*;
import acm.program.GraphicsProgram;

/*
 * The Bird class will be in charge of the bird's behavior and graphics
 * TODO
 * Make another enum class to choose different skins. *DO LATER*
 */
public class Bird extends GraphicsProgram {
	
	//Declarations
	//public float x, y;
	//public float xspeed, yspeed;
	private Physics p = new Physics();
	private MainApplication program;
	private Graphics g;

	//Screen Dimensions for Bird scaling
	private static final int WINDOW_HEIGHT = 576;
	private static final int WINDOW_WIDTH = 1024;

	public Bird(MainApplication app) {
		program = app;
	}
	
	public void drawBird() {
		g = createBird();
		g.draw(program);
		System.out.println("TEST BIRD DRAW");
	}
	
	/*
	 * TODO
	 * -Make the file flexible, doesn't have to always be the 'flappy bird'. Players should be able to choose what character they want to be.
	 */
	public Graphics createBird() {
		Graphics temp;
		temp = new Graphics("flappy-bird.png", 150, 250, WINDOW_HEIGHT, WINDOW_WIDTH);
		return temp;
	}

	/*
	 * birdJump() will make the bird fly/jump. All that should be needed here is an
	 * downwards motion. It pull the birdJump method created in the Physic's class. 
	 */
	public void birdJump() {
		p.birdJump();
		g.changeFloatLocation(p.getX(), p.getY());
		System.out.println("BIRD JUMP");
	}

	/*
	 * 
	 * 
	 */

	//MEthod will be in charge of 
	public void birdPhysics() {
		p.birdPhysics();
		g.changeFloatLocation(p.getX(), p.getY());

	}
	
	public float birdGetY() {
		System.out.println("Y VALUE: " + p.y);
		return p.y;
	}
	
	public void birdReset() {
		p.setX(100);
		p.setY(100);
		g.hideContents();
	}

	// resetBirdLocation() will reset the bird's location to original
	/*public void resetBirdLocation() {
		x = WINDOW_HEIGHT / 2;
		y = WINDOW_WIDTH / 2;
		xspeed = yspeed = 0;
	}*/
	
	
	

	
}
