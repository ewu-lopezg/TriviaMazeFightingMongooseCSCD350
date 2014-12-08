package maze;

/**
 * @author Team: fighting mongoose
 *
 */
public class Locked implements I_Status 
{

	/* (non-Javadoc)
	 * @see maze.I_Status#move()
	 */
	@Override
	public boolean move() 
	{
		return false;
	}
	
	/* (non-Javadoc)
	 * @see maze.I_Status#visit()
	 */
	public String visit()
	{
		return "l ";
	}

	/* (non-Javadoc)
	 * @see maze.I_Status#isPassable()
	 */
	@Override
	public boolean isPassable() 
	{
		return false;
	}

	/* (non-Javadoc)
	 * @see maze.I_Status#hasQuestion()
	 */
	@Override
	public boolean hasQuestion() 
	{
		return false;
	}


}
