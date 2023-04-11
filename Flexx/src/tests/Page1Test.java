package tests;

//Import required libraries and classes
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Gurkirat.Page1;
import Gurkirat.TestUtils;

//Page1Test class for testing the Page1 class
class Page1Test {
	// Declare a variable for the Page1 instance
    Page1 page1;
    
    // Set up the test environment before each test method
    @BeforeEach
    void setUp() throws InterruptedException {
    	// Create a CountDownLatch to ensure the UI is fully loaded before executing tests
        CountDownLatch latch = new CountDownLatch(1);
    	
     // Initialize the Page1 instance on the Event Dispatch Thread
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    page1 = new Page1();
                    latch.countDown();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        
     // Wait for the UI to finish loading before proceeding with tests
        latch.await(5, TimeUnit.SECONDS);
    }
    
 // Test that the frame is not null
    @Test
    void testFrameNotNull() { // Unit Test 
        assertNotNull(page1.frame);
    }

 // Test that the frame attributes are set correctly
    @Test
    void testFrameAttributes() { // Unit Test 
        JFrame frame = page1.frame;
        assertEquals(100, frame.getX());
        assertEquals(100, frame.getY());
        assertEquals(450, frame.getWidth());
        assertEquals(300, frame.getHeight());
    }
    
 // Test that the comboBoxes are not null
    @Test
    void testComboBoxesNotNull() { // Integration Test
        JComboBox comboBox = (JComboBox) TestUtils.getChildNamed(page1.frame, "comboBox");
        JComboBox comboBox_1 = (JComboBox) TestUtils.getChildNamed(page1.frame, "comboBox_1");

        assertNotNull(comboBox);
        assertNotNull(comboBox_1);
    }

 // Test that the text areas are not null
    @Test
    void testTextAreasNotNull() { // Integration Test
        JTextArea txtrMuscleGroup = (JTextArea) TestUtils.getChildNamed(page1.frame, "txtrMuscleGroup");
        JTextArea txtrWorkoutTypes = (JTextArea) TestUtils.getChildNamed(page1.frame, "txtrWorkoutTypes");

        assertNotNull(txtrMuscleGroup);
        assertNotNull(txtrWorkoutTypes);
    }

 // Test that the text pane is not null
    @Test
    void testTextPaneNotNull() { // Integration Test 
        JTextPane textPane = (JTextPane) TestUtils.getChildNamed(page1.frame, "textPane");
        assertNotNull(textPane);
    }
    
 // Test that the initial text of the text areas is correct
    @Test
    void testInitialTextAreasText() { // Integration Test 
        JTextArea txtrMuscleGroup = (JTextArea) TestUtils.getChildNamed(page1.frame, "txtrMuscleGroup");
        JTextArea txtrWorkoutTypes = (JTextArea) TestUtils.getChildNamed(page1.frame, "txtrWorkoutTypes");

        assertEquals("       Muscle Group", txtrMuscleGroup.getText());
        assertEquals("       Workout Types", txtrWorkoutTypes.getText());
    }

 // Test that the comboBoxes have the correct number of items
    @Test
    void testComboBoxesItemCount() {	// Integration Test 
        JComboBox comboBox = (JComboBox) TestUtils.getChildNamed(page1.frame, "comboBox");
        JComboBox comboBox_1 = (JComboBox) TestUtils.getChildNamed(page1.frame, "comboBox_1");

        int expectedComboBoxItemCount = 5; // Set this to the expected item count for comboBox.
        int expectedComboBox_1ItemCount = 1; // Set this to the expected item count for comboBox_1.

        assertEquals(expectedComboBoxItemCount, comboBox.getItemCount());
        assertEquals(expectedComboBox_1ItemCount, comboBox_1.getItemCount());
    }
    
    // Test the functionality of the "Get Results" button
    @Test
    void testGetResultsButtonClick() { // Integration Test 
        // Locate the "Get Results" button
        JButton getResultsButton = (JButton) TestUtils.getChildNamed(page1.frame, "getResultsButton");

        // Set the initial state of the UI components
        JComboBox comboBox = (JComboBox) TestUtils.getChildNamed(page1.frame, "comboBox");
        JComboBox comboBox_1 = (JComboBox) TestUtils.getChildNamed(page1.frame, "comboBox_1");
        comboBox.setSelectedIndex(1); // Set the selected item in comboBox to a specific index
        comboBox_1.setSelectedIndex(1); // Set the selected item in comboBox_1 to a specific index

        // Simulate the button click
        getResultsButton.getActionListeners()[0].actionPerformed(new ActionEvent(getResultsButton, ActionEvent.ACTION_PERFORMED, null));
    }

}

