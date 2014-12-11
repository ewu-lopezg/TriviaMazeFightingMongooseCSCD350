package maze;

/**
 * @author Team: fighting mongoose
 *
 */
public class Wall implements I_Path
{
	//make a wall
	public Wall()
	{
		
	}

// returns false, player cant pass a wall
	@Override
	public boolean isPassable() 
	{
		return false;
	}

	//returns false, player didnt move through wall
	@Override
	public boolean move() 
	{
		return false;
		
	}
	
	//returns w for wall
	public String visit()
	{
		return "w ";
	}

}
