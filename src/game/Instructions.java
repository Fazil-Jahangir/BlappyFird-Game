package game;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;

import acm.graphics.GImage;
import acm.graphics.GLabel;

public class Instructions extends GraphicsPane {
	private MainApplication program;
	
	private GImage spaceBar = new GImage("spacebar.png", (MainApplication.WINDOW_WIDTH/2) - 280, 230);
	private GImage escape = new GImage("escape.png", (MainApplication.WINDOW_WIDTH/2) + 200, 230);
	private GLabel title = new GLabel("INSTRUCTIONS", (MainApplication.WINDOW_WIDTH/2) - 150, 200);
	private GLabel esc = new GLabel("Press Esc to MENU/PAUSE", (MainApplication.WINDOW_WIDTH/2) + 100, 350);
	private GLabel instructions = new GLabel("Press Space to Fly/Jump", (MainApplication.WINDOW_WIDTH/2) - 400, 350);
	private GLabel instructions1 = new GLabel("Objective: Your goal is to avoid hitting the pipes.", (MainApplication.WINDOW_WIDTH/2) - 380, 450);
	private GLabel instructions2 = new GLabel("Survive as long as you can! Earn most points!", (MainApplication.WINDOW_WIDTH/2) - 230, 485);
	public static GImage background = new GImage("settings.png", 0, 0);
	
	public Instructions(MainApplication app) {
		program = app;
		
		setEsc();
		setTitle();
		setInstructions();
	}
	

	@Override
	public void showContents() {
		program.add(background);
		program.add(spaceBar);
		program.add(escape);
		program.add(title);
		program.add(esc);
		program.add(instructions);
		program.add(instructions1);
		program.add(instructions2);
		
	}

	@Override
	public void hideContents() {
		program.remove(escape);
		program.remove(spaceBar);
		program.remove(title);
		program.remove(esc);
		program.remove(instructions);
		program.remove(instructions1);
		program.remove(instructions2);
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
		instructions2.setColor(Color.WHITE);
		instructions2.setFont(new Font("Showcard Gothic", Font.BOLD, 24));
		instructions.setFont(new Font("Showcard Gothic", Font.BOLD, 24));
	}
	
	public void setTitle() {
		title.setColor(Color.WHITE);
		title.setFont(new Font("Showcard Gothic", Font.BOLD, 35));
	}
}
