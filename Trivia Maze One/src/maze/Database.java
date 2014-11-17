package maze;

import java.sql.*;

public class Database {
	private static Connection c = null;
	private static Statement stmt = null;
	
	public static void main (String args[])
	{
		//if not exist 
		//when creating, deleting, inserting 
		//Insertion: check if username already exists 
		//if database dropped than SELECT cannot print
		
			openTable();
			createTable();
			insertOperation();
			//updateOperation();
			//deleteOperation();			
			selectOperation();
			//dropTable("user");
			//selectOperation();
			close();
	}
//--------------------------------------------------------------------------------------------------------------------------
	private Database(String username, String password, boolean admin)
	{
		insertOperation();
	}
//--------------------------------------------------------------------------------------------------------------------------
	/*
	 * Opens table
	 */
	private static void openTable()
	{
		try{
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:maze.db");
			c.setAutoCommit(false);
		}catch (Exception e)
		 {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Opened database Successfully");
	}
	
//--------------------------------------------------------------------------------------------------------------------------
	/*
	 * Used whenever the user creates profile
	 */
	private static void insertOperationParams(String username, String password, boolean admin)
	{
		//Converts boolean admin into 1 or 0 for database insertion purposes 
		int finaladmin;
		if(admin)
		{
			finaladmin = 1; 
		}
		else
		{
			finaladmin = 0;
		}
		
		
		try{
			stmt = c.createStatement();
			String sql = "INSERT INTO USER (USERNAME,PASSWORD,ADMIN,SAVE,LOCATION) " +
	                   "VALUES (" + username +"," + password + ", " + finaladmin + ", NULL, NULL);";
				stmt.executeUpdate(sql);
				
			stmt.close();
			c.commit();
		}catch(Exception e)
		 {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Records created successfully");
	}	
//--------------------------------------------------------------------------------------------------------------------------
	private static void createTable()
	{
		try{
			stmt = c.createStatement();
			String sql = "CREATE TABLE IF NOT EXISTS USER" +
	                   "(USERNAME CHAR(10) NOT NULL, " + 
	                   " PASSWORD INT NOT NULL, " + 
	                   " ADMIN BOOLEAN NOT NULL, " +
	                   " SAVE CHAR(255) , " +
	                   " LOCATION CHAR(255));"; 
			stmt.executeUpdate(sql);
			
			
			sql = "CREATE TABLE IF NOT EXISTS QUESTIONS" +
	                   "(QUESTION CHAR(255) NOT NULL, " + 
	                   " ANSWER CHAR(255) NOT NULL, " + 
	                   " POSSIBLE1 CHAR(255) NOT NULL, " + 
	                   " POSSIBLE2 CHAR(255) NOT NULL, " +
	                   " POSSIBLE3 CHAR(255) NOT NULL, " + 
	                   " TRUEFALSE BOOLEAN NOT NULL);";
			stmt.executeUpdate(sql);
	
			stmt.close();
		}catch(Exception e)
		 {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Table created successfully");
	}
//--------------------------------------------------------------------------------------------------------------------------
	private static void selectOperation()
	{
		try{
			stmt = c.createStatement();
			ResultSet result = stmt.executeQuery("SELECT * FROM USER;");
			while(result.next())
			{
				String username = result.getString("username");
				int password  = result.getInt("password");
				boolean admin = result.getBoolean("admin");
				String save = result.getString("save");
				String location = result.getString("location");
				
				System.out.println();
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
	private static void insertOperation()
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
	}	
//--------------------------------------------------------------------------------------------------------------------------
	private static void updateOperation()
	{
		try
		{
			stmt = c.createStatement();
			String sql = "UPDATE USER set password = 2014 where ID=1;";
			stmt.executeUpdate(sql);
			c.commit();
	        stmt.close();
		}catch ( Exception e )
		 {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		 }
		 System.out.println("Updating done successfully");
	}
//--------------------------------------------------------------------------------------------------------------------------
	
	private static void deleteOperation()
	{
		try
		{
			stmt = c.createStatement();
		    String sql = "DELETE from USER where ID=2;";
		    stmt.executeUpdate(sql);
		    c.commit();
		    stmt.close();
		}catch ( Exception e )
		 {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		 }
		 System.out.println("Deletion done successfully");
	}
//--------------------------------------------------------------------------------------------------------------------------
	private static void dropTable(String tableName)
	{
		try
		{
			stmt = c.createStatement();
			String sql = "DROP TABLE IF EXISTS " + tableName + " ;";
			stmt.executeUpdate(sql);
			c.commit();			
			stmt.close();
		}catch ( Exception e )
		 {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		 }
		 System.out.println("Dropped table successfully");
	}
//--------------------------------------------------------------------------------------------------------------------------
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



