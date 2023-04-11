package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Elyse.Page4;
import otherUtil.JDBC;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

class Page4Test {

    private Page4 page4;
	private JFrame frame;
	private JProgressBar progressBar;
	private JButton addButton;
    

    @BeforeEach
    void setUp() {
        page4 = new Page4();
    }

    @Test
    void test1() {
        JDBC.createDB();
        JDBC.createTables();
        String goal = "go on 3 walks this week";
        String testQuery = "INSERT INTO goals (\""+goal+"\") VALUES (?)";

        try {
            Connection con = DriverManager.getConnection(JDBC.databaseURL, JDBC.user, JDBC.password);
            Statement statement = con.createStatement();
            statement.execute(testQuery);
        } catch (SQLException err) {
            err.printStackTrace();
        }

        assertEquals("go on 3 walks this week", goal);
    }

    @Test
    void test2() {
        JDBC.createDB();
        JDBC.createTables();
        String goal = "";
        String testQuery = "INSERT INTO goals (\""+goal+"\") VALUES (?)";

        try {
            Connection con = DriverManager.getConnection(JDBC.databaseURL, JDBC.user, JDBC.password);
            Statement statement = con.createStatement();
            statement.execute(testQuery);
        } catch (SQLException err) {
            //err.printStackTrace();
        }

        assertEquals("", goal);
    }

    @Test
    void test3() {
        JDBC.createDB();
        JDBC.createTables();
        String goal = "__workout 4 times this week_";
        String testQuery = "INSERT INTO goals (\""+goal+"\") VALUES (?)";

        try {
            Connection con = DriverManager.getConnection(JDBC.databaseURL, JDBC.user, JDBC.password);
            Statement statement = con.createStatement();
            statement.execute(testQuery);
        } catch (SQLException err) {
            //err.printStackTrace();
        }

        assertEquals("__workout 4 times this week_", goal);
    }

    
    //Integration testing 
    
    @Test
    void testAddButton() {
        JButton addButton = (JButton) getComponentByName(page4.frame, "Add");
        JComboBox<String> comboBox = (JComboBox<String>) getComponentByName(page4.frame, "Menu");

        assertNotNull(addButton);

        int initialTextFieldCount = countTextFields(page4.frame);
        addButton.doClick();

        int updatedTextFieldCount = countTextFields(page4.frame);
        assertEquals(initialTextFieldCount + 1, updatedTextFieldCount);
    }

   
    @Test
    public void testProgressBarUpdatesCorrectly() {
    	
    	// Initialize the frame and panel
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new BorderLayout());

        // Initialize the progress bar
        progressBar = new JProgressBar();
        frame.add(progressBar);

        // Add checkboxes to the panel
        JCheckBox checkBox1 = new JCheckBox("Goal 1");
        JCheckBox checkBox2 = new JCheckBox("Goal 2");
        JCheckBox checkBox3 = new JCheckBox("Goal 3");
        JCheckBox checkBox4 = new JCheckBox("Goal 4");
        frame.add(checkBox1);
        frame.add(checkBox2);
        frame.add(checkBox3);
        frame.add(checkBox4);
        
        // Set up the initial state of the progress bar and checkboxes
        progressBar.setValue(0);
        setCheckBoxSelected(false, "Goal 1");
        setCheckBoxSelected(false, "Goal 2");
        setCheckBoxSelected(false, "Goal 3");
        setCheckBoxSelected(false, "Goal 4");

        // Test case steps
        setCheckBoxSelected(true, "Goal 1");
        progressBar.setValue(25);
        setCheckBoxSelected(true, "Goal 2");
        progressBar.setValue(50);
        setCheckBoxSelected(true, "Goal 3");
        progressBar.setValue(75);
        setCheckBoxSelected(true, "Goal 4");
        progressBar.setValue(100);
    }

    // Helper method to set checkbox selected status by text
    private void setCheckBoxSelected(boolean selected, String text) {
        Component[] components = frame.getContentPane().getComponents();
        for (Component component : components) {
            if (component instanceof JCheckBox) {
                JCheckBox checkBox = (JCheckBox) component;
                if (checkBox.getText().equals(text)) {
                    checkBox.setSelected(selected);
                    break;
                }
            }
        }
    
    }
    private Component getComponentByName(Container container, String name) {
        for (Component component : container.getComponents()) {
            if (name.equals(component.getName())) {
                return component;
            }
            if (component instanceof Container) {
                Component found = getComponentByName((Container) component, name);
                if (found != null) {
                    return found;
                }
            }
        }
        return null; // return null if component is not found
    }


    private int countTextFields(Container container) {
        return (int) Arrays.stream(container.getComponents())
                .mapToInt(component -> {
                    if (component instanceof JTextField) {
                        return 1;
                    } else if (component instanceof Container) {
                        return countTextFields((Container) component);
                    } else {
                        return 0;
                    }
                }).sum();
    }


    private JTextField getLastTextField(Container container) {
        return (JTextField) Arrays.stream(container.getComponents())
                .filter(component -> component instanceof JTextField)
                .reduce((first, second) -> second)
                .orElse(null);
    }

    private JCheckBox getLastCheckBox(Container container) {
        List<Component> components = Arrays.asList(container.getComponents());
        Collections.reverse(components);
        for (Component component : components) {
            if (component instanceof JCheckBox) {
                return (JCheckBox) component;
            } else if (component instanceof Container) {
                JCheckBox checkBox = getLastCheckBox((Container) component);
                if (checkBox != null) {
                    return checkBox;
                }
            }
        }
        return null;
    }

}


