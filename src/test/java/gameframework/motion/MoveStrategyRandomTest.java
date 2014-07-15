package gameframework.motion;

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

}
