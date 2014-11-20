package maze;
import java.io.*;
import java.util.*;

public class Maze 
{
	private Player one;
	private Location start;
	private Room[][] map;
	private int size = 3;
	
	public Maze()
	{
		start = new Location(0,0);
		one = new Player(start);
		map =  new Room[size][size];
		
//------------------------------------------------------make rooms	and walls	
		for(int i = 0; i < size; i++)
		{
			for(int j = 0; j < size; j++)
			{
				map[i][j] = new Room();
				if(j == 0)
					map[i][j].setLeft(new Wall());
				
				if(j==size-1)
					map[i][j].setRight(new Wall());
				
				if(i==0)
					map[i][j].setUp(new Wall());
				
				if(i== size-1)
					map[i][j].setDown(new Wall());
			}//end inner for loop
		}//end outer for loop

//----------------------------------------------------------------make doors		
		for(int i = 0; i < size; i++)
		{
			for(int j = 0; j < size; j++)
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
		
		this.visit();
		//constructor
	}//end constructor
	
	public Player getPlayer()
	{
		return this.one;
	}
	
	public String mazeString()
	{
		String map = "";
		for(int i = 0; i < size; i++)
		{
			for(int j = 0; j < size; j++)
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
		for(int col = 0; col < this.size; col++)
		{
			for(int row = 0; row < this.size; row++)
			{
				temp = temp + map[col][row].visit();
			}
		}
//		System.out.println(temp);
		return temp;
	}
	public int getSize()
	{
		return this.size;
	}
}
