package Package1;
import java.sql.*;
public class JDBC{
	private static String password = "Oromidayo01";// replace ... with your password
	public static void main(String[] args) {}
	public static String url = "jdbc:mysql://localhost:3306/" ;
	public static String user = "root" ;
	public static String query = "CREATE database Flexx" ;
	
	public static void createDB() {
		
		try {
			// create connection
			Connection con = DriverManager.getConnection (url,user,password);
			
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
		
		//change my table from here
		//only change the query
		String query = "CREATE TABLE BREAKFAST( textField VARCHAR(255) NOT NULL);" ;
		
		try {
			// create connection
			Connection con = DriverManager.getConnection (url,user,password);
			
			 // create statement
			Statement statement = con.createStatement();
			
			 // generate result set
			statement.execute(query);
			

		} catch (SQLException e) {
//			e.printStackTrace();
		}
		System.out.println("table 1 created");
	}
}
