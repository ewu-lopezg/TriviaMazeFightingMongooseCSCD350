package maze;

public class Open implements I_Status 
{

	@Override
	public boolean move() 
	{
		return true;

	}

	@Override
	public boolean isPassable() 
	{
		return true;
	}
}
