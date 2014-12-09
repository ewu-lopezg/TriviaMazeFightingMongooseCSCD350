/*
 /*
 /*
 /*
 * Trivia Maze Database 
 * @author Fighting Mongoose
 * @version 1.0z build Nov 9, 2014
 * 
 */

package maze;

import java.sql.*;
import java.util.*;

import javax.swing.JOptionPane;

public class Database 
{
	static Connection c = null;
	private static Statement stmt = null;
	private static String save = "";
	 static ArrayList usedQuestionId = new ArrayList();

	
	//public static void main (String args[])
	//{
		//if not exist 
		//when creating, deleting, inserting 
		//Insertion: check if username already exists 
		//if database dropped than SELECT cannot print
		// "INSERT INTO USER (USERNAME,PASSWORD,ADMIN,SAVE,LOCATION) " +
        // "VALUES (" + command[1] +"," + command[2] + ", " + command[3] + ", "+ ", NULL, NULL);";
			//openTable();
			//createTable();
			//insertOperation();
			//String[] s = new String[4];
			//s[1] = "glopez";
			//s[2] = "2000";
			//s[3] = "0"; 
			//insertToUserTable(s);
			//updateOperation();
			//deleteOperation();			
			//selectOperation();
			//dropTable("user");
			//dropTable("questions");
			//selectOperation();
			//selectOperationQuestions();
			//String[] s = getQuestion();
			//Print(s);
			//close();
	//}
	public static void Print(String[] s)
	{
		for(int index = 0; index < s.length; index++)
		{
			System.out.println("Index [" +  index + "] " + s[index] );
		}
	}
//--------------------------------------------------------------------------------------------------------------------------
	/*
	 * Takes command for both tables(USER and QUESTIONS). For the USER table: tablename,USERNAME,PASSWORD,ADMIN,SAVE,LOCATION 
	 * For the QUESTIONS table: tablename,QUESTION,ANSWER,POSSIBLE1,POSSIBLE2,POSSIBLE3,TRUEFALSE.
	 * @param String[] takes ([0]=tableName, [1]=colum1, [2]=colum2, [3]=colum3, [4]=colum4, [5]=colum5, [6]=colum6)
	 */
	public Database()
	{
		openTable();
		createTable();		
	}
	public boolean Database(String[] command)
	{
		if(command[0] == "questions")
		{
			return insertToQuestionSTable(command);
		}
		else
		{
			return insertToUserTable(command);
		}
	}
//--------------------------------------------------------------------------------------------------------------------------
	/*
	 * Opens maze database 
	 * @returns boolean true if opens database successfully, false if otherwise 
	 */
	
	/*
	 * Opens maze database
	 
	public Connection dbConnection() {
		try{
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:maze.db");
			c.setAutoCommit(false);
			return c; 
		}catch(Exception e)
		{
			return null; 
		}
		
	}*/
	public static boolean openTable()
	{
		try{
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:maze.db");
			c.setAutoCommit(false);
		}catch (Exception e)
		 {
			return false; 
		}
		return true; 
	}
	
//--------------------------------------------------------------------------------------------------------------------------
	/*
	 * Inserts into the Questions table. Returns true if successful, false otherwise. 
	 * @param String[] array takes [QUESTION,ANSWER,POSSIBLE1,POSSIBLE2,POSSIBLE3,TRUEFALSE] in that order. 
	 * @returns boolean true if successful and false otherwise.
	 */
	public static boolean insertToQuestionSTable(String[] command)
	{		
		try{
			stmt = c.createStatement();
			String sql = "INSERT INTO QUESTIONS (QUESTION,ANSWER,POSSIBLE1,POSSIBLE2,POSSIBLE3,TRUEFALSE,USED) " +
	                   "VALUES ('" + command[0] +"','" + command[1] + "', '" + command[2] + "', '" + command[3] +"', '" + command[4] +"', " + command[5] + "," + command[6]+");";
				stmt.executeUpdate(sql);
				
			stmt.close();
			c.commit();
			//c.close();
		}catch(Exception e)
		 {
			JOptionPane.showMessageDialog(null, e);
			return false; 
		}
		JOptionPane.showMessageDialog(null, "Question insertion Successful");
		return true; 
	}
//--------------------------------------------------------------------------------------------------------------------------
	/*
	 * Inserts into the USER table. Returns true if successful, false otherwise. 
	 * @param String[] array takes [tablename, ID,USERNAME,PASSWORD,ADMIN,SAVE,LOCATION] in that order
	 * @returns boolean true if insert successful, false if otherwise. 
	 */
	public static boolean insertToUserTable(String[] command)
	{		
		try{
			stmt = c.createStatement();
			String sql = "INSERT INTO USER (USERNAME,PASSWORD,ADMIN,SAVE,LOCATION,USED) " +
	                   "VALUES ('" + command[1] +"','" + command[2] + "'," + command[3] + ",'"+ command[4]+"','" + command[5]+"','"+ command[6]+"');";
				stmt.executeUpdate(sql);
				
			stmt.close();
			c.commit();
			//c.close();
		}catch(Exception e)
		 {
			JOptionPane.showMessageDialog(null,"Username Already Exist, Please try again.");
			return false; 
		}
		JOptionPane.showMessageDialog(null, "Add New User Successful");
		return true; 
	}	
	public static boolean hasAdminPrivileges(String username)
	{
		ResultSet result = null;
		boolean isAdmin = false; 
		boolean found = false; 
		try{
			stmt = c.createStatement();
			result = stmt.executeQuery("SELECT username, admin FROM USER where USERNAME='" + username +"';");
			
			while(result.next() && !found)
			{
				String userName = result.getString("username");
				boolean admin = result.getBoolean("admin");
				if((userName.compareTo(username) == 0) && admin)
				{
					isAdmin = true; 
					found = true; 
				}
			}
			System.out.println("Select database successfully\n");
			result.close();
			
			stmt.close();
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e.getClass().getName() + ": " + e.getMessage());
		}
		return isAdmin; 
	}
//--------------------------------------------------------------------------------------------------------------------------
	/*
	 * Creates tables for USER and QUESTIONS in the maze database
	 * @returns boolean true if created successfully, false otherwise 
	 */
	public static boolean createTable()
	{
		try{
			stmt = c.createStatement();
			String sql = "CREATE TABLE IF NOT EXISTS USER" +
	                   "(ID INTEGER PRIMARY KEY AUTOINCREMENT,"+
	                   "USERNAME VARCHAR(10) NOT NULL, " + 
	                   "PASSWORD VARCHAR(30) NOT NULL, " + 
	                   "ADMIN BOOLEAN NOT NULL, " +
	                   "SAVE VARCHAR(74) , " +
	                   "LOCATION VARCHAR(6), " +
	                   "USED VARCHAR(34), " +
	                   "UNIQUE(USERNAME));"; 
			stmt.executeUpdate(sql);
			
			sql = "CREATE TABLE IF NOT EXISTS QUESTIONS" +
	                   "(ID INTEGER PRIMARY KEY AUTOINCREMENT,"+
	                   "QUESTION VARCHAR(255) NOT NULL, " + 
	                   "ANSWER VARCHAR(255) NOT NULL, " + 
	                   "POSSIBLE1 VARCHAR(255) NOT NULL, " + 
	                   "POSSIBLE2 VARCHAR(255) NOT NULL, " +
	                   "POSSIBLE3 VARCHAR(255) NOT NULL, " + 
	                   "TRUEFALSE BOOLEAN NOT NULL, " +
	                   "USED BOOLEAN NOT NULL);";
			stmt.executeUpdate(sql);
	
			stmt.close();
			//c.close();
		}catch(Exception e)
		 {
			JOptionPane.showMessageDialog(null, "Something went wrong");
			return false; 
		}
		return true; 
	}
//--------------------------------------------------------------------------------------------------------------------------
	/*
	 * Selects everything from the USER table
	 */
	public static ResultSet selectOperation()
	{	
		ResultSet result = null;
		try{
			stmt = c.createStatement();
			result = stmt.executeQuery("SELECT * FROM USER;");
			
			while(result.next())
			{
				int id = result.getInt("id");
				String username = result.getString("username");
				String password  = result.getString("password");
				boolean admin = result.getBoolean("admin");
				String save = result.getString("save");
				String location = result.getString("location");
				String used = result.getString("used");
				
				System.out.println();
				System.out.println("ID = " + id);
				System.out.println("USERNAME = " + username);
				System.out.println("PASSWORD = " + password);
				System.out.println("ADMIN " + admin);
				System.out.println("SAVE = " + save);
				System.out.println("LOCATION = " + location);
				System.out.println("USED = " + used);
			}
			System.out.println("Select database successfully\n");
			result.close();
			
			stmt.close();
			//c.close();
		}catch(Exception e)
		 {
			
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
		return result;
	}

	public static ResultSet selectOperationQuestions()
	{	
		//QUESTION,ANSWER,POSSIBLE1,POSSIBLE2,POSSIBLE3,TRUEFALSE, USED
		ResultSet result = null;
		try{
			stmt = c.createStatement();
			result = stmt.executeQuery("SELECT * FROM QUESTIONS;");
			
			while(result.next())
			{
				int id = result.getInt("id");
				String question = result.getString("question");
				String answer  = result.getString("answer");
				String poss1 = result.getString("possible1");
				String poss2 = result.getString("possible2");
				String poss3 = result.getString("possible3");
				boolean truefalse = result.getBoolean("truefalse");
				boolean used = result.getBoolean("used");
				
				System.out.println();
				System.out.println("ID = " + id);
				System.out.println("question = " + question);
				System.out.println("answer = " + answer);
				System.out.println("Possible1 = " + poss1);
				System.out.println("Possible2 = " + poss2);
				System.out.println("possible3 = " + poss3);
				System.out.println("truefalse = " + truefalse);
				System.out.println("used = " + used);
			}
			System.out.println("Select database successfully\n");
			result.close();
			
			stmt.close();
			//c.close();
		}catch(Exception e)
		 {
			
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
		return result;
	}
//--------------------------------------------------------------------------------------------------------------------------
	private static void insertOperation()//false = 0, true = 1; 
	{
		try{
			stmt = c.createStatement();
			String sql = "INSERT INTO USER (USERNAME,PASSWORD,ADMIN,SAVE,LOCATION,USED) " +
	                   "VALUES ('admin','admin', 1, NULL, NULL,'4 5 8');";
				stmt.executeUpdate(sql);
				
			sql = "INSERT INTO QUESTIONS (QUESTION,ANSWER,POSSIBLE1,POSSIBLE2,POSSIBLE3,TRUEFALSE, USED) " +
		                  "VALUES ('From what city are the EWU','Cheney', 'Spokane', 'Medical Lake', 'Airway Heights', 1, 0);";
				stmt.executeUpdate(sql);
				
			stmt.close();
			c.commit();
			
		}catch(Exception e)
		 {
			JOptionPane.showMessageDialog(null, "Data already exist");	
		}
		System.out.println("Records created successfully");
	}	
//--------------------------------------------------------------------------------------------------------------------------
	/*
	 * Updates either USER or QUESTIONS table depending on the command[0]
	 * @param String[] takes tablesName, updateColumnName, UpdateColumnNameValue, whereColumnNameValue
	 * @returns boolean true if update successful, false if otherwise
	 */
	public static boolean updateOperation(String[] command)
	{// needs table name, colum name, value, whereCommand, whereCommandValue
		try
		{
			stmt = c.createStatement();
			String sql = "UPDATE " + command[0] +" set "+ command[1] +" = '"+ command[2] +"' where id="+ command[3] +";";
			stmt.executeUpdate(sql);
			c.commit();
	        stmt.close();
		}catch ( Exception e )
		 {
			JOptionPane.showMessageDialog(null, e);
			//JOptionPane.showMessageDialog(null, command[1] + " was not able to update to "+ command[2] +" Please make sure id number is correct");
		     return false; 
		 }
		 return true; 
	}
	
//--------------------------------------------------------------------------------------------------------------------------
	/*
	 *Deletes from tables specified with the string id number.
	 *@param String, String  table name and id number
	 *@returns boolean true if deletion successful, false if otherwise 
	 */
	public static boolean deleteOperation(String tableName, String id)
	{
		if(Integer.parseInt(id) == 1 && tableName.compareTo("USER") == 0)
		{
			JOptionPane.showMessageDialog(null , "Cannot delete an admin account");
			return false; 
		}
		try
		{
			stmt = c.createStatement();
		    String sql = "DELETE FROM " + tableName +" WHERE id = "+ id +";";
		    
		    stmt.executeUpdate(sql);
		    c.commit();
		    stmt.close();
		    //c.close();
		}catch ( Exception e )
		 {
		      JOptionPane.showMessageDialog(null, "Please enter a valid ID");
		      return false; 
		 }
		 JOptionPane.showMessageDialog(null, "Deletion Successful");
		 return true; 
	}
//--------------------------------------------------------------------------------------------------------------------------
	/*
	 * Drops specified table from maze database. 
	 * @param 
	 * @returns boolean true database dropped successful, false if otherwise
	 */
	public static boolean dropTable(String tableName)
	{
		try
		{
			stmt = c.createStatement();
			//String sql = "DROP TABLE IF EXISTS " + tableName + " ;";
			String sql = "DROP TABLE " + tableName + " ;"; //added this methods so that if not exist it throws an error
			stmt.executeUpdate(sql);
			c.commit();			
			stmt.close();
		}catch ( Exception e )
		 {
		      return false; 
		 }
		 return true; 
	}
	//--------------------------------------------------------------------------------------------------------------------------
		/*
		 * getQuestion will traverse through the database questions and grab only the none repeated question. 
		 * @returns String[] returns a question array, where [0]=question, [1]=answer, [2]=poss1, [3]=poss2, [4]=poss3
		 */
	public static String[] getQuestion()
	{			
		String [] question = new String[6];	
		Arrays.fill(question, "E");
		
		int found = 0;
		
		ResultSet result = null;
		
		try{
			stmt = c.createStatement();
			result = stmt.executeQuery("SELECT * FROM QUESTIONS;");
			
			while(result.next() && found !=1)
			{
				int id = result.getInt("id");
				String quest = result.getString("question");
				String answer  = result.getString("answer");
				String poss1 = result.getString("possible1");
				String poss2 = result.getString("possible2");
				String poss3 = result.getString("possible3");
				boolean isTrueFalse = result.getBoolean("truefalse");
				
				if(isTrueFalse && !usedQuestionId.contains(id))
				{
					question[0] = quest; 
					question[1] = answer; 
					question[2] = poss1; 
					question[3] = poss2; 
					found = 1; 
					usedQuestionId.add(id);
				}
				if(!isTrueFalse && !usedQuestionId.contains(id))
				{
					question[0] = quest; 
					question[1] = answer; 
					question[2] = poss1; 
					question[3] = poss2; 
					question[4] = poss3; 
					found = 1;
					usedQuestionId.add(id);
				}
			}
			System.out.println("Select database successfully\n");
			result.close();
			stmt.close();
			//c.close();
		}catch(Exception e)
		 {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
		return question; 
	}	
//--------------------------------------------------------------------------------------------------------------------------
	/*
	 * Closes maze database
	 */
	public static boolean close()
	{
		try{
			c.close();
		}catch ( Exception e )
		 {
		      return false; 
		 }
		 return true;
	}
//--------------------------------------------------------------------------------------------------------------------------
		
		public String[] getLoadedMap(String userName)
		{
			Maze maze = new Maze();
			String [] profile = new String[4];
			
			ResultSet result = null;
			try{
				stmt = c.createStatement();
				result = stmt.executeQuery("SELECT * FROM USER;");
				boolean found = false; 
				
				while(result.next() && !found)
				{
					String username = result.getString("username");
					String save = result.getString("save");
					String location = result.getString("location");
					String used = result.getString("used");
					
					if(username.compareTo(userName) == 0)
					{
						found = true; 
						profile[0] = "4 4";
						profile[1] = "0 0"; 
						profile[2] = maze.visit(); 
						profile[3] = "4 4";
						loadUsedQuestion(used);
					}
				}
				result.close();
				stmt.close();
				
			}catch(Exception e)
			 {
				System.err.println(e.getClass().getName() + ": " + e.getMessage());
			}
			return profile;   
		}
//--------------------------------------------------------------------------------------------------------------------------	
		/*
		 * Loads saved questions from user profile
		 */
		public void loadUsedQuestion(String usedQuestions)
		{
			usedQuestionId.clear();//clearing out array 
			
	        String[] storing = usedQuestions.split(" ");
			for(String used : storing)
			{
					usedQuestionId.add(used);
			}
		}
//--------------------------------------------------------------------------------------------------------------------------
				
		public boolean checkLogginCredentials(String username, String password) 
		{
			ResultSet result = null;
			try{
				stmt = c.createStatement();
				result = stmt.executeQuery("SELECT USERNAME, PASSWORD FROM USER;");
				
				while(result.next())
				{
					if((result.getString("username").compareTo(username) == 0) && (result.getString("password").compareTo(password) ==0))
					{
						return true; 
					}
				}
				System.out.println("Select database successfully\n");
				result.close();
				stmt.close();
			}catch(Exception e)
			 {
				JOptionPane.showMessageDialog(null, e.getMessage());
			} 
			return false;
		}

}
