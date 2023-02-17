package Package1;

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
	
	public Set(JFrame f,int Y) {
		frame = f;
		repsLabel = new JLabel("Reps:");
		repsLabel.setBounds(135, Y, 35, 20);
		frame.getContentPane().add(repsLabel);
		
		repsField = new JTextField();
		repsField.setColumns(10);
		repsField.setBounds(175, Y, 125, 20);
		frame.getContentPane().add(repsField);
		
		weightLabel = new JLabel("Weight:");
		weightLabel.setBounds(125, Y+20, 45, 20);
		frame.getContentPane().add(weightLabel);
		
		weightField = new JTextField();
		weightField.setColumns(10);
		weightField.setBounds(175, Y+20, 125, 20);
		frame.getContentPane().add(weightField);
		
		frame.validate();
		frame.repaint();
		
	}
	public void setSetNumber(ArrayList<Set> s) {
		setNumber = s.size()+1;
		
		setCount = new JLabel("Set: "+setNumber);
		setCount.setBounds(80, repsLabel.getY(), 35, 20);
		frame.getContentPane().add(setCount);
		
//		System.out.println(setNumber);
	}
}