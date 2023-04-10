package Ava;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import Andrew.*;
import Elyse.*;
import Gurkirat.*;
import Timi.*;
import otherUtil.*;

public class Home {

	public JFrame frame; // Declare a JFrame instance
	
	// Main method that creates and runs the application 
	public static void main(String[] args) {
		

	    EventQueue.invokeLater(new Runnable() {
	        public void run() {
	            try {
	                Flexx.main(args); // Starts the application 
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
			}
		});
	}

	// Constructor that initializes the GUI
	public Home() {
		initialize();
	}


    // Method that initializes the GUI components
	private void initialize() {	
		
	    frame = new JFrame(); // Create a new JFrame instance
	    frame.getContentPane().setBackground(new Color(77, 77, 77));
	    frame.setBounds(100, 100, 456, 313); // Set the bounds of the frame
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.getContentPane().setLayout(null);
	    
        // Create a new GridBagLayout instance for the frame
	    GridBagLayout gridBagLayout = new GridBagLayout();
        frame.getContentPane().setLayout(gridBagLayout);
        
        // Create a new GridBagConstraints instance for the layout
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5, 5, 5, 5); // Set the insets for the layout
	    
	    JLabel lblNewLabel = new JLabel(""); // Create a new JLabel instance
	    Image img = new ImageIcon(this.getClass().getResource("/Flexx_icon.png")).getImage();
	    lblNewLabel.setIcon(new ImageIcon(img));
	    lblNewLabel.setBounds(5, 5, 50, 50);
	    frame.getContentPane().add(lblNewLabel);
	    
	   
	    // Create a new JLabel instance with the user ID
	    JLabel homeLabel = new JLabel(Login.USERID);
	    homeLabel.setFont(new Font("Helvetica", Font.BOLD, 15));
	    homeLabel.setForeground(Color.WHITE);
	    homeLabel.setHorizontalAlignment(SwingConstants.CENTER);
	    homeLabel.setVerticalAlignment(SwingConstants.CENTER);
	    homeLabel.setOpaque(true);
	    homeLabel.setBackground(new Color(0x2B579A)); 
	    // Set positions of grid
	    gbc.gridx = 1; 
        gbc.gridy = 0; 
        gbc.gridwidth = 1; 
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 0;
        frame.getContentPane().add(homeLabel, gbc);
	    
        // Create a new button for the personalized workout page
	    JButton personalizedWorkoutButton = new JButton("Personalized Workout");
	    personalizedWorkoutButton.setBackground(new Color(0, 122, 255));
	    personalizedWorkoutButton.setFont(new Font("San Francisco", Font.PLAIN, 14));
	    personalizedWorkoutButton.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            Page1 page1 = new Page1();
	            page1.frame.setVisible(true);
	            frame.setVisible(false);
	        }
	    });
	    // Set positions of grid
	    gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        frame.getContentPane().add(personalizedWorkoutButton, gbc);

        // Create a new button for the workout graphs page
		JButton Page2Button = new JButton("Workout Graphs");
		//Page2Button.setForeground(new Color(255, 255, 255));
		Page2Button.setBackground(new Color(77, 77, 77));
	    Page2Button.setPreferredSize(new Dimension(100, 25)); // Set preferred size
		Page2Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Page3 page2 = new Page3();
				page2.frame.setVisible(true);
				frame.setVisible(false); // Hide the Home frame
			}
		});
	    // Set positions of grid
		 gbc.gridx = 2;
		 gbc.gridy = 1;
		 gbc.gridwidth = 1;
		 gbc.gridheight = 1;
		 gbc.weightx = 1;
		 gbc.weighty = 0;
		 frame.getContentPane().add(Page2Button, gbc);
		
		// Create a new button for the track workout page
	    JButton trackWorkoutButton = new JButton("Track Workout");
	    trackWorkoutButton.setBackground(new Color(0, 122, 255));
	    trackWorkoutButton.setFont(new Font("San Francisco", Font.PLAIN, 14));
	    trackWorkoutButton.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            Page3 page3 = new Page3();
	            page3.frame.setVisible(true);
	            frame.setVisible(false);
	        }
	    });
	    // Set positions of grid
	    gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        frame.getContentPane().add(trackWorkoutButton, gbc);
        
        // Create a new button for the progress tracker page
	    JButton progressTrackerButton = new JButton("Progress Tracker");
	    progressTrackerButton.setBackground(new Color(0, 122, 255));
	    progressTrackerButton.setFont(new Font("San Francisco", Font.PLAIN, 14));
	    progressTrackerButton.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            Page4 page4 = new Page4();
	            page4.frame.setVisible(true);
	            frame.setVisible(false);
	        }
	    });
	    // Set positions of grid
	    gbc.gridx = 1;
	    gbc.gridy = 2;
	    gbc.gridwidth = 1;
	    gbc.gridheight = 1;
	    gbc.weightx = 1;
	    gbc.weighty = 1;
	    frame.getContentPane().add(progressTrackerButton, gbc);

	    // Create a new button for the food tracker page
	    JButton foodTrackerButton = new JButton("Food Tracker");
	    foodTrackerButton.setBackground(new Color(0, 122, 255));
	    foodTrackerButton.setFont(new Font("San Francisco", Font.PLAIN, 14));
	    foodTrackerButton.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            Page5 page5 = new Page5();
	            page5.frame.setVisible(true);
	            frame.setVisible(false);
	        }
	    });
	    // Set positions of grid
	    gbc.gridx = 0;
	    gbc.gridy = 2;
	    gbc.gridwidth = 1;
	    gbc.gridheight = 1;
	    gbc.weightx = 1;
	    gbc.weighty = 1;
	    frame.getContentPane().add(foodTrackerButton, gbc);
	    
	    // Create a new button for logging out
	    JButton loginButton = new JButton("logout");
	    loginButton.setBackground(new Color(255, 74, 74));
	    loginButton.setPreferredSize(new Dimension(100, 25)); // Set preferred size
	    loginButton.setFont(new Font("San Francisco", Font.PLAIN, 14));
	    loginButton.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            Login login = new Login();
	            login.frame.setVisible(true);
	            frame.setVisible(false);
	        }
	    });
	    // Set positions of grid
		 gbc.gridx = 2;
		 gbc.gridy = 0;
		 gbc.gridwidth = 1;
		 gbc.gridheight = 1;
		 gbc.weightx = 1;
		 gbc.weighty = 0;
	    frame.getContentPane().add(loginButton, gbc);
	    
	    // Create a label for the home page
	    JLabel usernameLabel = new JLabel("Home");
	    usernameLabel.setFont(new Font("Helvetica", Font.BOLD, 30));
	    usernameLabel.setForeground(Color.WHITE); // Change the color of the HOME font to white
	    usernameLabel.setHorizontalAlignment(SwingConstants.CENTER);
	    usernameLabel.setVerticalAlignment(SwingConstants.CENTER);
	    usernameLabel.setOpaque(true);
	    usernameLabel.setBackground(new Color(0x2B579A)); 
	    // Set positions of grid
	    gbc.gridx = 0;
	    gbc.gridy = 4;
	    gbc.gridwidth = 2;
	    gbc.gridheight = 1;
	    gbc.weightx = 1;
	    gbc.weighty = 1;
	    frame.getContentPane().add(usernameLabel, gbc);

	    frame.pack();
		
	}
}
