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
	    ArrayList<String> bestSets = new ArrayList<String>();
	    int last=0;
	    for (int i=0;i<sets.size();i++) { //only puts the best set into the list
	    	workoutSet set = sets.get(i);
	    	double thisORM = set.weight*((set.reps/30)+1);
	    	ORMsTEMP.add(thisORM);
	    	
	    	if (i==sets.size()-1 || sets.get(i+1).number!=set.number) { //last set or new set
	    		double bestORM = Collections.max(ORMsTEMP);
	    		int bestORMIndex = ORMsTEMP.indexOf(bestORM);
	    		Double previousORM = 0.0;
	    		if (ORMs.size()!=0) previousORM = ORMs.get(ORMs.size()-1);
	    		if (ORMs.size()==0 || (bestORM>previousORM*.8 && bestORM<previousORM*1.20)) {
	    			bestSets.add(sets.get(last+bestORMIndex).toStringCompressed());
	    			ORMs.add(bestORM); 
	    			
		    		xAxis.add(set.number);
		    		last = i+1;
	    		}
	    		ORMsTEMP.clear();
	    		
	    		
	    	}
	    	
	    }
	    return new GraphXY(xAxis,ORMs,bestSets);
	}
	
	//prints the class in a string
	public String toString() {
		String ret = "";
		for (int i=0;i<sets.size();i++) {
			workoutSet thisSet = sets.get(i);
			ret+=thisSet.toString()+"\n";
			
		}
		return ret;
	}
}