package maze;

public class QuestionTrueFalse implements I_Question
{
	private String answer;
	private String question;
	public QuestionTrueFalse(String val, String question)
	{
		this.answer = val;
		this.question = question;	
	}
	@Override
	public Object[] getPossible() 
	{
		Object[] possible = {"true","false"};
		return possible;
	}
	@Override
	public String getQuestion() 
	{
		return this.question;
	}
	@Override
	public String getType() 
	{
		return "true/false";
	}
	
	public boolean validate(String passed)
	{
		if(passed.compareToIgnoreCase(this.answer) ==0)
			return true;
		
		return false;	
	}
	

}
