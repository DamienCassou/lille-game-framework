package gameframework.motion;

import java.awt.event.KeyEvent;

import org.junit.Test;

public class MoveStrategyKeyboard8DirTest extends
		MoveStrategyKeyboardTest {
	
	@Override
	protected MoveStrategyKeyboard8Dir createStrategy() {
		return new MoveStrategyKeyboard8Dir();
	}
	
	@Test
	public void goingDiag() throws Exception {
		strategy.keyPressed(KeyEvent.VK_DOWN);
		strategy.keyPressed(KeyEvent.VK_RIGHT);
		assertDownRight();
	}

}
