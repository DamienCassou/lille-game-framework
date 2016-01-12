package gameframework.motion;

import java.awt.event.KeyEvent;

import org.junit.Test;

public class MoveStrategyKeyboard8DirTest extends
		MoveStrategyKeyboardTest {
	
	@Override
	protected MoveStrategyKeyboard8Dir createStrategy() {
		return new MoveStrategyKeyboard8Dir();
	}
	
	@Override
	protected MoveStrategyKeyboard8Dir createStrategyKeyboard() {
		return new MoveStrategyKeyboard8Dir();
	}

	@Override
	protected MoveStrategyKeyboard8Dir createStrategyKeyboard(Boolean alwaysMove) {
		return new MoveStrategyKeyboard8Dir(alwaysMove);
	}

	@Override
	protected MoveStrategyKeyboard8Dir createStrategyKeyboard(Boolean alwaysMove, SpeedVector speedVector) {
		return new MoveStrategyKeyboard8Dir(alwaysMove, speedVector);
	}

	@Test
	public void goingDiag() throws Exception {
		strategy.keyPressed(KeyEvent.VK_DOWN);
		strategy.keyPressed(KeyEvent.VK_RIGHT);
		assertDownRight();
	}

}
