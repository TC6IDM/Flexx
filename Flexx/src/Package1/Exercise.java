package Package1;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class Exercise{
	public JLabel nameLabel;
	public JTextField nameField;
	public ArrayList<Set> sets = new ArrayList<Set>();
	public JButton addSetButton;
	public JButton newExerciseButton;
	public int exerciseNumber;
	public ArrayList<Exercise> exercises = new ArrayList<Exercise>();
	
	public Exercise(JFrame frame,int Y){
		int distanceBetweenExerciseAndReps = 25;
//		int moveDown = 10;
		nameLabel = new JLabel("Exercise Name:");
		nameLabel.setBounds(80, Y, 90, 20);
		frame.getContentPane().add(nameLabel);
		
		nameField = new JTextField();
		nameField.setBounds(175, Y, 125, 20);
		frame.getContentPane().add(nameField);
		nameField.setColumns(10);
		
		frame.validate();
		frame.repaint();
		
		Set thisSet = new Set (frame,Y+distanceBetweenExerciseAndReps);	
		thisSet.setSetNumber(sets);
		
		sets.add(thisSet);
		
		JTextField weightField = thisSet.weightField;
		
		
		addSetButton = new JButton("Add set");
		addSetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Set newSet = new Set (frame,addSetButton.getY());	
				newSet.setSetNumber(sets);
				JTextField newWeightField = newSet.weightField;
				sets.add(newSet);
				addSetButton.setLocation(addSetButton.getX(), newWeightField.getY()+newWeightField.getHeight());
				
//				System.out.println(exerciseNumber+ " " + exercises.size());
				
				if (exerciseNumber != exercises.size()) {
					
					for (int i=exerciseNumber;i<exercises.size();i++) {
						Exercise tempExercise = exercises.get(i);
						Exercise prevExercise = exercises.get(i-1);
						JLabel tempNameLabel = tempExercise.nameLabel;
						JTextField tempNameField = tempExercise.nameField;
						JButton tempAddSetButton = tempExercise.addSetButton;		
						
						int tempY = prevExercise.addSetButton.getY()+prevExercise.addSetButton.getHeight()+10;
						
						tempNameLabel.setLocation(tempNameLabel.getX(),	tempY);
						tempNameField.setLocation(tempNameField.getX(),	tempY);
						tempY+=distanceBetweenExerciseAndReps;
						for (int k=0;k<tempExercise.sets.size();k++) {
//							System.out.println(tempExercise.sets.size());
							Set tempSet = tempExercise.sets.get(k);
							JLabel tempSetCount = tempSet.setCount;
							JLabel tempRepsLabel = tempSet.repsLabel;
							JTextField tempRepsField = tempSet.repsField;
							JLabel tempWeightLabel = tempSet.weightLabel;
							JTextField tempWeightField = tempSet.weightField;
							tempSetCount.setLocation(tempSetCount.getX(), tempY);
							tempRepsLabel.setLocation(tempRepsLabel.getX(), tempY);
							tempRepsField.setLocation(tempRepsField.getX(), tempY);
							tempWeightLabel.setLocation(tempWeightLabel.getX(), tempY+20);
							tempWeightField.setLocation(tempWeightField.getX(), tempY+20);
							tempAddSetButton.setLocation(tempAddSetButton.getX(),tempWeightField.getY()+tempWeightField.getHeight());
							tempY = tempAddSetButton.getY();
							
						}
						newExerciseButton.setLocation(newExerciseButton.getX(), tempAddSetButton.getY()+tempAddSetButton.getHeight()+10);
						
					}
					
				}else {
					newExerciseButton.setLocation(newExerciseButton.getX(), addSetButton.getY()+addSetButton.getHeight()+10);
				}
			}
		});
		int centerWeight = weightField.getX()+weightField.getWidth()/2;
		int addSetButton_width = 80;
		addSetButton.setBounds(centerWeight-addSetButton_width/2, weightField.getY()+weightField.getHeight(), addSetButton_width, 13);
		frame.getContentPane().add(addSetButton);
//		newExerciseButton.setLocation(Y, newExerciseButton.getY());
		
	}
	
	public void setNewExerciseButton(JButton e){
		newExerciseButton = e;
	}
	
	public void setExerciseNumber(ArrayList<Exercise> e) {
		exercises = e;
		exerciseNumber = e.size();
		//add code to display number to the left of the reps counter
	}
	
}
