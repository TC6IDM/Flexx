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
	private JTextField textField;
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
	
	public String isValid() {
		String invalidInfo ="\n";
		if (exercises.size()==0) return "|No Exercises|";
		for (int i=0;i<exercises.size();i++) {
			Exercise currentExercise = exercises.get(i);
			String exerciseName = currentExercise.nameField.getText();
			if (exerciseName.equals("")) invalidInfo = invalidInfo+ "|Exercise #"+currentExercise.exerciseNumber+" Name Invalid|\n";
			for (int k=0;k<currentExercise.sets.size();k++) {
				Set currentSet = currentExercise.sets.get(k);
				String reps = currentSet.repsField.getText();
				String weight = currentSet.weightField.getText();
				if (reps.equals("")) invalidInfo = invalidInfo+ "|Exercise #"+currentExercise.exerciseNumber+" Set #"+currentSet.setNumber+" Reps Invalid|\n";
				if (weight.equals(""))invalidInfo = invalidInfo+ "|Exercise #"+currentExercise.exerciseNumber+" Set #"+currentSet.setNumber+" Weight Invalid|\n";
				
				try {
					Integer.parseInt(reps);
			    } catch (NumberFormatException nfe) {
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
				
				String invalidInfo = isValid();
				if (!invalidInfo.equals("\n")) JOptionPane.showMessageDialog(frame, "Invalid Input:\n"+invalidInfo);
				else {
					String url = "jdbc:mysql://localhost:3306/Flexx" ;
					String user = "root" ;
					String sizeQuery = "SELECT COUNT(*) FROM exerciselogs";
					
					int tableSize =0;
					try {
						// create connection
						Connection con = DriverManager.getConnection (JDBC.databaseURL,JDBC.user,JDBC.password);
//						System.out.println("hi");
						 // create statement
						Statement statement = con.createStatement();
//						System.out.println("hi");
						 // generate result set
						ResultSet rs = statement.executeQuery(sizeQuery);
						rs.next();
						tableSize = rs.getInt(1);
//					    System.out.println("hi");
					    
						

					} catch (SQLException err) {
//						err.printStackTrace();
					}
					
					
					
					for (int i=0;i<exercises.size();i++) {
						Exercise currentExercise = exercises.get(i);
						String exerciseName = currentExercise.nameField.getText();
						for (int k=0;k<currentExercise.sets.size();k++) {
							Set currentSet = currentExercise.sets.get(k);
							String reps = currentSet.repsField.getText();
							String weight = currentSet.weightField.getText(); 
							String insertQuery = "INSERT INTO exerciselogs VALUE(\""+exerciseName+"\", "+reps+", "+weight+", "+tableSize+");";
//							System.out.println(insertQuery);
							try {
								Connection con = DriverManager.getConnection (JDBC.databaseURL,JDBC.user,JDBC.password);
//								System.out.println("hi2");
								 // create statement
								Statement statement = con.createStatement();
//								System.out.println("hi2");
								 // generate result set
								statement.execute(insertQuery);
//								System.out.println("hi2");
							} catch (SQLException err) {
//								err.printStackTrace();
							}
						}
					}
					
					
					System.out.println("Number of records in the table represented by the ResultSet object is: "+tableSize);
					Home home = new Home();
					home.frame.setVisible(true);
					frame.setVisible(false);
				}
				
			}
		});
		doneButton.setBounds(Frame_Width-100, 10, 75, 35);
		frame.getContentPane().add(doneButton);
		
		int newExerciseButton_width = 150;
		int newExerciseButton_height = 35;	
		int newExerciseButton_distanceFromTop = 50;
		int moveDown = 10;
		JButton newExerciseButton = new JButton("New Exercise");
		newExerciseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canNotScrollHigherLabel.setVisible(false);
				canNotScrollLowerLabel.setVisible(false);
				int newY = 50;
				if (exercises.size() != 0){
					JButton oldAddSetButton = exercises.get(exercises.size()-1).addSetButton;
					newY = oldAddSetButton.getY()+oldAddSetButton.getHeight()+moveDown;
				}
				Exercise thisExercise = new Exercise(frame,newY, canNotScrollHigherLabel, canNotScrollLowerLabel);
				exercises.add(thisExercise);
				JButton addSetButton = thisExercise.addSetButton;
				newExerciseButton.setLocation(newExerciseButton.getX(), addSetButton.getY()+addSetButton.getHeight()+moveDown);	
				thisExercise.setNewExerciseButton(newExerciseButton);
				thisExercise.setExerciseNumber(exercises);
				frame.validate();
				frame.repaint();
			}
		});
		newExerciseButton.setBounds(Frame_Center-newExerciseButton_width/2, newExerciseButton_distanceFromTop, newExerciseButton_width, newExerciseButton_height);
		frame.getContentPane().add(newExerciseButton);
		
		
		textField = new JTextField();
		textField.setBounds(340, 292, 85, 19);
		textField.setText("20");
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel scrollByLabel = new JLabel("Scroll By:");
		scrollByLabel.setBounds(340, 279, 85, 13);
		frame.getContentPane().add(scrollByLabel);
		
		invalidInputLabel = new JLabel("Invalid Input");
		invalidInputLabel.setBounds(340, 311, 85, 13);
		invalidInputLabel.setVisible(false);
		frame.getContentPane().add(invalidInputLabel);
		
		canNotScrollHigherLabel = new JLabel("Can Not Scroll Higher");
		canNotScrollHigherLabel.setBounds(318, 233, 117, 13);
		canNotScrollHigherLabel.setVisible(false);
		frame.getContentPane().add(canNotScrollHigherLabel);
		
		canNotScrollLowerLabel = new JLabel("Can Not Scroll Lower");
		canNotScrollLowerLabel.setBounds(318, 360, 117, 13);
		canNotScrollLowerLabel.setVisible(false);
		frame.getContentPane().add(canNotScrollLowerLabel);
		
		JButton moveUpButton = new JButton("Up");
		moveUpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int moveBy = Integer.parseInt(textField.getText());
					if (!move(-moveBy)) canNotScrollHigherLabel.setVisible(true); else canNotScrollHigherLabel.setVisible(false);
					canNotScrollLowerLabel.setVisible(false);
					invalidInputLabel.setVisible(false);
					}catch (NumberFormatException ek) {
//					ek.printStackTrace();
					invalidInputLabel.setVisible(true);
				}
			}
		});
		moveUpButton.setBounds(340, 248, 85, 21);
		frame.getContentPane().add(moveUpButton);
		
		JButton moveDownButton = new JButton("Down");
		moveDownButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int moveBy = Integer.parseInt(textField.getText());
					if (!move(moveBy)) canNotScrollLowerLabel.setVisible(true); else canNotScrollLowerLabel.setVisible(false);
					canNotScrollHigherLabel.setVisible(false);
					invalidInputLabel.setVisible(false);
				}catch (NumberFormatException ek) {
//					ek.printStackTrace();
					invalidInputLabel.setVisible(true);
				}
			}
		});
		moveDownButton.setBounds(340, 334, 85, 21);
		frame.getContentPane().add(moveDownButton);
		
		
		
		
		
		
	}
}