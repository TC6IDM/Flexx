package Andrew;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Dimension;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import Ava.*;
import otherUtil.Flexx;

import java.awt.Color;
import javax.swing.SwingConstants;

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
	 */
	public Page2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	private void initialize() {
		int Frame_Left = 100;
		int Frame_Width = 450;
		int Frame_Top = 100;
		int Frame_Height = 600;
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(77, 77, 77));
		frame.setBounds(Frame_Left, Frame_Top, Frame_Width, Frame_Height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setLayout(null);
		
//		JLabel lblNewLabel = new JLabel("PAGE 2");
//		lblNewLabel.setBounds(132, 10, 172, 35);
//		lblNewLabel.setFont(new Font("Berlin Sans FB", Font.PLAIN, 31));
//		frame.getContentPane().add(lblNewLabel);
		
		int Frame_ActualWidth = Frame_Width - 14;
		int buttonWidth = 70;
		int buttonDistanceFromSides = 10;
		int buttonHeight = 30;
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setBounds(buttonDistanceFromSides, buttonDistanceFromSides, buttonWidth, buttonHeight);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home home = new Home();
				home.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		frame.getContentPane().add(btnNewButton);
		
		JButton doneButton = new JButton("Done");
		doneButton.setBounds(Frame_ActualWidth-buttonWidth-buttonDistanceFromSides, buttonDistanceFromSides, buttonWidth, buttonHeight);
		frame.getContentPane().add(doneButton);
		
		
		int topLabelHeight = 50;
		JLabel lblTrackWorkout = new JLabel("Track Workout");
		lblTrackWorkout.setVerticalAlignment(SwingConstants.CENTER);
		lblTrackWorkout.setOpaque(true);
		lblTrackWorkout.setHorizontalAlignment(SwingConstants.CENTER);
		lblTrackWorkout.setForeground(Color.WHITE);
		lblTrackWorkout.setFont(new Font("SansSerif", Font.BOLD, 30));
		lblTrackWorkout.setBackground(new Color(43, 87, 154));
		lblTrackWorkout.setBounds(0, 0, Frame_ActualWidth, topLabelHeight);
		frame.getContentPane().add(lblTrackWorkout);
		
		int distanceFromTopLabel = 5;
		int topLabelHeightWithPadding = topLabelHeight + distanceFromTopLabel;
		int fieldHeight = 20;
		int nameFieldLength =125;
		
		JTextField nameField = new JTextField();
		nameField.setBounds(Frame_ActualWidth/2 - nameFieldLength/2, topLabelHeightWithPadding, nameFieldLength, fieldHeight);
		frame.getContentPane().add(nameField);
		nameField.setColumns(10);
		
		int nameLabelWidth = 90;
		JLabel nameLabel = new JLabel("Exercise Name:");
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nameLabel.setForeground(new Color(255, 255, 255));
		nameLabel.setBounds(nameField.getX()-nameLabelWidth, topLabelHeightWithPadding, nameLabelWidth, fieldHeight);
		frame.getContentPane().add(nameLabel);
		
		int numberLabelWidth = 18;
		JLabel exerciseNumberLabel = new JLabel("1");
		exerciseNumberLabel.setHorizontalAlignment(SwingConstants.CENTER);
		exerciseNumberLabel.setForeground(Color.WHITE);
		exerciseNumberLabel.setBounds(nameLabel.getX()-numberLabelWidth, topLabelHeightWithPadding, numberLabelWidth, fieldHeight);
		frame.getContentPane().add(exerciseNumberLabel);
		
		int setRepWeightLabelHeight = exerciseNumberLabel.getY() + exerciseNumberLabel.getHeight()+5;
		int setRepWeightLabelWidth = 35;
		
		JLabel setCount = new JLabel("Set");
		setCount.setHorizontalAlignment(SwingConstants.CENTER);
		setCount.setForeground(new Color(255, 255, 255));
		setCount.setBounds(Frame_ActualWidth/4 - setRepWeightLabelWidth/2, setRepWeightLabelHeight, setRepWeightLabelWidth, fieldHeight);
		frame.getContentPane().add(setCount);
		
		JLabel repsLabel = new JLabel("Reps");
		repsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		repsLabel.setForeground(new Color(255, 255, 255));
		repsLabel.setBounds(Frame_ActualWidth/2 - setRepWeightLabelWidth/2, setRepWeightLabelHeight, setRepWeightLabelWidth, fieldHeight);
		frame.getContentPane().add(repsLabel);
		
		JLabel weightLabel = new JLabel("Weight");
		weightLabel.setHorizontalAlignment(SwingConstants.CENTER);
		weightLabel.setForeground(new Color(255, 255, 255));
		weightLabel.setBounds(Frame_ActualWidth*3/4 - setRepWeightLabelWidth/2, setRepWeightLabelHeight, setRepWeightLabelWidth, fieldHeight);
		frame.getContentPane().add(weightLabel);
		
		int distanceBetween0thAnd1stSets = 25;
		int firstSetStartingHeight = setRepWeightLabelHeight+distanceBetween0thAnd1stSets;
		JLabel lblExercise_1 = new JLabel("1");
		lblExercise_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblExercise_1.setForeground(Color.WHITE);
		lblExercise_1.setBounds(Frame_ActualWidth/4 - numberLabelWidth/2, firstSetStartingHeight, numberLabelWidth, fieldHeight);
		frame.getContentPane().add(lblExercise_1);
		
		int textFieldWidth = 70;
		//creates the reps field
		JTextField repsField = new JTextField();
		repsField.setColumns(10);
		repsField.setBounds(Frame_ActualWidth/2 - textFieldWidth/2, firstSetStartingHeight, textFieldWidth, fieldHeight);
		frame.getContentPane().add(repsField);
		
		//creates the weight field
		JTextField weightField = new JTextField();
		weightField.setColumns(10);
		weightField.setBounds(Frame_ActualWidth*3/4 - textFieldWidth/2, firstSetStartingHeight, textFieldWidth, fieldHeight);
		frame.getContentPane().add(weightField);
		
		int addSetButton_width = 80;
		int addSetButton_height = 13;
		int addSetButtonY = repsField.getY()+repsField.getHeight()+5;
		JButton addSetButton = new JButton("Add set");
		addSetButton.setBounds(Frame_ActualWidth/2 - addSetButton_width/2, addSetButtonY, addSetButton_width, addSetButton_height);
		frame.getContentPane().add(addSetButton);		
		
		
		int newExerciseButton_width = 150;
		int newExerciseButton_height = 35;
		int NewExerciseButtonY = addSetButton.getY()+addSetButton.getHeight()+5;
		JButton newExerciseButton = new JButton("New Exercise");
		newExerciseButton.setBounds(Frame_ActualWidth/2 - newExerciseButton_width/2, NewExerciseButtonY, newExerciseButton_width, newExerciseButton_height);
		frame.getContentPane().add(newExerciseButton);
		
		
		
		
		
		

	}
}
