package maze;

/**
 * @author Team: fighting mongoose
 *
 */
public class QuestionTrueFalse implements I_Question
{
	private String answer;
	private String question;
	/**
	 * @param val
	 * @param question
	 */
	public QuestionTrueFalse(String val, String question)
	{
		this.answer = val;
		this.question = question;	
	}

// gets possible answers
	@Override
	public Object[] getPossible() 
	{
		Object[] possible = {"true","false"};
		return possible;
	}

//gets the question
	@Override
	public String getQuestion() 
	{
		return this.question;
	}

//gets they type of question
	@Override
	public String getType() 
	{
		return "true/false";
	}
	

// checks if answer is true
	public boolean validate(String passed)
	{
		if(passed.compareToIgnoreCase(this.answer) ==0)
		{
			AudioPlayer.play("open.wav");
			return true;
		}
		
		AudioPlayer.play("lock.wav");
		return false;	
	}
	

}
