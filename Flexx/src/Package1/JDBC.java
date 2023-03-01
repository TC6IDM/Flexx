package Package1;
import java.sql.*;
public class JDBC{
	private static String password = "eLYse2979";// replace ... with your password
	public static void main(String[] args) {}
	public static void createDB() {
		String url = "jdbc:mysql://localhost:3306/" ;
		String user = "root" ;
		String query = "CREATE database Flexx" ;
		
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
		String url = "jdbc:mysql://localhost:3306/Flexx" ;
		String user = "root" ;
		
		
		String query = "CREATE TABLE userInfo( username VARCHAR(255) NOT NULL, password VARCHAR(255) NOT NULL);" ;
		
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
