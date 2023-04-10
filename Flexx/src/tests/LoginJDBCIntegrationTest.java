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

    private static final String TEST_DB_URL = "jdbc:sqlite:testdb.sqlite";

    @BeforeEach
    public void setUp() throws SQLException {
        JDBC.setDbUrl(TEST_DB_URL);
        JDBC.createTables();
    }

    @AfterEach
    public void tearDown() throws SQLException {
        try (Connection connection = DriverManager.getConnection(TEST_DB_URL);
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
