package Package1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

/* Andrew Tissi */

class Workout{
	public String name; 
	public ArrayList<Set> sets = new ArrayList<Set>();
}

class Set extends Workout{
	private int reps;
	private int weight;	
}

public class Page3 {

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
	public Page3() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		int Frame_Left = 100;
		int Frame_Width = 450;
		int Frame_Top = 100;
		int Frame_Height = 300;
		int Frame_Center = Frame_Width/2;
		
		frame = new JFrame();
		frame.setBounds(Frame_Left, Frame_Top, Frame_Width, Frame_Height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PAGE 3");
		lblNewLabel.setBounds(Frame_Center-50, 10, 100, 35);
		lblNewLabel.setFont(new Font("Berlin Sans FB", Font.PLAIN, 31));
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home home = new Home();
				home.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnNewButton.setBounds(10, 10, 75, 35);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton2 = new JButton("Done");
		btnNewButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home home = new Home();
				home.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnNewButton2.setBounds(Frame_Width-100, 10, 75, 35);
		frame.getContentPane().add(btnNewButton2);
		
		int btnNewButton_1_width = 100;
		int btnNewButton_1_height = 35;	
		int btnNewButton_1_distanceFromTop = 50;
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton_1.setLocation(btnNewButton_1.getX(), btnNewButton_1.getY()+75);
			}
		});
		btnNewButton_1.setBounds(Frame_Center-btnNewButton_1_width/2, btnNewButton_1_distanceFromTop, btnNewButton_1_width, btnNewButton_1_height);
		frame.getContentPane().add(btnNewButton_1);
	}

}
