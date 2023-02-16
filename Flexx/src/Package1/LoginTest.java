package Package1;

import static org.junit.jupiter.api.Assertions.*;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LoginTest {

    private Login login;

    @BeforeEach
    public void setUp() {
        login = new Login();
    }

    @Test
    public void testClearButton() {
        JTextField usernameField = login.getUsernameField();
        JPasswordField passwordField = new JPasswordField();


        // Set the username and password fields to non-empty values
        usernameField.setText("test");
        passwordField.setText("password");

        // Click the Clear button
        JButton clearButton = (JButton) login.frame.getContentPane().getComponent(3);
        clearButton.doClick();

        // Check that the fields are now empty
        assertEquals("", usernameField.getText());
        assertEquals("", passwordField.getText());
    }
}