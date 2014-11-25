package maze;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.*;

public class mapPanel extends JPanel   //switch to scroll pane
{
	private ImageIcon floor;
	private ImageIcon doorv;
	private ImageIcon doorh;
	private ImageIcon wallv;
	private ImageIcon wallh;
	private int sizeCol;
	private int sizeRow;
	private String map;
	private final int base = 100;
	private final int offsetEnd = 90;
	private final int offsetEdge = 10;
	private final int offsetPath = 10;
	private Location player;
	
	private int place(int val)
	{
		return val * base + offsetEdge;
		
	}
	
	public void readMap(int col, int row, String str, Location player)
	{
		this.sizeCol=col;
		this.sizeRow = row;
		this.map=str;
		this.player= player;
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		floor = new ImageIcon("floor.png");
		doorv = new ImageIcon("doorv.png");
		doorh = new ImageIcon("doorh.png");
		wallv = new ImageIcon("wallv.png");
		wallh = new ImageIcon("wallh.png");

		
		//--------------------------------paint floors
		for(int i =0; i < this.sizeCol;i++)
		{
			for(int j = 0; j < this.sizeRow;j++)
			{
				floor.paintIcon(this, g, place(j), place(i));
			}
		}
		
		//----------------------------------paint paths
		String rest = this.map;
		
		for(int i =0; i < this.sizeCol;i++)
		{
			for(int j = 0; j < this.sizeRow;j++)
			{
				String curr = rest.substring(0,8);
				rest = rest.substring(8);
				
				//up
				if(curr.charAt(0)=='w')
					wallh.paintIcon(this, g, place(j), place(i) -offsetPath);
				
				else
				{
					doorh.paintIcon(this,g,place(j)+ offsetPath,place(i) -offsetPath);
					
//					g.setColor(Color.RED);
//					g.fillRect(this.place(j)+ offsetPath, this.place(i) - offsetPath, 80, 20); //---------------------v
					
					if(curr.charAt(0) == 'l')
					{
						g.setColor(Color.RED);
						g.fillRect(this.place(j)+ offsetPath, this.place(i) - offsetPath, 80, 20);
					}
					
					else if(curr.charAt(0) == 'o')
					{
						g.setColor(Color.GREEN);
						g.fillRect(this.place(j)+ offsetPath, this.place(i) - offsetPath, 80, 20);
					}
					
				}
				//add fill r
				
				
				
				//right
				if(curr.charAt(2)=='w')
					wallv.paintIcon(this, g, place(j)+ offsetEnd, place(i));
				else
				{
					doorv.paintIcon(this, g, place(j)+ offsetEnd, place(i) + offsetPath);
					
//					g.setColor(Color.RED);
//					g.fillRect(this.place(j)+ offsetEnd, this.place(i) + offsetPath, 20, 80);//-----------------X
					
					if(curr.charAt(2) == 'l')
					{
						g.setColor(Color.RED);
						g.fillRect(this.place(j)+ offsetEnd, this.place(i) + offsetPath, 20, 80);
					}
					
					else if(curr.charAt(2) == 'o')
					{
						g.setColor(Color.GREEN);
						g.fillRect(this.place(j)+ offsetEnd, this.place(i) + offsetPath, 20, 80);
					}
				}				
				
			
				//down
				if(curr.charAt(4)=='w')
					wallh.paintIcon(this, g, place(j), place(i) + offsetEnd);
				else
				{
					doorh.paintIcon(this, g, place(j)+ offsetPath, place(i)+ offsetEnd);
					
//					g.setColor(Color.RED);
//					g.fillRect(place(j)+ offsetPath, place(i)+ offsetEnd, 80, 20);//----------------x
				
					if(curr.charAt(4) == 'l')
					{
						g.setColor(Color.RED);
						g.fillRect(place(j)+ offsetPath, place(i)+ offsetEnd, 80, 20);
					}
					
					else if(curr.charAt(4) == 'o')
					{
						g.setColor(Color.GREEN);
						g.fillRect(place(j)+ offsetPath, place(i)+ offsetEnd, 80, 20);
					}
				}

	
				
				
				//left
				if(curr.charAt(6)=='w')
					wallv.paintIcon(this, g, place(j)-offsetPath, place(i));
				else
				{
					doorv.paintIcon(this, g, place(j) -offsetPath, place(i) + offsetPath);
					
//					g.setColor(Color.RED);
//					g.fillRect(place(j) -offsetPath, place(i) + offsetPath, 20, 80);//---------------------------X
				
					if(curr.charAt(6) == 'l')
					{
						g.setColor(Color.RED);
						g.fillRect(place(j) -offsetPath, place(i) + offsetPath, 20, 80);
					}
					
					else if(curr.charAt(6) == 'o')
					{
						g.setColor(Color.GREEN);
						g.fillRect(place(j) -offsetPath, place(i) + offsetPath, 20, 80);
					}
				}
				
				
				
			}
		}
		
		g.setColor(Color.BLUE);
		g.fillOval(place(this.player.getY()) +35,place(this.player.getX())+35, 40, 40);
		
		
//		floor.paintIcon(this, g, 0, 0);
//		doorh.paintIcon(this, g, 10, 0);
		
//		System.out.println("height: " + floor.getIconHeight());
		//System.out.println("width: " + floor.getIconWidth());
	}

}
