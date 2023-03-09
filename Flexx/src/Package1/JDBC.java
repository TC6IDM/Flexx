package Package1;
import java.sql.*;
public class JDBC{
	public static String password = "eLYse2979";// replace ... with your password
	public static void main(String[] args) {}
	public static String DB_url = "jdbc:mysql://localhost:3306/Flexx";
	public static String my_url = "jdbc:mysql://localhost:3306/" ;
	public static String user = "root" ;
	public static void createDB() {
		
		String query = "CREATE database Flexx" ;
		
		try {
			// create connection
			Connection con = DriverManager.getConnection (my_url,user,password);
			
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
		
		
		
		String query = "INSERT INTO goals (goal, completed) VALUES (?, ?)";
		
		try {
			// create connection
			Connection con = DriverManager.getConnection (DB_url,user,password);
			
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
