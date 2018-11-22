package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import acm.graphics.GImage;
import acm.graphics.GLabel;

public class SettingsPane extends GraphicsPane
{
	private MainApplication program;
	private GImage settingsImage = new GImage("settings.png", 0, 0);
	private GLabel settingsLabel = new GLabel("Settings", 300, 100);
		
	public SettingsPane(MainApplication app) 
	{
		this.program = app;
		settingsLabel.setFont(new Font("Algerian", Font.BOLD, 75));
		settingsLabel.setColor(Color.BLACK);
	}
	
	@Override
	public void showContents() 
	{
		program.add(settingsImage);
		program.add(settingsLabel);
	}
	
	@Override
	public void hideContents() 
	{
		program.remove(settingsImage);
		program.remove(settingsLabel);
	}
	
	@Override
	public void keyPressed(KeyEvent e) 
	{
		//On Escape press, goes back to menu screen
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) 
		{
			program.switchToMenu();
		}
	}
}
