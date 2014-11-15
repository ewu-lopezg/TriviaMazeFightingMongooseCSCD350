package trivaMaze;

public interface I_Status 
{
	public boolean move();
	public boolean isPassable();
	public boolean hasQuestion();
	public String[] getQuestion();
}
