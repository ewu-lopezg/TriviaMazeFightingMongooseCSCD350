package maze;

/**
 * @author Team: fighting mongoose
 *
 */
public class Door implements I_Path
{
	private I_Status status;
	
	/**
	 * 
	 */
	public Door()
	{
		this.status = new Closed();
	}
	/**
	 * @param passed
	 */
	public Door(I_Status passed)
	{
		this.status = passed;
	}
	

	/**
	 * @param newStatus
	 */
	private void setStatus(I_Status newStatus) //-------------------
	{
		this.status = newStatus;
	}

	/* (non-Javadoc)
	 * @see maze.I_Path#isPassable()
	 */
	@Override
	public boolean isPassable() 
	{
		return this.status.isPassable();
	}
	
	/* (non-Javadoc)
	 * @see maze.I_Path#visit()
	 */
	public String visit()
	{
		return this.status.visit();
	}

	/* (non-Javadoc)
	 * @see maze.I_Path#move()
	 */
	@Override
	public boolean move() 
	{
		boolean moved = status.move();
		if (moved)
			this.status = new Open();
		else
			this.status = new Locked();
		
		return moved;
		
	}

}
