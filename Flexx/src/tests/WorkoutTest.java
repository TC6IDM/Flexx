package tests;

import static org.junit.Assert.assertEquals;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.junit.jupiter.api.Test;

import Andrew.Workout;
import Andrew.workoutSet;
import otherUtil.*;

class WorkoutTest {
	
	@Test
	void test1() {
		Workout newWorkout = new Workout("Bench Press");
		newWorkout.addDataPoint(20, 30, 0);
		newWorkout.addDataPoint(30, 320, 0);
		newWorkout.addDataPoint(25, 340, 4);
		newWorkout.addDataPoint(220, 130, 2);
		newWorkout.addDataPoint(2550, 302, 1);
		
		String workoutStr ="Reps: 20 Weight: 30.0 Number: 0\n"
				+ "Reps: 30 Weight: 320.0 Number: 0\n"
				+ "Reps: 25 Weight: 340.0 Number: 4\n"
				+ "Reps: 220 Weight: 130.0 Number: 2\n"
				+ "Reps: 2550 Weight: 302.0 Number: 1\n";
		assertEquals(newWorkout.toString(),workoutStr);
	}
	

}
