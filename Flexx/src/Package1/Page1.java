package Package1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.SystemColor;

public class Page1 {

	public JFrame frame;

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
	 */
	public Page1() {
		initialize();
	} 

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(138, 170, 229));
		frame.getContentPane().setForeground(new Color(238, 255, 249));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Personalized For You");
		lblNewLabel.setBounds(148, 8, 172, 35);
		lblNewLabel.setFont(new Font("Kohinoor Telugu", Font.BOLD, 15));
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setToolTipText("Redirects to home page");
		btnNewButton.setBackground(new Color(255, 93, 88));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home home = new Home();
				home.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnNewButton.setBounds(6, 8, 75, 16);
		frame.getContentPane().add(btnNewButton);
		
		JTextArea txtrMuscleGroup = new JTextArea();
		txtrMuscleGroup.setToolTipText("");
		txtrMuscleGroup.setBackground(new Color(138, 170, 229));
		txtrMuscleGroup.setEditable(false);
		txtrMuscleGroup.setFont(new Font("Geneva", Font.BOLD, 13));
		txtrMuscleGroup.setLineWrap(true);
		txtrMuscleGroup.setText("       Muscle Group");
		txtrMuscleGroup.setBounds(29, 71, 134, 16);
		frame.getContentPane().add(txtrMuscleGroup);
		
		JTextArea txtrWorkoutTypes = new JTextArea();
		txtrWorkoutTypes.setBackground(new Color(138, 170, 229));
		txtrWorkoutTypes.setEditable(false);
		txtrWorkoutTypes.setFont(new Font("Geneva", Font.BOLD, 13));
		txtrWorkoutTypes.setText("       Workout Types");
		txtrWorkoutTypes.setBounds(29, 119, 145, 16);
		frame.getContentPane().add(txtrWorkoutTypes);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select", "Arms", "Legs", "Chest", "Back"}));
		comboBox.setBounds(252, 67, 145, 27);
		frame.getContentPane().add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(252, 115, 145, 27);
		frame.getContentPane().add(comboBox_1);
		comboBox_1.setEnabled(false); // set it to be disabled
		comboBox_1.setSelectedItem("Select"); 

		comboBox.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String selected = comboBox.getSelectedItem().toString();
		        if(selected.equals("Arms")) {
		            comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Select", "Hammer curls with rope-biceps", "Preacher curls-biceps", "Incline curls-biceps", "Tricep extensions-tricep", "Dips-tricep"}));
		            comboBox_1.setEnabled(true);
		        } 
		        else if(selected.equals("Legs")) {
		            comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Select", "Hack Squats", "Leg Extension", "Hamstrings"}));
		            comboBox_1.setEnabled(true);
		        }
		        else if(selected.equals("Chest")) {
		            comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Select", "Incline dumbell","Pectoral flys","Cable chest flys"}));
		            comboBox_1.setEnabled(true);
		        } 
		        else if(selected.equals("Back")) {
		            comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Select", "Lat pulldowns", "T-bar", "Cable rows"}));
		            comboBox_1.setEnabled(true);
		        }
		        else {
		            comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Select"}));
		            comboBox_1.setEnabled(false);
		        }
		}});
		
		comboBox_1.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String selected = comboBox_1.getSelectedItem().toString();
		        if(selected.equals("Select")) {
		            JOptionPane.showMessageDialog(null, "Please choose a Workout Type");
		        }
		    }
		});
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBackground(new Color(138, 170, 229));
		textPane.setBounds(0, 182, 448, 90);
		frame.getContentPane().add(textPane);
		
		JButton btnNewButton_1 = new JButton("Get Results");
		btnNewButton_1.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String muscleGroup = comboBox.getSelectedItem().toString();
		        String workoutType = comboBox_1.getSelectedItem().toString();
		        
		        // Outputs for the 'Legs' Muscle group

		        if (muscleGroup.equals("Legs") && workoutType.equals("Hack Squats")) {
		        	StyledDocument doc = textPane.getStyledDocument();
		            SimpleAttributeSet center = new SimpleAttributeSet();
		            StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		            StyleConstants.setBold(center, true);
		            doc.setParagraphAttributes(0, doc.getLength(), center, false);
		            textPane.setText("\n\n 3 sets of 8-12 reps");
		        } 
		        else if (muscleGroup.equals("Legs") && workoutType.equals("Leg Extension")) {
		        	StyledDocument doc = textPane.getStyledDocument();
		            SimpleAttributeSet center = new SimpleAttributeSet();
		            StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		            StyleConstants.setBold(center, true);
		            doc.setParagraphAttributes(0, doc.getLength(), center, false);
		            textPane.setText("\n\n 3 sets of 10-12 reps");	
		        }
		        else if (muscleGroup.equals("Legs") && workoutType.equals("Hamstrings")) {
		        	StyledDocument doc = textPane.getStyledDocument();
		            SimpleAttributeSet center = new SimpleAttributeSet();
		            StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		            StyleConstants.setBold(center, true);
		            doc.setParagraphAttributes(0, doc.getLength(), center, false);
		            textPane.setText("\n\n 3 sets of 6-12 reps");	
		        }
		        
		        // Outputs for the 'Arms' Muscle Group
		        
		        else if (muscleGroup.equals("Arms") && workoutType.equals("Hammer curls with rope-biceps")) {
		        	StyledDocument doc = textPane.getStyledDocument();
		            SimpleAttributeSet center = new SimpleAttributeSet();
		            StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		            StyleConstants.setBold(center, true);
		            doc.setParagraphAttributes(0, doc.getLength(), center, false);
		            textPane.setText("\n\n 3 sets of 8-12 reps");	
		        } 
		        else if (muscleGroup.equals("Arms") && workoutType.equals("Preacher curls-biceps")) {
		        	StyledDocument doc = textPane.getStyledDocument();
		            SimpleAttributeSet center = new SimpleAttributeSet();
		            StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		            StyleConstants.setBold(center, true);
		            doc.setParagraphAttributes(0, doc.getLength(), center, false);
		            textPane.setText("\n\n 3 sets of 8-10 reps");		
		        }
		        else if (muscleGroup.equals("Arms") && workoutType.equals("Incline curls-biceps")) {
		        	StyledDocument doc = textPane.getStyledDocument();
		            SimpleAttributeSet center = new SimpleAttributeSet();
		            StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		            StyleConstants.setBold(center, true);
		            doc.setParagraphAttributes(0, doc.getLength(), center, false);
		            textPane.setText("\n\n 3 sets of 8-12 reps");		
		        }
		        else if (muscleGroup.equals("Arms") && workoutType.equals("Tricep extensions-tricep")) {
		        	StyledDocument doc = textPane.getStyledDocument();
		            SimpleAttributeSet center = new SimpleAttributeSet();
		            StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		            StyleConstants.setBold(center, true);
		            doc.setParagraphAttributes(0, doc.getLength(), center, false);
		            textPane.setText("\n\n 3 sets of 8-14 reps");		
		        }
		        else if (muscleGroup.equals("Arms") && workoutType.equals("Dips-tricep")) {
		        	StyledDocument doc = textPane.getStyledDocument();
		            SimpleAttributeSet center = new SimpleAttributeSet();
		            StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		            StyleConstants.setBold(center, true);
		            doc.setParagraphAttributes(0, doc.getLength(), center, false);
		            textPane.setText("\n\n 3 sets of 6-12 reps");		
		        }
		        
		        // Outputs for the 'Chest' Muscle Group
		        
		        else if (muscleGroup.equals("Chest") && workoutType.equals("Incline dumbell")) {
		        	StyledDocument doc = textPane.getStyledDocument();
		            SimpleAttributeSet center = new SimpleAttributeSet();
		            StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		            StyleConstants.setBold(center, true);
		            doc.setParagraphAttributes(0, doc.getLength(), center, false);
		            textPane.setText("\n\n 3 sets of 8-12 reps");	
		        }
		        else if (muscleGroup.equals("Chest") && workoutType.equals("Pectoral flys")) {
		        	StyledDocument doc = textPane.getStyledDocument();
		            SimpleAttributeSet center = new SimpleAttributeSet();
		            StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		            StyleConstants.setBold(center, true);
		            doc.setParagraphAttributes(0, doc.getLength(), center, false);
		            textPane.setText("\n\n 3 sets of 6-12 reps");	
		        }
		        else if (muscleGroup.equals("Chest") && workoutType.equals("Cable chest flys")) {
		        	StyledDocument doc = textPane.getStyledDocument();
		            SimpleAttributeSet center = new SimpleAttributeSet();
		            StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		            StyleConstants.setBold(center, true);
		            doc.setParagraphAttributes(0, doc.getLength(), center, false);
		            textPane.setText("\n\n 3 sets of 8-10 reps");	
		        }
		        
		        // Outputs for the 'Back' Muscle Group
		        
		        else if (muscleGroup.equals("Back") && workoutType.equals("Lat pulldowns")) {
		        	StyledDocument doc = textPane.getStyledDocument();
		            SimpleAttributeSet center = new SimpleAttributeSet();
		            StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		            StyleConstants.setBold(center, true);
		            doc.setParagraphAttributes(0, doc.getLength(), center, false);
		            textPane.setText("\n\n 3 sets of 8-12 reps");		
		        }
		        else if (muscleGroup.equals("Back") && workoutType.equals("T-bar")) {
		        	StyledDocument doc = textPane.getStyledDocument();
		            SimpleAttributeSet center = new SimpleAttributeSet();
		            StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		            StyleConstants.setBold(center, true);
		            doc.setParagraphAttributes(0, doc.getLength(), center, false);
		            textPane.setText("\n\n 3 sets of 8-10 reps");		
		        }
		        else if(muscleGroup.equals("Back") && workoutType.equals("Cable rows")) {
		        	StyledDocument doc = textPane.getStyledDocument();
		            SimpleAttributeSet center = new SimpleAttributeSet();
		            StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		            StyleConstants.setBold(center, true);
		            doc.setParagraphAttributes(0, doc.getLength(), center, false);
		            textPane.setText("\n\n 3 sets of 6-12 reps");		
		        }
		        
		        else {
		            JOptionPane.showMessageDialog(frame, "Please select a valid Muscle Group and Workout Type.");
		        }
		    }
		});
		btnNewButton_1.setBounds(148, 297, 117, 29);
		frame.getContentPane().add(btnNewButton_1);
		
		comboBox.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Clear the text pane when the combo box selection changes
		        textPane.setText("");
		    }
		});

		comboBox_1.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Clear the text pane when the combo box selection changes
		        textPane.setText("");
		    }
		});



		btnNewButton_1.setToolTipText("Generates Routine");
		btnNewButton_1.setBounds(138, 155, 156, 29);
		frame.getContentPane().add(btnNewButton_1);
	}
}
