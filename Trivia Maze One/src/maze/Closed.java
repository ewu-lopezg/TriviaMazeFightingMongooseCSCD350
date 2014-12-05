package maze;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Closed implements I_Status 
{
	private I_Question question;

	@Override
	public boolean move() 
	{
		boolean question = ask();
		return question;
	}

	public boolean isPassable()
	{
		return true;
	}

	private boolean ask()
	{
//		Database.Print(s);
		String[] temp = Database.getQuestion();
		if(temp[4].equals("E"))
			question = new QuestionTrueFalse(temp[1], temp[0]);
		else
			question = new QuestionMultiChoice(temp[1],temp[0],temp[2],temp[3],temp[4]);

//		tf(answer, question)
//		question = new QuestionMultiChoice("ma ha ha ha","best way to fight a titan","go for the eyes","ma ha ha ha","die" );
		
		Object[] possibleValues = question.getPossible();
		String selectedValue = (String) JOptionPane.showInputDialog(null,question.getQuestion(), question.getType(),
		JOptionPane.QUESTION_MESSAGE, null,
		possibleValues, possibleValues[0]);
		
		//hit exit
		if(selectedValue == null)
			return false;
		
		return question.validate(selectedValue);
	}

	@Override
	public boolean hasQuestion()
	{
		return true;
	}

	@Override
	public String[] getQuestion() 
	{
		
		return null;
	}
	
	public String visit()
	{
		return "c ";
	}

}
