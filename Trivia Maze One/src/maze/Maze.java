package maze;

public class Maze 
{
	Player one;
	Location start;
	Room[][] map;
	int size = 5;

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
				if(map[i][j].left == null)
				{
					Door temp = new Door();
					map[i][j].left = temp;
					map[i][j-1].right = temp;

				}
			
				if(map[i][j].up == null)
				{
					Door temp = new Door();
					map[i][j].up = temp;
					map[i-1][j].down = temp;

				}
				
			}
		}
		//constructor
	}//end constructor

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
		//	System.out.print("move right to a ");
		Location curr = one.getLocation();
		Location next;
		boolean moved = map[curr.getX()][curr.getY()].down.move();
	
		if(moved)
		{
			next = new Location(curr.getX()+1, curr.getY());
			one.move(next);
		
		}
	
	}
	public void moveUp()
	{
		Location curr = one.getLocation();
		boolean moved = map[curr.getX()][curr.getY()].up.move();
	
		if(moved)
			one.move(new Location(curr.getX()-1, curr.getY()));
	}
	public void moveLeft()
	{
		Location curr = one.getLocation();
		boolean moved = map[curr.getX()][curr.getY()].left.move();
	
		if(moved)
			one.move(new Location(curr.getX(), curr.getY()-1));
	}
	public void moveRight()
	{
		Location curr = one.getLocation();
		boolean moved = map[curr.getX()][curr.getY()].right.move();
	
		if(moved)
			one.move(new Location(curr.getX(), curr.getY() +1));
	}
}


