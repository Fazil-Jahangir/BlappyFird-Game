package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

import acm.graphics.GCompound;
import acm.graphics.GLabel;
import acm.graphics.GRoundRect;
import javafx.scene.control.Label;

public class GButton extends GCompound 
{
	private GRoundRect rect;
	private GLabel message;
	private Font customFont;
	
	public GButton(String label, double x, double y, double width, double height) 
	{
		this(label, x, y, width, height, Color.BLACK);
		/*
		try {
		    //create the font to use. Specify the size!
		    customFont = Font.createFont(Font.TRUETYPE_FONT, new File("8.ttf")).deriveFont(30f);
		    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		    //register the font
		    ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("8.ttf")));
		} 
		catch (IOException e) 
		{
		    e.printStackTrace();
		} catch(FontFormatException e) 
		{
		    e.printStackTrace();
		}
		*/				
	}
	
	public GButton(String label, double x, double y, double width, double height, Color col) 
	{
		setLocation(x, y);
		rect = new GRoundRect(0, 0, width, height);
		rect.setFilled(true);
		rect.setFillColor(col);
		add(rect);
		message = new GLabel(label);
		double centerX = width/2 - message.getAscent()/4;
		double centerY = height/2 + message.getAscent()/4;
		add(message, centerX, centerY);
	}
	
	public void setFillColor(Color col) 
	{
		rect.setFillColor(col);
	}
	
	public void setColor(Color col) 
	{
		message.setColor(col);
	}
	
	public void setFilled(boolean temp)
	{
		rect.setFilled(temp);
	}
	
	public GLabel getLabel()
	{
		return message;
	}
	
	public void setCustomFont()
	{
		//message.setFont(customFont);
		//message.setFont(new Font("Castellar", Font.BOLD, 35));
		message.setFont(new Font("Showcard Gothic", Font.BOLD, 35));	
	}	
}
