package maze;

/**
 * @author Team: fighting mongoose
 *
 */
public class Wall implements I_Path
{
	/**
	 * 
	 */
	public Wall()
	{
		
	}
	/* (non-Javadoc)
	 * @see maze.I_Path#isPassable()
	 */
	@Override
	public boolean isPassable() 
	{
		return false;
	}

	/* (non-Javadoc)
	 * @see maze.I_Path#move()
	 */
	@Override
	public boolean move() 
	{
		return false;
		
	}
	
	/* (non-Javadoc)
	 * @see maze.I_Path#visit()
	 */
	public String visit()
	{
		return "w ";
	}

}
