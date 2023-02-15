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
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextPane;

public class Page1 {

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
	 */
	public Page1() {
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
		
		JLabel lblNewLabel = new JLabel("Personalized For You");
		lblNewLabel.setBounds(148, 8, 172, 35);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 14));
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home home = new Home();
				home.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnNewButton.setBounds(10, 10, 77, 35);
		frame.getContentPane().add(btnNewButton);
		
		JTextArea txtrMuscleGroup = new JTextArea();
		txtrMuscleGroup.setEditable(false);
		txtrMuscleGroup.setFont(new Font("Geneva", Font.BOLD, 13));
		txtrMuscleGroup.setLineWrap(true);
		txtrMuscleGroup.setText("Muscle Group");
		txtrMuscleGroup.setBounds(29, 71, 92, 16);
		frame.getContentPane().add(txtrMuscleGroup);
		
		JTextArea txtrWorkoutTypes = new JTextArea();
		txtrWorkoutTypes.setEditable(false);
		txtrWorkoutTypes.setFont(new Font("Geneva", Font.BOLD, 13));
		txtrWorkoutTypes.setText("Workout Types");
		txtrWorkoutTypes.setBounds(161, 71, 101, 16);
		frame.getContentPane().add(txtrWorkoutTypes);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select", "Test 2"}));
		comboBox.setBounds(29, 115, 92, 27);
		frame.getContentPane().add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Select", "Test 2"}));
		comboBox_1.setBounds(170, 115, 92, 27);
		frame.getContentPane().add(comboBox_1);
		
		JTextArea txtrTest = new JTextArea();
		txtrTest.setText("Objectives/Goals");
		txtrTest.setFont(new Font("Geneva", Font.BOLD, 13));
		txtrTest.setEditable(false);
		txtrTest.setBounds(304, 71, 108, 16);
		frame.getContentPane().add(txtrTest);
		
		JComboBox comboBox_1_1 = new JComboBox();
		comboBox_1_1.setModel(new DefaultComboBoxModel(new String[] {"Select", "Build Muscle", "Lose Fat"}));
		comboBox_1_1.setBounds(311, 115, 101, 27);
		frame.getContentPane().add(comboBox_1_1);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(0, 148, 448, 124);
		frame.getContentPane().add(textPane);
	}
}
