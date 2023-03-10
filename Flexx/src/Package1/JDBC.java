package Package1;
import java.sql.*;
public class JDBC{
	public static String password = "Oromidayo01";// replace ... with your password
	public static void main(String[] args) {}
	public static String DB_url = "jdbc:mysal://localhost:3306/Flexx";
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
		String query = "CREATE TABLE IF NOT EXISTS goals (" +
				"id INT NOT NULL UTO_INCREMENT,"+
				"goal VARCHAR(255),"+
				"PRIMARY KAY (id)" +
				")";
		try {
			// create connection
			Connection con = DriverManager.getConnection(url, user, password) ;
			// create statement
			Statement statement = con. createStatement ();
			// execute query
			statement.executeUpdate (query) ;
			// close statement and connection 
			statement.close();
			con.close();
			System.out.println("Table created successfully!");
		} catch (SQLException e) {
			e.printStackTrace () ;
		}
	}
}
