package maze;

public class Open implements I_Status 
{

	@Override
	public boolean move() 
	{
		return true;

	}

	public String visit()
	{
		return "o ";
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
