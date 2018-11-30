package game;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;

import acm.graphics.GImage;
import acm.graphics.GLabel;

public class Instructions extends GraphicsPane {
	
	private MainApplication program;
	
	private GImage spaceBar = new GImage("spacebar.png", (MainApplication.WINDOW_WIDTH/2) - 60, 250);
	private GLabel title = new GLabel("INSTRUCTIONS", (MainApplication.WINDOW_WIDTH/2) - 150, 150);
	private GLabel esc = new GLabel("ESC RETURN TO MENU", 0, 20);
	private GLabel instructions = new GLabel("Press Space to Fly/Jump", (MainApplication.WINDOW_WIDTH/2) - 150, 400);
	private GLabel instructions1 = new GLabel("Your goal is to avoid hitting the pipes. Survive as long as you can", (MainApplication.WINDOW_WIDTH/2) - 400, 450);
	public static GImage background = new GImage("menu.png", 0, 0);
	
	public Instructions(MainApplication app) {
		program = app;
		setEsc();
		setTitle();
		setInstructions();
	}
	

	@Override
	public void showContents() {
		// TODO Auto-generated method stub
		program.add(background);
		program.add(spaceBar);
		program.add(title);
		program.add(esc);
		program.add(instructions);
		program.add(instructions1);
		
	}

	@Override
	public void hideContents() {
		// TODO Auto-generated method stub
		program.remove(spaceBar);
		program.remove(title);
		program.remove(esc);
		program.remove(instructions);
		program.remove(instructions1);
		program.remove(background);
	}
	
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == (KeyEvent.VK_ESCAPE)) {
			program.switchToMenu();
			hideContents();
		}
	}
	
	public void setEsc() {
		esc.setColor(Color.WHITE);
		esc.setFont(new Font("Showcard Gothic", Font.BOLD, 24));
	}
	
	public void setInstructions() {
		instructions.setColor(Color.WHITE);
		instructions1.setColor(Color.WHITE);
		instructions1.setFont(new Font("Showcard Gothic", Font.BOLD, 24));
		instructions.setFont(new Font("Showcard Gothic", Font.BOLD, 24));
	}
	
	public void setTitle() {
		title.setColor(Color.WHITE);
		title.setFont(new Font("Showcard Gothic", Font.BOLD, 35));
	}



	
}
