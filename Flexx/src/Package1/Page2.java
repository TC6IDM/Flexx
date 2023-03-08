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

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;

public class Page2 {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Page1 window = new Page1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public Page2() {
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
		
		JLabel lblNewLabel = new JLabel("PAGE 2");
		lblNewLabel.setBounds(132, 10, 172, 35);
		lblNewLabel.setFont(new Font("Berlin Sans FB", Font.PLAIN, 31));
		frame.getContentPane().add(lblNewLabel);
		
//		JButton btnNewButton = new JButton("Back");
//		btnNewButton.setBounds(10, 10, 77, 35);
//		btnNewButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				Home home = new Home();
//				home.frame.setVisible(true);
//				frame.setVisible(false);
//			}
//		});
//		frame.getContentPane().add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 50, 416, 203);
		JButton btnNewButton2 = new JButton("Back");
		btnNewButton2.setBounds(10, 10, 77, 35);
		btnNewButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home home = new Home();
				home.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		scrollPane.add(btnNewButton2);
		frame.getContentPane().add(scrollPane);
	}
}
