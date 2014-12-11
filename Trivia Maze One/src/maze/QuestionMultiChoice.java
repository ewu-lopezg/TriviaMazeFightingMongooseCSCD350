package maze;

/**
 * @author Team: fighting mongoose
 *
 */
public class QuestionMultiChoice implements I_Question
{
	private String answer;
	private String question;
	private String optionA;
	private String optionB;
	private String optionC;
	
	/**
	 * @param val
	 * @param question
	 * @param a
	 * @param b
	 * @param c
	 */
	public QuestionMultiChoice(String val, String question, String a, String b, String c)
	{
		this.answer = val;
		this.question = question;
		this.optionA = a;
		this.optionB = b;
		this.optionC = c;
	}
	
	
//gets the possible answers
	@Override
	public Object[] getPossible() 
	{
		Object[] possible = {this.optionA,this.optionB,this.optionC};
		return possible;
	}

//gets the question
	@Override
	public String getQuestion()
	{
		return this.question;
	}

//gets the type of question
	@Override
	public String getType() 
	{
		return "Multi Choice";
	}

	//checks if answered correctly
	@Override
	public boolean validate(String passed) 
	{
		if(this.answer.compareToIgnoreCase(passed)==0 )
		{
			AudioPlayer.play("open.wav");
			return true;
		}
		AudioPlayer.play("lock.wav");
		return false;
	}

}
