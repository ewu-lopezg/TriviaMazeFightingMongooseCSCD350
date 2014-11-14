package maze;

public class Room {
	I_Path up;
	I_Path down;
	I_Path left;
	I_Path right;
	
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
}
