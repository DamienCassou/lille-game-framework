package gameframework.motion;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.awt.Point;
import java.awt.event.KeyEvent;

import org.junit.Test;

public class MoveStrategyKeyboard8DirTest extends
		MoveStrategyTest<MoveStrategyKeyboard8Dir> {
	
	@Override
	protected MoveStrategyKeyboard8Dir createStrategy() {
		return new MoveStrategyKeyboard8Dir();
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

	@Test
	public void stopWhenAlwaysMoveisOff() throws Exception {
		strategy = new MoveStrategyKeyboard8Dir();
		strategy.keyPressed(KeyEvent.VK_DOWN);
		strategy.keyReleased(KeyEvent.VK_DOWN);
		assertNoMovement();
	}

	@Test
	public void dontStopWhenAlwaysMoveisOn() throws Exception {
		strategy = new MoveStrategyKeyboard8Dir();
		strategy.keyPressed(KeyEvent.VK_DOWN);
		strategy.keyReleased(KeyEvent.VK_DOWN);
		assertDown();
	}

	@Test
	public void defaultValues() throws Exception {
		strategy = new MoveStrategyKeyboard8Dir();
		assertTrue(strategy.alwaysMove);
		assertNoMovement();
	}

	@Test
	public void initializedValues() throws Exception {
		SpeedVector speedVector = new SpeedVector(new Point(5,5), 50);
		strategy = new MoveStrategyKeyboard8Dir(speedVector);

		assertEquals(speedVector, strategy.speedVector);
		assertEquals(false, strategy.alwaysMove);
	}

}
