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
	

// makes room
	public Room()
	{
	}
	

//gets the string of the room(up right down left)
	public String visit()
	{
		return this.up.visit() + this.right.visit() + this.down.visit() + this. left.visit();
	}
	
	// sets up path
	public void setUp(I_Path passed)
	{
		this.up = passed;
	}

	//sets down path
	public void setDown(I_Path passed)
	{
		this.down = passed;
	}
	
	//sets left path
	public void setLeft(I_Path passed)
	{
		this.left = passed;
	}
	
	//sets right path
	public void setRight(I_Path passed)
	{
		this.right = passed;
	}
	
	//gets up path
	public I_Path getUp()
	{
		return this.up;
	}
	
	//gets left path
	public I_Path getLeft()
	{
		return this.left;
	}
	
	//gets right path
	public I_Path getRight()
	{
		return this.right;
	}
	
	//gets down path
	public I_Path getDown()
	{
		return this.down;
	}
}
