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
public class workoutSet{
	public int reps;
	public double weight;
	public int number;
	
	public workoutSet(int r, double w, int n){
		reps = r;
		weight = w;
		number = n;
	}
	
	//prints the class in a string
	public String toString() {
		return "Reps: "+reps+" Weight: "+weight+" Number: "+number;
	}
	public String toStringCompressed() {
		return weight+"x"+reps;
	}
	
}