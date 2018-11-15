package game;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.Timer;
import acm.util.RandomGenerator;
import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GObject;
import acm.graphics.GOval;
import acm.program.GraphicsProgram;

public class PipeGeneration extends GraphicsProgram implements ActionListener {

	private RandomGenerator rgen;
	
	private static final int WINDOW_HEIGHT = 576;
	private static final int WINDOW_WIDTH = 1024;
	private int numTime = 0;
	private ArrayList<Graphics> pipes;
	private Timer movement;
	private int pipeSpeed = 2;
	private Graphics g;
	private int x = 0;

	public void run() {
		rgen = RandomGenerator.getInstance();
		pipes = new ArrayList<Graphics>();
		movement = new Timer(50, this);
		movement.start();
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		numTime++;
		// System.out.println(NUMTIME);
		if (numTime % 100 == 0) {
			drawPipes();
		}
		movePipeImages();
	}

	public void init() {
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
	}

	public Graphics createPipes() {
		
		
		if (x % 2 != 0) {
			//Creates a pipe image
			g = new Graphics("pipeUp.png", 1024, rgen.nextInt(300, 500), WINDOW_HEIGHT, WINDOW_WIDTH);
			pipes.add(g);
		} else {
			g = new Graphics("pipeDown.png", 1024, rgen.nextInt(-250,10), WINDOW_HEIGHT, WINDOW_WIDTH);
			pipes.add(g);

		}
		x++;
	
		return g;

	}

	public void drawPipes() {
		Graphics p = createPipes();
		p.draw(this);
	}

	public void movePipeImages() {
		for (Graphics p : pipes) {
			System.out.println("x: " + p.getX() + "size: " + pipes.size());
			p.changeLocation((int) p.getX() - pipeSpeed, (int) p.getY());
		}
		

	}
	
	
	
	

}
