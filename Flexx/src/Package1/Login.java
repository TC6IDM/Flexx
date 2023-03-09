package Package1;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

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
	 */
	public Login() {
		initialize();	
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.getContentPane().setForeground(new Color(77, 77, 77));
		frame.getContentPane().setBackground(new Color(77, 77, 77));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		usernameField = new JTextField();
		usernameField.setBounds(188, 101, 159, 19);
		frame.getContentPane().add(usernameField);
		usernameField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("PASSWORD:");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("San Francisco", Font.PLAIN, 18));
		lblNewLabel.setBounds(61, 119, 140, 43);
		frame.getContentPane().add(lblNewLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(188, 131, 159, 19);
		frame.getContentPane().add(passwordField);
		
		JLabel lblUsername = new JLabel("USERNAME:");
		lblUsername.setForeground(new Color(255, 255, 255));
		lblUsername.setFont(new Font("San Francisco", Font.PLAIN, 18));
		lblUsername.setBounds(63, 93, 140, 35);
		frame.getContentPane().add(lblUsername);
		
						
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(0, 122, 255));
		btnNewButton.setFont(new Font("San Francisco", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String username = usernameField.getText();
		        String password = passwordField.getText();
		        boolean found = false;
		        
		        try {
		        	JDBC.createTables();
		        	found = JDBC.checkUser(username, password);
		        	
		        } catch (SQLException ex) {
		        }
		            
		        if (found) {
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
		
		JButton btnClearButton = new JButton("Clear");
		btnClearButton.setForeground(Color.WHITE);
		btnClearButton.setBackground(new Color(0, 122, 255));
		btnClearButton.setFont(new Font("San Francisco", Font.BOLD, 14));
		btnClearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usernameField.setText("");
				passwordField.setText("");
			}
		});
		btnClearButton.setBounds(35, 183, 115, 30);
		frame.getContentPane().add(btnClearButton);
		
		JButton btnNewButton_1 = new JButton("Sign up");
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(new Color(0, 122, 255));
		btnNewButton_1.setFont(new Font("San Francisco", Font.BOLD, 14));
		btnNewButton_1.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent e) {
			    JTextField usernameField = new JTextField();
			    JTextField passwordField = new JPasswordField();
			    Object[] fields = {
			      "Username:", usernameField,
			      "Password:", passwordField
			    };
			    int option = JOptionPane.showConfirmDialog(frame, fields, "Sign up", JOptionPane.OK_CANCEL_OPTION);
			    
			    if (option == JOptionPane.OK_OPTION) {
			      String username = usernameField.getText();
			      String password = passwordField.getText();
			      
			      try {
			    	  JDBC.insertUser(username, password);
			    	  JOptionPane.showMessageDialog(frame,  "You have successfully signed up!"); 
			      } catch (Exception ex) {
			    	  JOptionPane.showMessageDialog(frame, "An error occurred while signing up.");
			          ex.printStackTrace();
			      }
			    }
			  }
			});
		btnNewButton_1.setBounds(285, 183, 115, 30);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/Flexx_icon.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img));
		lblNewLabel_1.setBounds(184, 11, 70, 70);
		frame.getContentPane().add(lblNewLabel_1);
	
	}
	
	public JTextField getUsernameField() {
	    return usernameField;
	}
	
	public JTextField getPasswordField() {
		return passwordField;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}