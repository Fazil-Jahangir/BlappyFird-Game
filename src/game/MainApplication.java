package game;

import java.awt.Color;
import acm.graphics.GImage;
import acm.graphics.GObject;
import acm.graphics.GRect;

public class MainApplication extends GraphicsApplication {
	public static final int WINDOW_HEIGHT = 535;
	public static final int WINDOW_WIDTH = 1000;
	public static final int BUTTON_HEIGHT = 250;
	public static final int BUTTON_WIDTH = 50;

	private MenuPane menuPane;
	private StorePane storePane;
	private SettingsPane settingsPane;
	private GameTest gamePane;
	private Instructions instructions;

	public static GImage background = new GImage("menu.png", 0, 0);

	public void init() {
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
	}

	public void run() {
		menuPane = new MenuPane(this);
		storePane = new StorePane(this);
		settingsPane = new SettingsPane(this);
		gamePane = new GameTest(this);
		instructions = new Instructions(this);
		switchToScreen(menuPane);
	}

	public void switchToMenu() {
		switchToScreen(menuPane);
	}

	public void switchToStore() {
		switchToScreen(storePane);
	}

	public void switchToSettings() {
		switchToScreen(settingsPane);
	}
	
	public void switchToGame() {
		switchToScreen(gamePane);
	}
	
	public void switchToInstructions() {
		switchToScreen(instructions);
	}
		
}
