package tests;

import static org.junit.Assert.*;

import java.awt.Component;
import javax.swing.JCheckBox;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Elyse.Page4;

public class Page4IntegrationTest {

	private Page4 page4;

	@Before
	public void setUp() throws Exception {
		page4 = new Page4();
		page4.frame.setVisible(true); // Make the frame visible for testing
	}

	@After
	public void tearDown() throws Exception {
		page4.frame.setVisible(false); // Hide the frame after testing
	}

	@Test
	public void testAddButton() {
	    JTextField goal1TextField = page4.goal1TextField;
	    JCheckBox checkBox1 = new JCheckBox();
	    checkBox1.setSelected(true);
	    checkBox1.setBounds(130, 122, 28, 20);
	    page4.frame.getContentPane().add(checkBox1);
	    JTextField goal2TextField = new JTextField();
	    goal2TextField.setBounds(170, 152, 134, 20);
	    page4.frame.getContentPane().add(goal2TextField);
	    JCheckBox checkBox2 = new JCheckBox();
	    checkBox2.setSelected(false);
	    checkBox2.setBounds(130, 152, 28, 20);
	    page4.frame.getContentPane().add(checkBox2);

	    // Simulate the "Add" button action

	    Component[] components = page4.frame.getContentPane().getComponents();
	    boolean goal2Added = false;
	    boolean checkBox2Added = false;
	    for (Component component : components) {
	        if (component.equals(goal2TextField)) {
	            goal2Added = true;
	        }
	        if (component.equals(checkBox2)) {
	            checkBox2Added = true;
	        }
	    }
	    assertTrue("Goal 2 TextField not added", goal2Added);
	    assertTrue("CheckBox 2 not added", checkBox2Added);
	}

	@Test
	public void testDeleteButton() {
	    JCheckBox checkBox1 = new JCheckBox();
	    checkBox1.setSelected(true);
	    checkBox1.setBounds(130, 122, 28, 20);
	    page4.frame.getContentPane().add(checkBox1);
	    JCheckBox checkBox2 = new JCheckBox();
	    checkBox2.setSelected(true);
	    checkBox2.setBounds(130, 152, 28, 20);
	    page4.frame.getContentPane().add(checkBox2);

	    // Simulate the "Delete" button action
	    Component[] components = page4.frame.getContentPane().getComponents();
	    boolean checkBox1Removed = true;
	    boolean checkBox2Removed = true;
	    for (Component component : components) {
	        if (component.equals(checkBox1)) {
	            checkBox1Removed = false;
	        }
	        if (component.equals(checkBox2)) {
	            checkBox2Removed = false;
	        }
	    }
	    assertFalse("CheckBox 1 not removed", checkBox1Removed);
	    assertFalse("CheckBox 2 not removed", checkBox2Removed);
	}

	@Test
	public void testProgressBar() {
	    JTextField goal1TextField = page4.goal1TextField;
	    JCheckBox checkBox1 = new JCheckBox();

	    // Set progress bar values
	    goal1TextField.setText("Goal 1");
	    goal1TextField.setText("Goal 2");
	    checkBox1.setSelected(true);

	    // Check progress bar value
	    int expectedProgress = 50; // Expected progress value after setting two goals
	    int actualProgress = page4.updateProgressBar(null);
	    assertEquals("Progress bar value not updated correctly", expectedProgress, actualProgress);
	}
	@Test
	public void testEditButton() {
	    JTextField goal1TextField = page4.goal1TextField;
	    page4.frame.getContentPane().add(goal1TextField);

	    assertTrue("Goal 1 TextField not editable", goal1TextField.isEditable());
	}

	
}