package trivaMaze;

public class Open implements I_Status 
{

	@Override
	public boolean move() 
	{
		System.out.print("open door");
		return true;

	}

	@Override
	public boolean isPassable() 
	{
		return true;
	}

}
