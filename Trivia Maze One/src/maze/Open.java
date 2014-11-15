package trivaMaze;

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

	@Override
	public boolean hasQuestion() 
	{
		return false;
	}

	@Override
	public String[] getQuestion() 
	{
		return null;
	}

}
