package gameframework.motion;

import static org.junit.Assert.assertEquals;
import gameframework.motion.MoveStrategyRandom;

import java.util.Random;

import org.junit.Test;

public class MoveStrategyRandomTest extends
		MoveStrategyTest<MoveStrategyRandom> {

	@Override
	protected MoveStrategyRandom createStrategy() {
		return new MoveStrategyRandom();
	}

	public void setRandom(final int value) {
		MoveStrategyRandom.random = new Random() {

			private static final long serialVersionUID = 5411193534475148025L;

			@Override
			public int nextInt(int n) {
				return value;
			}
		};
	}

	@Test
	public void goToRight() throws Exception {
		setRandom(0);
		assertRight();
	}

	@Test
	public void goToLeft() throws Exception {
		setRandom(1);
		assertLeft();
	}

	@Test
	public void goUp() throws Exception {
		setRandom(2);
		assertUp();
	}

	@Test
	public void goDown() throws Exception {
		setRandom(3);
		assertDown();
	}
	
	@Test
	public void goodSpeed() throws Exception {

		MoveStrategyRandom strat = new MoveStrategyRandom(4);
		
		assertEquals(4, strat.getSpeed());
		assertEquals(4, strat.getSpeedVector().getSpeed());
		
		strat.setSpeed(12);
		
		assertEquals(12, strat.getSpeedVector().getSpeed());
	}

}
