package game;

import java.awt.Font;

import acm.graphics.GImage;
import starter.GraphicsApplication;

public class MainApplication extends GraphicsApplication 
{
	public static final int WINDOW_HEIGHT = 576;
	public static final int WINDOW_WIDTH = 1024;
	public static final int BUTTON_HEIGHT = 120;
	public static final int BUTTON_WIDTH = 50;
	
	private MenuPane menu;
	
	public static GImage background = new GImage("background.png", 0, 0);
	public static Font titleFont = new Font("Serif", Font.BOLD, 46);
	public static Font menuFont = new Font("Serif", Font.BOLD, 36);
	

	
	public void init() 
	{
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);		
	}
	
	public void run() 
	{
		menu = new MenuPane(this);
	}
}
