package otherUtil;
import java.sql.*;

import javax.swing.JOptionPane;
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
	}
	public static void createTables() {
		String query = "CREATE TABLE IF NOT EXISTS userInfo( Uname VARCHAR(255) NOT NULL, Upassword VARCHAR(255) NOT NULL);" ;
		
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
		
		
		
		
		
		String query2 = "CREATE TABLE IF NOT EXISTS ExerciseLogs( ExerciseName VARCHAR(255) NOT NULL, Reps INT NOT NULL, Weight FLOAT(2) NOT NULL, WorkoutNumber INT NOT NULL, User VARCHAR(255) NOT NULL);" ;
		
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
		
		String query3 = "CREATE TABLE IF NOT EXISTS goals (" +
                "id INT NOT NULL AUTO_INCREMENT," +
                "goal VARCHAR(255)," +
                "PRIMARY KEY (id)" +
                ")";

        try {
            // create connection
            Connection con = DriverManager.getConnection(databaseURL, user, password);

            // create statement
            Statement statement = con.createStatement();

            // execute query
            statement.executeUpdate(query3);

            // close statement and connection
            statement.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        try {
			String query4 = "CREATE TABLE IF NOT EXISTS breakfast (" +
					"id INT NOT NULL AUTO_INCREMENT," +
					"calories VARCHAR(255)," +
					"PRIMARY KEY (id)" +
					")";
			// create connection
			Connection con = DriverManager.getConnection(databaseURL, user, password) ;
			// create statement
			Statement statement = con. createStatement ();
			// execute query
			statement.executeUpdate (query4) ;
			// close statement and connection 
			statement.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace () ;
		}
        
        try {
			String query5 = "CREATE TABLE IF NOT EXISTS lunch (" +
					"id INT NOT NULL AUTO_INCREMENT," +
					"calories VARCHAR(255)," +
					"PRIMARY KEY (id)" +
					")";
			// create connection
			Connection con = DriverManager.getConnection(databaseURL, user, password) ;
			// create statement
			Statement statement = con. createStatement ();
			// execute query
			statement.executeUpdate (query5) ;
			// close statement and connection 
			statement.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace () ;
		}
        
        try {
			String query6 = "CREATE TABLE IF NOT EXISTS dinner (" +
					"id INT NOT NULL AUTO_INCREMENT," +
					"calories VARCHAR(255)," +
					"PRIMARY KEY (id)" +
					")";
			// create connection
			Connection con = DriverManager.getConnection(databaseURL, user, password) ;
			// create statement
			Statement statement = con. createStatement ();
			// execute query
			statement.executeUpdate (query6) ;
			// close statement and connection 
			statement.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace () ;
		}
        
        try {
			String query7 = "CREATE TABLE IF NOT EXISTS snacks (" +
					"id INT NOT NULL AUTO_INCREMENT," +
					"calories VARCHAR(255)," +
					"PRIMARY KEY (id)" +
					")";
			// create connection
			Connection con = DriverManager.getConnection(databaseURL, user, password) ;
			// create statement
			Statement statement = con. createStatement ();
			// execute query
			statement.executeUpdate (query7) ;
			// close statement and connection 
			statement.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace () ;
		}
        
        try {
			String query8 = "CREATE TABLE IF NOT EXISTS water (" +
					"id INT NOT NULL AUTO_INCREMENT," +
					"litres VARCHAR(255)," +
					"PRIMARY KEY (id)" +
					")";
			// create connection
			Connection con = DriverManager.getConnection(databaseURL, user, password) ;
			// create statement
			Statement statement = con. createStatement ();
			// execute query
			statement.executeUpdate (query8) ;
			// close statement and connection 
			statement.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace () ;
		}
        
        try {
			String query9 = "CREATE TABLE IF NOT EXISTS calburned (" +
					"id INT NOT NULL AUTO_INCREMENT," +
					"calories VARCHAR(255)," +
					"PRIMARY KEY (id)" +
					")";
			// create connection
			Connection con = DriverManager.getConnection(databaseURL, user, password) ;
			// create statement
			Statement statement = con. createStatement ();
			// execute query
			statement.executeUpdate (query9) ;
			// close statement and connection 
			statement.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace () ;
		}

	}
	
	public static void insertUser(String Uname, String Upassword) {
		String query = "INSERT INTO userInfo (Uname, Upassword) VALUES (?, ?)";
		
		try {
			// create connection
			Connection con = DriverManager.getConnection (databaseURL,user,password);
			
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
			e.printStackTrace();
		}
	
	}
	
	/* Checks if a user exists in the "userInfo" 
	 * table with the provided username and password.
	 */
	public static boolean checkUser(String Uname, String Upassword) throws SQLException {
	    String query = "SELECT * FROM userinfo WHERE Uname = ? AND Upassword = ?";
	    boolean found = false;

	    // create connection
	    Connection conn = DriverManager.getConnection(databaseURL, user, password);

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
	
	public static boolean checkUsernameExists(String Uname) throws SQLException {
		String query = "SELECT * FROM userinfo WHERE Uname = ?";
	    boolean exists = false;

	    // create connection
	    Connection conn = DriverManager.getConnection(databaseURL, user, password);

	    // create prepared statement
	    PreparedStatement stmt = conn.prepareStatement(query);
	    
	    stmt.setString(1, Uname);

	    // execute query and check result
	    ResultSet rs = stmt.executeQuery();
	    exists = rs.next();

	    // close resources
	    rs.close();
	    stmt.close();
	    conn.close();

	    return exists;
	}
	
	
	public static void setPassword(String pw) {
		password = pw;
	}
	
	// FOR INTEGRATION TESTING
    private static String dbUrl = "jdbc:sqlite:productionDb.sqlite"; // Replace with the URL of your production database

    // Add a static method to set the database URL
    public static void setDbUrl(String dbUrl) {
        JDBC.dbUrl = dbUrl;
    }

}
