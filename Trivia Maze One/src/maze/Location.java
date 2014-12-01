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
	public String toString()
	{
		return x+","+y;
	}
	
	@Override
	public boolean equals(Object end) 
	{
		
		if(this.x == ((Location)end).getX() && this.y == ((Location)end).getY())
			return true;
		return false;
	}
}
