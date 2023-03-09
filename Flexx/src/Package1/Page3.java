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
	public int height = 0;
	public JFrame frame;
	public ArrayList<Exercise> exercises = new ArrayList<Exercise>();
	private JTextField textField;

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
	
	public void move(int move) {
		int CUTOFF = 50;
		if (exercises.size()==0) return;
		if (exercises.get(0).newExerciseButton.getY()+move < CUTOFF) move = -1*(exercises.get(0).newExerciseButton.getY() - CUTOFF);
		height+= move;
		exercises.get(0).newExerciseButton.setLocation(exercises.get(0).newExerciseButton.getX(),exercises.get(0).newExerciseButton.getY()+move);
		for (int i=0;i<exercises.size();i++) {
			Exercise currentExercise = exercises.get(i);
			currentExercise.nameLabel.setLocation(currentExercise.nameLabel.getX(),currentExercise.nameLabel.getY()+move);
			currentExercise.nameField.setLocation(currentExercise.nameField.getX(),currentExercise.nameField.getY()+move);
			currentExercise.addSetButton.setLocation(currentExercise.addSetButton.getX(),currentExercise.addSetButton.getY()+move);
			if (currentExercise.nameLabel.getY()<CUTOFF) currentExercise.nameLabel.setVisible(false); else currentExercise.nameLabel.setVisible(true);
			if (currentExercise.nameField.getY()<CUTOFF) currentExercise.nameField.setVisible(false); else currentExercise.nameField.setVisible(true);
			if (currentExercise.addSetButton.getY()<CUTOFF) currentExercise.addSetButton.setVisible(false); else currentExercise.addSetButton.setVisible(true);
			
			for (int k=0;k<currentExercise.sets.size();k++) {
				Set currentSet = currentExercise.sets.get(k);
				currentSet.setCount.setLocation(currentSet.setCount.getX(),currentSet.setCount.getY()+move);
				currentSet.repsLabel.setLocation(currentSet.repsLabel.getX(),currentSet.repsLabel.getY()+move);
				currentSet.repsField.setLocation(currentSet.repsField.getX(),currentSet.repsField.getY()+move);
				currentSet.weightLabel.setLocation(currentSet.weightLabel.getX(),currentSet.weightLabel.getY()+move);
				currentSet.weightField.setLocation(currentSet.weightField.getX(),currentSet.weightField.getY()+move);
				if (currentSet.setCount.getY()<CUTOFF) currentSet.setCount.setVisible(false); else currentSet.setCount.setVisible(true);
				if (currentSet.repsLabel.getY()<CUTOFF) currentSet.repsLabel.setVisible(false); else currentSet.repsLabel.setVisible(true);
				if (currentSet.repsField.getY()<CUTOFF) currentSet.repsField.setVisible(false); else currentSet.repsField.setVisible(true);
				if (currentSet.weightLabel.getY()<CUTOFF) currentSet.weightLabel.setVisible(false); else currentSet.weightLabel.setVisible(true);
				if (currentSet.weightField.getY()<CUTOFF) currentSet.weightField.setVisible(false); else currentSet.weightField.setVisible(true);
				frame.validate();
				frame.repaint();
			}
		}
		
	}
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
		int pageLabel_width = 200;
		JLabel pageLabel = new JLabel("Track Workout");
		pageLabel.setBounds(Frame_Center-pageLabel_width/2, 10, pageLabel_width, 35);
		pageLabel.setFont(new Font("Berlin Sans FB", Font.PLAIN, 31));
		frame.getContentPane().add(pageLabel);
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        int option = JOptionPane.showConfirmDialog(frame, "Are you sure you would like to go back? This Current Workout will be Lost...", "Cancel?", JOptionPane.YES_NO_OPTION);
		        if (option == JOptionPane.YES_OPTION) {
		        	Home home = new Home();
					home.frame.setVisible(true);
					frame.setVisible(false);
		        }
			}
		});
		backButton.setBounds(10, 10, 75, 35);
		frame.getContentPane().add(backButton);
		
		JButton doneButton = new JButton("Done");
		doneButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean valid = true;
				String invalidInfo ="\n";
				if (exercises.size()==0) {
					valid = false;
					invalidInfo = "|No Exercises|";
				}
				for (int i=0;i<exercises.size();i++) {
					Exercise currentExercise = exercises.get(i);
					String exerciseName = currentExercise.nameField.getText();
					if (exerciseName.equals("")) {
						valid = false; 
						invalidInfo = invalidInfo+ "|Exercise #"+currentExercise.exerciseNumber+" Name Invalid|\n";
					}
					for (int k=0;k<currentExercise.sets.size();k++) {
						Set currentSet = currentExercise.sets.get(k);
						String reps = currentSet.repsField.getText();
						String weight = currentSet.weightField.getText();
						if (reps.equals("")) {
							valid = false; 
							invalidInfo = invalidInfo+ "|Exercise #"+currentExercise.exerciseNumber+" Set #"+currentSet.setNumber+" Reps Invalid|\n";
						}
						if (weight.equals("")) {
							valid = false; 
							invalidInfo = invalidInfo+ "|Exercise #"+currentExercise.exerciseNumber+" Set #"+currentSet.setNumber+" Weight Invalid|\n";
						}
						try {
					        int d = Integer.parseInt(reps);
					    } catch (NumberFormatException nfe) {
					    	if (!reps.equals("")) {
					    		valid = false; 
						    	invalidInfo = invalidInfo+ "|Exercise #"+currentExercise.exerciseNumber+" Set #"+currentSet.setNumber+" Reps must be an Integer|\n";
					    	}
					    }
						try {
					        double d = Double.parseDouble(weight);
					    } catch (NumberFormatException nfe) {
					    	if (!weight.equals("")) {
					    		valid = false; 
						    	invalidInfo = invalidInfo+ "|Exercise #"+currentExercise.exerciseNumber+" Set #"+currentSet.setNumber+" Weight must be a double|\n";
					    	}
					    }
					}
				}
				
				if (valid) {
					String url = "jdbc:mysql://localhost:3306/Flexx" ;
					String user = "root" ;
					String sizeQuery = "SELECT COUNT(*) FROM exerciselogs";
					
					int tableSize =0;
					try {
						// create connection
						Connection con = DriverManager.getConnection (url,user,JDBC.password);
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
								Connection con = DriverManager.getConnection (url,user,JDBC.password);
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
				else {
					JOptionPane.showMessageDialog(frame, "Invalid Input:\n"+invalidInfo);
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
				int newY = 45;
				if (exercises.size() != 0){
					JButton oldAddSetButton = exercises.get(exercises.size()-1).addSetButton;
					newY = oldAddSetButton.getY()+oldAddSetButton.getHeight()+moveDown;
				}
				Exercise thisExercise = new Exercise(frame,newY);
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
		textField.setBounds(329, 140, 85, 19);
		textField.setText("20");
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel scrollByLabel = new JLabel("Scroll By:");
		scrollByLabel.setBounds(329, 127, 85, 13);
		frame.getContentPane().add(scrollByLabel);
		
		JLabel invalidInputLabel = new JLabel("Invalid Input");
		invalidInputLabel.setBounds(329, 159, 85, 13);
		invalidInputLabel.setVisible(false);
		frame.getContentPane().add(invalidInputLabel);
		
		JButton moveUpButton = new JButton("Up");
		moveUpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int moveBy = Integer.parseInt(textField.getText());
					move(-moveBy);
					invalidInputLabel.setVisible(false);
				}catch (NumberFormatException ek) {
//					ek.printStackTrace();
					invalidInputLabel.setVisible(true);
				}
			}
		});
		moveUpButton.setBounds(327, 55, 85, 21);
		frame.getContentPane().add(moveUpButton);
		
		JButton moveDownButton = new JButton("Down");
		moveDownButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int moveBy = Integer.parseInt(textField.getText());
					move(moveBy);
					invalidInputLabel.setVisible(false);
				}catch (NumberFormatException ek) {
//					ek.printStackTrace();
					invalidInputLabel.setVisible(true);
				}
			}
		});
		moveDownButton.setBounds(327, 232, 85, 21);
		frame.getContentPane().add(moveDownButton);
		
		
		
		
		
		
	}
}