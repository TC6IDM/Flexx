package Andrew;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Dimension;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import Ava.*;
import otherUtil.Flexx;
import otherUtil.JDBC;

import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class Page2 {

	public JFrame frame;
	public ArrayList<Workout> workouts = new ArrayList<Workout>();
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
	public Page2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	private void initialize() {
		//creates the frame
		Page3 page3 = new Page3();
		int Frame_Left = page3.Frame_Left;
		int Frame_Top = page3.Frame_Top;
		int Frame_Width = page3.Frame_Width;
		int Frame_Height = page3.Frame_Height;
		int Frame_ActualWidth = page3.Frame_ActualWidth;
		
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(77, 77, 77));
		frame.setBounds(Frame_Left, Frame_Top, Frame_Width, Frame_Height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setLayout(null);
				
				
				
		//creates the back button
		int buttonWidth = 100;
		int buttonDistanceFromSides = 0;
		int buttonHeight = 50;
		JButton backButton = new JButton("");
		backButton.setHorizontalAlignment(SwingConstants.LEFT);
		backButton.setIcon(new ImageIcon(Page3.class.getResource("/Andrew/x-mark-32.png")));
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home home = new Home();
				home.frame.setVisible(true);
				frame.setVisible(false);
		        
			}
		});
		backButton.setOpaque(false);
		backButton.setContentAreaFilled(false);
		backButton.setBorderPainted(false);
		backButton.setBounds(buttonDistanceFromSides, buttonDistanceFromSides, buttonWidth, buttonHeight);
		frame.getContentPane().add(backButton);
				
		//creates the Track work-out Title
		int topLabelHeight = 50;
		JLabel lblTrackWorkout = new JLabel("Exercise View");
		lblTrackWorkout.setVerticalAlignment(SwingConstants.CENTER);
		lblTrackWorkout.setOpaque(true);
		lblTrackWorkout.setHorizontalAlignment(SwingConstants.CENTER);
		lblTrackWorkout.setForeground(Color.WHITE);
		lblTrackWorkout.setFont(new Font("SansSerif", Font.BOLD, 30));
		lblTrackWorkout.setBackground(new Color(43, 87, 154));
		lblTrackWorkout.setBounds(0, 0, Frame_ActualWidth, topLabelHeight);
		frame.getContentPane().add(lblTrackWorkout);
		
		JSlider slider = new JSlider();
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				System.out.println(slider.getValue());
			}
		});
		slider.setOrientation(SwingConstants.VERTICAL);
		slider.setBounds(29, 117, 51, 185);
		frame.getContentPane().add(slider);
		
		
		String exercisesQuery = "SELECT DISTINCT ExerciseName FROM exerciselogs";
		try {
			Connection con = DriverManager.getConnection (JDBC.databaseURL,JDBC.user,JDBC.password);
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(exercisesQuery);
			while (rs.next()) {
				Workout thisWorkout = new Workout(rs.getString(1));
				String findAllExercisesQuery = "SELECT * FROM exerciselogs HAVING ExerciseName='"+thisWorkout.workoutName+"'";
				System.out.println(thisWorkout.workoutName);
				Connection con2 = DriverManager.getConnection (JDBC.databaseURL,JDBC.user,JDBC.password);
				Statement statement2 = con2.createStatement();
				ResultSet rs2 = statement2.executeQuery(findAllExercisesQuery);
				while (rs2.next()) {
//					System.out.println(rs2.getInt(2)+" "+rs2.getInt(3)+" "+rs2.getInt(4));
					thisWorkout.addDataPoint(rs2.getInt(2),rs2.getInt(3) ,rs2.getInt(4) );
				}
				workouts.add(thisWorkout);
			}
			
			for (int i=0;i<workouts.size();i++) {
				Workout thisWorkout = workouts.get(i);
				JButton btnNewButton = new JButton(thisWorkout.workoutName);
				btnNewButton.setBounds(100, 50+100*i, Frame_ActualWidth-200, 50);
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						GraphPanel.createAndShowGui(thisWorkout.getORMs(),thisWorkout.getxAxis());						
//						System.out.println(thisWorkout.workoutName);
					}
				});
				frame.getContentPane().add(btnNewButton);
				thisWorkout.setButton(btnNewButton);
				
			}
		} catch (SQLException err) {
			err.printStackTrace();
		}
		

	}
}
