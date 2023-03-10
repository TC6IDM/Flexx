package Package1;

import javax.swing.*;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Page4 {

    public JFrame frame;
    private JTextField goal1TextField;
    private boolean isEditSelected = false;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Page4 window = new Page4();
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
    public Page4() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(207, 225, 235));
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        //Create progress tracker
        JLabel lblNewLabel = new JLabel("Progress Tracker");
        lblNewLabel.setBounds(140, 10, 187, 35);
        lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 23));
        frame.getContentPane().add(lblNewLabel);

        JButton btnNewButton = new JButton("Back");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Home home = new Home();
                home.frame.setVisible(true);
                frame.setVisible(false);
            }
        });
        btnNewButton.setBounds(10, 10, 77, 35);
        frame.getContentPane().add(btnNewButton);

        //Create progress bar
        JProgressBar progressBar = new JProgressBar();
        progressBar.setValue(0);
        progressBar.setStringPainted(true);
        progressBar.setBounds(160, 89, 146, 20);
        frame.getContentPane().add(progressBar);

        //Add button to implement new goals and add checkboxes alongside
        JButton btnNewButton_1 = new JButton("Add");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int lastTextFieldY = 122;
                Component[] components = frame.getContentPane().getComponents();
                for (Component component : components) {
                    if (component instanceof JTextField) {
                        lastTextFieldY = component.getY();
                    }
                }
        	    JTextField newGoal = new JTextField();
        	    newGoal.setBounds(170, lastTextFieldY + 30, 134, 20);
        	    newGoal.setEnabled(true);
        	    List<String> goals = new ArrayList<>();
                Component[] components1 = frame.getContentPane().getComponents();
                for (Component component : components1) {
                    if (component instanceof JTextField) {
                        JTextField textField = (JTextField) component;
                        String goal = textField.getText().trim();
                        if (!goal.isEmpty()) {
                            goals.add(goal);
                        }
                    }
                }
                //once clicked off textbox it locks
        	    newGoal.addFocusListener(new FocusAdapter() {
        	        @Override
        	        public void focusLost(FocusEvent e) {
        	            newGoal.setEnabled(false);
        	        }
        	    });
        	    frame.getContentPane().add(newGoal);

        	    JCheckBox newCheckBox = new JCheckBox("");
        	    newCheckBox.setSelected(false);
        	    newCheckBox.setBounds(130, lastTextFieldY + 30, 28, 20);
        	    newCheckBox.addItemListener(new ItemListener() {
        	        @Override
        	        public void itemStateChanged(ItemEvent e) {
        	            updateProgressBar(progressBar);
        	        }
        	    });
        	    frame.getContentPane().add(newCheckBox);

        	    updateProgressBar(progressBar);

        	    frame.validate();
        	    frame.repaint();
        	}

        });
        btnNewButton_1.setBackground(new Color(238, 238, 238));
        btnNewButton_1.setEnabled(false);
        btnNewButton_1.setBounds(162, 117, 54, 16);
        btnNewButton_1.setEnabled(true);
        frame.getContentPane().add(btnNewButton_1);
        
       // Delete button where you are able to select goals to delete
        JButton btnNewButton_1_1 = new JButton("Delete");
        btnNewButton_1_1.setBackground(SystemColor.window);
        btnNewButton_1_1.setBounds(252, 117, 54, 16);
        btnNewButton_1_1.setEnabled(false);
        frame.getContentPane().add(btnNewButton_1_1);

        //getting components to delete when checkboxes are selected
        btnNewButton_1_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Component[] components = frame.getContentPane().getComponents();
                List<Component> componentsToRemove = new ArrayList<>();
                for (Component component : components) {
                    if (component instanceof JCheckBox && ((JCheckBox) component).isSelected()) {
                        Component[] componentsAbove = Arrays.copyOfRange(components, 0, Arrays.asList(components).indexOf(component));
                        List<Component> correspondingTextFields = Arrays.stream(componentsAbove)
                                .filter(c -> c instanceof JTextField)
                                .filter(c -> c.getY() == component.getY())
                                .collect(Collectors.toList());
                        componentsToRemove.addAll(correspondingTextFields);
                        componentsToRemove.add(component);
                    }
                }
                componentsToRemove.forEach(component -> frame.getContentPane().remove(component));
                updateProgressBar(progressBar);
                frame.validate();
                frame.repaint();
            }
        });

        //Combo box with all features
        JComboBox<String> comboBox = new JComboBox<String>();
        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	//If statements to enable the feature selected
                String selectedOption = (String) comboBox.getSelectedItem();
                if (selectedOption.equals("Add goal")) {
                    btnNewButton_1.setEnabled(true);
                } else {
                    btnNewButton_1.setEnabled(false);
                }
                if (selectedOption.equals("Delete goal")) {
                	btnNewButton_1_1.setEnabled(true);
                } else {
                	btnNewButton_1_1.setEnabled(false);
                }
                // Goals become editable
                if (selectedOption.equals("Edit goal")) {
                    isEditSelected = true;
                } else {
                    isEditSelected = false;
                }
                
             
                for (Component comp : frame.getContentPane().getComponents()) {
                    if (comp instanceof JTextField && comp != goal1TextField) {
                        comp.setEnabled(isEditSelected);
                    }
                }
            }
        });

        comboBox.setModel(new DefaultComboBoxModel(new String[] {"Add goal", "Edit goal", "Delete goal"}));
        comboBox.setBounds(206, 57, 106, 27);
        frame.getContentPane().add(comboBox);

        //Menu label
        JLabel lblNewLabel_1 = new JLabel("Menu:");
        lblNewLabel_1.setBounds(163, 61, 61, 16);
        frame.getContentPane().add(lblNewLabel_1);
        
        //Button to save all goals which should be saved into database, had a few issues with that
        JButton btnNewButton_2 = new JButton("Save");
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    // Establish a connection to the database
                    Connection con = DriverManager.getConnection(JDBC.databaseURL, JDBC.user, JDBC.password);

                    // Create a table to store the data
            		String query = "INSERT INTO goals (goal) VALUES ('" + goal1TextField + "')";

                    Statement stmt = con.createStatement();
                    stmt.executeUpdate(query);

                    // Insert the data into the table
                    String insertSql = "INSERT INTO goals (goal) VALUES (?)";
                    PreparedStatement pstmt = con.prepareStatement(insertSql);
                    Component[] components = frame.getContentPane().getComponents();
                    boolean dataInserted = false;
                    for (Component component : components) {
                        if (component instanceof JTextField) {
                            String goal = ((JTextField) component).getText();
                            pstmt.setString(1, goal);
                            int rows = pstmt.executeUpdate();
                            if (rows > 0) {
                                dataInserted = true;
                            }
                        }
                    }

                    // Close the connection
                    pstmt.close();
                    stmt.close();
                    con.close();

                    // Show a message to indicate whether the data has been saved
                    if (dataInserted) {
                        JOptionPane.showMessageDialog(frame, "Data has been saved to the database.");
                    } else {
                        JOptionPane.showMessageDialog(frame, "No data was inserted into the database.");
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage());
                }
            }
        });
        btnNewButton_2.setBounds(396, 243, 54, 29);
        frame.getContentPane().add(btnNewButton_2);
   
     
   
    }
   
//	Method to update progress bar as checkboxes are selected true
    private void updateProgressBar(JProgressBar progressBar) {
        Component[] components = frame.getContentPane().getComponents();
        int totalGoals = 0;
        int completedGoals = 0;
        for (Component component : components) {
            if (component instanceof JCheckBox) {
                totalGoals++;
                if (((JCheckBox) component).isSelected()) {
                    completedGoals++;
                }
            }
        }
        int percentage = 0;
        if (totalGoals > 0) {
            percentage = (int) (((double) completedGoals / totalGoals) * 100);
        }
        progressBar.setValue(percentage);
    }
    
    
}



