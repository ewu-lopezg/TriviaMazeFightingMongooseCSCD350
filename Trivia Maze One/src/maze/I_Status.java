package maze;

/**
 * @author Team: fighting mongoose
 *
 */
public interface I_Status 
{
	/**
	 * @return boolean if the player moved through
	 */
	public boolean move();
	/**
	 * @return if the player is allowed to move
	 */
	public boolean isPassable();

	/**
	 * @return the string representaion of the status
	 */
	public String visit();
}
