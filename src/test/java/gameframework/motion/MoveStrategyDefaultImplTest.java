package gameframework.motion;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MoveStrategyDefaultImplTest extends
		MoveStrategyTest<MoveStrategyDefaultImpl> {

	@Override
	protected MoveStrategyDefaultImpl createStrategy() {
		return new MoveStrategyDefaultImpl();
	}

	@Test
	public void dontMove() throws Exception {
		assertNoMovement();
	}
	
	@Test
	public void speedZero() throws Exception {
		assertEquals(0, strategy.getSpeed());
		strategy.setSpeed(2);
		assertEquals(0, strategy.getSpeed());
	}

}
