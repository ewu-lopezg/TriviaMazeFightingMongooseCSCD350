package maze;

/**
 * @author Team: fighting mongoose
 *
 */
public interface I_Path 
{
	/**
	 * @return boolean if the path is passable
	 */
	boolean isPassable();
	/**
	 * @return boolean if the player moved through the path
	 */
	boolean move();
	/**
	 * @return String the string value of the path
	 */
	String visit();
}
