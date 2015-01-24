package gameframework.motion;

import gameframework.motion.MoveStrategyStraightLine;

import java.awt.Point;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MoveStrategyStraightLineTest extends
		MoveStrategyTest<MoveStrategyStraightLine> {

	@Override
	protected MoveStrategyStraightLine createStrategy() {
		return new MoveStrategyStraightLine(new Point(0, 0), new Point(0, 0));
	}

	@Test
	public void goToGoal() throws Exception {
		Point origin = new Point(0, 0);
		Point goal = new Point(2, 1);
		strategy = new MoveStrategyStraightLine(origin, goal);

		assertEquals(new Point(0, 0), strategy.currentPosition);
		assertRight();
		strategy.currentPosition = new Point(1, 0);

		assertEquals(new Point(1, 0), strategy.currentPosition);
		assertDownRight();

		strategy.currentPosition = goal;

		assertEquals(goal, strategy.currentPosition);
		assertNoMovement();

	}
	
	public void goodSpeed() throws Exception {
		Point origin = new Point(0, 0);
		Point goal = new Point(2, 1);
		MoveStrategyStraightLine strat = new MoveStrategyStraightLine(origin, goal, 4);
		
		assertEquals(strat.getSpeed(), 4);
		assertEquals(strat.getSpeedVector().getSpeed(), 4);
		
		strat.setSpeed(12);
		
		assertEquals(strat.getSpeedVector().getSpeed(), 12);
	}
}
