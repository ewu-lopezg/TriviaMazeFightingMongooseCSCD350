package trivaMaze;

public class Wall implements I_Path
{
	public Wall()
	{
		
	}
	@Override
	public boolean isPassable() 
	{
		return false;
	}

	@Override
	public boolean move() 
	{
		System.out.print("door");
		return false;
		
	}

}
