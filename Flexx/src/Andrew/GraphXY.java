package Andrew;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

//exercise class
public class GraphXY{
	public List<Integer> xValues;
	public List<Double> yValues;
	public List<String> bestSets;

	
	public GraphXY(List<Integer> x, List<Double> y, List<String> s){
		xValues = x;
		yValues = y;
		bestSets = s;
	}
	
	public String toString() {
		String ret = "";
		for (int i=0;i<xValues.size();i++) {
			ret+="("+xValues.get(i)+","+yValues.get(i)+")\n";
		}
		return ret;
	}
}