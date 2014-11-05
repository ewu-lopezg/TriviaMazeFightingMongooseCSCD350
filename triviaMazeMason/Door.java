package trivaMaze;

public class Door implements I_Path
{
	I_Status status;
//	Room one;
//	Room two;
	
	public Door()
	{
		this.status = new Closed();
	}
	
//	public void SetRooms(Room one, Room two)
//	{
		
//	}
	private void setStatus(I_Status newStatus)
	{
		this.status = newStatus;
	}

	@Override
	public boolean isPassable() {
		// TODO Auto-generated method stub
		return false;
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
