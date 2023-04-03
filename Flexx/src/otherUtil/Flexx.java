package otherUtil;

import javax.swing.UIManager;

import Ava.*;

public class Flexx {
	public static void main(String[] args) {
		
		try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            // If the system look and feel is not available, you can set the GUI to another look and feel.
        }
		
		JDBC.createDB();
		JDBC.createTables();
	
		Login login = new Login();
        login.frame.setVisible(true);
    }
}