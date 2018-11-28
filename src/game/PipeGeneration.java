package game;

import java.awt.Color;
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
    private static final int WINDOW_HEIGHT = 576;
    private static final int WINDOW_WIDTH = 1024;

    // Store pipes in an ArrayList.
    private ArrayList < Graphics > pipes;
    private ArrayList < GRect > gRectBehindPipe;

    // Declarations
    private int pipeSpeed = 2;
    private Graphics g;
    private int x = 0;
    private MainApplication program;
    private GameTest game;

    private RandomGenerator rgen;
    private GRect rect;
    private Bird bird;


    // Constructor
    public PipeGeneration(MainApplication app) {
        program = app;
        rgen = RandomGenerator.getInstance();
        pipes = new ArrayList < Graphics > ();
        gRectBehindPipe = new ArrayList < GRect > ();
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
            temp = new Graphics("pipeUp.png", 1024, imgY, WINDOW_HEIGHT, WINDOW_WIDTH);
            rect = new GRect(1024, imgY, 55, imgY + 400);
            gRectBehindPipe.add(rect);
            rect.setColor(Color.BLACK);
            rect.setFilled(true);
            rect.setVisible(true);
            program.add(rect);
            pipes.add(temp);

        } else {
            imgY = rgen.nextInt(-250, 5);
            temp = new Graphics("pipeDown.png", 1024, imgY, WINDOW_HEIGHT, WINDOW_WIDTH);
            rect = new GRect(1024, imgY, 55, imgY + 400);
            gRectBehindPipe.add(rect);
            rect.setColor(Color.BLACK);
            rect.setFilled(true);
            rect.setVisible(true);
            program.add(rect);
            pipes.add(temp);
        }
        x++;
        System.out.println("TEST CREATE PIPES");
        return temp;
    }

    // Method will draw pipes to the Main controller of the game.
    public void drawPipes() {
        g = createPipes();
        g.draw(program);
        
        // Add test rectangle
        program.add(rect);
        //System.out.println("TEST DRAW PIPES");
    }

    /*
     * Method will move the pipes to left. Pipespeed will determine the speed of the
     * pipe's movements. If the speed is not desired, change the value of pipespeed.
     * The higher the number, the faster of the movement TODO Probably needs to be
     * set in float or double to have a smoother movement.
     * 
     */
    public void movePipeImages() {
        for (Graphics p: pipes) {
            //System.out.println("x: " + p.getX() + "size: " + pipes.size());
            p.changeLocation((int) p.getX() - pipeSpeed, (int) p.getY());
            p.changeFloatLocation((float) p.getX() - pipeSpeed, (float) p.getY());
        }
        for (GObject r : gRectBehindPipe) {
        	r.move(-4.001, 0);
        }
        //System.out.println("TEST MOVEMENT");
    }

    public void resetMap() {
        pipes.clear();
        for (Graphics p: pipes) {
            p.hideContents();
        }

    }

    /*
    
    //TEST COLLISION: DOES NOT WORK
    public void checkPipeCollision() {   
    	for (GObject r : gRectBehindPipe) {
        	
        	//System.out.println("Pipe Y: " + p.getElementAt(pipeY));
    		if (getElementAt(r.getLocation()) == bird.birdGetY()) {
    			if(rect.contains(bird.birdGetY())) {
    				
    			}
    		}
    	}
    	/*
        for (Graphics p: pipes) {
        	for (GObject r: gRectBehindPipe) {
        		double pipeYDouble = p.getY();
            	int pipeY = (int)pipeYDouble;
            	
            	//System.out.println("Pipe Y: " + p.getElementAt(pipeY));
            	
            	if(bird.getY() == r.getElementAt())	
        	}

        }
        */
    }

}

/*
 *
 *
 */