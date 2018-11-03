package game;

/*
 * The class bird will be in charge of how the bird will behave.
 */
public class Bird {
	
	public float x, y, vx, vy;
	
	public static final int RAD = 25;
	//private Physics p;
	
	
	
	public Bird() {
		// TODO Auto-generated constructor stub
		x = ConsoleGame.WIDTH/2;
		y = ConsoleGame.HEIGHT/2;
		
	}
	//Method will make the bird fly/jump. 
	public void jump() {
		vy = -8;
	}
	
	public void physics() {
		x += vx;
		y += vy;
		vy += 0.5f;
		//p.setX(vx);
	}
	//Method will reset the bird's location
	public void reset() {
		x = 640/2;
		y = 640/2;
		vx = vy = 0;
	}
	
	
	

}
