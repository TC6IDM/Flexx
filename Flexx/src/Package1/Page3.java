package Package1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

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
import javax.swing.JScrollBar;

/* Andrew Tissi */

public class Page3 {
	public JFrame frame;
	public ArrayList<Exercise> exercises = new ArrayList<Exercise>();
	private JTextField scrollByField;
	private JLabel invalidInputLabel;
	private JLabel canNotScrollHigherLabel;
	private JLabel canNotScrollLowerLabel;


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
		int CUTOFF = 50; //height cutoff, the exercise button can not go above this point, and the first exercise can not be below this point
		boolean canMove = true;//keeps track if the exercises can move
		if (exercises.size()==0) return false; //no exercises and therefore return false, nothing will move
		if (exercises.get(0).newExerciseButton.getY()+move < CUTOFF) {move = -1*(exercises.get(0).newExerciseButton.getY() - CUTOFF); canMove = false;} //if the next move will put the exercise button above the cutoff, then only move by however much can keep it right at the cutoff
		if (exercises.get(0).nameField.getY()+move > CUTOFF) {move = CUTOFF - exercises.get(0).nameField.getY(); canMove = false;}//if the next move will put the first exercise below the cutoff, then only move by however much can keep it right at the cutoff
		exercises.get(0).newExerciseButton.setLocation(exercises.get(0).newExerciseButton.getX(),exercises.get(0).newExerciseButton.getY()+move); //moves the new exercise button
		
		for (int i=0;i<exercises.size();i++) { //loops through all exercises
			Exercise currentExercise = exercises.get(i); //finds the current exercise
			//moves the three elements of exercise
			currentExercise.nameLabel.setLocation(currentExercise.nameLabel.getX(),currentExercise.nameLabel.getY()+move);
			currentExercise.nameField.setLocation(currentExercise.nameField.getX(),currentExercise.nameField.getY()+move);
			currentExercise.addSetButton.setLocation(currentExercise.addSetButton.getX(),currentExercise.addSetButton.getY()+move); 
			
			//for each element of exercise, it will turn invisible if it is beyond the cutoff and it will be visible if not beyond the cutoff
			if (currentExercise.nameLabel.getY()<CUTOFF) currentExercise.nameLabel.setVisible(false); else currentExercise.nameLabel.setVisible(true); 
			if (currentExercise.nameField.getY()<CUTOFF) currentExercise.nameField.setVisible(false); else currentExercise.nameField.setVisible(true);
			if (currentExercise.addSetButton.getY()<CUTOFF) currentExercise.addSetButton.setVisible(false); else currentExercise.addSetButton.setVisible(true);
			
			for (int k=0;k<currentExercise.sets.size();k++) { //loops through all sets
				Set currentSet = currentExercise.sets.get(k); //finds the current set
				//moves the five elements of exercise
				currentSet.setCount.setLocation(currentSet.setCount.getX(),currentSet.setCount.getY()+move); 
				currentSet.repsLabel.setLocation(currentSet.repsLabel.getX(),currentSet.repsLabel.getY()+move); 
				currentSet.repsField.setLocation(currentSet.repsField.getX(),currentSet.repsField.getY()+move);
				currentSet.weightLabel.setLocation(currentSet.weightLabel.getX(),currentSet.weightLabel.getY()+move);
				currentSet.weightField.setLocation(currentSet.weightField.getX(),currentSet.weightField.getY()+move);
				
				//for each element of the set, it will turn invisible if it is beyond the cutoff and it will be visible if not beyond the cutoff
				if (currentSet.setCount.getY()<CUTOFF) currentSet.setCount.setVisible(false); else currentSet.setCount.setVisible(true);
				if (currentSet.repsLabel.getY()<CUTOFF) currentSet.repsLabel.setVisible(false); else currentSet.repsLabel.setVisible(true);
				if (currentSet.repsField.getY()<CUTOFF) currentSet.repsField.setVisible(false); else currentSet.repsField.setVisible(true);
				if (currentSet.weightLabel.getY()<CUTOFF) currentSet.weightLabel.setVisible(false); else currentSet.weightLabel.setVisible(true);
				if (currentSet.weightField.getY()<CUTOFF) currentSet.weightField.setVisible(false); else currentSet.weightField.setVisible(true);
				
				//updates the frame
				frame.validate();
				frame.repaint();
			}
		}
		return canMove; //returns whether the items can move
		
	}
	
	//start of the program
	private void initialize() {
		//sets the bounds of the frame
		int Frame_Left = 100;
		int Frame_Width = 450;
		int Frame_Top = 100;
		int Frame_Height = 600;
		int Frame_Center = Frame_Width/2;
		
		//creates the frame
		frame = new JFrame();
		frame.setBounds(Frame_Left, Frame_Top, Frame_Width, Frame_Height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//creates the Track work-out Title
		int pageLabel_width = 200;
		JLabel pageLabel = new JLabel("Track Workout");
		pageLabel.setBounds(Frame_Center-pageLabel_width/2, 10, pageLabel_width, 35);
		pageLabel.setFont(new Font("Berlin Sans FB", Font.PLAIN, 31));
		frame.getContentPane().add(pageLabel);
		
		//creates the back button
		JButton backButton = new JButton("Back");
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
		backButton.setBounds(10, 10, 75, 35);
		frame.getContentPane().add(backButton);
		
		//creates the done button
		JButton doneButton = new JButton("Done");
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
		doneButton.setBounds(Frame_Width-100, 10, 75, 35);
		frame.getContentPane().add(doneButton);
		
		
		//sets the bounds of the new exercise button and creates the button
		int newExerciseButton_width = 150;
		int newExerciseButton_height = 35;	
		int newExerciseButton_distanceFromTop = 50;
		int moveDown = 10;
		JButton newExerciseButton = new JButton("New Exercise");
		newExerciseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//removes any error labels
				canNotScrollHigherLabel.setVisible(false);
				canNotScrollLowerLabel.setVisible(false);
				int newY = 50;
				if (exercises.size() != 0){ // not the first exercise button to be added
					JButton oldAddSetButton = exercises.get(exercises.size()-1).addSetButton; //keeps track of the old set button
					newY = oldAddSetButton.getY()+oldAddSetButton.getHeight()+moveDown; //finds the position where the new exercise will start
				}
				Exercise thisExercise = new Exercise(frame,newY, canNotScrollHigherLabel, canNotScrollLowerLabel);//creates a new exercise to put at the given Y value
				exercises.add(thisExercise);//adds the exercise to the exercise list
				JButton addSetButton = thisExercise.addSetButton; //keeps track of the new add set button
				
				newExerciseButton.setLocation(newExerciseButton.getX(), addSetButton.getY()+addSetButton.getHeight()+moveDown);	//moves the new Exercise Button to where it is supposed to be (relative to the add set button)
				thisExercise.setNewExerciseButton(newExerciseButton); //adds the new exercise button to the exercise object
				thisExercise.setExerciseNumber(exercises); //sets the number of the exercise
				
				//reprints the frame
				frame.validate();
				frame.repaint();
			}
		});
		newExerciseButton.setBounds(Frame_Center-newExerciseButton_width/2, newExerciseButton_distanceFromTop, newExerciseButton_width, newExerciseButton_height);
		frame.getContentPane().add(newExerciseButton);
		
		//creates the text field for the amount the user wants to scroll down
		scrollByField = new JTextField();
		scrollByField.setBounds(340, 292, 85, 19);
		scrollByField.setText("20");
		frame.getContentPane().add(scrollByField);
		scrollByField.setColumns(10);
		
		//creates a label to go above the scroll by field
		JLabel scrollByLabel = new JLabel("Scroll By:");
		scrollByLabel.setBounds(340, 279, 85, 13);
		frame.getContentPane().add(scrollByLabel);
		
		//creates a label which will appear when the user inputs an invalid input for the scroll field
		invalidInputLabel = new JLabel("Invalid Input");
		invalidInputLabel.setBounds(340, 311, 85, 13);
		invalidInputLabel.setVisible(false);
		frame.getContentPane().add(invalidInputLabel);
		
		//creates a label which will appear when the user can not scroll higher
		canNotScrollHigherLabel = new JLabel("Can Not Scroll Higher");
		canNotScrollHigherLabel.setBounds(318, 233, 117, 13);
		canNotScrollHigherLabel.setVisible(false);
		frame.getContentPane().add(canNotScrollHigherLabel);
		
		//creates a label which will appear when the user can not scroll lower
		canNotScrollLowerLabel = new JLabel("Can Not Scroll Lower");
		canNotScrollLowerLabel.setBounds(318, 360, 117, 13);
		canNotScrollLowerLabel.setVisible(false);
		frame.getContentPane().add(canNotScrollLowerLabel);
		
		//creates the scroll up button
		JButton moveUpButton = new JButton("Up");
		moveUpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int moveBy = Integer.parseInt(scrollByField.getText()); //attempts to turns the string in the field to an integer
					if (!move(-moveBy)) canNotScrollHigherLabel.setVisible(true); else canNotScrollHigherLabel.setVisible(false); //if we can not move up then we display that we can not move up, however if we can move up, we take away this error
					
					//sets the other labels invisible
					canNotScrollLowerLabel.setVisible(false);
					invalidInputLabel.setVisible(false);
				}
				catch (NumberFormatException ek) {
					//not a valid input, so we display that it is not a valid input
					canNotScrollHigherLabel.setVisible(false);
					canNotScrollLowerLabel.setVisible(false);
					invalidInputLabel.setVisible(true);
				}
			}
		});
		moveUpButton.setBounds(340, 248, 85, 21);
		frame.getContentPane().add(moveUpButton);
		
		//creates the scroll down button
		JButton moveDownButton = new JButton("Down");
		moveDownButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int moveBy = Integer.parseInt(scrollByField.getText());//attempts to turns the string in the field to an integer
					if (!move(moveBy)) canNotScrollLowerLabel.setVisible(true); else canNotScrollLowerLabel.setVisible(false);//if we can not move down then we display that we can not move down, however if we can move down, we take away this error
					
					//sets the other labels invisible
					canNotScrollHigherLabel.setVisible(false);
					invalidInputLabel.setVisible(false);
				}catch (NumberFormatException ek) {
					//not a valid input, so we display that it is not a valid input
					canNotScrollHigherLabel.setVisible(false);
					canNotScrollLowerLabel.setVisible(false);
					invalidInputLabel.setVisible(true);
				}
			}
		});
		moveDownButton.setBounds(340, 334, 85, 21);
		frame.getContentPane().add(moveDownButton);
		
		
	}
}