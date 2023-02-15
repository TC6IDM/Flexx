package Package1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/* Andrew Tissi */

class Exercise{
	public JLabel nameLabel;
	public JTextField nameField;
	public ArrayList<Set> sets = new ArrayList<Set>();
	public JButton addSetButton;
	public JButton newExerciseButton;
	
	public Exercise(JFrame frame,int Y){
		
		nameLabel = new JLabel("Exercise Name:");
		nameLabel.setBounds(100, Y, 71, 20);
		frame.getContentPane().add(nameLabel);
		
		nameField = new JTextField();
		nameField.setBounds(175, Y, 125, 20);
		frame.getContentPane().add(nameField);
		nameField.setColumns(10);
		
		frame.validate();
		frame.repaint();
		
		Set thisSet = new Set (frame,Y+25);		
		
		sets.add(thisSet);
		
		JTextField weightField = thisSet.weightField;
		
		
		addSetButton = new JButton("Add set");
		addSetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Set newSet = new Set (frame,addSetButton.getY());	
				JTextField newWeightField = newSet.weightField;
				sets.add(newSet);
				addSetButton.setLocation(addSetButton.getX(), newWeightField.getY()+newWeightField.getHeight());
				
				newExerciseButton.setLocation(newExerciseButton.getX(), addSetButton.getY()+addSetButton.getHeight()+10);
			}
		});
		
		addSetButton.setBounds(200, weightField.getY()+weightField.getHeight(), 73, 13);
		frame.getContentPane().add(addSetButton);
		
	}
	
	public void setNewExerciseButton(JButton e){
		newExerciseButton = e;
	}
	
}

class Set{
	
	public JLabel repsLabel;
	public JTextField repsField;
	public JLabel weightLabel;
	public JTextField weightField;
	
	public Set(JFrame frame,int Y) {
		
		repsLabel = new JLabel("Reps:");
		repsLabel.setBounds(145, Y, 26, 20);
		frame.getContentPane().add(repsLabel);
		
		repsField = new JTextField();
		repsField.setColumns(10);
		repsField.setBounds(175, Y, 125, 20);
		frame.getContentPane().add(repsField);
		
		weightLabel = new JLabel("Weight:");
		weightLabel.setBounds(135, Y+20, 36, 20);
		frame.getContentPane().add(weightLabel);
		
		weightField = new JTextField();
		weightField.setColumns(10);
		weightField.setBounds(175, Y+20, 125, 20);
		frame.getContentPane().add(weightField);
		
		frame.validate();
		frame.repaint();
		
	}
}


public class Page3 {

	public JFrame frame;
	public ArrayList<Exercise> exercises = new ArrayList<Exercise>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Page1 window = new Page1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public Page3() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void drawMoving() {
		
	}
	
	private void initialize() {
		int Frame_Left = 100;
		int Frame_Width = 450;
		int Frame_Top = 100;
		int Frame_Height = 300;
		int Frame_Center = Frame_Width/2;
		
		frame = new JFrame();
		frame.setBounds(Frame_Left, Frame_Top, Frame_Width, Frame_Height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel pageLabel = new JLabel("PAGE 3");
		pageLabel.setBounds(Frame_Center-50, 10, 100, 35);
		pageLabel.setFont(new Font("Berlin Sans FB", Font.PLAIN, 31));
		frame.getContentPane().add(pageLabel);
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home home = new Home();
				home.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		backButton.setBounds(10, 10, 75, 35);
		frame.getContentPane().add(backButton);
		
		JButton doneButton = new JButton("Done");
		doneButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home home = new Home();
				home.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		doneButton.setBounds(Frame_Width-100, 10, 75, 35);
		frame.getContentPane().add(doneButton);
		
		int newExerciseButton_width = 100;
		int newExerciseButton_height = 35;	
		int newExerciseButton_distanceFromTop = 50;
		int moveDown = 10;
		JButton newExerciseButton = new JButton("New exercise");
		newExerciseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int newY = 45;
				if (exercises.size() != 0){
					JButton oldAddSetButton = exercises.get(exercises.size()-1).addSetButton;
					newY = oldAddSetButton.getY()+oldAddSetButton.getHeight()+moveDown;
				}
				Exercise thisExercise = new Exercise(frame,newY);
				exercises.add(thisExercise);
				JButton addSetButton = thisExercise.addSetButton;
				newExerciseButton.setLocation(newExerciseButton.getX(), addSetButton.getY()+addSetButton.getHeight()+moveDown);	
				thisExercise.setNewExerciseButton(newExerciseButton);
				
				frame.validate();
				frame.repaint();
//				newExerciseButton.setVisible(false);
			}
		});
		newExerciseButton.setBounds(Frame_Center-newExerciseButton_width/2, newExerciseButton_distanceFromTop, newExerciseButton_width, newExerciseButton_height);
		frame.getContentPane().add(newExerciseButton);
		
//		JLabel nameLabel = new JLabel("Exercise Name:");
//		nameLabel.setBounds(100, 45, 71, 20);
//		frame.getContentPane().add(nameLabel);
//		
//		JTextField nameField = new JTextField();
//		nameField.setBounds(175, 45, 125, 20);
//		frame.getContentPane().add(nameField);
//		nameField.setColumns(10);
//		
//		JLabel repsLabel = new JLabel("Reps:");
//		repsLabel.setBounds(145, 70, 26, 20);
//		frame.getContentPane().add(repsLabel);
//		
//		JTextField repsField = new JTextField();
//		repsField.setColumns(10);
//		repsField.setBounds(175, 70, 125, 20);
//		frame.getContentPane().add(repsField);
//		
//		JLabel weightLabel = new JLabel("Weight:");
//		weightLabel.setBounds(135, 90, 36, 20);
//		frame.getContentPane().add(weightLabel);
//		
//		JTextField weightField = new JTextField();
//		weightField.setColumns(10);
//		weightField.setBounds(175, 90, 125, 20);
//		frame.getContentPane().add(weightField);
//		
//		JButton addSetButton = new JButton("Add set");
//		addSetButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//			}
//		});
//		
//		addSetButton.setBounds(200, 115, 73, 13);
//		frame.getContentPane().add(addSetButton);
		
	}

}
