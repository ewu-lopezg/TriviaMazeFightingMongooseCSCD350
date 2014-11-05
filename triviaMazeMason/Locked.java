package trivaMaze;

public class Locked implements I_Status 
{

	@Override
	public boolean move() 
	{
		System.out.print("locked door\n");
		return false;
	}

	@Override
	public boolean isPassable() 
	{
		return false;
	}

}
