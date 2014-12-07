package maze;

/**
 * @author Patches
 *
 */
public interface I_Status 
{
	/**
	 * @return
	 */
	public boolean move();
	/**
	 * @return
	 */
	public boolean isPassable();
	/**
	 * @return
	 */
	public boolean hasQuestion();
	/**
	 * @return
	 */
	public String visit();
}
