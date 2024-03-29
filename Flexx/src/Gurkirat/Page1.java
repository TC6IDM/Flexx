package Gurkirat;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import Ava.*;
import otherUtil.*;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.SwingConstants;

public class Page1 {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Flexx.main(args);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Page1() {
		initialize();
	} 

	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	private void initialize() {
		frame = new JFrame();
		// Set the background color of the content pane of the frame
		frame.getContentPane().setBackground(new Color(77, 77, 77));
		// Set the foreground color of the content pane of the frame
		frame.getContentPane().setForeground(new Color(238, 255, 249));
		// Set the size and position of the frame
		frame.setBounds(100, 100, 450, 300);
		// Set the default close operation for the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Set the layout of the content pane to null
		frame.getContentPane().setLayout(null);
		
		// Create a button with the given text and tooltip, and add an action listener to it
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setToolTipText("Redirects to home page");
		btnNewButton.setBackground(new Color(238, 238, 238));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Create a new instance of the Home class and make its frame visible
				Home home = new Home();
				home.frame.setVisible(true);
				// Make the current frame invisible
				frame.setVisible(false);
			}
		});
		btnNewButton.setBounds(6, 11, 70, 30);
		frame.getContentPane().add(btnNewButton);
		
		JTextArea txtrMuscleGroup = new JTextArea(); // Create a new JTextArea
		txtrMuscleGroup.setName("txtrMuscleGroup");
		txtrMuscleGroup.setForeground(new Color(255, 200, 0));
		txtrMuscleGroup.setToolTipText(""); // Set the tooltip text to an empty string
		txtrMuscleGroup.setBackground(new Color(77, 77, 77)); // Set the background color
		txtrMuscleGroup.setEditable(false); // Set it to be uneditable
		txtrMuscleGroup.setFont(new Font("Georgia", Font.BOLD, 13)); // Set the font
		txtrMuscleGroup.setLineWrap(true); // Enable line wrapping
		txtrMuscleGroup.setText("       Muscle Group"); // Set the text
		txtrMuscleGroup.setBounds(29, 71, 134, 16); // Set the position and size
		frame.getContentPane().add(txtrMuscleGroup); // Add it to the content pane of the JFrame

		JTextArea txtrWorkoutTypes = new JTextArea(); // Create another JTextArea
		txtrWorkoutTypes.setName("txtrWorkoutTypes");
		txtrWorkoutTypes.setForeground(new Color(255, 200, 0));
		txtrWorkoutTypes.setBackground(new Color(77, 77, 77)); // Set the background color
		txtrWorkoutTypes.setEditable(false); // Set it to be uneditable
		txtrWorkoutTypes.setFont(new Font("Georgia", Font.BOLD, 13)); // Set the font
		txtrWorkoutTypes.setText("       Workout Types"); // Set the text
		txtrWorkoutTypes.setBounds(29, 119, 145, 16); // Set the position and size
		frame.getContentPane().add(txtrWorkoutTypes); // Add it to the content pane of the JFrame

		JComboBox comboBox = new JComboBox(); // Create a new JComboBox
		comboBox.setName("comboBox");
		comboBox.setFont(new Font("Georgia", Font.PLAIN, 13));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select", "Arms", "Legs", "Chest", "Back"})); // Set the items in the combo box
		comboBox.setBounds(252, 67, 145, 27); // Set the position and size
		frame.getContentPane().add(comboBox); // Add it to the content pane of the JFrame

		JComboBox comboBox_1 = new JComboBox(); // Create another JComboBox
		comboBox_1.setName("comboBox_1");
		comboBox_1.setFont(new Font("Georgia", Font.PLAIN, 13));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Select"})); // Initialize with "Select" item
		comboBox_1.setBounds(252, 115, 145, 27); // Set the position and size
		frame.getContentPane().add(comboBox_1); // Add it to the content pane of the JFrame
		comboBox_1.setEnabled(false); // Set it to be disabled

		comboBox.addActionListener(new ActionListener() { // Add an action listener to the first combo box
		    public void actionPerformed(ActionEvent e) {
		        String selected = comboBox.getSelectedItem().toString(); // Get the selected item as a string
		        if(selected.equals("Arms")) { // If "Arms" is selected
		            comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Select", "Hammer curls with rope-biceps", "Preacher curls-biceps", "Incline curls-biceps", "Tricep extensions-tricep", "Dips-tricep"})); // Set the items in the second combo box
		            comboBox_1.setEnabled(true); // Enable the second combo box
		        } 
		        else if(selected.equals("Legs")) { // If "Legs" is selected
		            comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Select", "Hack Squats", "Leg Extension", "Hamstrings"})); // Set the items in the second combo box
		            comboBox_1.setEnabled(true); // Enable the second combo box
		        }
		        else if(selected.equals("Chest")) { //If "Chest" is selected
		            comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Select", "Incline dumbell","Pectoral flys","Cable chest flys"}));
		            comboBox_1.setEnabled(true); // Enable the second combo box
		        } 
		        else if(selected.equals("Back")) { //If "Back" is selected
		            comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Select", "Lat pulldowns", "T-bar", "Cable rows"}));
		            comboBox_1.setEnabled(true); // Enable the second combo box
		        }
		        else {
		            comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Select"}));
		            comboBox_1.setEnabled(false); // Disable the second combo box
		        }
		}});
		
		comboBox_1.addActionListener(new ActionListener() {
		    // Define the actionPerformed() method for the event
		    public void actionPerformed(ActionEvent e) {
		        // Retrieve the selected item from comboBox_1 and convert it to a string
		        String selected = comboBox_1.getSelectedItem().toString();
		    }
		});

		// Create a new JTextPane object named textPane, set its properties, and add it to the frame
		JTextPane textPane = new JTextPane();
		textPane.setName("textPane");
		textPane.setEditable(false);
		textPane.setBackground(new Color(77, 77, 77));
		textPane.setBounds(0, 182, 448, 90);
		frame.getContentPane().add(textPane);

		// Create a new JButton object named btnNewButton_1, and add an action listener to trigger an event when it is clicked
		JButton btnNewButton_1 = new JButton("Get Results");
		btnNewButton_1.setName("getResultsButton");
		btnNewButton_1.setFont(new Font("Georgia", Font.PLAIN, 13));
		btnNewButton_1.addActionListener(new ActionListener() {
		    // Define the actionPerformed() method for the event
		    public void actionPerformed(ActionEvent e) {
		        // Retrieve the selected items from comboBox and comboBox_1 and convert them to strings
		        String muscleGroup = comboBox.getSelectedItem().toString();
		        String workoutType = comboBox_1.getSelectedItem().toString();

		        //  // Outputs for the 'Legs' Muscle Group
		        if (muscleGroup.equals("Legs") && workoutType.equals("Hack Squats")) {
		        	StyledDocument doc = textPane.getStyledDocument();
		            SimpleAttributeSet center = new SimpleAttributeSet();
		            StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		            StyleConstants.setBold(center, true);
		            doc.setParagraphAttributes(0, doc.getLength(), center, false);
		            textPane.setText("\n\n 3 sets of 8-12 reps");
		            textPane.setFont(new Font("Georgia", Font.PLAIN, 13));
		            textPane.setForeground(Color.ORANGE);
		            
		            Color borderColor = new Color(150, 150, 150);
		            int borderThickness = 2;
		            textPane.setBorder(BorderFactory.createMatteBorder(borderThickness, borderThickness, borderThickness, borderThickness, borderColor));
		        } 
		        else if (muscleGroup.equals("Legs") && workoutType.equals("Leg Extension")) {
		        	StyledDocument doc = textPane.getStyledDocument();
		            SimpleAttributeSet center = new SimpleAttributeSet();
		            StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		            StyleConstants.setBold(center, true);
		            doc.setParagraphAttributes(0, doc.getLength(), center, false);
		            textPane.setText("\n\n 3 sets of 10-12 reps");	
		            textPane.setFont(new Font("Georgia", Font.PLAIN, 13));
		            textPane.setForeground(Color.ORANGE);
		            
		            Color borderColor = new Color(150, 150, 150);
		            int borderThickness = 2;
		            textPane.setBorder(BorderFactory.createMatteBorder(borderThickness, borderThickness, borderThickness, borderThickness, borderColor));
		        }
		        else if (muscleGroup.equals("Legs") && workoutType.equals("Hamstrings")) {
		        	StyledDocument doc = textPane.getStyledDocument();
		            SimpleAttributeSet center = new SimpleAttributeSet();
		            StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		            StyleConstants.setBold(center, true);
		            doc.setParagraphAttributes(0, doc.getLength(), center, false);
		            textPane.setText("\n\n 3 sets of 6-12 reps");	
		            textPane.setFont(new Font("Georgia", Font.PLAIN, 13));
		            textPane.setForeground(Color.ORANGE);
		            
		            Color borderColor = new Color(150, 150, 150);
		            int borderThickness = 2;
		            textPane.setBorder(BorderFactory.createMatteBorder(borderThickness, borderThickness, borderThickness, borderThickness, borderColor));
		        }
		        
		        // Outputs for the 'Arms' Muscle Group
		        
		        else if (muscleGroup.equals("Arms") && workoutType.equals("Hammer curls with rope-biceps")) {
		        	StyledDocument doc = textPane.getStyledDocument();
		            SimpleAttributeSet center = new SimpleAttributeSet();
		            StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		            StyleConstants.setBold(center, true);
		            doc.setParagraphAttributes(0, doc.getLength(), center, false);
		            textPane.setText("\n\n 3 sets of 8-12 reps");	
		            textPane.setFont(new Font("Georgia", Font.PLAIN, 13));
		            textPane.setForeground(Color.ORANGE);
		            
		            Color borderColor = new Color(150, 150, 150);
		            int borderThickness = 2;
		            textPane.setBorder(BorderFactory.createMatteBorder(borderThickness, borderThickness, borderThickness, borderThickness, borderColor));
		        } 
		        else if (muscleGroup.equals("Arms") && workoutType.equals("Preacher curls-biceps")) {
		        	StyledDocument doc = textPane.getStyledDocument();
		            SimpleAttributeSet center = new SimpleAttributeSet();
		            StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		            StyleConstants.setBold(center, true);
		            doc.setParagraphAttributes(0, doc.getLength(), center, false);
		            textPane.setText("\n\n 3 sets of 8-10 reps");	
		            textPane.setFont(new Font("Georgia", Font.PLAIN, 13));
		            textPane.setForeground(Color.ORANGE);
		            
		            Color borderColor = new Color(150, 150, 150);
		            int borderThickness = 2;
		            textPane.setBorder(BorderFactory.createMatteBorder(borderThickness, borderThickness, borderThickness, borderThickness, borderColor));
		        }
		        else if (muscleGroup.equals("Arms") && workoutType.equals("Incline curls-biceps")) {
		        	StyledDocument doc = textPane.getStyledDocument();
		            SimpleAttributeSet center = new SimpleAttributeSet();
		            StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		            StyleConstants.setBold(center, true);
		            doc.setParagraphAttributes(0, doc.getLength(), center, false);
		            textPane.setText("\n\n 3 sets of 8-12 reps");
		            textPane.setFont(new Font("Georgia", Font.PLAIN, 13));
		            textPane.setForeground(Color.ORANGE);
		            
		            Color borderColor = new Color(150, 150, 150);
		            int borderThickness = 2;
		            textPane.setBorder(BorderFactory.createMatteBorder(borderThickness, borderThickness, borderThickness, borderThickness, borderColor));
		        }
		        else if (muscleGroup.equals("Arms") && workoutType.equals("Tricep extensions-tricep")) {
		        	StyledDocument doc = textPane.getStyledDocument();
		            SimpleAttributeSet center = new SimpleAttributeSet();
		            StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		            StyleConstants.setBold(center, true);
		            doc.setParagraphAttributes(0, doc.getLength(), center, false);
		            textPane.setText("\n\n 3 sets of 8-14 reps");	
		            textPane.setFont(new Font("Georgia", Font.PLAIN, 13));
		            textPane.setForeground(Color.ORANGE);
		            
		            Color borderColor = new Color(150, 150, 150);
		            int borderThickness = 2;
		            textPane.setBorder(BorderFactory.createMatteBorder(borderThickness, borderThickness, borderThickness, borderThickness, borderColor));
		        }
		        else if (muscleGroup.equals("Arms") && workoutType.equals("Dips-tricep")) {
		        	StyledDocument doc = textPane.getStyledDocument();
		            SimpleAttributeSet center = new SimpleAttributeSet();
		            StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		            StyleConstants.setBold(center, true);
		            doc.setParagraphAttributes(0, doc.getLength(), center, false);
		            textPane.setText("\n\n 3 sets of 6-12 reps");	
		            textPane.setFont(new Font("Georgia", Font.PLAIN, 13));
		            textPane.setForeground(Color.ORANGE);
		            
		            Color borderColor = new Color(150, 150, 150);
		            int borderThickness = 2;
		            textPane.setBorder(BorderFactory.createMatteBorder(borderThickness, borderThickness, borderThickness, borderThickness, borderColor));
		        }
		        
		        // Outputs for the 'Chest' Muscle Group
		        
		        else if (muscleGroup.equals("Chest") && workoutType.equals("Incline dumbell")) {
		        	StyledDocument doc = textPane.getStyledDocument();
		            SimpleAttributeSet center = new SimpleAttributeSet();
		            StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		            StyleConstants.setBold(center, true);
		            doc.setParagraphAttributes(0, doc.getLength(), center, false);
		            textPane.setText("\n\n 3 sets of 8-12 reps");
		            textPane.setFont(new Font("Georgia", Font.PLAIN, 13));
		            textPane.setForeground(Color.ORANGE);
		            
		            Color borderColor = new Color(150, 150, 150);
		            int borderThickness = 2;
		            textPane.setBorder(BorderFactory.createMatteBorder(borderThickness, borderThickness, borderThickness, borderThickness, borderColor));
		        }
		        else if (muscleGroup.equals("Chest") && workoutType.equals("Pectoral flys")) {
		        	StyledDocument doc = textPane.getStyledDocument();
		            SimpleAttributeSet center = new SimpleAttributeSet();
		            StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		            StyleConstants.setBold(center, true);
		            doc.setParagraphAttributes(0, doc.getLength(), center, false);
		            textPane.setText("\n\n 3 sets of 6-12 reps");	
		            textPane.setFont(new Font("Georgia", Font.PLAIN, 13));
		            textPane.setForeground(Color.ORANGE);
		            
		            Color borderColor = new Color(150, 150, 150);
		            int borderThickness = 2;
		            textPane.setBorder(BorderFactory.createMatteBorder(borderThickness, borderThickness, borderThickness, borderThickness, borderColor));
		        }
		        else if (muscleGroup.equals("Chest") && workoutType.equals("Cable chest flys")) {
		        	StyledDocument doc = textPane.getStyledDocument();
		            SimpleAttributeSet center = new SimpleAttributeSet();
		            StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		            StyleConstants.setBold(center, true);
		            doc.setParagraphAttributes(0, doc.getLength(), center, false);
		            textPane.setText("\n\n 3 sets of 8-10 reps");	
		            textPane.setFont(new Font("Georgia", Font.PLAIN, 13));
		            textPane.setForeground(Color.ORANGE);
		            
		            Color borderColor = new Color(150, 150, 150);
		            int borderThickness = 2;
		            textPane.setBorder(BorderFactory.createMatteBorder(borderThickness, borderThickness, borderThickness, borderThickness, borderColor));
		        }
		        
		        
		        // Outputs for the 'Back' Muscle Group
		        
		        else if (muscleGroup.equals("Back") && workoutType.equals("Lat pulldowns")) {
		        	StyledDocument doc = textPane.getStyledDocument();
		            SimpleAttributeSet center = new SimpleAttributeSet();
		            StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		            StyleConstants.setBold(center, true);
		            doc.setParagraphAttributes(0, doc.getLength(), center, false);
		            textPane.setText("\n\n 3 sets of 8-12 reps");	
		            textPane.setFont(new Font("Georgia", Font.PLAIN, 13));
		            textPane.setForeground(Color.ORANGE);
		            
		            Color borderColor = new Color(150, 150, 150);
		            int borderThickness = 2;
		            textPane.setBorder(BorderFactory.createMatteBorder(borderThickness, borderThickness, borderThickness, borderThickness, borderColor));
		        }
		        else if (muscleGroup.equals("Back") && workoutType.equals("T-bar")) {
		        	StyledDocument doc = textPane.getStyledDocument();
		            SimpleAttributeSet center = new SimpleAttributeSet();
		            StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		            StyleConstants.setBold(center, true);
		            doc.setParagraphAttributes(0, doc.getLength(), center, false);
		            textPane.setText("\n\n 3 sets of 8-10 reps");	
		            textPane.setFont(new Font("Georgia", Font.PLAIN, 13));
		            textPane.setForeground(Color.ORANGE);
		            
		            Color borderColor = new Color(150, 150, 150);
		            int borderThickness = 2;
		            textPane.setBorder(BorderFactory.createMatteBorder(borderThickness, borderThickness, borderThickness, borderThickness, borderColor));
		        }
		        else if(muscleGroup.equals("Back") && workoutType.equals("Cable rows")) {
		        	StyledDocument doc = textPane.getStyledDocument();
		            SimpleAttributeSet center = new SimpleAttributeSet();
		            StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		            StyleConstants.setBold(center, true);
		            doc.setParagraphAttributes(0, doc.getLength(), center, false);
		            textPane.setText("\n\n 3 sets of 6-12 reps");	
		            textPane.setFont(new Font("Georgia", Font.PLAIN, 13));
		            textPane.setForeground(Color.ORANGE);
		            
		            Color borderColor = new Color(150, 150, 150);
		            int borderThickness = 2;
		            textPane.setBorder(BorderFactory.createMatteBorder(borderThickness, borderThickness, borderThickness, borderThickness, borderColor));
		        }
		        
		        else {
		            JOptionPane.showMessageDialog(frame, "Please select a valid Muscle Group and Workout Type.");
		        } // Error message generated if user does clicks "Get Results" without selecting from both Drop-downs
		    }
		});
		// Set the position and size of the button with the label "btnNewButton_1" and add it to the frame's content pane
		btnNewButton_1.setBounds(148, 297, 117, 29);
		frame.getContentPane().add(btnNewButton_1);

		// Add an action listener to the "comboBox" object that clears the text pane when the combo box selection changes
		comboBox.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		textPane.setText(""); // Clear the text pane when the combo box selection changes
		textPane.setBorder(BorderFactory.createEmptyBorder());
		textPane.setText(""); // Clear the text pane when the combo box selection changes
		}
		});

		// Add an action listener to the "comboBox_1" object that clears the text pane when the combo box selection changes
		comboBox_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		textPane.setText(""); // Clear the text pane when the combo box selection changes
		textPane.setBorder(BorderFactory.createEmptyBorder());
		textPane.setText(""); // Clear the text pane when the combo box selection changes
		}
		});

		// Set a tool tip text for the button with the label "btnNewButton_1", set its position and size, and add it to the frame's content pane
		btnNewButton_1.setToolTipText("Generates Routine");
		btnNewButton_1.setBounds(138, 155, 156, 29);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblPersonalizedForYou = new JLabel("Personalized For You");
		lblPersonalizedForYou.setVerticalAlignment(SwingConstants.CENTER);
		lblPersonalizedForYou.setOpaque(true);
		lblPersonalizedForYou.setHorizontalAlignment(SwingConstants.CENTER);
		lblPersonalizedForYou.setForeground(Color.WHITE);
		lblPersonalizedForYou.setFont(new Font("SansSerif", Font.BOLD, 25));
		lblPersonalizedForYou.setBackground(new Color(43, 87, 154));
		lblPersonalizedForYou.setBounds(0, 0, 450, 50);
		frame.getContentPane().add(lblPersonalizedForYou);
	}
}
