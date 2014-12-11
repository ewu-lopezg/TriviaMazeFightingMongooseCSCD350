package maze;

/**
 * @author Team: fighting mongoose
 *
 */
public class Player 
{
	Location curr;
	Location end;
	
//creates a player at a passed location and end destination
	public Player(Location passed, Location end)
	{
		this.curr = passed;
		this.end = end;
		
	}
	
	//moves player to new location
	public void move(Location newLocation)
	{
		this.curr = newLocation;
	}
	
	//gets the player current location
	public Location getLocation()
	{
		return this.curr;
	}
	

// returns the end destination
	public Location getEnd()
	{
		return this.end;
	}
	
	//checks if the player reached the end
	public boolean won()
	{
		if(this.curr.equals(this.end))
			return true;
		return false;
	}

}
