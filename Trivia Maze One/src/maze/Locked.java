package maze;

public class Locked implements I_Status 
{

	@Override
	public boolean move() 
	{
		return false;
	}
	
	public String visit()
	{
		return "l ";
	}

	@Override
	public boolean isPassable() 
	{
		return false;
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
