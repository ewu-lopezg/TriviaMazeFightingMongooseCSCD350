package maze;

/**
 * @author Team: fighting mongoose
 *
 */
public class Open implements I_Status 
{

//returns true(player can move through an open door)
	@Override
	public boolean move() 
	{
		return true;

	}

//returns o for open door
	public String visit()
	{
		return "o ";
	}

//returns true that a player can move through an open door
	@Override
	public boolean isPassable() 
	{
		return true;
	}

}
