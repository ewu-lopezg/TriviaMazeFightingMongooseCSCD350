package maze;

public interface I_Question
{
	
	public Object[] getPossible();
	public String getQuestion();
	public String getType();
	public boolean validate(String passed);
	
}
