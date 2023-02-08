package Package1;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FlexxClass {

	private JFrame frame;
	private JTextField username_TextField;
	private JTextField email_TextField;
	private JTextField password_TextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FlexxClass window = new FlexxClass();
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
	public FlexxClass() {
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
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(26, 21, 95, 13);
		frame.getContentPane().add(lblNewLabel);
		
		username_TextField = new JTextField();
		username_TextField.setBounds(10, 34, 111, 19);
		frame.getContentPane().add(username_TextField);
		username_TextField.setColumns(10);
		
		email_TextField = new JTextField();
		email_TextField.setBounds(141, 34, 96, 19);
		frame.getContentPane().add(email_TextField);
		email_TextField.setColumns(10);
		
		password_TextField = new JTextField();
		password_TextField.setBounds(264, 34, 96, 19);
		frame.getContentPane().add(password_TextField);
		password_TextField.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(167, 21, 45, 13);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(294, 21, 45, 13);
		frame.getContentPane().add(lblPassword);
		
		JButton btnNewButton = new JButton("Sign In");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(167, 173, 85, 21);
		frame.getContentPane().add(btnNewButton);
	}
}
