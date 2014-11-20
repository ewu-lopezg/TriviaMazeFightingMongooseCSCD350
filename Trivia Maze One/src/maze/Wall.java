package maze;

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
		return false;
		
	}
	
	public String visit()
	{
		return "w ";
	}

}
