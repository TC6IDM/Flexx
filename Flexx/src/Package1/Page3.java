package Package1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

/* Andrew Tissi */

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
		int pageLabel_width = 200;
		JLabel pageLabel = new JLabel("Track Workout");
		pageLabel.setBounds(Frame_Center-pageLabel_width/2, 10, pageLabel_width, 35);
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
		
		int newExerciseButton_width = 150;
		int newExerciseButton_height = 35;	
		int newExerciseButton_distanceFromTop = 50;
		int moveDown = 10;
		JButton newExerciseButton = new JButton("New Exercise");
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
				thisExercise.setExerciseNumber(exercises);
				frame.validate();
				frame.repaint();
			}
		});
		newExerciseButton.setBounds(Frame_Center-newExerciseButton_width/2, newExerciseButton_distanceFromTop, newExerciseButton_width, newExerciseButton_height);
		frame.getContentPane().add(newExerciseButton);
		
	}

}
