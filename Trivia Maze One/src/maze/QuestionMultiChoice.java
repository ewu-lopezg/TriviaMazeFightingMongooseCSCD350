package maze;

public class QuestionMultiChoice implements I_Question
{
	private String answer;
	private String question;
	private String optionA;
	private String optionB;
	private String optionC;
	
	public QuestionMultiChoice(String val, String question, String a, String b, String c)
	{
		this.answer = val;
		this.question = question;
		this.optionA = a;
		this.optionB = b;
		this.optionC = c;
	}
	
	
	@Override
	public Object[] getPossible() 
	{
		Object[] possible = {this.optionA,this.optionB,this.optionC};
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
		return "Multi Choice";
	}

	@Override
	public boolean validate(String passed) 
	{
		if(this.answer.compareToIgnoreCase(passed)==0 )
			return true;
		return false;
	}

}
