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
	/* (non-Javadoc)
	 * @see maze.I_Question#getPossible()
	 */
	@Override
	public Object[] getPossible() 
	{
		Object[] possible = {"true","false"};
		return possible;
	}
	/* (non-Javadoc)
	 * @see maze.I_Question#getQuestion()
	 */
	@Override
	public String getQuestion() 
	{
		return this.question;
	}
	/* (non-Javadoc)
	 * @see maze.I_Question#getType()
	 */
	@Override
	public String getType() 
	{
		return "true/false";
	}
	
	/* (non-Javadoc)
	 * @see maze.I_Question#validate(java.lang.String)
	 */
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
