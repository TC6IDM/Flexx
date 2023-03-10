package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import otherUtil.*;

class JDBCTest {

    @Test
    public void testInsertUser() throws SQLException {
        String testUsername = "testuser";
        String testPassword = "testpassword";
        
        JDBC.createDB();
        JDBC.createTables();
        
        // inserts user information into table
        JDBC.insertUser(testUsername, testPassword);

        // checks if user information is in table
        boolean found = JDBC.checkUser(testUsername, testPassword);

        Assertions.assertTrue(found);
        
    }
    
    @Test
    public void testCheckUserInvalidLogin() throws Exception {
        String username = "testuser";
        String password = "wrongpassword";
        boolean actual = JDBC.checkUser(username, password);
        assertFalse(actual);
    }
    
    @Test
    public void testCheckUserNonexistentUser() throws Exception {
        String username = "nonexistentuser";
        String password = "rdmpassword";
        boolean actual = JDBC.checkUser(username, password);
        assertFalse(actual);
    }
    
}


