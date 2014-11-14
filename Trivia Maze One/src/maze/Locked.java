package maze;

public class Locked implements I_Status 
{

	@Override
	public boolean move() 
	{
		return false;
	}

	@Override
	public boolean isPassable() 
	{
		return false;
	}
}
