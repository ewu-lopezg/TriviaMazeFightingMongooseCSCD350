package maze;

/**
 * @author Team: fighting mongoose
 *
 */
public interface I_Question
{
	
	/**
	 * @return gets an array of possible answers
	 */
	public Object[] getPossible();
	/**
	 * @return String gets the actual question
	 */
	public String getQuestion();
	/**
	 * @return String gets the type of question
	 */
	public String getType();
	/**
	 * @param passed the String that was guessed
	 * @return boolean if the answer was right
	 */
	public boolean validate(String passed);
	
}
