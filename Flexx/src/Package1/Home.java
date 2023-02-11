package Package1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Home {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
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
	public Home() {
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
		
		JLabel lblNewLabel = new JLabel("HOME PAGE");
		lblNewLabel.setBounds(132, 10, 172, 35);
		lblNewLabel.setFont(new Font("Berlin Sans FB", Font.PLAIN, 31));
		frame.getContentPane().add(lblNewLabel);
		
		JButton Page1Button = new JButton("Page1");
		Page1Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Page1 page1 = new Page1();
				page1.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		Page1Button.setBounds(10, 180, 85, 21);
		frame.getContentPane().add(Page1Button);
		
		JButton Page2Button = new JButton("Page2");
		Page2Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Page2 page2 = new Page2();
				page2.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		Page2Button.setBounds(105, 180, 85, 21);
		frame.getContentPane().add(Page2Button);
		
		JButton Page3Button = new JButton("Page3");
		Page3Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Page3 page3 = new Page3();
				page3.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		Page3Button.setBounds(232, 180, 85, 21);
		frame.getContentPane().add(Page3Button);
		
		JButton Page4Button = new JButton("Page4");
		Page4Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Page4 page4 = new Page4();
				page4.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		Page4Button.setBounds(341, 180, 85, 21);
		frame.getContentPane().add(Page4Button);
		
		JButton Page5Button = new JButton("Page5");
		Page5Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Page5 page5 = new Page5();
				page5.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		Page5Button.setBounds(166, 232, 85, 21);
		frame.getContentPane().add(Page5Button);
		
		JButton Page5Button_1 = new JButton("Login");
		Page5Button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login login = new Login();
				login.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		Page5Button_1.setBounds(166, 97, 85, 21);
		frame.getContentPane().add(Page5Button_1);
		
		
	}

}
