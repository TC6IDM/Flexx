package Package1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

class Page4Test {

	@Test
	void test1() {
		
		JDBC.createDB();
		JDBC.createTables();
		String goal = "go on 3 walks this week";
		String testQuery = "INSERT INTO goals (\""+goal+"\") VALUES (?)";
		
		try {
			
				Connection con = DriverManager.getConnection(JDBC.databaseURL, JDBC.user, JDBC.password);
				
				Statement statement = con.createStatement();
				
				statement.execute(testQuery);
		}catch(SQLException err) {
			//err.printStackTrace();
		}
		
		assertEquals("go on 3 walks this week", goal);
	}
	
	@Test
	void test2() {
		JDBC.createDB();
		JDBC.createTables();
		String goal = "";
		String testQuery = "INSERT INTO goals (\""+goal+"\") VALUES (?)";

		
		try {
			
			Connection con = DriverManager.getConnection(JDBC.databaseURL, JDBC.user, JDBC.password);
			
			Statement statement = con.createStatement();
			
			statement.execute(testQuery);
	}catch(SQLException err) {
		//err.printStackTrace();
	}
	
	assertEquals("", goal);
	}
	
	@Test
	void test3() {
		JDBC.createDB();
		JDBC.createTables();
		String goal = "__workout 4 times this week_";
		String testQuery = "INSERT INTO goals (\""+goal+"\") VALUES (?)";

		
		try {
			
			Connection con = DriverManager.getConnection(JDBC.databaseURL, JDBC.user, JDBC.password);
			
			Statement statement = con.createStatement();
			
			statement.execute(testQuery);
	}catch(SQLException err) {
		//err.printStackTrace();
	}
	
	assertEquals("__workout 4 times this week_", goal);
		
	}

}
