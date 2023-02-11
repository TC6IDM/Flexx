package Package1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Home extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("HOME PAGE");
		lblNewLabel.setBounds(132, 10, 172, 35);
		lblNewLabel.setFont(new Font("Berlin Sans FB", Font.PLAIN, 31));
		contentPane.add(lblNewLabel);
		
		JButton Page1Button = new JButton("Page1");
		Page1Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Page1 page1 = new Page1();
				page1.setVisible(true);
				contentPane.setVisible(false);;
			}
		});
		Page1Button.setBounds(10, 180, 85, 21);
		contentPane.add(Page1Button);
		
		JButton Page2Button = new JButton("Page2");
		Page2Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Page2 page2 = new Page2();
				page2.setVisible(true);
				contentPane.setVisible(false);
			}
		});
		Page2Button.setBounds(105, 180, 85, 21);
		contentPane.add(Page2Button);
		
		JButton Page3Button = new JButton("Page3");
		Page3Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Page3 page3 = new Page3();
				page3.setVisible(true);
				contentPane.setVisible(false);
			}
		});
		Page3Button.setBounds(232, 180, 85, 21);
		contentPane.add(Page3Button);
		
		JButton Page4Button = new JButton("Page4");
		Page4Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Page4 page4 = new Page4();
				page4.setVisible(true);
				contentPane.setVisible(false);
			}
		});
		Page4Button.setBounds(341, 180, 85, 21);
		contentPane.add(Page4Button);
		
		JButton Page5Button = new JButton("Page5");
		Page5Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Page5 page5 = new Page5();
				page5.setVisible(true);
				contentPane.setVisible(false);
			}
		});
		Page5Button.setBounds(166, 232, 85, 21);
		contentPane.add(Page5Button);
		
		
	}

}
