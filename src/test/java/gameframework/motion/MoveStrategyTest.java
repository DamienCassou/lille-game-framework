package gameframework.motion;

import gameframework.motion.MoveStrategy;

import java.awt.Point;

import org.junit.Before;

import static org.junit.Assert.assertEquals;

public abstract class MoveStrategyTest<S extends MoveStrategy> {

	protected S strategy;

	@Before
	public void initStrategy() {
		strategy = createStrategy();
	}

	protected abstract S createStrategy();

	protected void assertNoMovement() {
		assertEquals(new Point(0, 0), strategy.getSpeedVector().getDirection());
	}

	protected void assertLeft() {
		assertEquals(new Point(-1, 0), strategy.getSpeedVector().getDirection());
	}

	protected void assertRight() {
		assertEquals(new Point(1, 0), strategy.getSpeedVector().getDirection());
	}

	protected void assertUp() {
		assertEquals(new Point(0, -1), strategy.getSpeedVector().getDirection());
	}

	protected void assertDown() {
		assertEquals(new Point(0, 1), strategy.getSpeedVector().getDirection());
	}

	protected void assertDownRight() {
		assertEquals(new Point(1, 1), strategy.getSpeedVector().getDirection());
	}
}
