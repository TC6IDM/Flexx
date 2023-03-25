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
	public List<Double> xValues;
	public List<Double> yValues;

	
	public GraphXY(List<Double> x, List<Double> y){
		xValues = x;
		yValues = y;
	}
	
}