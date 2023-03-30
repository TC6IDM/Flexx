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
	
	public GraphXY getGraphXY() {
	    ArrayList<Double> ORMs = new ArrayList<Double>();
	    ArrayList<Double> ORMsTEMP = new ArrayList<Double>();
	    ArrayList<Integer> xAxis = new ArrayList<Integer>();
	    ArrayList<Integer> xAxisTEMP = new ArrayList<Integer>();
	    int currentWorkout = 1;
	    for (workoutSet set : sets) { //only puts the best set into the list
	    	double thisORM = set.weight / ((1.0278) - (0.0278 * set.reps));
	    	ORMsTEMP.add(thisORM);
	    	xAxisTEMP.add(set.number);
	    	if (currentWorkout != set.number) {
	    		Collections.sort(ORMsTEMP);
	    		Collections.reverse(ORMsTEMP);
	    		ORMs.add(ORMsTEMP.get(0)); ORMsTEMP.clear(); ORMsTEMP.add(thisORM);
	    		xAxis.add(xAxisTEMP.get(0)); xAxisTEMP.clear(); xAxisTEMP.add(set.number);
	    		currentWorkout = set.number;
	    	}
	    	
	    }
	    
	    return new GraphXY(xAxis,ORMs);
	}
}