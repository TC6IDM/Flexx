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
	public Home() {
		initialize();
	}


	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */

	private void initialize() {	
		
	    frame = new JFrame();
	    frame.getContentPane().setBackground(new Color(77, 77, 77));
	    frame.setBounds(100, 100, 456, 313);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.getContentPane().setLayout(null);
	    
	    GridBagLayout gridBagLayout = new GridBagLayout();
        frame.getContentPane().setLayout(gridBagLayout);
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5, 5, 5, 5);
	    
	    JLabel lblNewLabel = new JLabel("");
	    Image img = new ImageIcon(this.getClass().getResource("/Flexx_icon.png")).getImage();
	    lblNewLabel.setIcon(new ImageIcon(img));
	    lblNewLabel.setBounds(5, 5, 50, 50);
	    frame.getContentPane().add(lblNewLabel);
	    
	   
	    
	    JLabel homeLabel = new JLabel(Login.USERID);
	    homeLabel.setFont(new Font("Helvetica", Font.BOLD, 15));
	    homeLabel.setForeground(Color.WHITE);
	    homeLabel.setHorizontalAlignment(SwingConstants.CENTER);
	    homeLabel.setVerticalAlignment(SwingConstants.CENTER);
	    homeLabel.setOpaque(true);
	    homeLabel.setBackground(new Color(0x2B579A)); 
	    gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 0;
        frame.getContentPane().add(homeLabel, gbc);
	    
	    
	    

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
	    gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        frame.getContentPane().add(personalizedWorkoutButton, gbc);

		
		JButton Page2Button = new JButton("Page2");
		//Page2Button.setForeground(new Color(255, 255, 255));
		Page2Button.setBackground(new Color(77, 77, 77));
	    Page2Button.setPreferredSize(new Dimension(100, 25)); // Set preferred size
		Page2Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Page2 page2 = new Page2();
				page2.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		 gbc.gridx = 2;
		 gbc.gridy = 1;
		 gbc.gridwidth = 1;
		 gbc.gridheight = 1;
		 gbc.weightx = 1;
		 gbc.weighty = 0;
		 frame.getContentPane().add(Page2Button, gbc);
		
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
	    gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        frame.getContentPane().add(trackWorkoutButton, gbc);
        
        
        
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
	    gbc.gridx = 1;
	    gbc.gridy = 2;
	    gbc.gridwidth = 1;
	    gbc.gridheight = 1;
	    gbc.weightx = 1;
	    gbc.weighty = 1;
	    frame.getContentPane().add(progressTrackerButton, gbc);

	    JButton foodTrackerButton = new JButton("Food Tracker");
	    //foodTrackerButton.setForeground(Color.WHITE);
	    foodTrackerButton.setBackground(new Color(0, 122, 255));
	    foodTrackerButton.setFont(new Font("San Francisco", Font.PLAIN, 14));
	    foodTrackerButton.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            Page5 page5 = new Page5();
	            page5.frame.setVisible(true);
	            frame.setVisible(false);
	        }
	    });
	    gbc.gridx = 0;
	    gbc.gridy = 2;
	    gbc.gridwidth = 1;
	    gbc.gridheight = 1;
	    gbc.weightx = 1;
	    gbc.weighty = 1;
	    frame.getContentPane().add(foodTrackerButton, gbc);
	    
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
		 gbc.gridx = 2;
		 gbc.gridy = 0;
		 gbc.gridwidth = 1;
		 gbc.gridheight = 1;
		 gbc.weightx = 1;
		 gbc.weighty = 0;
	    frame.getContentPane().add(loginButton, gbc);
	    
	    JLabel usernameLabel = new JLabel("Home");
	    usernameLabel.setFont(new Font("Helvetica", Font.BOLD, 30));
	    usernameLabel.setForeground(Color.WHITE); // Change the color of the HOME font to white
	    usernameLabel.setHorizontalAlignment(SwingConstants.CENTER);
	    usernameLabel.setVerticalAlignment(SwingConstants.CENTER);
	    usernameLabel.setOpaque(true);
	    usernameLabel.setBackground(new Color(0x2B579A)); 
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
