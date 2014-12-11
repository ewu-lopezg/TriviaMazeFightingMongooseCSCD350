package maze;

/**
 * @author Team: fighting mongoose
 *
 */
public class Door implements I_Path
{
	private I_Status status;
	
//cerate a door with default of closed
	public Door()
	{
		this.status = new Closed();
	}

//creates a door with a chosen status
	public Door(I_Status passed)
	{
		this.status = passed;
	}
	

//sets the status of a door
	private void setStatus(I_Status newStatus) //-------------------
	{
		this.status = newStatus;
	}

//return if a door is passable depending on status
	@Override
	public boolean isPassable() 
	{
		return this.status.isPassable();
	}
	

//returns the type of door depending on status
	public String visit()
	{
		return this.status.visit();
	}

//returns if a player moved through the door and changes status
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
