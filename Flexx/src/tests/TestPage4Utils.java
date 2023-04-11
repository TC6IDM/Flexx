package tests;

import javax.swing.*;

public class TestPage4Utils {

    public static JTextField createGoalTextField(int x, int y) {
        JTextField goalTextField = new JTextField();
        goalTextField.setBounds(x, y, 134, 20);
        return goalTextField;
    }

    public static JCheckBox createGoalCheckBox(int x, int y) {
        JCheckBox goalCheckBox = new JCheckBox("");
        goalCheckBox.setBounds(x, y, 28, 20);
        return goalCheckBox;
    }
}
