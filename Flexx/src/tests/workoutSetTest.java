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

class workoutSetTest {
	@Test
	void test1() {
		workoutSet newWorkoutSet = new workoutSet(1,2,3);
		String workoutStr ="Reps: 1 Weight: 2.0 Number: 3";
		assertEquals(newWorkoutSet.toString(),workoutStr);
	}
	@Test
	void test2() {
		workoutSet newWorkoutSet = new workoutSet(10,2.1,33);
		String workoutStr ="Reps: 10 Weight: 2.1 Number: 33";
		assertEquals(newWorkoutSet.toString(),workoutStr);
	}
	@Test
	void test3() {
		workoutSet newWorkoutSet = new workoutSet(0,0,0);
		String workoutStr ="Reps: 0 Weight: 0.0 Number: 0";
		assertEquals(newWorkoutSet.toString(),workoutStr);
	}
	

}
