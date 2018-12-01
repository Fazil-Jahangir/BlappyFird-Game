package game;

import java.awt.Color;
import java.awt.Font;
import acm.graphics.GImage;
import acm.graphics.GLabel;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Scanner;
import acm.graphics.GLabel;
import acm.graphics.GObject;
import acm.graphics.GRect;
import java.io.*;
import java.util.Collections;
import java.util.List;

public class LeaderboardsPane extends GraphicsPane 
{
	private MainApplication program;
	
	private GImage leaderboardsImage = new GImage("settings.png", 0, 0);
	private GLabel leaderboardLabel = new GLabel("Leaderboards: ", 300, 100);
	
	private File leaderboardsDirectory = new File("Leaderboard.txt");
	private boolean iFileExist = leaderboardsDirectory.exists();
	
	private ArrayList<GLabel> highScoreLabels = new ArrayList<GLabel>();
	private List<Integer> gameScores = new ArrayList<Integer>();
	
	public LeaderboardsPane(MainApplication app) throws IOException 
	{
		this.program = app;
		setLabel();
	}

	@Override
	public void showContents() 
	{
		try 
		{
			getScore();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		program.add(leaderboardsImage);
		program.add(leaderboardLabel);
		for (GLabel labels : highScoreLabels) 
		{
			program.add(labels);
		}
	}

	@Override
	public void hideContents() 
	{
		program.remove(leaderboardsImage);
		program.remove(leaderboardLabel);
		for (GLabel labels : highScoreLabels) 
		{
			program.remove(labels);
		}
	}
	
	public void setLabel() 
	{
		leaderboardLabel.setFont(new Font("Algerian", Font.BOLD, 75));		
		leaderboardLabel.setColor(Color.BLACK);
	}
	
	public void getScore()
	{
		
	}
}
