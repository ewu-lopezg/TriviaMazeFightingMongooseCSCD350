package maze;

public class Player 
{
	Location curr;
	Location end;
	
	public Player(Location passed, Location end)
	{
		this.curr = passed;
		this.end = end;
		
	}
	
	public void move(Location newLocation)
	{
		this.curr = newLocation;
	}
	
	public Location getLocation()
	{
		return this.curr;
	}
	
	public Location getEnd()
	{
		return this.end;
	}
	
	public boolean won()
	{
		if(this.curr.equals(this.end))
			return true;
		return false;
	}

}
