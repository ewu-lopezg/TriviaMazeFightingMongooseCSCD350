package maze;

/**
 * @author Patches
 *
 */
public interface I_Question
{
	
	/**
	 * @return
	 */
	public Object[] getPossible();
	/**
	 * @return
	 */
	public String getQuestion();
	/**
	 * @return
	 */
	public String getType();
	/**
	 * @param passed
	 * @return
	 */
	public boolean validate(String passed);
	
}
