package Andrew;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Set{
	public JLabel setCount;
	public JTextField repsField;
	public JTextField weightField;
	public int setNumber;
	public JFrame frame;
	
	//creates a set of an exercise
	public Set(JFrame f,int Y) {
		frame = f;
		int Frame_Width = 450;
		int Frame_ActualWidth = Frame_Width - 14;
		int fieldHeight = 20;
		int numberLabelWidth = 18;
		setCount = new JLabel("1");
		setCount.setHorizontalAlignment(SwingConstants.CENTER);
		setCount.setForeground(Color.WHITE);
		setCount.setBounds(Frame_ActualWidth/4 - numberLabelWidth/2, Y, numberLabelWidth, fieldHeight);
		frame.getContentPane().add(setCount);
		
		int textFieldWidth = 70;
		//creates the reps field
		repsField = new JTextField();
		repsField.setColumns(10);
		repsField.setBounds(Frame_ActualWidth/2 - textFieldWidth/2, Y, textFieldWidth, fieldHeight);
		frame.getContentPane().add(repsField);
		
		//creates the weight field
		weightField = new JTextField();
		weightField.setColumns(10);
		weightField.setBounds(Frame_ActualWidth*3/4 - textFieldWidth/2, Y, textFieldWidth, fieldHeight);
		frame.getContentPane().add(weightField);
		
		//reprints the frame
		frame.validate();
		frame.repaint();
		
	}
	
	//sets the set number
	public void setSetNumber(ArrayList<Set> s) {
		setNumber = s.size()+1; //gets the set number
		setCount.setText(Integer.toString(setNumber));
		frame.validate();
		frame.repaint();
	}
}