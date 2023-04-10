package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import otherUtil.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;

public class LoginJDBCIntegrationTest {

	public static String password = "MyN3wP4ssw0rd";// replace with your password
	public static String user = "root" ;
	private static final String TEST_DB_URL = "jdbc:mysql://localhost:3306/Flexx";

    @BeforeEach
    public void setUp() throws SQLException {
        JDBC.setDbUrl(TEST_DB_URL);
        try (Connection connection = DriverManager.getConnection(TEST_DB_URL, user, password);
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("DROP TABLE IF EXISTS userInfo");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS userInfo( Uname VARCHAR(255) NOT NULL, Upassword VARCHAR(255) NOT NULL);");
        }
    }
    
    @AfterEach
    public void tearDown() throws SQLException {
        try (Connection connection = DriverManager.getConnection(TEST_DB_URL,user,password);
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("DROP TABLE IF EXISTS userInfo");
        }
    }

    @Test
    public void testUserRegistrationAndAuthentication() throws SQLException {
        String username = "testUser";
        String password = "testPassword";

        assertFalse(JDBC.checkUsernameExists(username));
        JDBC.insertUser(username, password);
        assertTrue(JDBC.checkUsernameExists(username));

        boolean isAuthenticated = JDBC.checkUser(username, password);
        assertTrue(isAuthenticated);
    }

    @Test
    public void testFailedAuthenticationWithWrongPassword() throws SQLException {
        String username = "testUser";
        String password = "testPassword";
        String wrongPassword = "wrongPassword";

        JDBC.insertUser(username, password);
        boolean isAuthenticated = JDBC.checkUser(username, wrongPassword);

        assertFalse(isAuthenticated);
    }
}
