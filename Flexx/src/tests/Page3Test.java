package tests;

import static org.junit.Assert.assertEquals;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.junit.jupiter.api.Test;

import otherUtil.*;

class Page3Test {
	
	@Test
	void test1() {
		String dropQuery = "DROP TABLE exerciselogs;";
		try {
			Connection con = DriverManager.getConnection (JDBC.databaseURL,JDBC.user,JDBC.password);
			Statement statement = con.createStatement();
			statement.execute(dropQuery);
		} catch (SQLException err) {
			err.printStackTrace();
		}
		JDBC.createDB();
		JDBC.createTables();
		String exerciseName = "Bench Press";
		String reps = "5";
		String weight = "100";
		String tableSize = "0";
		String User = "TC";
		String insertQuery = "INSERT INTO exerciselogs VALUE(\""+exerciseName+"\", "+reps+", "+weight+", "+tableSize+", \""+User+"\");";
		try {
			Connection con = DriverManager.getConnection (JDBC.databaseURL,JDBC.user,JDBC.password);
			Statement statement = con.createStatement();
			statement.execute(insertQuery);
		} catch (SQLException err) {
			err.printStackTrace();
		}
		String testQuery1 = "SELECT * FROM exerciselogs WHERE exerciseName='Bench Press' AND Weight=100 AND Reps=5 AND WorkoutNumber=0 AND User='TC';";
		String exerciseNametest = null;
        int Weighttest = 0;
        int Repstest = 0;
        int WorkoutNumbertest = 0;
        String Username = null;
		try {
			Connection con = DriverManager.getConnection (JDBC.databaseURL,JDBC.user,JDBC.password);
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(testQuery1);
			while (rs.next()) {
                exerciseNametest = rs.getString("exerciseName");
                Weighttest = rs.getInt("Weight");
                Repstest = rs.getInt("Reps");
                WorkoutNumbertest = rs.getInt("WorkoutNumber");
                Username = rs.getString("User");
            }
		} catch (SQLException err) {
			err.printStackTrace();
		}
		
		assertEquals("Bench Press", exerciseNametest);
		assertEquals(5,Repstest);
		assertEquals(100,Weighttest);
		assertEquals(0,WorkoutNumbertest);
		assertEquals("TC",Username);
	}
	@Test
	void test2() {
		String dropQuery = "DROP TABLE exerciselogs;";
		try {
			Connection con = DriverManager.getConnection (JDBC.databaseURL,JDBC.user,JDBC.password);
			Statement statement = con.createStatement();
			statement.execute(dropQuery);
		} catch (SQLException err) {
			err.printStackTrace();
		}
		JDBC.createDB();
		JDBC.createTables();
		String exerciseName = "Lateral Raise";
		String reps = "50";
		String weight = "10";
		String tableSize = "1";
		String User = "TIMI";
		String insertQuery = "INSERT INTO exerciselogs VALUE(\""+exerciseName+"\", "+reps+", "+weight+", "+tableSize+", \""+User+"\");";;
		try {
			Connection con = DriverManager.getConnection (JDBC.databaseURL,JDBC.user,JDBC.password);
			Statement statement = con.createStatement();
			statement.execute(insertQuery);
		} catch (SQLException err) {
			err.printStackTrace();
		}
		String testQuery1 = "SELECT * FROM exerciselogs WHERE exerciseName='Lateral Raise' AND Weight=10 AND Reps=50 AND WorkoutNumber=1 AND User='TIMI';";
		String exerciseNametest = null;
        int Weighttest = 0;
        int Repstest = 0;
        int WorkoutNumbertest = 0;
        String Username = null;
		try {
			Connection con = DriverManager.getConnection (JDBC.databaseURL,JDBC.user,JDBC.password);
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(testQuery1);
			while (rs.next()) {
                exerciseNametest = rs.getString("exerciseName");
                Weighttest = rs.getInt("Weight");
                Repstest = rs.getInt("Reps");
                WorkoutNumbertest = rs.getInt("WorkoutNumber");
                Username = rs.getString("User");
            }
		} catch (SQLException err) {
			err.printStackTrace();
		}
		
		assertEquals("Lateral Raise", exerciseNametest);
		assertEquals(50,Repstest);
		assertEquals(10,Weighttest);
		assertEquals(1,WorkoutNumbertest);
		assertEquals("TIMI",Username);
	
	}
	@Test
	void test3() {
		String dropQuery = "DROP TABLE exerciselogs;";
		try {
			Connection con = DriverManager.getConnection (JDBC.databaseURL,JDBC.user,JDBC.password);
			Statement statement = con.createStatement();
			statement.execute(dropQuery);
		} catch (SQLException err) {
			err.printStackTrace();
		}
		JDBC.createDB();
		JDBC.createTables();
		String exerciseName = "Squat";
		String reps = "8";
		String weight = "405";
		String tableSize = "2";
		String User = "JJ";
		String insertQuery = "INSERT INTO exerciselogs VALUE(\""+exerciseName+"\", "+reps+", "+weight+", "+tableSize+", \""+User+"\");";;
		try {
			Connection con = DriverManager.getConnection (JDBC.databaseURL,JDBC.user,JDBC.password);
			Statement statement = con.createStatement();
			statement.execute(insertQuery);
		} catch (SQLException err) {
			err.printStackTrace();
		}
		String testQuery1 = "SELECT * FROM exerciselogs WHERE exerciseName='Squat' AND Weight=405 AND Reps=8 AND WorkoutNumber=2 AND User='JJ';";
		String exerciseNametest = null;
        int Weighttest = 0;
        int Repstest = 0;
        int WorkoutNumbertest = 0;
        String Username = null;
		try {
			Connection con = DriverManager.getConnection (JDBC.databaseURL,JDBC.user,JDBC.password);
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(testQuery1);
			while (rs.next()) {
                exerciseNametest = rs.getString("exerciseName");
                Weighttest = rs.getInt("Weight");
                Repstest = rs.getInt("Reps");
                WorkoutNumbertest = rs.getInt("WorkoutNumber");
                Username = rs.getString("User");
            }
		} catch (SQLException err) {
			err.printStackTrace();
		}
		
		assertEquals("Squat", exerciseNametest);
		assertEquals(8,Repstest);
		assertEquals(405,Weighttest);
		assertEquals(2,WorkoutNumbertest);
		assertEquals("JJ",Username);
	}

}
