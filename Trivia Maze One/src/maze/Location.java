package maze;

/**
 * @author Team: fighting mongoose
 *
 */
public class Location 
{
	private int x; //row
	private int y; //col
	
	/**
	 * @param x the row
	 * @param y the column
	 */
	public Location(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	/**
	 * @return returns the x(row) value
	 */
	public int getX()
	{
		return this.x;
	}
	
	/**
	 * @return returns the y(column) value
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
