package Andrew;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Ava.*;
import otherUtil.*;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Canvas;

/* Andrew Tissi */

public class Page3 {
	public JFrame frame;
	public ArrayList<Exercise> exercises = new ArrayList<Exercise>();
	public JTextField scrollByField;
	public JLabel invalidInputLabel;
	public JButton backButton;
	public JButton doneButton;
	public JLabel lblTrackWorkout;
	public JButton newExerciseButton;
	public JLabel scrollByLabel;
	public JButton moveUpButton;
	public JButton moveDownButton;
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
	 * @wbp.parser.entryPoint
	 */
	public Page3() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	//checks all text fields to make sure that all the values are appropriate
	public String isValid() {
		String invalidInfo ="\n";//Initializes the string
		if (exercises.size()==0) return "|No Exercises|"; // if there are no exercises then the error code is that there are no exercises
		
		//loops through all exercises
		for (int i=0;i<exercises.size();i++) {
			Exercise currentExercise = exercises.get(i);//gets the current exercise
			String exerciseName = currentExercise.nameField.getText(); //find the user input exercise name
			if (exerciseName.equals("")) invalidInfo = invalidInfo+ "|Exercise #"+currentExercise.exerciseNumber+" Name Invalid|\n"; //if the field is empty, add to the string that it is invalid
			
			//loops through all sets
			for (int k=0;k<currentExercise.sets.size();k++) {
				Set currentSet = currentExercise.sets.get(k);//gets the current set
				
				//gets the text for the reps and weight field
				String reps = currentSet.repsField.getText();
				String weight = currentSet.weightField.getText();
				
				//checks if either of these fields are empty, if they are, add to the string that it is invalid
				if (reps.equals("")) invalidInfo = invalidInfo+ "|Exercise #"+currentExercise.exerciseNumber+" Set #"+currentSet.setNumber+" Reps Invalid|\n";
				if (weight.equals(""))invalidInfo = invalidInfo+ "|Exercise #"+currentExercise.exerciseNumber+" Set #"+currentSet.setNumber+" Weight Invalid|\n";
				
				//checks if the reps are an integer
				try {
					Integer.parseInt(reps);
			    } catch (NumberFormatException nfe) {
			    	//if the amount of reps are not 
			    	if (!reps.equals("")) invalidInfo = invalidInfo+ "|Exercise #"+currentExercise.exerciseNumber+" Set #"+currentSet.setNumber+" Reps must be an Integer|\n";
			    }
				
				try {
			        Double.parseDouble(weight);
			    } catch (NumberFormatException nfe) {
			    	if (!weight.equals(""))invalidInfo = invalidInfo+ "|Exercise #"+currentExercise.exerciseNumber+" Set #"+currentSet.setNumber+" Weight must be a double|\n";
			    }
			}
		}
		return invalidInfo;
	}
	//moves all elements of the work-outs up or down by x 
	public boolean move(int move) {
		int CUTOFF = 55; //height cutoff, the exercise button can not go above this point, and the first exercise can not be below this point
		boolean canMove = true;//keeps track if the exercises can move
		if (exercises.size()==0) return false; //no exercises and therefore return false, nothing will move
		if (exercises.get(0).newExerciseButton.getY()+move <= Frame_ActualHeight-exercises.get(0).newExerciseButton.getHeight()) {move = -1*(exercises.get(0).newExerciseButton.getY() - (Frame_ActualHeight-exercises.get(0).newExerciseButton.getHeight())); canMove = false;} //if the next move will put the exercise button above the cutoff, then only move by however much can keep it right at the cutoff
		if (exercises.get(0).nameField.getY()+move > CUTOFF) {move = CUTOFF - exercises.get(0).nameField.getY(); canMove = false;}//if the next move will put the first exercise below the cutoff, then only move by however much can keep it right at the cutoff
		exercises.get(0).newExerciseButton.setLocation(exercises.get(0).newExerciseButton.getX(),exercises.get(0).newExerciseButton.getY()+move); //moves the new exercise button
		
		for (int i=0;i<exercises.size();i++) { //loops through all exercises
			Exercise currentExercise = exercises.get(i); //finds the current exercise
			//moves the three elements of exercise
			currentExercise.nameLabel.setLocation(currentExercise.nameLabel.getX(),currentExercise.nameLabel.getY()+move);
			currentExercise.nameField.setLocation(currentExercise.nameField.getX(),currentExercise.nameField.getY()+move);
			currentExercise.addSetButton.setLocation(currentExercise.addSetButton.getX(),currentExercise.addSetButton.getY()+move); 
			currentExercise.exerciseNumberLabel.setLocation(currentExercise.exerciseNumberLabel.getX(),currentExercise.exerciseNumberLabel.getY()+move); 
			currentExercise.setLabel.setLocation(currentExercise.setLabel.getX(),currentExercise.setLabel.getY()+move); 
			currentExercise.repsLabel.setLocation(currentExercise.repsLabel.getX(),currentExercise.repsLabel.getY()+move); 
			currentExercise.weightLabel.setLocation(currentExercise.weightLabel.getX(),currentExercise.weightLabel.getY()+move); 
			
			//for each element of exercise, it will turn invisible if it is beyond the cutoff and it will be visible if not beyond the cutoff
			if (currentExercise.nameLabel.getY()<CUTOFF) currentExercise.nameLabel.setVisible(false); else currentExercise.nameLabel.setVisible(true); 
			if (currentExercise.nameField.getY()<CUTOFF) currentExercise.nameField.setVisible(false); else currentExercise.nameField.setVisible(true);
			if (currentExercise.addSetButton.getY()<CUTOFF) currentExercise.addSetButton.setVisible(false); else currentExercise.addSetButton.setVisible(true);
			if (currentExercise.exerciseNumberLabel.getY()<CUTOFF) currentExercise.exerciseNumberLabel.setVisible(false); else currentExercise.exerciseNumberLabel.setVisible(true);
			if (currentExercise.setLabel.getY()<CUTOFF) currentExercise.setLabel.setVisible(false); else currentExercise.setLabel.setVisible(true);
			if (currentExercise.repsLabel.getY()<CUTOFF) currentExercise.repsLabel.setVisible(false); else currentExercise.repsLabel.setVisible(true);
			if (currentExercise.weightLabel.getY()<CUTOFF) currentExercise.weightLabel.setVisible(false); else currentExercise.weightLabel.setVisible(true);
			
			for (int k=0;k<currentExercise.sets.size();k++) { //loops through all sets
				Set currentSet = currentExercise.sets.get(k); //finds the current set
				//moves the five elements of exercise
				currentSet.setCount.setLocation(currentSet.setCount.getX(),currentSet.setCount.getY()+move); 
				currentSet.repsField.setLocation(currentSet.repsField.getX(),currentSet.repsField.getY()+move);
				currentSet.weightField.setLocation(currentSet.weightField.getX(),currentSet.weightField.getY()+move);
				
				//for each element of the set, it will turn invisible if it is beyond the cutoff and it will be visible if not beyond the cutoff
				if (currentSet.setCount.getY()<CUTOFF) currentSet.setCount.setVisible(false); else currentSet.setCount.setVisible(true);
				if (currentSet.repsField.getY()<CUTOFF) currentSet.repsField.setVisible(false); else currentSet.repsField.setVisible(true);
				if (currentSet.weightField.getY()<CUTOFF) currentSet.weightField.setVisible(false); else currentSet.weightField.setVisible(true);
				
				//updates the frame
				frame.validate();
				frame.repaint();
			}
		}
		return canMove; //returns whether the items can move
		
	}
	
	/**
	 * start of the program
	 * @wbp.parser.entryPoint
	 */
	private void initialize() {
		
		//creates the frame
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(77, 77, 77));
		frame.setBounds(Frame_Left, Frame_Top, Frame_Width, Frame_Height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setLayout(null);
		
		
		
		//creates the back button
		int buttonWidth = 100;
		int buttonDistanceFromSides = 0;
		int buttonHeight = 50;
		backButton = new JButton("");
		backButton.setHorizontalAlignment(SwingConstants.LEFT);
		backButton.setIcon(new ImageIcon(Page3.class.getResource("/Andrew/x-mark-32.png")));
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        //creates a pop up confirmation for going back to the home page
				int option = JOptionPane.showConfirmDialog(frame, "Are you sure you would like to go back? This Current Workout will be Lost...", "Cancel?", JOptionPane.YES_NO_OPTION);
		        if (option == JOptionPane.YES_OPTION) { //user chooses yes
		        	//go back to home page
		        	Home home = new Home();
					home.frame.setVisible(true);
					frame.setVisible(false);
		        }
			}
		});
		backButton.setOpaque(false);
		backButton.setContentAreaFilled(false);
		backButton.setBorderPainted(false);
		backButton.setBounds(buttonDistanceFromSides, buttonDistanceFromSides, buttonWidth, buttonHeight);
		frame.getContentPane().add(backButton);
		
		//creates the done button
		doneButton = new JButton("Done");
		doneButton.setFont(new Font("SansSerif", Font.BOLD, 20));
		doneButton.setForeground(Color.ORANGE);
		doneButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//gets a string of the invalid information given by the user
				String invalidInfo = isValid();
				if (!invalidInfo.equals("\n")) {JOptionPane.showMessageDialog(frame, "Invalid Input:\n"+invalidInfo);return;} //makes a pop up message with the invalid information if there is any
				
				//Searches the database for how many previous exercises there are
				String sizeQuery = "SELECT COUNT(*) FROM exerciselogs";
				int tableSize =0;
				try {
					Connection con = DriverManager.getConnection (JDBC.databaseURL,JDBC.user,JDBC.password);
					Statement statement = con.createStatement();
					ResultSet rs = statement.executeQuery(sizeQuery);
					rs.next();
					tableSize = rs.getInt(1); //stores the size of the table
				} catch (SQLException err) {
					err.printStackTrace();
				}
					
					
				//loops through all exercises
				for (int i=0;i<exercises.size();i++) {
					Exercise currentExercise = exercises.get(i);//gets the current exercise
					String exerciseName = currentExercise.nameField.getText();//find the user input of the exercise
					
					//loops through all sets
					for (int k=0;k<currentExercise.sets.size();k++) {
						Set currentSet = currentExercise.sets.get(k);//gets the current set
						//finds the user input of sets and reps
						String reps = currentSet.repsField.getText();
						String weight = currentSet.weightField.getText(); 
						
						//inserts all information into the table
						String insertQuery = "INSERT INTO exerciselogs VALUE(\""+exerciseName+"\", "+reps+", "+weight+", "+tableSize+");";
						try {
							Connection con = DriverManager.getConnection (JDBC.databaseURL,JDBC.user,JDBC.password);
							Statement statement = con.createStatement();
							statement.execute(insertQuery);
						} catch (SQLException err) {
							err.printStackTrace();
						}
					}
				}

				//returns to the home page
				Home home = new Home();
				home.frame.setVisible(true);
				frame.setVisible(false);
				
			}
		});
		doneButton.setOpaque(false);
		doneButton.setContentAreaFilled(false);
		doneButton.setBorderPainted(false);
		doneButton.setBounds(Frame_ActualWidth-buttonWidth-buttonDistanceFromSides, buttonDistanceFromSides, buttonWidth, buttonHeight);
		frame.getContentPane().add(doneButton);
		
		//creates the Track work-out Title
		int topLabelHeight = 50;
		lblTrackWorkout = new JLabel("Track Workout");
		lblTrackWorkout.setVerticalAlignment(SwingConstants.CENTER);
		lblTrackWorkout.setOpaque(true);
		lblTrackWorkout.setHorizontalAlignment(SwingConstants.CENTER);
		lblTrackWorkout.setForeground(Color.WHITE);
		lblTrackWorkout.setFont(new Font("SansSerif", Font.BOLD, 30));
		lblTrackWorkout.setBackground(new Color(43, 87, 154));
		lblTrackWorkout.setBounds(0, 0, Frame_ActualWidth, topLabelHeight);
		frame.getContentPane().add(lblTrackWorkout);
		
		//sets the bounds of the new exercise button and creates the button
		int newExerciseButton_width = 150;
		int newExerciseButton_height = 35;	
		int moveDown = 10;
		int NewExerciseButtonY = 55;

		newExerciseButton = new JButton("New Exercise");
		newExerciseButton.setForeground(Color.ORANGE);
		newExerciseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//removes any error labels
				int newY = NewExerciseButtonY;
				if (exercises.size() != 0){ // not the first exercise button to be added
					JButton oldAddSetButton = exercises.get(exercises.size()-1).addSetButton; //keeps track of the old set button
					int distanceBetweenExercises =20;
					newY = oldAddSetButton.getY()+oldAddSetButton.getHeight()+distanceBetweenExercises; //finds the position where the new exercise will start
				}
				Exercise thisExercise = new Exercise(Page3.this,newY);//creates a new exercise to put at the given Y value
				exercises.add(thisExercise);//adds the exercise to the exercise list
				JButton addSetButton = thisExercise.addSetButton; //keeps track of the new add set button
				newExerciseButton.setLocation(newExerciseButton.getX(), addSetButton.getY()+addSetButton.getHeight()+moveDown);	//moves the new Exercise Button to where it is supposed to be (relative to the add set button)
				if (newExerciseButton.getY()+newExerciseButton.getHeight() > Frame_ActualHeight) {
					moveDownButton.setVisible(true); //if the next move will put the exercise button above the cutoff, then only move by however much can keep it right at the cutoff
					move(-(newExerciseButton.getY()+newExerciseButton.getHeight()-Frame_ActualHeight));
				}
				
				thisExercise.setNewExerciseButton(newExerciseButton); //adds the new exercise button to the exercise object
				thisExercise.setExerciseNumber(exercises); //sets the number of the exercise
//				move(-100);
				//reprints the frame
				frame.validate();
				frame.repaint();
			}
		});
		newExerciseButton.setBounds(Frame_ActualWidth/2 - newExerciseButton_width/2, NewExerciseButtonY, newExerciseButton_width, newExerciseButton_height);
		newExerciseButton.setOpaque(false);
		newExerciseButton.setContentAreaFilled(false);
		newExerciseButton.setBorderPainted(false);
		frame.getContentPane().add(newExerciseButton);
		
//		ImageIcon myImage = new ImageIcon("images/myImage.jpg");
//		JButton button = new JButton(myImage);
		
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
					if (!move(-moveBy)) moveUpButton.setVisible(false); else moveUpButton.setVisible(true); //if we can not move up then we display that we can not move up, however if we can move up, we take away this error
					
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
					int moveBy = Integer.parseInt(scrollByField.getText());//attempts to turns the string in the field to an integer
					if (!move(moveBy)) moveDownButton.setVisible(false); else moveDownButton.setVisible(true);//if we can not move down then we display that we can not move down, however if we can move down, we take away this error
					
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
		
		
		
		
		
		
		
		
	}
}