package otherUtil;

import Ava.*;

public class Flexx{
	public static void main(String[] args) {
		JDBC.createDB();
		JDBC.createTables();
		Login login = new Login();
		login.frame.setVisible(true);
	
	}

}