package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Ava.Login;
import javax.swing.JFrame;
import static org.junit.jupiter.api.Assertions.*;


class LoginTest {

    private Login login;

    @BeforeEach
    public void setUp() {
        login = new Login();
    }

    @Test
    public void testFrameNotNull() {
        assertNotNull(login.frame);
    }

    @Test
    public void testFrameCloseOperation() {
        assertEquals(JFrame.EXIT_ON_CLOSE, login.frame.getDefaultCloseOperation());
    }

    @Test
    public void testUsernameFieldNotNull() {
        assertNotNull(login.getUsernameField());
    }

    @Test
    public void testPasswordFieldNotNull() {
        assertNotNull(login.getPasswordField());
    }

    @Test
    public void testUsernameAndPasswordFieldsInitiallyEmpty() {
        assertEquals("", login.getUsernameField().getText());
        assertEquals("", login.getPasswordField().getText());
    }
}