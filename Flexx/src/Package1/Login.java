package Package1;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;

import java.awt.Font;
import java.awt.Window;

public class Login {

	private JFrame frame;
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
		lblNewLabel.setBounds(51, 117, 140, 19);
		frame.getContentPane().add(lblNewLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(188, 117, 159, 19);
		frame.getContentPane().add(passwordField);
		
		JLabel lblUsername = new JLabel("USERNAME");
		lblUsername.setFont(new Font("Rockwell", Font.PLAIN, 20));
		lblUsername.setBounds(51, 62, 140, 19);
		frame.getContentPane().add(lblUsername);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = usernameField.getText();
				String password = passwordField.getText();
				
				if (username.equals("e") && password.equals("e")) {
					JOptionPane.showMessageDialog(frame, "Welcome");
				
					Home home = new Home();
					home.setVisible(true);
					frame.setVisible(false);
					
				}
				else {
					JOptionPane.showMessageDialog(frame, "Invalid Login");
				}
				
 			}
		});
		btnNewButton.setBounds(172, 189, 85, 21);
		frame.getContentPane().add(btnNewButton);
	}
}