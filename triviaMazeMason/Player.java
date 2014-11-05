package trivaMaze;

public class Player 
{
	Location curr;
	
	public Player(Location passed)
	{
		this.curr = passed;
	}
	
	public void move(Location newLocation)
	{
		this.curr = newLocation;
	}
	
	public Location getLocation()
	{
		return this.curr;
	}

}
