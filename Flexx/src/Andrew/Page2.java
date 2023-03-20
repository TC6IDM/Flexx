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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import Ava.*;
import otherUtil.Flexx;
import otherUtil.JDBC;

import java.awt.Color;
import javax.swing.SwingConstants;

public class Page2 {

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
		        //creates a pop up confirmation for going back to the home page
				int option = JOptionPane.showConfirmDialog(frame, "Are you sure you would like to go back? This Current Workout will be Lost...", "Cancel?", JOptionPane.YES_NO_OPTION);
		        if (option == JOptionPane.YES_OPTION) { //user chooses yes
		        	//go back to home page
		        	Home home = new Home();
					home.frame.setVisible(true);
					frame.setVisible(false);
		        }
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
		
		String exercisesQuery = "SELECT DISTINCT ExerciseName FROM exerciselogs";
		try {
			Connection con = DriverManager.getConnection (JDBC.databaseURL,JDBC.user,JDBC.password);
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(exercisesQuery);
			int i=0;
			while (rs.next()) {
				System.out.println(rs.getString(1));
				i++;
			}
		} catch (SQLException err) {
			err.printStackTrace();
		}
		

	}
}
