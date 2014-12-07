package maze;

/**
 * @author Patches
 *
 */
public class Location 
{
	private int x; //row
	private int y; //col
	
	/**
	 * @param x
	 * @param y
	 */
	public Location(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	/**
	 * @return
	 */
	public int getX()
	{
		return this.x;
	}
	
	/**
	 * @return
	 */
	public int getY()
	{
		return this.y;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
		return x+","+y;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object end) 
	{
		
		if(this.x == ((Location)end).getX() && this.y == ((Location)end).getY())
			return true;
		return false;
	}
}
