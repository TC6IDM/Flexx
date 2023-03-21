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
public class Workout{
	public String workoutName;
	
	public ArrayList<Integer> weight = new ArrayList<Integer>();
	public ArrayList<Integer> reps = new ArrayList<Integer>();
	public ArrayList<Integer> number = new ArrayList<Integer>();
	
	public Workout(String s){
		workoutName = s;
	}
	//sets the new exercise button to the given button
	public void addDataPoint(int r,int w,int n){
		reps.add(r);
		weight.add(w);
		number.add(n);
		
		
	}
}