package Andrew;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

//exercise class
public class Exercise{
	public JLabel nameLabel;
	public JTextField nameField;
	public ArrayList<Set> sets = new ArrayList<Set>();
	public JButton addSetButton;
	public JButton newExerciseButton;
	public int exerciseNumber;
	public ArrayList<Exercise> exercises = new ArrayList<Exercise>();
	public JLabel exerciseNumberLabel;
	public JLabel setLabel;
	public JLabel repsLabel;
	public JLabel weightLabel;
	
	public Exercise(Page3 page,int Y){
		int Frame_ActualWidth = page.Frame_ActualWidth;
		int distanceBetweenExerciseAndReps = 25;
		int fieldHeight = 20;
		int nameFieldLength =125;
		JFrame frame = page.frame;
		//creates the exercise name field	
		nameField = new JTextField();
		nameField.setBounds(Frame_ActualWidth/2 - nameFieldLength/2, Y, nameFieldLength, fieldHeight);
		frame.getContentPane().add(nameField);
		nameField.setColumns(10);
		
		//creates the exercise name label
		int nameLabelWidth = 90;
		nameLabel = new JLabel("Exercise Name:");
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nameLabel.setForeground(new Color(255, 255, 255));
		nameLabel.setBounds(Frame_ActualWidth/4 - nameLabelWidth/2, Y, nameLabelWidth, fieldHeight);
		frame.getContentPane().add(nameLabel);
		
		int numberLabelWidth = 18;
		exerciseNumberLabel = new JLabel("1");
		exerciseNumberLabel.setHorizontalAlignment(SwingConstants.CENTER);
		exerciseNumberLabel.setForeground(Color.WHITE);
		exerciseNumberLabel.setBounds(nameLabel.getX()-numberLabelWidth, Y, numberLabelWidth, fieldHeight);
		frame.getContentPane().add(exerciseNumberLabel);
		
		int setRepWeightLabelHeight = exerciseNumberLabel.getY() + exerciseNumberLabel.getHeight()+5;
		int setRepWeightLabelWidth = 45;
		
		setLabel = new JLabel("Set");
		setLabel.setHorizontalAlignment(SwingConstants.CENTER);
		setLabel.setForeground(new Color(255, 255, 255));
		setLabel.setBounds(Frame_ActualWidth/4 - setRepWeightLabelWidth/2, setRepWeightLabelHeight, setRepWeightLabelWidth, fieldHeight);
		frame.getContentPane().add(setLabel);
		
		repsLabel = new JLabel("Reps");
		repsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		repsLabel.setForeground(new Color(255, 255, 255));
		repsLabel.setBounds(Frame_ActualWidth/2 - setRepWeightLabelWidth/2, setRepWeightLabelHeight, setRepWeightLabelWidth, fieldHeight);
		frame.getContentPane().add(repsLabel);
		
		weightLabel = new JLabel("Weight");
		weightLabel.setHorizontalAlignment(SwingConstants.CENTER);
		weightLabel.setForeground(new Color(255, 255, 255));
		weightLabel.setBounds(Frame_ActualWidth*3/4 - setRepWeightLabelWidth/2, setRepWeightLabelHeight, setRepWeightLabelWidth, fieldHeight);
		frame.getContentPane().add(weightLabel);
		
//		page.moveUpButton.setVisible(true);
//		page.scrollByLabel.setVisible(true);
//		page.scrollByField.setVisible(true);
		//reprints the frame
		frame.validate();
		frame.repaint();
		
		//creates a new set with a certain distance below the exercise
		Set thisSet = new Set (page,setRepWeightLabelHeight+distanceBetweenExerciseAndReps);	
		thisSet.setSetNumber(sets);
		
		sets.add(thisSet);//adds the set to the 
		
		JTextField repsField = thisSet.repsField;//keeps track of the weight field as it is the lowest in the set
		
		//adds the addset button
		int addSetButton_width = 80;
		int addSetButton_height = 13;
		int addSetButtonY = repsField.getY()+repsField.getHeight()+5;
		addSetButton = new JButton("Add set");
		addSetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//removes the error labels when a new set is added
				Set newSet = new Set (page,addSetButton.getY());//creates a new set with the last set button's Y value
				newSet.setSetNumber(sets); //sets the number of sets
				JTextField newRepsField = newSet.repsField;//gets the new weight field
				sets.add(newSet);//adds the set to the list
				addSetButton.setLocation(addSetButton.getX(), newRepsField.getY()+newRepsField.getHeight()+5);//sets the location of the add set button
				
				if (exerciseNumber == exercises.size()) {
					newExerciseButton.setLocation(newExerciseButton.getX(), addSetButton.getY()+addSetButton.getHeight()+10); // if this is the last exercise, only the exercise button needs to be moved down
					if (newExerciseButton.getY()+newExerciseButton.getHeight() > page.Frame_ActualHeight) {
						page.moveUpButton.setVisible(true); //if the next move will put the exercise button above the cutoff, then only move by however much can keep it right at the cutoff
//						page.move(-(newExerciseButton.getY()+newExerciseButton.getHeight()-page.Frame_ActualHeight));
					}
				
				}
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
						JLabel tempExerciseNumberLabel = tempExercise.exerciseNumberLabel;
						JLabel tempSetLabel = tempExercise.setLabel;
						JLabel tempRepsLabel = tempExercise.repsLabel;
						JLabel tempWeightLabel = tempExercise.weightLabel;
						int distanceBetweenExercises =20;
						int tempY = prevExercise.addSetButton.getY()+prevExercise.addSetButton.getHeight()+distanceBetweenExercises; //the new starting Y level based on the prevoius exercise
						
						//move the name field and name label down
						tempNameLabel.setLocation(tempNameLabel.getX(),	tempY);
						tempNameField.setLocation(tempNameField.getX(),	tempY);
						tempExerciseNumberLabel.setLocation(tempExerciseNumberLabel.getX(),	tempY);
						int newSetRepWeightLabelHeight = tempExerciseNumberLabel.getY() + tempExerciseNumberLabel.getHeight()+5;
						tempSetLabel.setLocation(tempSetLabel.getX(),newSetRepWeightLabelHeight);
						tempRepsLabel.setLocation(tempRepsLabel.getX(),newSetRepWeightLabelHeight);
						tempWeightLabel.setLocation(tempWeightLabel.getX(),newSetRepWeightLabelHeight);
						
						tempY = tempRepsLabel.getY()+tempRepsLabel.getHeight()+5; //move the Y down
						
						//loop through all the sets
						for (int k=0;k<tempExercise.sets.size();k++) {
							Set tempSet = tempExercise.sets.get(k); //the current set
							
							//all the elements of the set
							JLabel tempSetCount = tempSet.setCount;
							JTextField tempRepsField = tempSet.repsField;
							JTextField tempWeightField = tempSet.weightField;
							
							//move all the elements down to where they need to be
							tempSetCount.setLocation(tempSetCount.getX(), tempY);
							tempRepsField.setLocation(tempRepsField.getX(), tempY);
							tempWeightField.setLocation(tempWeightField.getX(), tempY);
							tempAddSetButton.setLocation(tempAddSetButton.getX(),tempRepsField.getY()+tempRepsField.getHeight()+5);
							tempY = tempAddSetButton.getY();
							
						}
						
						//set the location of the new Exercise Button
						newExerciseButton.setLocation(newExerciseButton.getX(), tempAddSetButton.getY()+tempAddSetButton.getHeight()+10);
						if (newExerciseButton.getY()+newExerciseButton.getHeight() > page.Frame_ActualHeight) {
							page.moveUpButton.setVisible(true); //if the next move will put the exercise button above the cutoff, then only move by however much can keep it right at the cutoff
//							page.move(-(newExerciseButton.getY()+newExerciseButton.getHeight()-page.Frame_ActualHeight));
						}
					}
				}
			}
		});
		addSetButton.setForeground(Color.ORANGE);
		addSetButton.setOpaque(false);
		addSetButton.setContentAreaFilled(false);
		addSetButton.setBorderPainted(false);
		addSetButton.setBounds(Frame_ActualWidth/2 - addSetButton_width/2, addSetButtonY, addSetButton_width, addSetButton_height);
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
		exerciseNumberLabel.setText(Integer.toString(exerciseNumber));
		//add code to display number to the left of the reps counter
	}
	
}