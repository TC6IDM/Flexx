package Andrew;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Set{
	public JLabel setCount;
	public JLabel repsLabel;
	public JTextField repsField;
	public JLabel weightLabel;
	public JTextField weightField;
	public int setNumber;
	public JFrame frame;
	
	//creates a set of an exercise
	public Set(JFrame f,int Y) {
		frame = f;
		
		//creates the reps label
		repsLabel = new JLabel("Reps:");
		repsLabel.setBounds(135, Y, 35, 20);
		frame.getContentPane().add(repsLabel);
		
		//creates the reps field
		repsField = new JTextField();
		repsField.setColumns(10);
		repsField.setBounds(175, Y, 125, 20);
		frame.getContentPane().add(repsField);
		
		//creates the weight label
		weightLabel = new JLabel("Weight:");
		weightLabel.setBounds(125, Y+20, 45, 20);
		frame.getContentPane().add(weightLabel);
		
		//creates the weight field
		weightField = new JTextField();
		weightField.setColumns(10);
		weightField.setBounds(175, Y+20, 125, 20);
		frame.getContentPane().add(weightField);
		
		//reprints the frame
		frame.validate();
		frame.repaint();
		
	}
	
	//sets the set number
	public void setSetNumber(ArrayList<Set> s) {
		setNumber = s.size()+1; //gets the set number
		
		//creates a new label to indicate the set number
		setCount = new JLabel("Set: "+setNumber);
		setCount.setBounds(80, repsLabel.getY(), 35, 20);
		frame.getContentPane().add(setCount);
	}
}