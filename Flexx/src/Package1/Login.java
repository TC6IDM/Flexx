package Package1;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

import java.awt.Font;

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
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		usernameField = new JTextField();
		usernameField.setBounds(188, 62, 159, 19);
		frame.getContentPane().add(usernameField);
		usernameField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("PASSWORD");
		lblNewLabel.setFont(new Font("Rockwell", Font.PLAIN, 20));
		lblNewLabel.setBounds(61, 109, 140, 43);
		frame.getContentPane().add(lblNewLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(188, 117, 159, 19);
		frame.getContentPane().add(passwordField);
		
		JLabel lblUsername = new JLabel("USERNAME");
		lblUsername.setFont(new Font("Rockwell", Font.PLAIN, 20));
		lblUsername.setBounds(51, 58, 140, 35);
		frame.getContentPane().add(lblUsername);
				
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = usernameField.getText();
				String password = passwordField.getText();
				boolean found = false;
				
		        try {
		            BufferedReader reader = new BufferedReader(new FileReader("users.txt"));
		            String line;
		            while ((line = reader.readLine()) != null) {
		                String[] parts = line.split(",");
		                if (parts.length == 2 && parts[0].equals(username) && parts[1].equals(password)) {
		                    found = true;
		                    break;
		                }
		            }
		            reader.close();
		        } catch (IOException ex) {
		            ex.printStackTrace();
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
		btnNewButton.setBounds(176, 189, 85, 21);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnClearButton = new JButton("Clear");
		btnClearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usernameField.setText("");
				passwordField.setText("");
			}
		});
		btnClearButton.setBounds(47, 185, 117, 29);
		frame.getContentPane().add(btnClearButton);
		
		JButton btnNewButton_1 = new JButton("Sign up");
		btnNewButton_1.setBounds(273, 185, 117, 29);
		frame.getContentPane().add(btnNewButton_1);
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
		            // save the username and password to a database or file
		            try {
		            	File file = new File("users.txt");
		            	if(!file.exists()) {
		            		file.createNewFile();
		            	}
		                BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
		                writer.write(username + "," + password + "\n");
		                writer.close();
		            JOptionPane.showMessageDialog(frame, "You have successfully signed up!");
		            } catch (IOException ex) {
		                ex.printStackTrace();
		            }
		        }
		    }
		});
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