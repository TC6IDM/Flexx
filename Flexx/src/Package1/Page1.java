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
		
		JLabel lblNewLabel = new JLabel("PAGE 1");
		lblNewLabel.setBounds(158, 2, 172, 35);
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
		btnNewButton.setBounds(10, 10, 77, 35);
		frame.getContentPane().add(btnNewButton);
		
		JTextArea txtrMuscleGroup = new JTextArea();
		txtrMuscleGroup.setEditable(false);
		txtrMuscleGroup.setFont(new Font("Geneva", Font.PLAIN, 13));
		txtrMuscleGroup.setLineWrap(true);
		txtrMuscleGroup.setText("Muscle Group");
		txtrMuscleGroup.setBounds(29, 128, 92, 16);
		frame.getContentPane().add(txtrMuscleGroup);
		
		JTextArea txtrWorkoutTypes = new JTextArea();
		txtrWorkoutTypes.setEditable(false);
		txtrWorkoutTypes.setFont(new Font("Geneva", Font.PLAIN, 13));
		txtrWorkoutTypes.setText("Workout Types");
		txtrWorkoutTypes.setBounds(158, 128, 101, 16);
		frame.getContentPane().add(txtrWorkoutTypes);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Test 1", "Test 2"}));
		comboBox.setBounds(29, 162, 92, 27);
		frame.getContentPane().add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Test 1", "Test 2"}));
		comboBox_1.setBounds(158, 162, 92, 27);
		frame.getContentPane().add(comboBox_1);
	}
}
