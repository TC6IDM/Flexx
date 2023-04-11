package Timi;


import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import otherUtil.*;

public class water {

	public JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private String textFieldValue = "";
	private JLabel lblNewLabel_2;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Flexx.main(args);
				} 
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @return 
	 */
	public water() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("WATER");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(171, 6, 81, 16);
		frame.getContentPane().add(lblNewLabel);
		frame.getContentPane().setBackground(new Color(77, 77, 77));


		JButton btnNewButton = new JButton("BACK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Page5 p5 = new Page5();
				p5.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnNewButton.setBounds(0, 1, 89, 29);
		frame.getContentPane().add(btnNewButton);


		textField_1 = new JTextField();
		textField_1.setBounds(41, 105, 130, 26);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(41, 157, 130, 26);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(41, 214, 130, 26);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setBounds(41, 57, 130, 26);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);

		textField_5 = new JTextField();
		textField_5.setBounds(220, 105, 130, 26);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);

		textField_6 = new JTextField();
		textField_6.setBounds(220, 157, 130, 26);
		frame.getContentPane().add(textField_6);
		textField_6.setColumns(10);

		textField_7 = new JTextField();
		textField_7.setBounds(220, 57, 130, 26);
		frame.getContentPane().add(textField_7);
		textField_7.setColumns(10);

		JButton btnNewButton_1 = new JButton("Save");
		lblNewLabel_2 = new JLabel("---litres");
		lblNewLabel_2.setForeground(Color.ORANGE);
		lblNewLabel_2.setBounds(289, 219, 61, 16);
		frame.getContentPane().add(lblNewLabel_2);
		btnNewButton_1.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        try {
		            // Establish a connection to the database
		            Connection con = DriverManager.getConnection(JDBC.databaseURL, JDBC.user, JDBC.password);

		            // Create a table to store the data
		            String insertSql = "INSERT INTO WATER (litres) VALUES (?)";
		            PreparedStatement pstmt = con.prepareStatement(insertSql);
		            Component[] components = frame.getContentPane().getComponents();
		            boolean dataInserted = false;
		            int totalCalories = 0; // Initialize totalCalories to 0
		            for (Component component : components) {
		                if (component instanceof JTextField) {
		                    String calories = ((JTextField) component).getText();
		                    if (!calories.isEmpty()) { // Check if the input field is empty
		                        pstmt.setString(1, calories);
		                        int rows = pstmt.executeUpdate();
		                        if (rows > 0) {
		                            dataInserted = true;
		                            totalCalories += Integer.parseInt(calories); // Add the calories to the totalCalories
		                        }
		                    }
		                }
		            }

		            // Set the label text to the sum of all input data
		            if (totalCalories == 0) {
		                lblNewLabel_2.setText("---litres"); // If there is no input, set the label text to "---cal"
		            } else {
		                lblNewLabel_2.setText(totalCalories + " litres");
		            }

		            // Close the connection
		            pstmt.close();
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
	
		btnNewButton_1.setBounds(384, 237, 60, 29);
		frame.getContentPane().add(btnNewButton_1);

		JLabel lblNewLabel_1 = new JLabel("Total Cal:");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(220, 219, 61, 16);
		frame.getContentPane().add(lblNewLabel_1);
		

		// Add document listeners to the text fields to update their values
		// whenever the user types in them

		textField_1.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				updateTextField_1Value();
			}
			public void removeUpdate(DocumentEvent e) {
				updateTextField_1Value();
			}
			public void insertUpdate(DocumentEvent e) {
				updateTextField_1Value();
			}
		});
		textField_2.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				updateTextField_2Value();
			}
			public void removeUpdate(DocumentEvent e) {
				updateTextField_2Value();
			}
			public void insertUpdate(DocumentEvent e) {
				updateTextField_2Value();
			}
		});
		textField_3.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				updateTextField_3Value();
			}
			public void removeUpdate(DocumentEvent e) {
				updateTextField_3Value();
			}
			public void insertUpdate(DocumentEvent e) {
				updateTextField_3Value();
			}
		});
		textField_4.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				updateTextField_4Value();
			}
			public void removeUpdate(DocumentEvent e) {
				updateTextField_4Value();
			}
			public void insertUpdate(DocumentEvent e) {
				updateTextField_4Value();
			}
		});
		textField_5.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				updateTextField_5Value();
			}
			public void removeUpdate(DocumentEvent e) {
				updateTextField_5Value();
			}
			public void insertUpdate(DocumentEvent e) {
				updateTextField_5Value();
			}
		});
		textField_6.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				updateTextField_6Value();
			}
			public void removeUpdate(DocumentEvent e) {
				updateTextField_6Value();
			}
			public void insertUpdate(DocumentEvent e) {
				updateTextField_6Value();
			}
		}
				);
		textField_7.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				updateTextField_7Value();
			}
			public void removeUpdate(DocumentEvent e) {
				updateTextField_7Value();
			}
			public void insertUpdate(DocumentEvent e) {
				updateTextField_7Value();
			}
		}
				);

	}



	private void updateTextField_1Value() {
		textFieldValue = textField_1.getText();
	}
	private void updateTextField_2Value() {
		textFieldValue = textField_2.getText();
	}
	private void updateTextField_3Value() {
		textFieldValue = textField_3.getText();
	}
	private void updateTextField_4Value() {
		textFieldValue = textField_4.getText();
	}
	private void updateTextField_5Value() {
		textFieldValue = textField_5.getText();
	}
	private void updateTextField_6Value() {
		textFieldValue = textField_6.getText();
	}
	private void updateTextField_7Value() {
		textFieldValue = textField_7.getText();
	}

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}
}
