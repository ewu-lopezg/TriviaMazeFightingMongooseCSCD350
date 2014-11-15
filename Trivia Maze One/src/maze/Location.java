package maze;

public class Location 
{
	//make private
	private int x; //row
	private int y; //col
	
	public Location(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	public int getX()
	{
		return this.x;
	}
	
	public int getY()
	{
		return this.y;
	}
	
}
