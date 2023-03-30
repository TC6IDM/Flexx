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
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import Ava.*;
import otherUtil.Flexx;
import otherUtil.JDBC;

import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class Page2 {

	public JFrame frame;
	public ArrayList<Workout> workouts = new ArrayList<Workout>();
	public JLabel scrollByLabel;
	public JButton moveUpButton;
	public JButton moveDownButton;
	public JTextField scrollByField;
	public JLabel invalidInputLabel;
	public int Frame_Left = 100;
	public int Frame_Width = 450;
	public int Frame_Top = 100;
	public int Frame_Height = 600;
	public int Frame_ActualWidth = Frame_Width - 14;
	public int Frame_ActualHeight = Frame_Height-36;
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

	
	public boolean move(int move) {
//		System.out.println(move);
		int CUTOFF = 55; //height cutoff, the exercise button can not go above this point, and the first exercise can not be below this point
		boolean canMove = true;//keeps track if the exercises can move
		if (workouts.size()==0) return false; //no exercises and therefore return false, nothing will move
		if (workouts.get(workouts.size()-1).button.getY()+move <= Frame_ActualHeight-workouts.get(workouts.size()-1).button.getHeight()) {move = -1*(workouts.get(workouts.size()-1).button.getY() - (Frame_ActualHeight-workouts.get(workouts.size()-1).button.getHeight())); canMove = false;} //if the next move will put the exercise button above the cutoff, then only move by however much can keep it right at the cutoff
//		System.out.println(move);
		if (workouts.get(0).button.getY()+move > CUTOFF) {move = CUTOFF - workouts.get(0).button.getY(); canMove = false;}//if the next move will put the first exercise below the cutoff, then only move by however much can keep it right at the cutoff
//		System.out.println(move);
		//workouts.get(0).button.setLocation(workouts.get(0).button.getX(),workouts.get(0).button.getY()+move); //moves the new exercise button
		
		for (int i=0;i<workouts.size();i++) { //loops through all exercises
			
			JButton currentExercise = workouts.get(i).button; //finds the current exercise
			//moves the three elements of exercise
//			System.out.println(workouts.get(i).workoutName);
//			System.out.println(currentExercise.getY());
//			System.out.println(move);
			currentExercise.setLocation(currentExercise.getX(),currentExercise.getY()+move);
			
			//for each element of exercise, it will turn invisible if it is beyond the cutoff and it will be visible if not beyond the cutoff
//			if (currentExercise.getY()<CUTOFF) currentExercise.setVisible(false); else currentExercise.setVisible(true); 
			
			frame.validate();
			frame.repaint();
		}
		return canMove; //returns whether the items can move
	}
	
	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	private void initialize() {
		//creates the frame
		Page3 page3 = new Page3();
		int Frame_Left = page3.Frame_Left;
		int Frame_Top = page3.Frame_Top;
		int Frame_Width = page3.Frame_Width;
		int Frame_Height = page3.Frame_Height;
		int Frame_ActualWidth = page3.Frame_ActualWidth;
		
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(77, 77, 77));
		frame.setBounds(Frame_Left, Frame_Top, Frame_Width, Frame_Height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setLayout(null);
				
				
				
		//creates the back button
		int buttonWidth = 100;
		int buttonDistanceFromSides = 0;
		int buttonHeight = 50;
		JButton backButton = new JButton("");
		backButton.setHorizontalAlignment(SwingConstants.LEFT);
		backButton.setIcon(new ImageIcon(Page3.class.getResource("/Andrew/x-mark-32.png")));
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home home = new Home();
				home.frame.setVisible(true);
				frame.setVisible(false);
		        
			}
		});
		backButton.setOpaque(false);
		backButton.setContentAreaFilled(false);
		backButton.setBorderPainted(false);
		backButton.setBounds(buttonDistanceFromSides, buttonDistanceFromSides, buttonWidth, buttonHeight);
		frame.getContentPane().add(backButton);
				
		//creates the Track work-out Title
		int topLabelHeight = 50;
		JLabel lblTrackWorkout = new JLabel("Exercise View");
		lblTrackWorkout.setVerticalAlignment(SwingConstants.CENTER);
		lblTrackWorkout.setOpaque(true);
		lblTrackWorkout.setHorizontalAlignment(SwingConstants.CENTER);
		lblTrackWorkout.setForeground(Color.WHITE);
		lblTrackWorkout.setFont(new Font("SansSerif", Font.BOLD, 30));
		lblTrackWorkout.setBackground(new Color(43, 87, 154));
		lblTrackWorkout.setBounds(0, 0, Frame_ActualWidth, topLabelHeight);
		frame.getContentPane().add(lblTrackWorkout);
		
		int scrollLabelHeight = 13;
		int scrollFieldHeight = 19;
		int scrollWidth = 53;
		int scrollButtonHeight = 32;
		int padding = 10;
		
		//creates the text field for the amount the user wants to scroll down
		scrollByField = new JTextField();
		scrollByField.setBounds(Frame_ActualWidth - scrollWidth -padding, Frame_ActualHeight/2-scrollFieldHeight/2, scrollWidth, scrollFieldHeight);
		scrollByField.setText("20");
		scrollByField.setColumns(10);
//		scrollByField.setVisible(true);
		frame.getContentPane().add(scrollByField);
				
				
		//creates a label to go above the scroll by field
		scrollByLabel = new JLabel("Scroll By:");
		scrollByLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		scrollByLabel.setHorizontalAlignment(SwingConstants.CENTER);
		scrollByLabel.setForeground(Color.ORANGE);
		scrollByLabel.setBounds(scrollByField.getX(), scrollByField.getY()-scrollLabelHeight, scrollWidth, scrollLabelHeight);
//		scrollByLabel.setVisible(false);
		frame.getContentPane().add(scrollByLabel);
				
		//creates the scroll up button
		moveUpButton = new JButton("");
		moveUpButton.setIcon(new ImageIcon(Page3.class.getResource("/Andrew/uparrow.png")));
		moveUpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int moveBy = Integer.parseInt(scrollByField.getText()); //attempts to turns the string in the field to an integer
					if (!move(moveBy)) moveUpButton.setVisible(false); else moveUpButton.setVisible(true); //if we can not move up then we display that we can not move up, however if we can move up, we take away this error
							
					//sets the other labels invisible
					moveDownButton.setVisible(true);
					invalidInputLabel.setVisible(false);
				}
				catch (NumberFormatException ek) {
					//not a valid input, so we display that it is not a valid input
					invalidInputLabel.setVisible(true);
				}
			}
		});
		moveUpButton.setOpaque(false);
		moveUpButton.setContentAreaFilled(false);
		moveUpButton.setBorderPainted(false);
		moveUpButton.setBounds(scrollByField.getX(), scrollByLabel.getY()-scrollButtonHeight, scrollWidth, scrollButtonHeight);
		moveUpButton.setVisible(false);
		frame.getContentPane().add(moveUpButton);
						
		//creates a label which will appear when the user inputs an invalid input for the scroll field
		invalidInputLabel = new JLabel("Invalid Input");
		invalidInputLabel.setFont(new Font("Tahoma", Font.PLAIN, 9));
		invalidInputLabel.setHorizontalAlignment(SwingConstants.CENTER);
		invalidInputLabel.setForeground(Color.RED);
		invalidInputLabel.setBounds(scrollByField.getX(), scrollByField.getY()+scrollFieldHeight, scrollWidth, scrollLabelHeight);
		invalidInputLabel.setVisible(false);
		frame.getContentPane().add(invalidInputLabel);
				
		//creates the scroll down button
		moveDownButton = new JButton("");
		moveDownButton.setIcon(new ImageIcon(Page3.class.getResource("/Andrew/downarrow.png")));
		moveDownButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
//					System.out.println(scrollByField.getText());
					int moveBy = Integer.parseInt(scrollByField.getText());//attempts to turns the string in the field to an integer
					if (!move(-moveBy)) moveDownButton.setVisible(false); else moveDownButton.setVisible(true);//if we can not move down then we display that we can not move down, however if we can move down, we take away this error
						
					//sets the other labels invisible
					moveUpButton.setVisible(true);
					invalidInputLabel.setVisible(false);
				}catch (NumberFormatException ek) {
					//not a valid input, so we display that it is not a valid input
					invalidInputLabel.setVisible(true);
				}
			}
		});
		moveDownButton.setOpaque(false);
		moveDownButton.setContentAreaFilled(false);
		moveDownButton.setBorderPainted(false);
		moveDownButton.setBounds(scrollByField.getX(), invalidInputLabel.getY()+scrollLabelHeight, scrollWidth, scrollButtonHeight);
		moveDownButton.setVisible(false);
		frame.getContentPane().add(moveDownButton);

		
		String exercisesQuery = "SELECT DISTINCT ExerciseName FROM (Select * FROM exerciselogs HAVING User='"+Login.USERID+"') AS test";
		try {
			Connection con = DriverManager.getConnection (JDBC.databaseURL,JDBC.user,JDBC.password);
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(exercisesQuery);
			while (rs.next()) {
				Workout thisWorkout = new Workout(rs.getString(1));
				String findAllExercisesQuery = "SELECT * FROM exerciselogs HAVING ExerciseName='"+thisWorkout.workoutName+"' AND User='"+Login.USERID+"'";
//				System.out.println(thisWorkout.workoutName);
				Connection con2 = DriverManager.getConnection (JDBC.databaseURL,JDBC.user,JDBC.password);
				Statement statement2 = con2.createStatement();
				ResultSet rs2 = statement2.executeQuery(findAllExercisesQuery);
				
				while (rs2.next()) {
//					System.out.println(rs2.getInt(2)+" "+rs2.getInt(3)+" "+rs2.getInt(4));
					thisWorkout.addDataPoint(rs2.getInt(2),rs2.getInt(3) ,rs2.getInt(4) );
				}
				workouts.add(thisWorkout);
			}
			
			for (int i=0;i<workouts.size();i++) {
				Workout thisWorkout = workouts.get(i);
				JButton btnNewButton = new JButton(thisWorkout.workoutName);
				int buttonHeight2 = 50;
				int buttonGap = 100;
				int buttonWidth2 = Frame_ActualWidth-200;
				int buttonY = 5+buttonHeight2+buttonGap*i;
				btnNewButton.setBounds(Frame_ActualWidth/2 - buttonWidth2/2 ,buttonY, buttonWidth2, buttonHeight2);
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (thisWorkout.sets.size()<2) {JOptionPane.showMessageDialog(frame, "Not Enough data points to plot this exercise\nPlease preform this exercise again\nto generate a graph");return;}
						GraphXY graphxy = thisWorkout.getGraphXY();
//						System.out.println(thisWorkout.toString());
//						System.out.println(graphxy.toString());
						GraphPanel.createAndShowGui(graphxy.yValues,graphxy.xValues,graphxy.bestSets);						
//						System.out.println(thisWorkout.workoutName);
					}
				});
				if (buttonY + buttonHeight2 > Frame_ActualHeight) moveDownButton.setVisible(true);
				frame.getContentPane().add(btnNewButton);
				thisWorkout.setButton(btnNewButton);
				
			}
		} catch (SQLException err) {
			err.printStackTrace();
		}
		
		
	}
}
