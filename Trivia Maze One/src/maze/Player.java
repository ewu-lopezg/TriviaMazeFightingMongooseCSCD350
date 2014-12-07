package maze;

/**
 * @author Patches
 *
 */
public class Player 
{
	Location curr;
	Location end;
	
	/**
	 * @param passed
	 * @param end
	 */
	public Player(Location passed, Location end)
	{
		this.curr = passed;
		this.end = end;
		
	}
	
	/**
	 * @param newLocation
	 */
	public void move(Location newLocation)
	{
		this.curr = newLocation;
	}
	
	/**
	 * @return
	 */
	public Location getLocation()
	{
		return this.curr;
	}
	
	/**
	 * @return
	 */
	public Location getEnd()
	{
		return this.end;
	}
	
	/**
	 * @return
	 */
	public boolean won()
	{
		if(this.curr.equals(this.end))
			return true;
		return false;
	}

}
