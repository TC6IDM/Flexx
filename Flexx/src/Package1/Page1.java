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
import java.awt.Color;
import java.awt.SystemColor;

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
		frame.getContentPane().setBackground(new Color(138, 170, 229));
		frame.getContentPane().setForeground(new Color(238, 255, 249));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Personalized For You");
		lblNewLabel.setBounds(148, 8, 172, 35);
		lblNewLabel.setFont(new Font("Kohinoor Telugu", Font.BOLD, 15));
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Home");
		btnNewButton.setToolTipText("Redirects to home page");
		btnNewButton.setBackground(new Color(255, 93, 88));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home home = new Home();
				home.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnNewButton.setBounds(6, 8, 75, 16);
		frame.getContentPane().add(btnNewButton);
		
		JTextArea txtrMuscleGroup = new JTextArea();
		txtrMuscleGroup.setToolTipText("");
		txtrMuscleGroup.setBackground(new Color(138, 170, 229));
		txtrMuscleGroup.setEditable(false);
		txtrMuscleGroup.setFont(new Font("Geneva", Font.BOLD, 13));
		txtrMuscleGroup.setLineWrap(true);
		txtrMuscleGroup.setText("       Muscle Group");
		txtrMuscleGroup.setBounds(29, 71, 134, 16);
		frame.getContentPane().add(txtrMuscleGroup);
		
		JTextArea txtrWorkoutTypes = new JTextArea();
		txtrWorkoutTypes.setBackground(new Color(138, 170, 229));
		txtrWorkoutTypes.setEditable(false);
		txtrWorkoutTypes.setFont(new Font("Geneva", Font.BOLD, 13));
		txtrWorkoutTypes.setText("       Workout Types");
		txtrWorkoutTypes.setBounds(29, 119, 145, 16);
		frame.getContentPane().add(txtrWorkoutTypes);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select", "Arms", "Legs", "Chest", "Back"}));
		comboBox.setBounds(252, 67, 145, 27);
		frame.getContentPane().add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Select", "Incline dumbell - Chest", "Pectoral flys - Chest", "Cable chest flys - Chest", "Lat pulldowns - Back", "T-bar - Back", "Cable rows - Back", "Shoulder press- Shoulders", "Lateral raises with dumbbells - Shoulders", "Reverse flys-shoulders", "Hammer curls with rope-biceps", "Preacher curls-biceps", "Incline curls-biceps", "Tricep extensions-tricep", "Tricep extensions-tricep", "Dips-tricep"}));
		comboBox_1.setBounds(252, 115, 145, 27);
		frame.getContentPane().add(comboBox_1);
		
		JTextPane textPane = new JTextPane();
		textPane.setBackground(new Color(138, 170, 229));
		textPane.setBounds(0, 182, 448, 90);
		frame.getContentPane().add(textPane);
		
		JButton btnNewButton_1 = new JButton("Get Results");
		btnNewButton_1.setToolTipText("Generates Routine");
		btnNewButton_1.setBounds(138, 155, 156, 29);
		frame.getContentPane().add(btnNewButton_1);
	}
}
