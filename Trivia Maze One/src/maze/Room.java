package trivaMaze;

public class Room 
{
	private I_Path up;
	private I_Path down;
	private I_Path left;
	private I_Path right;
	
	public Room()
	{
	}
	// move right
	public void setUp(I_Path passed)
	{
		this.up = passed;
	}

	public void setDown(I_Path passed)
	{
		this.down = passed;
	}
	
	public void setLeft(I_Path passed)
	{
		this.left = passed;
	}
	
	public void setRight(I_Path passed)
	{
		this.right = passed;
	}
	
	public I_Path getUp()
	{
		return this.up;
	}
	
	public I_Path getLeft()
	{
		return this.left;
	}
	
	public I_Path getRight()
	{
		return this.right;
	}
	
	public I_Path getDown()
	{
		return this.down;
	}
}
