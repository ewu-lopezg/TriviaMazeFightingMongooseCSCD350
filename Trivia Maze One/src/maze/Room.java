package maze;

/**
 * @author Team: fighting mongoose
 *
 */
public class Room 
{
	private I_Path up;
	private I_Path down;
	private I_Path left;
	private I_Path right;
	
	/**
	 * 
	 */
	public Room()
	{
	}
	
	/**
	 * @return
	 */
	public String visit()
	{
		return this.up.visit() + this.right.visit() + this.down.visit() + this. left.visit();
	}
	// move right
	/**
	 * @param passed
	 */
	public void setUp(I_Path passed)
	{
		this.up = passed;
	}

	/**
	 * @param passed
	 */
	public void setDown(I_Path passed)
	{
		this.down = passed;
	}
	
	/**
	 * @param passed
	 */
	public void setLeft(I_Path passed)
	{
		this.left = passed;
	}
	
	/**
	 * @param passed
	 */
	public void setRight(I_Path passed)
	{
		this.right = passed;
	}
	
	/**
	 * @return
	 */
	public I_Path getUp()
	{
		return this.up;
	}
	
	/**
	 * @return
	 */
	public I_Path getLeft()
	{
		return this.left;
	}
	
	/**
	 * @return
	 */
	public I_Path getRight()
	{
		return this.right;
	}
	
	/**
	 * @return
	 */
	public I_Path getDown()
	{
		return this.down;
	}
}
