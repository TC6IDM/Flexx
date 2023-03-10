package Package1;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
        boolean expected = false;
        boolean actual = JDBC.checkUser(username, password);
        assertFalse(actual);
    }
    
    @Test
    public void testCheckUserNonexistentUser() throws Exception {
        String username = "nonexistentuser";
        String password = "rdmpassword";
        boolean expected = false;
        boolean actual = JDBC.checkUser(username, password);
        assertFalse(actual);
    }
    
}


