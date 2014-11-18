package maze;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DatabaseUnitTest 
{
	private static String[] command = new String[7];
	private static Database tables;
	
	@Before
	public static void setUpBeforeClass() throws Exception {
		assertEquals(true , tables.openTable());
		assertEquals(true, tables.createTable());
	}
	
	@Test
	public static void addingUserProfile() throws Exception {
		command[0] = "USER";
		command[1] = "testName";
		command[2] = "test";
		command[3] = "0";
		command[4] = "";
		command[5] = "";
		command[6] = "";
		assertEquals(true , tables.insertToUserTable(command));
	}
	
	@Test
	public void addingQuestions() throws Exception {
		command[0] = "QUESTIONS";
		command[1] = "What quarter are we in";
		command[2] = "fall";
		command[3] = "winter";
		command[4] = "fall";
		command[5] = "spring";
		command[6] = "0";
		assertEquals(true, tables.insertToQuestionSTable(command));
	}

	@Test
	public void tearDownApplication() throws Exception {
		assertEquals(true , tables.close());
	}

	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

}
