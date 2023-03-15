package Ava;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import otherUtil.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

import java.awt.Font;
import java.awt.Image;

public class Login implements ActionListener{

	// Declare variables
	public static String USERID;
	public JFrame frame;
	private JTextField usernameField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * The constructor for the Login class
	 */
	public Login() {
		initialize();	
	}

	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	private void initialize() {
		
		// Creating the main frame
		frame = new JFrame();
		frame.getContentPane().setEnabled(false);
		frame.getContentPane().setForeground(new Color(77, 77, 77));
		frame.getContentPane().setBackground(new Color(77, 77, 77));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		// Creating the username input field
		usernameField = new JTextField();
		usernameField.setBounds(188, 101, 159, 19);
		frame.getContentPane().add(usernameField);
		usernameField.setColumns(10);
		
		// Creating the password label
		JLabel lblNewLabel = new JLabel("PASSWORD:");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("San Francisco", Font.PLAIN, 18));
		lblNewLabel.setBounds(61, 119, 140, 43);
		frame.getContentPane().add(lblNewLabel);
		
		// Creating the password input field
		passwordField = new JPasswordField();
		passwordField.setBounds(188, 131, 159, 19);
		frame.getContentPane().add(passwordField);
		
		// Creating the username label
		JLabel lblUsername = new JLabel("USERNAME:");
		lblUsername.setForeground(new Color(255, 255, 255));
		lblUsername.setFont(new Font("San Francisco", Font.PLAIN, 18));
		lblUsername.setBounds(63, 93, 140, 35);
		frame.getContentPane().add(lblUsername);
		
		// Creating the Login button
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBackground(new Color(0, 122, 255));
		btnNewButton.setFont(new Font("San Francisco", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String username = usernameField.getText();
		        String password = passwordField.getText();
		        boolean found = false;
		        
		        try {
		        	// Creating tables and checking user credentials from database
		        	JDBC.createTables();
		        	found = JDBC.checkUser(username, password);
		        	
		        } catch (SQLException ex) {
		        }
		            
		        // Opening Home window if user credentials are valid
		        if (found) {
		        	USERID = username;
		            JOptionPane.showMessageDialog(frame, "Welcome");
		            Home home = new Home();
		            home.frame.setVisible(true);
		            frame.setVisible(false);
		        } else {
		            JOptionPane.showMessageDialog(frame, "Invalid Login");
		        }
		    }
		});
		btnNewButton.setBounds(160, 183, 115, 30);
		frame.getContentPane().add(btnNewButton);
		
		// Create a Clear button and set its properties
		JButton btnClearButton = new JButton("Clear");
		btnClearButton.setBackground(new Color(0, 122, 255));
		btnClearButton.setFont(new Font("San Francisco", Font.BOLD, 14));
		
		// Add an action listener to the Clear button to clear the input fields
		btnClearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usernameField.setText("");
				passwordField.setText("");
			}
		});
		
		// Set the bounds of the Clear button and add it to the frame
		btnClearButton.setBounds(35, 183, 115, 30);
		frame.getContentPane().add(btnClearButton);
		
		// Create a Sign up button and set its properties
		JButton btnNewButton_1 = new JButton("Sign up");
		btnNewButton_1.setBackground(new Color(0, 122, 255));
		btnNewButton_1.setFont(new Font("San Francisco", Font.BOLD, 14));
		
		// Add action listener to the sign up button
		btnNewButton_1.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent e) {
				  
				// Create input fields for the username and password
			    JTextField usernameField = new JTextField();
			    JTextField passwordField = new JPasswordField();
			    Object[] fields = {
			    		
			    // Add the input fields to a dialog box
			      "Username:", usernameField,
			      "Password:", passwordField
			    };
			    int option = JOptionPane.showConfirmDialog(frame, fields, "Sign up", JOptionPane.OK_CANCEL_OPTION);
			    
				// If the user clicks the OK button, save the username and password to the database using JDBC
			    if (option == JOptionPane.OK_OPTION) {
			      String username = usernameField.getText();
			      String password = passwordField.getText();
			      
			      try {
			    	  JDBC.insertUser(username, password);
			    	  JOptionPane.showMessageDialog(frame,  "You have successfully signed up!");
			    	  USERID = username;
			          Home home = new Home();
			          home.frame.setVisible(true);
			          frame.setVisible(false);
			      } catch (Exception ex) {
			    	  JOptionPane.showMessageDialog(frame, "An error occurred while signing up.");
			          ex.printStackTrace();
			      }
			    }
			  }
			});
		
		// Set the bounds of the Sign up button and add it to the frame
		btnNewButton_1.setBounds(285, 183, 115, 30);
		frame.getContentPane().add(btnNewButton_1);
		
		// Create a label for the Flexx icon and set its properties
		JLabel lblNewLabel_1 = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/Flexx_icon.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img));
		lblNewLabel_1.setBounds(184, 11, 70, 70);

		frame.getContentPane().add(lblNewLabel_1); // Add the label to the frame
	
	}
	
	// Define methods to get the username and password fields
	public JTextField getUsernameField() {
	    return usernameField;
	}
	public JTextField getPasswordField() {
		return passwordField;
	}
	
	// Override the actionPerformed method, which is not used in this code
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}