package maze;

/**
 * @author Patches
 *
 */
public class Open implements I_Status 
{

	/* (non-Javadoc)
	 * @see maze.I_Status#move()
	 */
	@Override
	public boolean move() 
	{
		return true;

	}

	/* (non-Javadoc)
	 * @see maze.I_Status#visit()
	 */
	public String visit()
	{
		return "o ";
	}
	/* (non-Javadoc)
	 * @see maze.I_Status#isPassable()
	 */
	@Override
	public boolean isPassable() 
	{
		return true;
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
