package Gurkirat;

import java.awt.Component;
import java.awt.Container;

// TestUtils class containing utility methods for testing
public class TestUtils {

    /**
     * Recursively searches for a child component with the specified name in the
     * given parent component and its descendants.
     *
     * @param parent The parent component to start searching from.
     * @param name   The name of the child component to find.
     * @return The child component if found, null otherwise.
     */
    public static Component getChildNamed(Component parent, String name) {
        // Check if the parent component's name matches the target name
        if (name.equals(parent.getName())) {
            // If it matches, return the parent component
            return parent;
        }

        // Check if the parent component is a container (e.g. JPanel, JFrame, etc.)
        if (parent instanceof Container) {
            // If it is a container, get its child components
            Component[] children = ((Container) parent).getComponents();

            // Iterate through the child components
            for (int i = 0; i < children.length; ++i) {
                // Recursively call getChildNamed on each child component
                Component child = getChildNamed(children[i], name);

                // If a child component with the target name is found, return it
                if (child != null) {
                    return child;
                }
            }
        }

        // If the target child component is not found, return null
        return null;
    }
}
