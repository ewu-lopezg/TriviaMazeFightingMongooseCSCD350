package maze;
import java.io.*;
import java.util.*;

/**
 * @author Team: fighting mongoose
 * this is the main class for the logic of the maze. it creates and manages all the other classes
 * all manipulation of the maze should go through this class
 */
public class Maze 
{
	private Player one;
	private Room[][] map;
	private int sizeRow;
	private int sizeCol;
	
	/**
	 * @param passed - the string reprisentation of the diffrent patths in the class going clockwise
	 * starting with the top of the room. it also goes from top left room to the right then down to the next row
	 */
	public Maze(String[]passed) //[r][c]
	{
		 try
		 {
			 if(passed == null)
				 throw new RuntimeException();
			 
			 int[]temp = this.parseInts(passed[0]); // get size
			 this.sizeRow = temp[0];
			 this.sizeCol = temp[1];
			 
			 temp = this.parseInts(passed[1]); //get start location
			 this.one = new Player(new Location(temp[0],temp[1]), new Location(this.sizeCol-1,this.sizeRow -1));
			 
			 map =  new Room[sizeRow][sizeCol];
	
			 //---------------------------------------------------------------make floors
			 for(int i = 0; i < this.sizeRow; i ++)
			 {
				 for(int j =0; j <this.sizeCol; j++)
				 {
					 map[i][j] = new Room();
				 } //make outer walls here ------------------------
			 }
			 //-----------------------------------------------------------------------------
			 
			 String rest = passed[2];
			 for(int i = 0; i < this.sizeRow; i ++)
			 {
				 for(int j =0; j <this.sizeCol; j++)
				 {
					 String curr = rest.substring(0,8);
					 rest = rest.substring(8);
					 
					 if(i != 0)
						 map[i][j].setUp(map[i-1][j].getDown());
					 
					 
					 if(j != 0)
						 map[i][j].setLeft(map[i][j-1].getRight());
					 
					 if(map[i][j].getUp() == null)
						 map[i][j].setUp(setPath(curr.charAt(0)));
					 
					 if(map[i][j].getRight() == null)
						 map[i][j].setRight(setPath(curr.charAt(2)));
					 
					 if(map[i][j].getDown() == null)
					 map[i][j].setDown(setPath(curr.charAt(4)));
					 
					 if(map[i][j].getLeft() == null)
					 map[i][j].setLeft(setPath(curr.charAt(6)));
					 
						
				 } //make outer walls here ------------------------
			 }
			 		 
			 
		 }//end try
		 catch(RuntimeException e)
		 {
			 
		 }	 
	}//end constructor
	
	/**
	 * @param passed the character representing the path. w for wall, o for open door, c for closed door, l for locked door. must be lowercase
	 * @return the I_Path object that was set
	 */
	private I_Path setPath(char passed)
	{
		I_Path temp;
		if(passed == 'w')
			return new Wall();
		
		if(passed == 'o')
			return new Door(new Open());
		
		if(passed == 'c')
			return new Door(new Closed());
		
//		if(passed == 'l')
			return new Door(new Locked());
	}//------------------------------------pull to factyory
	
	/**
	 * @param passed a string with the integers represented as "x,y" 
	 * @return an int[] represented as {x,y}
	 */
	private int[] parseInts(String passed)
	{
		int[] ints = new int[2];
		String[]temp = passed.split(",");
		ints[0] = Integer.parseInt(temp[0]);
		ints[1] = Integer.parseInt(temp[1]);
		return ints;
		
	}
	
	/**
	 *  the generic maze constructor. it makes a 3x3 maze filled with closed doors and walls around the edges
	 */
	public Maze()
	{
		Location start = new Location(0,0); //-------------------------
		Location end = new Location(2,2);
		this.sizeRow = 3;
		this.sizeCol = 3;
		one = new Player(start, end);
		map =  new Room[sizeCol][sizeRow];
		
//------------------------------------------------------make rooms	and walls	
		for(int i = 0; i < sizeCol; i++)
		{
			for(int j = 0; j < sizeRow; j++)
			{
				map[i][j] = new Room();
				if(j == 0)
					map[i][j].setLeft(new Wall());
				
				if(j==sizeRow-1)
					map[i][j].setRight(new Wall());
				
				if(i==0)
					map[i][j].setUp(new Wall());
				
				if(i== sizeCol-1)
					map[i][j].setDown(new Wall());
			}//end inner for loop
		}//end outer for loop

//----------------------------------------------------------------make doors		
		for(int i = 0; i < sizeCol; i++)
		{
			for(int j = 0; j < sizeRow; j++)
			{
				if(map[i][j].getLeft() == null)
				{
					Door temp = new Door();
					map[i][j].setLeft(temp);
					map[i][j-1].setRight(temp);

				}
				
				if(map[i][j].getUp() == null)
				{
					Door temp = new Door();
					map[i][j].setUp(temp);
					map[i-1][j].setDown(temp);

				}
					
			}
		}
	}//end constructor
	
	/**
	 * @return Payer the player object
	 */
	public Player getPlayer()
	{
		return this.one;
	}
	
	
	/**
	 * the method to move down depending on the path set for down in that room.
	 */
	public void moveDown()
	{
		Location curr = one.getLocation();
		Location next;
		boolean moved = map[curr.getX()][curr.getY()].getDown().move();
		
		if(moved)
		{
			next = new Location(curr.getX()+1, curr.getY());
			one.move(next);
			
		}
		
	}
	/**
	 * the method to move up depending on the path set for up in that room.
	 */
	public void moveUp()
	{
		Location curr = one.getLocation();
		boolean moved = map[curr.getX()][curr.getY()].getUp().move();
		
		if(moved)
			one.move(new Location(curr.getX()-1, curr.getY()));
	}
	/**
	 * the method to move left depending on the path set for left in that room.
	 */
	public void moveLeft()
	{
		Location curr = one.getLocation();
		boolean moved = map[curr.getX()][curr.getY()].getLeft().move();
		
		if(moved)
			one.move(new Location(curr.getX(), curr.getY()-1));
	}
	/**
	 * the method to move right depending on the path set for right in that room.
	 */
	public void moveRight()
	{
		Location curr = one.getLocation();
		boolean moved = map[curr.getX()][curr.getY()].getRight().move();
		
		if(moved)
			one.move(new Location(curr.getX(), curr.getY() +1));
	}
	
	/**
	 * makes a string representation of the maze
	 * @return String makes a string representation of the maze
	 */
	public String visit()
	{
		String temp = "";
		for(int col = 0; col < this.sizeCol; col++)
		{
			for(int row = 0; row < this.sizeRow; row++)
			{
				temp = temp + map[col][row].visit();
			}
		}
		return temp;
	}
	/**
	 * @return int size of rows
	 */
	public int getSizeRow()
	{
		return this.sizeRow;
	}
	
	/**
	 * @return int size of columns 
	 */
	public int getSizeCol()
	{
		return this.sizeCol;
	}
	
	/**
	 * @return boolean if the player reached the end of the maze
	 */
	public boolean won()
	{
		return this.one.won();
	}
	
	/**
	 * @return boolean checks if the player can win the game
	 */
	public boolean isWinnable()
	{
		ArrayList<Location> list = new ArrayList<Location>();
		return isWinnable(one.getLocation(),list, one.getEnd());	
	}
	
	
	/**
	 * Recursively check if the player can win the game
	 * @param curr current location
	 * @param checked list of visited rooms
	 * @param target the end location
	 * @return boolean if win-able
	 */
	private boolean isWinnable(Location curr, ArrayList<Location> checked, Location target)
	{	
				//base
		if(curr.equals(target))
			return true;
		
		boolean pathUp = false;
		boolean pathRight = false;
		boolean pathDown = false;
		boolean pathLeft= false;
		
		Room temp = map[curr.getX()][curr.getY()];
		checked.add(curr);
		
		Location up =new Location(curr.getX()-1, curr.getY());
		if(temp.getUp().isPassable() && !checked.contains(up))// isPassable-valid- and not on list
			pathUp = isWinnable(up,checked, target);
		
		Location right =new Location(curr.getX(), curr.getY()+1);
		if(temp.getRight().isPassable() && !checked.contains(right))// isPassable-valid- and not on list
			pathRight = isWinnable(right,checked, target);
		
		Location down =new Location(curr.getX()+1, curr.getY());
		if(temp.getDown().isPassable() && !checked.contains(down))// isPassable-valid- and not on list
			pathDown =  isWinnable(down,checked, target);
		
		Location left =new Location(curr.getX(), curr.getY()-1);
		if(temp.getLeft().isPassable() && !checked.contains(left))// isPassable-valid- and not on list
			pathLeft = isWinnable(left,checked, target);
			
		if(pathUp || pathRight || pathDown || pathLeft)
			return true;
		
		else 
			return false;
	}
	
}
