package game;

import java.awt.Color;
import java.awt.Rectangle;
import java.util.ArrayList;
import acm.util.RandomGenerator;
import acm.graphics.GObject;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

/**
 * PipeGeneration class is a class that will handle generating pipe imaging,
 * spawning, and movement. Essentially this class will handle the behavior of
 * the pipes. TODO -Remove any unnecessary code in this class (if any) -Convert
 * the methods to work with the CONSOLEGAME. As of right now, it works with the
 * test demo I created. (Seth)
 */

public class PipeGeneration extends GraphicsProgram {
    // Window Dimensions
    //private static final int WINDOW_HEIGHT = 576;
    //private static final int WINDOW_WIDTH = 1024;

    // Store pipes in an ArrayList.
    private ArrayList < Graphics > pipes;
    //private ArrayList < GRect > gRectBehindPipe;
    private ArrayList < Rectangle > pipesTopRect;
    private ArrayList< Rectangle > pipesBotRect;

    // Declarations
    private int pipeSpeed = 5;
    private Graphics g;
    private int x = 0;
    private MainApplication program;
    private Rectangle boundsTop;
    private Rectangle boundsBot;
    

    private RandomGenerator rgen;
    private Bird bird;


    // Constructor
    public PipeGeneration(MainApplication app) {
        program = app;
        rgen = RandomGenerator.getInstance();
        pipes = new ArrayList < Graphics > ();
        pipesTopRect = new ArrayList<Rectangle>();
        pipesBotRect = new ArrayList<Rectangle>();
        boundsTop = new Rectangle();
        boundsBot = new Rectangle();
        bird = new Bird(app);
    }

    /*
     * Method will generate pipes throughout the map. Spawning is currently set as 1
     * UP facing pipe then 1 DOWN facing pipe then repeat. Although it's not
     * spawning randomly, it can be changed by updating the "x" value or changing it
     * entirely.
     */
    public Graphics createPipes() {
        // Controls spawn behavior
        Graphics temp;
        int imgY;
        if (x % 2 == 0) {
            // Creates pipe images
            imgY = rgen.nextInt(300, 500);
            temp = new Graphics("pipeUp.png", 1024, imgY, 280, 60);
            /*rect = new GRect(1024, imgY, 55, imgY + 400);
            gRectBehindPipe.add(rect);
            rect.setColor(Color.BLACK);
            rect.setFilled(true);
            rect.setVisible(true);
            program.add(rect);*/
            boundsTop = new Rectangle((int)temp.getX(),(int) temp.getY(), (int) temp.getWidth(),(int)temp.getHeight());
            pipes.add(temp);

        } else {
            imgY = rgen.nextInt(-250, 5);
            temp = new Graphics("pipeDown.png", 1024, imgY, 280, 60);
            /*rect = new GRect(1024, imgY, 55, 280);
            gRectBehindPipe.add(rect);
            rect.setColor(Color.BLACK);
            rect.setFilled(true);
            rect.setVisible(true);
            program.add(rect);*/
            boundsBot = new Rectangle((int)temp.getX(),(int) temp.getY(), (int) temp.getWidth(),(int)temp.getHeight());
            pipes.add(temp);
        }
        x++;
        //System.out.println("TEST CREATE PIPES: ");
        return temp;
    }

    // Method will draw pipes to the Main controller of the game.
    public void drawPipes() {
        g = createPipes();
        g.draw(program);
        
    }

    /*
     * Method will move the pipes to left. Pipespeed will determine the speed of the
     * pipe's movements. If the speed is not desired, change the value of pipespeed.
     * The higher the number, the faster of the movement TODO Probably needs to be
     * set in float or double to have a smoother movement.
     * 
     */
    /*
     * (SETH) Had to changeLocations, just made it easier and used int method of changeLocation. Was this below...
     *  p.changeLocation((int) p.getX() - pipeSpeed, (int) p.getY());
     *  p.changeFloatLocation((float) p.getX() - pipeSpeed, , (float) p.getY());
     */
    public boolean movePipeImages() {
    	for (Graphics p: pipes) {
    		int positionX = ((int) p.getX() - pipeSpeed);
        	int positionY = (int) p.getY();
            p.changeLocation(positionX, positionY);
			if (p.getfileLocation().equals("pipeUp.png")) {
				boundsBot.setLocation((int)p.getX(),(int) p.getY());
				//System.out.println("TEST BOT BOUNDS: " + boundsBot.getBounds());
			} else {
				boundsTop.setLocation((int)p.getX(),(int) p.getY());
				//System.out.println("TEST TOP BOUNDS: " + boundsTop.getBounds());
			}
			if(collision(Bird.bounds)) {
				return true;
			}
		}
    	return false;
    	/*
    	 * for (GObject r : gRectBehindPipe) {
        	r.move(-4.001, 0);
        }
    	 */
    }
    
    //Checks collision with Bird bounds
    public boolean collision(Rectangle bird) {
    	//return bird.intersects(boundsBot) || bird.intersects(boundsTop);
    	if(bird.intersects(boundsBot)) {
    		System.out.println("HIT BOT PIPE");
    		return true;
    	}
    	else if(bird.intersects(boundsTop)) {
    		System.out.println("HIT TOP PIPE");
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    

    public void resetMap() {
        pipes.clear();
        for (Graphics p: pipes) {
            p.hideContents();
        }
        x = 0;

    }



}

/*
 * public void checkPipeCollision() {   
    	for (GRect r : gRectBehindPipe) {
    		
    		//System.out.println(bird.birdGetX());
    		GRect gr = new GRect(bird.birdGetX(), bird.birdGetY(), 10, 10);
    		gr.setColor(Color.BLACK);
    		gr.setFilled(true);
    		gr.setVisible(true);
            program.add(gr);

    		if (r.getBounds().intersects(bird.getBirdTop())) {
    			System.out.println("Collided top of bird");
    			//game.endGame();
    		}

    	}
    }
 *
 */