package game;

import java.awt.Color;
import java.awt.Font;

import acm.graphics.GImage;
import acm.graphics.GLabel;

public class LeaderboardsPane extends GraphicsPane 
{
	private MainApplication program;
	
	private GImage leaderboardsImage = new GImage("settings.png", 0, 0);
	private GLabel leaderboardLabel = new GLabel("Settings", 300, 100);
	
	public LeaderboardsPane(MainApplication app) 
	{
		this.program = app;
		setLabel();
	}

	@Override
	public void showContents() 
	{
		program.add(leaderboardsImage);
		program.add(leaderboardLabel);
	}

	@Override
	public void hideContents() 
	{
		program.remove(leaderboardsImage);
		program.remove(leaderboardLabel);
	}
	
	public void setLabel() {
		leaderboardLabel.setFont(new Font("Algerian", Font.BOLD, 75));		
		leaderboardLabel.setColor(Color.BLACK);
	}
}
