package maze;

/**
 * @author Team: fighting mongoose
 *
 */
public class Locked implements I_Status 
{

//returns false if a player trys to move through a locked door
	@Override
	public boolean move() 
	{
		return false;
	}
	
//returns l for locked door
	public String visit()
	{
		return "l ";
	}


//returns false (players cant move through locked doors)
	@Override
	public boolean isPassable() 
	{
		return false;
	}
}
