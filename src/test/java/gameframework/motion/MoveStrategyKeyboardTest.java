package gameframework.motion;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.awt.Point;
import java.awt.event.KeyEvent;

import org.junit.Test;

public class MoveStrategyKeyboardTest extends
		MoveStrategyTest<MoveStrategyKeyboard> {

	@Override
	protected MoveStrategyKeyboard createStrategy() {
		return new MoveStrategyKeyboard();
	}

	/**
	 * Use the constructor without parameters.
	 */
	protected MoveStrategyKeyboard createStrategyKeyboard() {
		return new MoveStrategyKeyboard();
	}

	/**
	 * Use the constructor with 1 parameter (Boolean).
	 */
	protected MoveStrategyKeyboard createStrategyKeyboard(Boolean alwaysMove) {
		return new MoveStrategyKeyboard(alwaysMove);
	}

	/**
	 * Use the constructor with 2 parameters (Boolean, SpeedVector).
	 */
	protected MoveStrategyKeyboard createStrategyKeyboard(Boolean alwaysMove, SpeedVector speedVector) {
		return new MoveStrategyKeyboard(alwaysMove, speedVector);
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
		strategy = createStrategyKeyboard(false);
		strategy.keyPressed(KeyEvent.VK_DOWN);
		strategy.keyReleased(KeyEvent.VK_DOWN);
		assertNoMovement();
	}

	@Test
	public void dontStopWhenAlwaysMoveisOn() throws Exception {
		strategy = createStrategyKeyboard(true);
		strategy.keyPressed(KeyEvent.VK_DOWN);
		strategy.keyReleased(KeyEvent.VK_DOWN);
		assertDown();
	}

	@Test
	public void defaultValues() throws Exception {
		strategy = createStrategyKeyboard();
		assertTrue(strategy.alwaysMove);
		assertNoMovement();
	}
	
	@Test
	public void settableSpeed() throws Exception {
		strategy.setSpeed(3);
		assertEquals(3, strategy.getSpeed());
		strategy.setSpeed(1);
		assertEquals(1, strategy.getSpeed());
	}

	@Test
	public void initializedValues() throws Exception {
		SpeedVector speedVector = new SpeedVector(new Point(5,5), 50);
		strategy = createStrategyKeyboard(false, speedVector);

		assertEquals(speedVector, strategy.speedVector);
		assertEquals(false, strategy.alwaysMove);
	}

	@Test
	public void shouldMoveRightWhenAlwaysMoveisOn() {
		strategy = createStrategyKeyboard(true);
		strategy.keyPressed(KeyEvent.VK_LEFT);
		strategy.keyReleased(KeyEvent.VK_LEFT);
		strategy.keyPressed(KeyEvent.VK_LEFT);
		strategy.keyReleased(KeyEvent.VK_LEFT);
		strategy.keyPressed(KeyEvent.VK_RIGHT);
		strategy.keyReleased(KeyEvent.VK_RIGHT);
		assertRight();
	}

}
