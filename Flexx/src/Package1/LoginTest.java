package Package1;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.junit.jupiter.api.*;

class LoginTest {
	
	    @Test
	    public void testSignUp() {
	        String username = "John";
	        String password = "123";
	        
	        // sign-up with the given parameters
	        performSignUp(username, password);

	        // verify user was added to the txt file
	        assertTrue(verifyUserExists(username, password));
	    }

	    private void performSignUp(String username, String password) {
	        // TODO: Implement sign-up logic here
	        // write the username and password to a txt file
	        try {
	            FileWriter writer = new FileWriter("TestCaseUsers.txt", true);
	            writer.write(username + "," + password + "\n");
	            writer.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    private boolean verifyUserExists(String username, String password) {
	        try {
	            BufferedReader reader = new BufferedReader(new FileReader("TestCaseUsers.txt"));
	            String line;
	            while ((line = reader.readLine()) != null) {
	                String[] tokens = line.split(",");
	                if (tokens.length == 2 && tokens[0].equals(username) && tokens[1].equals(password)) {
	                    reader.close();
	                    return true;
	                }
	            }
	            reader.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return false;
	    
	}
	    
	    @Test
	    public void testSignUpAndLogin() {
	        // sign up a new user
	        String username = "John";
	        String password = "123";
	        signUp(username, password);

	        // attempt log in with credentials
	        boolean success = login(username, password);
	        assertTrue(success);
	    }

	    private void signUp(String username, String password) {
	        // write new user to the file
	        try (PrintWriter out = new PrintWriter(new FileWriter("TestCaseUsers.txt", true))) {
	            out.println(username + "," + password);
	        } catch (IOException e) {
	            fail("Failed to write to file: " + e.getMessage());
	        }
	    }

	    private boolean login(String username, String password) {
	        // read the file and see if the username and password match
	        try (BufferedReader in = new BufferedReader(new FileReader("TestCaseUsers.txt"))) {
	            String line;
	            while ((line = in.readLine()) != null) {
	                String[] tokens = line.split(",");
	                if (tokens.length == 2 && tokens[0].equals(username) && tokens[1].equals(password)) {
	                    return true;
	                }
	            }
	        } catch (IOException e) {
	            fail("Failed to read from file: " + e.getMessage());
	        }
	        return false;
	    }
}