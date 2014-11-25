package maze;
import java.io.*;
import java.util.*;

public class Maze 
{
	private Player one;
	private Location start;
	private Location end;
	private Room[][] map;
	private int sizeRow;
	private int sizeCol;
	
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
			 this.start = new Location(temp[0],temp[1]); 
			 this.one = new Player(this.start);
			 
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
	
	private int[] parseInts(String passed)
	{
		int[] ints = new int[2];
		String[]temp = passed.split(",");
		ints[0] = Integer.parseInt(temp[0]);
		ints[1] = Integer.parseInt(temp[1]);
		return ints;
		
	}
	
	public Maze()
	{
		start = new Location(0,0);
		end = new Location(3,3);
		this.sizeRow = 3;
		this.sizeCol = 3;
		one = new Player(start);
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
		
		this.visit(); //----------------------------------
		//constructor
	}//end constructor
	
	public Player getPlayer()
	{
		return this.one;
	}
	
	public String mazeString()
	{
		String map = "";
		for(int i = 0; i < sizeCol; i++)
		{
			for(int j = 0; j < sizeRow; j++)
			{
				if(i == one.getLocation().getX() && j==one.getLocation().getY())
					map = map + "X   ";
				else
					map = map + "o   ";
			}
			map = map + "\n"; 
		}
	  return map;
	}
	
	public void moveDown()
	{
//		System.out.print("move right to a ");
		Location curr = one.getLocation();
		Location next;
		boolean moved = map[curr.getX()][curr.getY()].getDown().move();
		
		if(moved)
		{
			next = new Location(curr.getX()+1, curr.getY());
			one.move(next);
			
		}
		
	}
	public void moveUp()
	{
		Location curr = one.getLocation();
		boolean moved = map[curr.getX()][curr.getY()].getUp().move();
		
		if(moved)
			one.move(new Location(curr.getX()-1, curr.getY()));
	}
	public void moveLeft()
	{
		Location curr = one.getLocation();
		boolean moved = map[curr.getX()][curr.getY()].getLeft().move();
		
		if(moved)
			one.move(new Location(curr.getX(), curr.getY()-1));
	}
	public void moveRight()
	{
		Location curr = one.getLocation();
		boolean moved = map[curr.getX()][curr.getY()].getRight().move();
		
		if(moved)
			one.move(new Location(curr.getX(), curr.getY() +1));
	}
	
	public String visit()
	{
		String temp = "";
//		System.out.println("rooms from left to right, top to bottom");
		for(int col = 0; col < this.sizeCol; col++)
		{
			for(int row = 0; row < this.sizeRow; row++)
			{
				temp = temp + map[col][row].visit();
			}
		}
//		System.out.println(temp);
		return temp;
	}
	public int getSizeRow()
	{
		return this.sizeRow;
	}
	
	public int getSizeCol()
	{
		return this.sizeCol;
	}
}
