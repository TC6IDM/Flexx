package Andrew;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

//exercise class
public class Workout{
	public String workoutName;
	
	public ArrayList <workoutSet> sets = new ArrayList<workoutSet>();
	
	public JButton button;
	
	public Workout(String s){
		workoutName = s;
	}
	//sets the new exercise button to the given button
	public void addDataPoint(int r,double w,int n){
		sets.add(new workoutSet(r,w,n));
	}
	public void setButton(JButton b){
		button = b;
	}
	
	public ArrayList<Double> getORMs() {
	    ArrayList<Double> ORMs = new ArrayList<Double>();
	    ArrayList<Double> ORMsTEMP = new ArrayList<Double>();
	    int currentWorkout = 1;
	    for (workoutSet set : sets) { //only puts the best set into the list
	    	double thisORM = set.weight / ((1.0278) - (0.0278 * set.reps));
	    	ORMsTEMP.add(thisORM);
	    	if (currentWorkout != set.number) {
	    		Collections.sort(ORMsTEMP);
	    		Collections.reverse(ORMsTEMP);
	    		ORMs.add(ORMsTEMP.get(0));
	    		ORMsTEMP.clear();
	    		ORMsTEMP.add(thisORM);
	    		currentWorkout = set.number;
	    	}
	    	
	    }
	    return ORMs;
	}
	public ArrayList<Integer> getxAxis() {
	    ArrayList<Integer> xAxis = new ArrayList<Integer>();
	    int currentWorkout = 0;
	    for (workoutSet set : sets) {
	    	if (set.number!=currentWorkout) {
	    		currentWorkout = set.number;
	    		System.out.println(set.number);
		    	xAxis.add(set.number);
	    	}
		    
	    }
	    return xAxis;
	}
}