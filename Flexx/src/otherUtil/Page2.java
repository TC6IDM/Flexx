package otherUtil;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Dimension;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JScrollPane;

public class Page2 {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Flexx.main(args);
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
		
		
		 JPanel panel = new JPanel();
		 for (int i = 0; i < 50; i++) {
			 JButton newButton = new JButton(""+i);
			 newButton.setBounds(10, 10, 25, i);
		     panel.add(newButton);
		 }
		 JScrollPane scrollPane = new JScrollPane(panel);
		 panel.setLayout(null);
		 scrollPane.setBounds(0, 50, 350, 200);
		 frame.getContentPane().add(scrollPane);
		 frame.setPreferredSize(new Dimension(450, 300));
		 frame.pack();
		 frame.setVisible(true);

	}
}
