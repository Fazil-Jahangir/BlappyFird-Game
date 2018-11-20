package game;

import starter.GButton;
import starter.GraphicsPane;
import java.awt.Color;
import java.util.ArrayList;
import acm.graphics.GLabel;
import acm.graphics.GObject;
import acm.graphics.GRect;

public class MenuPane extends GraphicsPane 
{
	
	private MainApplication program;
	
	private GButton newGame = new GButton("Start Game", (MainApplication.WINDOW_WIDTH/2)-58, 200, MainApplication.BUTTON_HEIGHT, MainApplication.BUTTON_WIDTH, Color.green);
	private GRect menuBox = new GRect(390, 50, 250, 500);
	private GLabel titleLabel = new GLabel("Blappy Fird", 397, 87.5);
	private GLabel menuLabel = new GLabel("MAIN MENU", 410, 166.6);
	
	private String[] gbuttonStrings = { "Instructions", "Settings", "High Scores", "Quit" };
	private ArrayList<GButton> gButtons = new ArrayList<GButton>();
	
	public MenuPane(MainApplication app) 
	{
		program = app;
		for (int i = 0; i <= 3; i++) 
		{
			GButton button = new GButton(gbuttonStrings[i], (MainApplication.WINDOW_WIDTH/2)-58, 270 + 70 * i, MainApplication.BUTTON_HEIGHT, MainApplication.BUTTON_WIDTH);
			button.setFillColor(Color.GREEN);
			gButtons.add(button);
			
		}
		titleLabel.setColor(Color.WHITE);
		menuLabel.setColor(Color.WHITE);
		titleLabel.setFont(MainApplication.titleFont);
		menuLabel.setFont(MainApplication.menuFont);
		menuBox.setFillColor(Color.BLACK);
		menuBox.setFilled(true);
		showContents();
	}
	
	@Override
	public void showContents() {
		program.add(MainApplication.background);
		program.add(menuBox);
		program.add(newGame);
		program.add(titleLabel);
		program.add(menuLabel);
		for (GButton button : gButtons) {
			program.add(button);
		}
		
	}

	@Override
	public void hideContents() {
		program.remove(menuBox);
		program.remove(newGame);
		program.remove(titleLabel);
		program.remove(menuLabel);
		for (GButton button : gButtons) {
			program.remove(button);
		}
		
	}
	
}
