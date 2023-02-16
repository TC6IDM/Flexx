package Package1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JCheckBox;
import java.awt.Checkbox;
import javax.swing.JComboBox;
import java.awt.List;
import javax.swing.JEditorPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JToolBar;

public class Page4 {

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
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
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
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setValue(50);
		progressBar.setStringPainted(true);
		progressBar.setBounds(166, 227, 146, 20);
		frame.getContentPane().add(progressBar);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Goal #1");
		chckbxNewCheckBox.setSelected(true);
		chckbxNewCheckBox.setBounds(38, 120, 106, 23);
		frame.getContentPane().add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Goal #2");
		chckbxNewCheckBox_1.setSelected(true);
		chckbxNewCheckBox_1.setBounds(166, 120, 128, 23);
		frame.getContentPane().add(chckbxNewCheckBox_1);
		
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("Goal #3");
		chckbxNewCheckBox_2.setSelected(true);
		chckbxNewCheckBox_2.setBounds(295, 120, 128, 23);
		frame.getContentPane().add(chckbxNewCheckBox_2);
		
		JCheckBox chckbxNewCheckBox_3 = new JCheckBox("Goal #4");
		chckbxNewCheckBox_3.setBounds(38, 166, 128, 23);
		frame.getContentPane().add(chckbxNewCheckBox_3);
		
		JCheckBox chckbxNewCheckBox_4 = new JCheckBox("Goal #5");
		chckbxNewCheckBox_4.setBounds(166, 166, 128, 23);
		frame.getContentPane().add(chckbxNewCheckBox_4);
		
		JCheckBox chckbxNewCheckBox_5 = new JCheckBox("Goal #6");
		chckbxNewCheckBox_5.setBounds(295, 166, 128, 23);
		frame.getContentPane().add(chckbxNewCheckBox_5);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Add goal", "Edit goal", "Delete goal"}));
		comboBox.setBounds(219, 57, 52, 27);
		frame.getContentPane().add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("Menu:");
		lblNewLabel_1.setBounds(171, 61, 61, 16);
		frame.getContentPane().add(lblNewLabel_1);
	}
}
