package trivaMaze;

import java.util.Scanner;

public class Closed implements I_Status 
{
//	I_Question question;

	@Override
	public boolean move() 
	{
		System.out.print("closed door, asking question\n");
		return ask();
	}

	public boolean isPassable()
	{
		return true;
	}
	
	private boolean ask()
	{
	//	return question.ask();
		System.out.print("1+ 1= ");
		Scanner kb = new Scanner(System.in);
		int temp = Integer.parseInt(kb.nextLine());
		
		if(temp == 2)
			return true;
			
		return false;
	}

}
