package maze;

import java.util.Scanner;

import javax.swing.JOptionPane;

/**
 * @author Team: fighting mongoose
 *
 */
public class Closed implements I_Status 
{
	private I_Question question;

//returns if the player moved through the closed door
	@Override
	public boolean move() 
	{
		boolean question = ask();
		return question;
	}

//returns true that player could move through a closed door(after opened)
	public boolean isPassable()
	{
		return true;
	}

//gets the question out of database, creates question class, ask user for anwer then validates
	private boolean ask()
	{
		String[] temp = Database.getQuestion();
		if(temp[4].equals("E"))
			question = new QuestionTrueFalse(temp[1], temp[0]);
		else
			question = new QuestionMultiChoice(temp[1],temp[0],temp[2],temp[3],temp[4]);
		
		Object[] possibleValues = question.getPossible();
		String selectedValue = (String) JOptionPane.showInputDialog(null,question.getQuestion(), question.getType(),
		JOptionPane.QUESTION_MESSAGE, null,
		possibleValues, possibleValues[0]);
		
		//hit exit
		if(selectedValue == null)
		{
			AudioPlayer.play("lock.wav");
			return false;
		}
		
		return question.validate(selectedValue);
	}

//returns c for closed door
	public String visit()
	{
		return "c ";
	}

}
