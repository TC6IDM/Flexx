package Package1;

import javax.swing.*;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class Page4 {

    public JFrame frame;
    private JTextField goal1TextField;
    private int numGoals = 1;
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
        progressBar.setValue(0);
        progressBar.setStringPainted(true);
        progressBar.setBounds(160, 89, 146, 20);
        frame.getContentPane().add(progressBar);

//        JCheckBox chckbxNewCheckBox = new JCheckBox("");
//        chckbxNewCheckBox.setSelected(false);
//        chckbxNewCheckBox.setBounds(130, 121, 28, 20);
//        frame.getContentPane().add(chckbxNewCheckBox);
////
//        goal1TextField = new JTextField();
//        goal1TextField.setText("Goal #1");
//        goal1TextField.setBounds(170, 121, 134, 20);
//        frame.getContentPane().add(goal1TextField);
//        goal1TextField.setColumns(10);

        JButton btnNewButton_1 = new JButton("Add");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int lastTextFieldY = frame.getContentPane().getComponentCount() > 10 ?
                	frame.getContentPane().getComponent(frame.getContentPane().getComponentCount()-1).getY() : 122;
                JTextField newGoal = new JTextField();
                newGoal.setBounds(170, lastTextFieldY + 30, 134, 20);
                newGoal.setEnabled(isEditSelected);
                frame.getContentPane().add(newGoal);
                frame.validate();
                frame.repaint();
                
                JCheckBox newCheckBox = new JCheckBox("");
                newCheckBox.setSelected(false);
                newCheckBox.setBounds(130, lastTextFieldY + 30, 28, 20);
                frame.getContentPane().add(newCheckBox);
                
                frame.validate();
                frame.repaint();
            }
        });
        btnNewButton_1.setBackground(new Color(238, 238, 238));
        btnNewButton_1.setEnabled(false);
        btnNewButton_1.setBounds(162, 117, 54, 16);
        btnNewButton_1.setEnabled(true);
        frame.getContentPane().add(btnNewButton_1);
        
        JButton btnNewButton_1_1 = new JButton("Delete");
        btnNewButton_1_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnNewButton_1_1.setBackground(SystemColor.window);
        btnNewButton_1_1.setBounds(223, 117, 54, 16);
        frame.getContentPane().add(btnNewButton_1_1);

        JComboBox<String> comboBox = new JComboBox<String>();
        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
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

                if (selectedOption.equals("Edit goal")) {
                    goal1TextField.setEnabled(true);
                    isEditSelected = true;
                } else {
                    goal1TextField.setEnabled(false);
                    isEditSelected = false;
                }
                
                // Disable all text fields except the first one
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

        JLabel lblNewLabel_1 = new JLabel("Menu:");
        lblNewLabel_1.setBounds(163, 61, 61, 16);
        frame.getContentPane().add(lblNewLabel_1);
    }
}
