package trivaMaze;
import java.io.*;
import java.util.*;
public class Tester 
{
	public static Scanner kb;

	public static void main(String[] args)
	{
		Maze one = new Maze();
		kb = new Scanner(System.in);
		
		do
		{
		int choice = menu();
		if(choice ==8)
			one.moveUp();
		
		if(choice == 2)
			one.moveDown();
		
		if(choice == 4)
			one.moveLeft();
		
		if(choice == 6 )
			one.moveRight();
		
		System.out.println("plaerLocation: " + one.one.getLocation().getX()+"," + one.one.getLocation().getY());
		}while(true);
	}
	
	public static int menu()
	{
		System.out.println("  8  ");
		System.out.println("4   6");
		System.out.println("  2  ");
		System.out.print("enter direction: ");
		return Integer.parseInt(kb.nextLine());
		
	}

}
