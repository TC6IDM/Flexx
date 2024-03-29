package Timi;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JSeparator;

import Ava.*;
import otherUtil.*;

public class Page5 {

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
	 */
	public Page5() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.RED);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(new Color(77, 77, 77));

		JButton btnNewButton = new JButton("Back");
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home home = new Home();
				home.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnNewButton.setBounds(0, 6, 77, 35);
		frame.getContentPane().add(btnNewButton);

		JLabel lblNewLabel = new JLabel("Breakfast");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(89, 21, 61, 16);
		frame.getContentPane().add(lblNewLabel);

		JButton btnNewButton_1 = new JButton("+");
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setSize(10,20);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				breakfast bf = new breakfast();
				bf.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnNewButton_1.setBounds(247, 16, 117, 29);
		frame.getContentPane().add(btnNewButton_1);

		JLabel lblNewLabel_1 = new JLabel("Lunch");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(89, 64, 61, 16);
		frame.getContentPane().add(lblNewLabel_1);

		JButton btnNewButton_2 = new JButton("+");
		btnNewButton_2.setForeground(Color.BLACK);
		btnNewButton_2.setBounds(247, 57, 117, 29);
		frame.getContentPane().add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lunch lunch = new lunch();
				lunch.frame.setVisible(true);
				frame.setVisible(false);
			}
		});

		JLabel lblNewLabel_2 = new JLabel("Dinner");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(89, 108, 61, 16);
		frame.getContentPane().add(lblNewLabel_2);

		JButton btnNewButton_3 = new JButton("+");
		btnNewButton_3.setForeground(Color.BLACK);
		btnNewButton_3.setBounds(247, 103, 117, 29);
		frame.getContentPane().add(btnNewButton_3);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dinner dinner = new dinner();
				dinner.frame.setVisible(true);
				frame.setVisible(false);
			}
		});

		JLabel lblNewLabel_3 = new JLabel("Snacks/Other");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(89, 153, 104, 16);
		frame.getContentPane().add(lblNewLabel_3);

		JButton btnNewButton_4 = new JButton("+");
		btnNewButton_4.setForeground(Color.BLACK);
		btnNewButton_4.setBounds(247, 148, 117, 29);
		frame.getContentPane().add(btnNewButton_4);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				snacks snacks = new snacks();
				snacks.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		JLabel lblNewLabel_4 = new JLabel("Water Tracker");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(89, 199, 93, 16);
		frame.getContentPane().add(lblNewLabel_4);

		JButton btnNewButton_5 = new JButton("+");
		btnNewButton_5.setForeground(Color.BLACK);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				water water = new water();
				water.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnNewButton_5.setBounds(247, 194, 117, 29);
		frame.getContentPane().add(btnNewButton_5);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(95, 108, 242, 1);
		frame.getContentPane().add(separator_1);

		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(105, 191, 248, 1);
		frame.getContentPane().add(separator_3);

		JLabel lblNewLabel_5 = new JLabel("Calories Burned");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setBounds(89, 238, 104, 16);
		frame.getContentPane().add(lblNewLabel_5);

		JButton btnNewButton_6 = new JButton("+");
		btnNewButton_6.setForeground(Color.BLACK);
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calburned calburned = new calburned();
				calburned.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnNewButton_6.setBounds(247, 235, 117, 29);
		frame.getContentPane().add(btnNewButton_6);

		JSeparator separator_6 = new JSeparator();
		separator_6.setBounds(336, 216, -240, 12);
		frame.getContentPane().add(separator_6);


	}
}
