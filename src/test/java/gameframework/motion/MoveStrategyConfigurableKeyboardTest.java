package gameframework.motion;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.awt.Point;
import java.awt.event.KeyEvent;

import org.junit.Test;

public class MoveStrategyConfigurableKeyboardTest extends
		MoveStrategyTest<MoveStrategyConfigurableKeyboard> {

	@Override
	protected MoveStrategyConfigurableKeyboard createStrategy() {
		return new MoveStrategyConfigurableKeyboard();
	}
	
	/**
	 * Use the constructor with 1 parameter (Boolean).
	 */
	protected MoveStrategyConfigurableKeyboard createStrategyKeyboard(Boolean alwaysMove) {
		return new MoveStrategyConfigurableKeyboard(alwaysMove);
	}

	/**
	 * Use the constructor with 2 parameters (Boolean, SpeedVector).
	 */
	protected MoveStrategyConfigurableKeyboard createStrategyKeyboard(Boolean alwaysMove, SpeedVector speedVector) {
		return new MoveStrategyConfigurableKeyboard(alwaysMove, speedVector);
	}

	/**
	 * Use the constructor with every parameters.
	 */
	protected MoveStrategyConfigurableKeyboard createStrategyKeyboard(Boolean alwaysMove, SpeedVector speedVector, Boolean combineDirections) {
		return new MoveStrategyConfigurableKeyboard(alwaysMove, speedVector, combineDirections);
	}
	
	@Test
	public void goingLeftWhenPressingTheCorrespondingConfiguredKey() {
		int key = KeyEvent.VK_A;
		strategy.addKeyDirection(key, new Point(-1, 0));
		strategy.keyPressed(key);
		assertLeft();
	}
	
	@Test
	public void goingRightWhenPressingTheCorrespondingConfiguredKey() {
		int key = KeyEvent.VK_Z;
		strategy.addKeyDirection(key, new Point(1, 0));
		strategy.keyPressed(key);
		assertRight();
	}

	@Test
	public void stopWhenAlwaysMoveisOff() throws Exception {
		strategy = createStrategyKeyboard(false);
		int key = KeyEvent.VK_C;
		strategy.addKeyDirection(key, new Point(-1, 0));
		strategy.keyPressed(key);
		strategy.keyReleased(key);
		assertNoMovement();
	}

	@Test
	public void dontStopWhenAlwaysMoveisOn() throws Exception {
		strategy = createStrategyKeyboard(true);
		int key = KeyEvent.VK_B;
		strategy.addKeyDirection(key, new Point(0, 1));
		strategy.keyPressed(key);
		strategy.keyReleased(key);
		assertDown();
	}

	@Test
	public void defaultValues() throws Exception {
		strategy = createStrategy();
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
		int leftKey = KeyEvent.VK_X;
		int rightKey = KeyEvent.VK_U;
		strategy.addKeyDirection(leftKey, new Point(-1, 0));
		strategy.addKeyDirection(rightKey, new Point(1, 0));
		strategy.keyPressed(leftKey);
		strategy.keyReleased(leftKey);
		strategy.keyPressed(leftKey);
		strategy.keyReleased(leftKey);
		strategy.keyPressed(rightKey);
		strategy.keyReleased(rightKey);
		assertRight();
	}
	
	@Test
	public void directionShouldBeLowerRightIfCombineIsOnAndLeftAndDownArePressedSimultaneously() {
		strategy = createStrategyKeyboard(false, new SpeedVector(new Point(0, 0)), true);
		int downKey = KeyEvent.VK_I;
		int rightKey = KeyEvent.VK_V;
		strategy.addKeyDirection(downKey, new Point(0, 1));
		strategy.addKeyDirection(rightKey, new Point(1, 0));
		strategy.keyPressed(downKey);
		strategy.keyPressed(rightKey);
		
		assertDownRight();
	}

}
