package maze;

/**
 * @author Patches
 *
 */
public interface I_Path 
{
	/**
	 * @return
	 */
	boolean isPassable();
	/**
	 * @return
	 */
	boolean move();
	/**
	 * @return
	 */
	String visit();
}
