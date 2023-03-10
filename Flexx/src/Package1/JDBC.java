package Package1;
import java.sql.*;
import java.sql.SQLException;


public class JDBC{
	private static String password = "MyN3wP4ssw0rd";// replace ... with your password
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
	
	/* Creates a table called "userInfo" in Flexx database, 
	 * if it does not already exist.
	 */
	public static void createTables() {
		String url = "jdbc:mysql://localhost:3306/Flexx" ;
		String user = "root" ;
		
		String query = "CREATE TABLE IF NOT EXISTS userInfo( Uname VARCHAR(255) NOT NULL, Upassword VARCHAR(255) NOT NULL);" ;
		
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
	
	/* Inserts a new user into the userInfo table with
	 * the provided username and password.
	 */
	public static void insertUser(String Uname, String Upassword) {
		String url = "jdbc:mysql://localhost:3306/Flexx" ;
		String user = "root" ;
		String query = "INSERT INTO userInfo (username, password) VALUES (?, ?)";
		
		try {
			// create connection
			Connection con = DriverManager.getConnection (url,user,password);
			
			 // create statement
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, Uname);
			pstmt.setString(2, Upassword);
			
			 // execute statement
			pstmt.executeUpdate();
			
			 // close resources
		    pstmt.close();
		    con.close();
		} catch (SQLException e) {
		}
	}
	
	/* Checks if a user exists in the "userInfo" 
	 * table with the provided username and password.
	 */
	public static boolean checkUser(String Uname, String Upassword) throws SQLException {
	    String url = "jdbc:mysql://localhost:3306/Flexx";
	    String user = "root";
	    String query = "SELECT * FROM userinfo WHERE username = ? AND password = ?";
	    boolean found = false;

	    // create connection
	    Connection conn = DriverManager.getConnection(url, user, password);

	    // create prepared statement
	    PreparedStatement stmt = conn.prepareStatement(query);
	    stmt.setString(1, Uname);
	    stmt.setString(2, Upassword);

	    // execute query and check result
	    ResultSet rs = stmt.executeQuery();
	    found = rs.next();

	    // close resources
	    rs.close();
	    stmt.close();
	    conn.close();

	    return found;
	}
	
}
