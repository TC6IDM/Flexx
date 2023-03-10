package Package1;
import java.sql.*;
public class JDBC{
	public static String password = "MyN3wP4ssw0rd";// replace ... with your password
	public static String databaseURL = "jdbc:mysql://localhost:3306/Flexx" ;
	public static String hostURL = "jdbc:mysql://localhost:3306/" ;
	public static String user = "root" ;
	public static void main(String[] args) {}
	public static void createDB() {
		
		String query = "CREATE database Flexx" ;
		
		try {
			// create connection
			Connection con = DriverManager.getConnection (hostURL,user,password);
			
			 // create statement
			Statement statement = con.createStatement();
			
			 // generate result set
			statement.execute(query);
			

		} catch (SQLException e) {
//			e.printStackTrace();
		}
		System.out.println("database created");
	}
	public static void createTables() {
		
		String query = "CREATE TABLE userInfo( username VARCHAR(255) NOT NULL, password VARCHAR(255) NOT NULL);" ;
		
		try {
			// create connection
			Connection con = DriverManager.getConnection (databaseURL,user,password);
			
			 // create statement
			Statement statement = con.createStatement();
			
			 // generate result set
			statement.execute(query);
			

		} catch (SQLException e) {
//			e.printStackTrace();
		}
		System.out.println("table 1 created");
		
		
		
		
		
		String query2 = "CREATE TABLE ExerciseLogs( ExerciseName VARCHAR(255) NOT NULL, Reps INT NOT NULL, Weight FLOAT(2) NOT NULL, WorkoutNumber INT NOT NULL);" ;
		
		try {
			// create connection
			Connection con = DriverManager.getConnection (databaseURL,user,password);
			
			 // create statement
			Statement statement = con.createStatement();
			
			 // generate result set
			statement.execute(query2);
			

		} catch (SQLException e) {
//			e.printStackTrace();
		}
		System.out.println("table 2 created");
	}
}
