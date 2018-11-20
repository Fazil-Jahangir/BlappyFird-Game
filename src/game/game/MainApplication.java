package game;

import java.awt.Color;
import acm.graphics.GImage;
import acm.graphics.GObject;
import acm.graphics.GRect;

public class MainApplication extends GraphicsApplication
{
	public static final int WINDOW_HEIGHT = 535;
	public static final int WINDOW_WIDTH = 1000;
	public static final int BUTTON_HEIGHT = 120;
	public static final int BUTTON_WIDTH = 50;
	
	private MenuPane menuPane;
	
	public static GImage background = new GImage("menu3.png", 0, 0);
	
	public void init() 
	{
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);		
	}
	
	public void run() 
	{
		menuPane = new MenuPane(this);
		switchToScreen(menuPane);
	}
	
	/*
	public static void highlightsButton(GButton button, GObject obj, int r, int g, int b) 
	{
		Color highlightColor = new Color(r, g, b);
		if (obj == button)
		{
			button.setFillColor(highlightColor);
		}			
		else 
		{
			button.setFillColor(Color.BLACK);
		}
	}
	*/
}
