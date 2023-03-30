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
//	    	System.out.println(set);
	    	double thisORM = set.weight / ((1.0278) - (0.0278 * set.reps));
	    	ORMsTEMP.add(thisORM);
	    	
	    	if (i==sets.size()-1 || sets.get(i+1).number!=set.number) {
//	    		Collections.sort(ORMsTEMP);
//	    		Collections.reverse(ORMsTEMP);
	    		double bestORM = Collections.max(ORMsTEMP);
	    		int bestORMIndex = ORMsTEMP.indexOf(bestORM);
//	    		System.out.println(i);
//	    		System.out.println(last);
//	    		System.out.println(bestORMIndex+"\n");
	    		bestSets.add(sets.get(last+bestORMIndex).toStringCompressed());
	    		ORMs.add(bestORM); ORMsTEMP.clear();
	    		xAxis.add(set.number);
	    		last = i+1;
	    	}
	    	
	    }
//	    System.out.println(bestSets);
	    return new GraphXY(xAxis,ORMs,bestSets);
	}
	
	public String toString() {
		String ret = "";
		for (int i=0;i<sets.size();i++) {
			workoutSet thisSet = sets.get(i);
			ret+=thisSet.toString()+"\n";
			
		}
		return ret;
	}
}