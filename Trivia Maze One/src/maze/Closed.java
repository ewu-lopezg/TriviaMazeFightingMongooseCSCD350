package trivaMaze;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Closed implements I_Status 
{
	private I_Question question;

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
		question = new QuestionTrueFalse("true", "taters gonna tate");
//		question = new QuestionMultiChoice("ma ha ha ha","best way to fight a titan","go for the eyes","ma ha ha ha","die" );
		
		Object[] possibleValues = question.getPossible();
		String selectedValue = (String) JOptionPane.showInputDialog(null,question.getQuestion(), question.getType(),
		JOptionPane.QUESTION_MESSAGE, null,
		possibleValues, possibleValues[0]);
		
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

}
