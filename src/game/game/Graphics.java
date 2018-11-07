package game;
import javax.swing.*;
import acm.graphics.GImage;
import starter.MainApplication;

import java.awt.*;

public class Graphics 
{
	private String fileLocation;
	private int x;
	private int y;
	private int width;
	private int height;
	private GImage img;
	private ConsoleGame program;
	
	public Graphics(String fileLocation, int x, int y, int height, int width) 
	{
		this.fileLocation = fileLocation;
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
	}
	
	/* TODO: Add the bird to 0,0 location,
	 * we may need to think about using an 
	 * instance variable here
	 */
	public void draw(ConsoleGame app)
	{
		this.program = app;
		img = new GImage(fileLocation, x, y);
		program.add(img);
	}
	
	/*
	@Override
	public void showContents() 
	{
		program.add(img);
	}

	@Override
	public void hideContents() 
	{
		program.remove(img);
	}
	*/
}
