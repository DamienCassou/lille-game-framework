package gameframework.motion;

import gameframework.motion.MoveStrategyDefaultImpl;

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

}
