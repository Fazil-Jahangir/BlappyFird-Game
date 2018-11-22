package game;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import acm.graphics.GObject;
import acm.graphics.GRect;

public class MenuPane extends GraphicsPane 
{	
	private MainApplication program;
	
	private static GRect menuBox = new GRect(0, 150, 1000, 60);
	
	private String[] gbuttonStrings = { "Start Game", "Instructions", "Store", "Settings", "Quit" };
	private ArrayList<GButton> gButtons = new ArrayList<GButton>();
	
	public MenuPane(MainApplication app) 
	{
		program = app;
		for (int i = 0; i < 5; i++) 
		{
			GButton button = new GButton(gbuttonStrings[i], (MainApplication.WINDOW_WIDTH/2)-230, 160 + 70 * i, MainApplication.BUTTON_HEIGHT, MainApplication.BUTTON_WIDTH);
			button.setColor(Color.WHITE);
			button.setFilled(true);
			button.setCustomFont();
			gButtons.add(button);			
		}
		menuBox.setFillColor(Color.RED);
		menuBox.setFilled(true);
		menuBox.setVisible(false);
	}
	
	@Override
	public void showContents() 
	{
		program.add(MainApplication.background);
		program.add(menuBox);
		for (GButton button : gButtons)
		{
			program.add(button);
		}
		
	}

	@Override
	public void hideContents() 
	{
		program.remove(MainApplication.background);
		program.remove(menuBox);
		for (GButton button : gButtons) 
		{
			program.remove(button);
		}		
	}	
	
	@Override
	public void mousePressed(MouseEvent e) 
	{
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj == gButtons.get(0)) 
		{
			//program.switchToInstructions();
		}
		if (obj == gButtons.get(1)) 
		{
			//program.switchToSettings();
		}
		if (obj == gButtons.get(2)) 
		{
			program.switchToStore();
		}
		if (obj == gButtons.get(3)) 
		{
			program.switchToSettings();
		}
		if (obj == gButtons.get(4)) 
		{
			System.exit(0);
		}
	}
	
	@Override
	public void mouseMoved(MouseEvent e) 
	{
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj != null) 
		{
			for (GButton button : gButtons) 
			{
				highlightsButton(button, obj, 255, 255, 255);
			}
		}
	}
	
	public static void highlightsButton(GButton button, GObject obj, int r, int g, int b) 
	{
		Color highlightColor = new Color(r, g, b);
		if (obj == button)
		{
			menuBox.setVisible(true);
			menuBox.setLocation(0, button.getY());
			button.setFillColor(highlightColor);
		}			
		else 
		{
			button.setFillColor(Color.BLACK);
		}
	}
}
