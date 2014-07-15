package gameframework.motion;

import gameframework.motion.MoveStrategyKeyboard;

import java.awt.event.KeyEvent;

import org.junit.Test;

public class MoveStrategyKeyboardTest extends MoveStrategyTest<MoveStrategyKeyboard> {

	@Override
	protected MoveStrategyKeyboard createStrategy() {
		return new MoveStrategyKeyboard();
	}
	
	@Test
	public void goingLeft() throws Exception {
		strategy.keyPressed(KeyEvent.VK_LEFT);
		assertLeft();
	}

	@Test
	public void goingRight() throws Exception {
		strategy.keyPressed(KeyEvent.VK_RIGHT);
		assertRight();
	}

	@Test
	public void goingUp() throws Exception {
		strategy.keyPressed(KeyEvent.VK_UP);
		assertUp();
	}

	@Test
	public void goingDown() throws Exception {
		strategy.keyPressed(KeyEvent.VK_DOWN);
		assertDown();
	}

}
