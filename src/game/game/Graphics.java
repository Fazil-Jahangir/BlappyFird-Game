package game;
import acm.graphics.GImage;

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
		showContents();
	}
	
	//Setters:
	public void changeLocation(int xLoc, int yLoc)
	{
		img.setLocation(xLoc, yLoc);
	}
		
	public void setFileLocation(String fileLocation) 
	{
		this.fileLocation = fileLocation;
	}
	
	public void setHeight(int height) 
	{
		this.height = height;
	}
	
	public void setWidth(int width) 
	{
		this.width = width;
	}

	//Getters:
	public String getfileLocation() 
	{
		return fileLocation;
	}
	
	public double getX() 
	{
		return img.getX();
	}
	
	public double getY() 
	{
		return img.getY();
	}
	
	public int getHeight() 
	{
		return height;
	}
	
	public int getWidth() 
	{
		return width;
	}	
	
	public void showContents() 
	{
		program.add(img);
	}

	public void hideContents() 
	{
		program.remove(img);
	}
}
