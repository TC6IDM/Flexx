package Andrew;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

//exercise class
public class Exercise{
	public JLabel nameLabel;
	public JTextField nameField;
	public ArrayList<Set> sets = new ArrayList<Set>();
	public JButton addSetButton;
	public JButton newExerciseButton;
	public int exerciseNumber;
	public ArrayList<Exercise> exercises = new ArrayList<Exercise>();
	
	public Exercise(JFrame frame,int Y,JLabel H,JLabel L){
		int distanceBetweenExerciseAndReps = 25;
		//creates the exercise name label
		nameLabel = new JLabel("Exercise Name:");
		nameLabel.setBounds(80, Y, 90, 20);
		frame.getContentPane().add(nameLabel);
		
		//creates the exercise name field
		nameField = new JTextField();
		nameField.setBounds(175, Y, 125, 20);
		frame.getContentPane().add(nameField);
		nameField.setColumns(10);
		
		//reprints the frame
		frame.validate();
		frame.repaint();
		
		//creates a new set with a certain distance below the exercise
		Set thisSet = new Set (frame,Y+distanceBetweenExerciseAndReps);	
		thisSet.setSetNumber(sets);
		
		sets.add(thisSet);//adds the set to the 
		
		JTextField weightField = thisSet.weightField;//keeps track of the weight field as it is the lowest in the set
		
		//adds the addset button
		addSetButton = new JButton("Add set");
		addSetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//removes the error labels when a new set is added
				H.setVisible(false);
				L.setVisible(false);
				Set newSet = new Set (frame,addSetButton.getY());//creates a new set with the last set button's Y value
				newSet.setSetNumber(sets); //sets the number of sets
				JTextField newWeightField = newSet.weightField;//gets the new weight field
				sets.add(newSet);//adds the set to the list
				addSetButton.setLocation(addSetButton.getX(), newWeightField.getY()+newWeightField.getHeight());//sets the location of the add set button
				
				if (exerciseNumber == exercises.size()) newExerciseButton.setLocation(newExerciseButton.getX(), addSetButton.getY()+addSetButton.getHeight()+10); // if this is the last exercise, only the exercise button needs to be moved down
				else{
					// if this is not the last exercise (IE: somewhere in the middle or beginning) move all exercises and sets down to accommodate for the new set
					//loop through all exercises starting at the current one
					for (int i=exerciseNumber;i<exercises.size();i++) {
						Exercise tempExercise = exercises.get(i); //this exercise
						Exercise prevExercise = exercises.get(i-1); //the previous exercise
						
						//all the elements of the exercise
						JLabel tempNameLabel = tempExercise.nameLabel;
						JTextField tempNameField = tempExercise.nameField;
						JButton tempAddSetButton = tempExercise.addSetButton;		
						
						int tempY = prevExercise.addSetButton.getY()+prevExercise.addSetButton.getHeight()+10; //the new starting Y level based on the prevoius exercise
						
						//move the name field and name label down
						tempNameLabel.setLocation(tempNameLabel.getX(),	tempY);
						tempNameField.setLocation(tempNameField.getX(),	tempY);
						tempY+=distanceBetweenExerciseAndReps; //move the Y down
						
						//loop through all the sets
						for (int k=0;k<tempExercise.sets.size();k++) {
							Set tempSet = tempExercise.sets.get(k); //the current set
							
							//all the elements of the set
							JLabel tempSetCount = tempSet.setCount;
							JLabel tempRepsLabel = tempSet.repsLabel;
							JTextField tempRepsField = tempSet.repsField;
							JLabel tempWeightLabel = tempSet.weightLabel;
							JTextField tempWeightField = tempSet.weightField;
							
							//move all the elements down to where they need to be
							tempSetCount.setLocation(tempSetCount.getX(), tempY);
							tempRepsLabel.setLocation(tempRepsLabel.getX(), tempY);
							tempRepsField.setLocation(tempRepsField.getX(), tempY);
							tempWeightLabel.setLocation(tempWeightLabel.getX(), tempY+20);
							tempWeightField.setLocation(tempWeightField.getX(), tempY+20);
							tempAddSetButton.setLocation(tempAddSetButton.getX(),tempWeightField.getY()+tempWeightField.getHeight());
							tempY = tempAddSetButton.getY();
							
						}
						
						//set the location of the new Exercise Button
						newExerciseButton.setLocation(newExerciseButton.getX(), tempAddSetButton.getY()+tempAddSetButton.getHeight()+10);
					}
				}
			}
		});
		int centerWeight = weightField.getX()+weightField.getWidth()/2;
		int addSetButton_width = 80;
		addSetButton.setBounds(centerWeight-addSetButton_width/2, weightField.getY()+weightField.getHeight(), addSetButton_width, 13);
		frame.getContentPane().add(addSetButton);		
	}
	
	//sets the new exercise button to the given button
	public void setNewExerciseButton(JButton e){
		newExerciseButton = e;
	}
	
	//gets the exercise number
	public void setExerciseNumber(ArrayList<Exercise> e) {
		exercises = e;
		exerciseNumber = e.size();
		//add code to display number to the left of the reps counter
	}
	
}