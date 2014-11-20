package maze;

public class Door implements I_Path
{
	private I_Status status;
//	Room one;
//	Room two;
	
	public Door()
	{
		this.status = new Closed();
		
//		this.status = new Open();
	}
	
//	public void SetRooms(Room one, Room two)
//	{
		
//	}
	private void setStatus(I_Status newStatus)
	{
		this.status = newStatus;
	}

	@Override
	public boolean isPassable() 
	{
		return this.status.isPassable();
	}
	
	public String visit()
	{
		return this.status.visit();
	}

	@Override
	public boolean move() 
	{
		boolean moved = status.move();
		if (moved)
			this.status = new Open();
		else
			this.status = new Locked();
		
		return moved;
		
//		if(status.move())
//		{
//			System.out.println("move player");
//		}
//		else
//			status = new Locked();
	}

}
