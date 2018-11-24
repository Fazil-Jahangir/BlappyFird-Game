package game;

import java.awt.Color;
import acm.graphics.GImage;
import acm.graphics.GObject;
import acm.graphics.GRect;
import starter.AudioPlayer;

public class MainApplication extends GraphicsApplication
{
	public static final int WINDOW_HEIGHT = 535;
	public static final int WINDOW_WIDTH = 1000;
	public static final int BUTTON_HEIGHT = 120;
	public static final int BUTTON_WIDTH = 50;
	
	private GameTest gamePane;
	private MenuPane menuPane;
	private StorePane storePane;
	private SettingsPane settingsPane;
	
	public static GImage background = new GImage("menu.png", 0, 0);
	
	public void init() 
	{
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);		
	}
	
	public void run() 
	{
		menuPane = new MenuPane(this);
		//gamePane = new GameTest(this);
		storePane = new StorePane(this);
		settingsPane = new SettingsPane(this);
		switchToScreen(menuPane);
	}
	
	public void switchToMenu() 
	{
		//playSound();
		switchToScreen(menuPane);
	}
	
	public void switchToStore() 
	{
		switchToScreen(storePane);
	}
	
	public void switchToSettings() 
	{
		switchToScreen(settingsPane);
	}
	
	/*
	public void switchToGame()
	{
		switchToScreen(GameTest);
	}
	*/
	
	private void playSound() 
	{
		AudioPlayer audio = AudioPlayer.getInstance();
		audio.playSound("sounds", "happy.mp3");
	}
}
