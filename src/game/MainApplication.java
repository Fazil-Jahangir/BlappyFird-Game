package game;

import acm.graphics.GImage;
import game.AudioPlayer;

public class MainApplication extends GraphicsApplication {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final int WINDOW_HEIGHT = 535;
	public static final int WINDOW_WIDTH = 1000;
	public static final int BUTTON_HEIGHT = 250;
	public static final int BUTTON_WIDTH = 50;
	
	public static boolean isSoundOn = true;

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
		switchToMenu();
	}

	public void switchToMenu() {
		AudioPlayer audio = AudioPlayer.getInstance();
		if (isSoundOn) {
			audio.playSound("sounds", "menuBeat.wav");
		}
		switchToScreen(menuPane);
	}

	public void switchToStore() {
		switchToScreen(storePane);
	}

	public void switchToSettings() {
		switchToScreen(settingsPane);
	}
	
	public void switchToGame() {
		muteSound();
		switchToScreen(gamePane);
	}
	
	public void switchToInstructions() {
		switchToScreen(instructions);
	}
	
	public void muteSound() {
		AudioPlayer audio = AudioPlayer.getInstance();
		audio.stopSound("sounds", "menuBeat.wav");
	}		
}
