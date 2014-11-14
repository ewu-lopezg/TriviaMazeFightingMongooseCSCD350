package maze;

import java.util.Scanner;

public class Closed  implements I_Status 
{
//	A_Question question;

	@Override
	public boolean move() 
	{
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
//		question = new QuestionTrueFalse(true, "taters gonna tate");
		
		Scanner kb = new Scanner(System.in);
		int temp = Integer.parseInt(kb.nextLine());
		
		if(temp == 2)
			return true;
			
		return false;
	}
}
