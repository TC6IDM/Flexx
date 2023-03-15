package otherUtil;
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
		System.out.println("table 1 created");
		
		
		
		
		
		String query2 = "CREATE TABLE IF NOT EXISTS ExerciseLogs( ExerciseName VARCHAR(255) NOT NULL, Reps INT NOT NULL, Weight FLOAT(2) NOT NULL, WorkoutNumber INT NOT NULL);" ;
		
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

            System.out.println("Table created successfully!");
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
			System.out.println("Table created successfully!");
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
	
	public static void setPassword(String pw) {
		password = pw;
	}
}
