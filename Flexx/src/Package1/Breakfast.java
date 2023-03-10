package Package1;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Breakfast {

	public JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Breakfast window = new Breakfast();
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
	public Breakfast() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("BREAKFAST");
		lblNewLabel.setBounds(171, 6, 81, 16);
		frame.getContentPane().add(lblNewLabel);

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

		setTextField(new JTextField());
		getTextField().setBounds(10, 53, 130, 26);
		frame.getContentPane().add(getTextField());
		getTextField().setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(10, 105, 130, 26);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(10, 157, 130, 26);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(10, 214, 130, 26);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_2.getDocument().addDocumentListener(new DocumentListener() {
		    public void insertUpdate1(DocumentEvent e) {
		        String input1 = textField_2.getText();
		        // do something with input1
		    }
		    public void removeUpdate1(DocumentEvent e) {
		        String input1 = textField_2.getText();
		        // do something with input1
		    }
		    public void changedUpdate1(DocumentEvent e) {
		        // not used for plain text fields
		    }
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}
		});

		textField_3.getDocument().addDocumentListener(new DocumentListener() {
		    public void insertUpdate(DocumentEvent e) {
		        String input2 = textField_3.getText();
		        // do something with input2
		    }
		    public void removeUpdate(DocumentEvent e) {
		        String input2 = textField_3.getText();
		        // do something with input2
		    }
		    public void changedUpdate(DocumentEvent e) {
		        // not used for plain text fields
		    }
		});


		textField_4 = new JTextField();
		textField_4.setBounds(171, 53, 130, 26);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);

		textField_5 = new JTextField();
		textField_5.setBounds(171, 105, 130, 26);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);

		textField_6 = new JTextField();
		textField_6.setBounds(171, 157, 130, 26);
		frame.getContentPane().add(textField_6);
		textField_6.setColumns(10);

		textField_7 = new JTextField();
		textField_7.setBounds(171, 214, 130, 26);

		
		
	}

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}
}
