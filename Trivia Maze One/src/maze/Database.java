/*
 * Trivia Maze Database 
 * @author Fighting Mongoose
 * @version 1.0z build Nov 9, 2014
 * 
 */

package maze;

import java.sql.*;

public class Database 
{
	private static Connection c = null;
	private static Statement stmt = null;
	
	/*public static void main (String args[])
	{
		//if not exist 
		//when creating, deleting, inserting 
		//Insertion: check if username already exists 
		//if database dropped than SELECT cannot print
		
			//openTable();
			//createTable();
			//insertOperation();
			//updateOperation();
			//deleteOperation();			
			//selectOperation();
			//dropTable("user");
			//selectOperation();
			//close();
	}*/
//--------------------------------------------------------------------------------------------------------------------------
	/*
	 * Takes command for both tables(USER and QUESTIONS). For the USER table: tablename,USERNAME,PASSWORD,ADMIN,SAVE,LOCATION 
	 * For the QUESTIONS table: tablename,QUESTION,ANSWER,POSSIBLE1,POSSIBLE2,POSSIBLE3,TRUEFALSE.
	 * @param String[] takes ([0]=tableName, [1]=colum1, [2]=colum2, [3]=colum3, [4]=colum4, [5]=colum5, [6]=colum6)
	 */
	public Database(String[] command)
	{
		if(command[0] == "questions")
		{
			insertToQuestionSTable(command);
		}
		else
		{
			insertToUserTable(command);
		}
	}
//--------------------------------------------------------------------------------------------------------------------------
	/*
	 * Opens maze database 
	 * @returns boolean true if opens database successfully, false if otherwise 
	 */
	private static boolean openTable()
	{
		try{
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:maze.db");
			c.setAutoCommit(false);
		}catch (Exception e)
		 {
			return false; 
		}
		System.out.println("Opened database Successfully");
		return true; 
	}
	
//--------------------------------------------------------------------------------------------------------------------------
	/*
	 * Inserts into the Questions table. Returns true if successful, false otherwise. 
	 * @param String[] array takes [QUESTION,ANSWER,POSSIBLE1,POSSIBLE2,POSSIBLE3,TRUEFALSE] in that order. 
	 * @returns boolean true if successful and false otherwise.
	 */
	private static boolean insertToQuestionSTable(String[] command)
	{		
		try{
			stmt = c.createStatement();
			String sql = "INSERT INTO QUESTIONS (QUESTION,ANSWER,POSSIBLE1,POSSIBLE2,POSSIBLE3,TRUEFALSE) " +
	                   "VALUES (" + command[1] +"," + command[2] + ", " + command[3] + ", " + command[4] +", " + command[5] +", " + command[6] +");";
				stmt.executeUpdate(sql);
				
			stmt.close();
			c.commit();
		}catch(Exception e)
		 {
			return false; 
		}
		System.out.println("Records created successfully");
		return true; 
	}
//--------------------------------------------------------------------------------------------------------------------------
	/*
	 * Inserts into the USER table. Returns true if successful, false otherwise. 
	 * @param String[] array takes [tablename, ID,USERNAME,PASSWORD,ADMIN,SAVE,LOCATION] in that order
	 * @returns boolean true if insert successful, false if otherwise. 
	 */
	private static boolean insertToUserTable(String[] command)
	{		
		try{
			stmt = c.createStatement();
			String sql = "INSERT INTO USER (ID,USERNAME,PASSWORD,ADMIN,SAVE,LOCATION) " +
	                   "VALUES (" + command[1] +"," + command[2] + ", " + command[3] + ", "+ command[4] +", NULL, NULL);";
				stmt.executeUpdate(sql);
				
			stmt.close();
			c.commit();
		}catch(Exception e)
		 {
			return false; 
		}
		System.out.println("Records created successfully");
		return true; 
	}	
//--------------------------------------------------------------------------------------------------------------------------
	/*
	 * Creates tables for USER and QUESTIONS in the maze database
	 * @returns boolean true if created successfully, false otherwise 
	 */
	private static boolean createTable()
	{
		try{
			stmt = c.createStatement();
			String sql = "CREATE TABLE IF NOT EXISTS USER" +
	                   "(ID INT NOT NULL,"+
	                   "USERNAME CHAR(10) NOT NULL, " + 
	                   " PASSWORD INT NOT NULL, " + 
	                   " ADMIN BOOLEAN NOT NULL, " +
	                   " SAVE CHAR(255) , " +
	                   " LOCATION CHAR(255));"; 
			stmt.executeUpdate(sql);
			
			
			sql = "CREATE TABLE IF NOT EXISTS QUESTIONS" +
	                   "(ID INT NOT NULL,"+
	                   " QUESTION CHAR(255) NOT NULL, " + 
	                   " ANSWER CHAR(255) NOT NULL, " + 
	                   " POSSIBLE1 CHAR(255) NOT NULL, " + 
	                   " POSSIBLE2 CHAR(255) NOT NULL, " +
	                   " POSSIBLE3 CHAR(255) NOT NULL, " + 
	                   " TRUEFALSE BOOLEAN NOT NULL);";
			stmt.executeUpdate(sql);
	
			stmt.close();
		}catch(Exception e)
		 {
			return false; 
		}
		System.out.println("Table created successfully");
		return true; 
	}
//--------------------------------------------------------------------------------------------------------------------------
	/*
	 * Selects everything from the USER table
	 */
	private static void selectOperation()
	{
		try{
			stmt = c.createStatement();
			ResultSet result = stmt.executeQuery("SELECT * FROM USER;");
			while(result.next())
			{
				int id = result.getInt("id");
				String username = result.getString("username");
				int password  = result.getInt("password");
				boolean admin = result.getBoolean("admin");
				String save = result.getString("save");
				String location = result.getString("location");
				
				System.out.println();
				System.out.println("ID = " + id);
				System.out.println("USERNAME = " + username);
				System.out.println("PASSWORD = " + password);
				System.out.println("ADMIN " + admin);
				System.out.println("SAVE = " + save);
				System.out.println("LOCATION = " + location);
			}
			System.out.println("Select database successfully\n");
			result.close();
			
			stmt.close();
		}catch(Exception e)
		 {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}	
	}
//--------------------------------------------------------------------------------------------------------------------------
	/*private static void insertOperation()
	{
		try{
			stmt = c.createStatement();
			String sql = "INSERT INTO USER (USERNAME,PASSWORD,ADMIN,SAVE,LOCATION) " +
	                   "VALUES ('glopez227777','2000', 0, NULL, NULL);";
				stmt.executeUpdate(sql);
				
			sql = "INSERT INTO QUESTIONS (QUESTION,ANSWER,POSSIBLE1,POSSIBLE2,POSSIBLE3,TRUEFALSE) " +
		                  "VALUES ('From what city are the EWU','Cheney', 'Spokane', 'Medical Lake', 'Airway Heights', 1);";
				stmt.executeUpdate(sql);
				
			stmt.close();
			c.commit();
		}catch(Exception e)
		 {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Records created successfully");
	}	*/
//--------------------------------------------------------------------------------------------------------------------------
	/*
	 * Updates either USER or QUESTIONS table depending on the command[0]
	 * @param String[] takes tablesName, updateColumnName, UpdateColumnNameValue, whereColumnName, whereColumnNameValue
	 * @returns boolean true if update successful, false if otherwise
	 */
	private static boolean updateOperation(String[] command)
	{// needs table name, colum name, value, whereCommand, whereCommandValue
		try
		{
			stmt = c.createStatement();
			String sql = "UPDATE " + command[0] +" set "+ command[1] +"  = "+ command[2] +" where "+ command[3] +"= "+ command[4] +";";
			stmt.executeUpdate(sql);
			c.commit();
	        stmt.close();
		}catch ( Exception e )
		 {
		      return false; 
		 }
		 System.out.println("Updating done successfully");
		 return true; 
	}
//--------------------------------------------------------------------------------------------------------------------------
	/*
	 *Deletes from tables specified with the string id number.
	 *@param String, String  table name and id number
	 *@returns boolean true if deletion successful, false if otherwise 
	 */
	private static boolean deleteOperation(String tableName, String id)
	{
		try
		{
			stmt = c.createStatement();
		    String sql = "DELETE from " + tableName +" where ID="+ id +";";
		    
		    stmt.executeUpdate(sql);
		    c.commit();
		    stmt.close();
		}catch ( Exception e )
		 {
		      return false; 
		 }
		 System.out.println("Deletion done successfully");
		 return true; 
	}
//--------------------------------------------------------------------------------------------------------------------------
	/*
	 * Drops specified table from maze database. 
	 * @param 
	 * @returns boolean true database dropped successful, false if otherwise
	 */
	private static boolean dropTable(String tableName)
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
		 System.out.println("Dropped table successfully");
		 return true; 
	}
//--------------------------------------------------------------------------------------------------------------------------
	/*
	 * Closes maze database
	 */
	private static void close()
	{
		try{
			c.close();
		}catch ( Exception e )
		 {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		 }
		 System.out.println("Closed successfully");
	}
}



