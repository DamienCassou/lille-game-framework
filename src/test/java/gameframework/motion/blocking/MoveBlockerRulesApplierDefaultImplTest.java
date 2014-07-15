package gameframework.motion.blocking;

import gameframework.motion.GameMovable;
import gameframework.motion.IllegalMoveException;

import java.awt.Rectangle;
import java.util.Vector;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MoveBlockerRulesApplierDefaultImplTest {

	Vector<MoveBlocker> moveBlockers = new Vector<MoveBlocker>();
	MyMovable movable = new MyMovable();

	@Test
	public void testWithNoSuperPower() throws Exception {
		MyMoveBlockerRulesApplier rulesApplier = new MyMoveBlockerRulesApplier();
		moveBlockers.add(new MyMoveBlocker());
		assertFalse(rulesApplier
				.moveValidationProcessing(movable, moveBlockers));
	}

	@Test
	public void testWithSuperPower() throws Exception {
		MyMoveBlockerRulesApplier rulesApplier = new MyMoveBlockerRulesApplier();
		moveBlockers.add(new MyMoveBlocker());
		movable.superPower = true;
		assertTrue(rulesApplier.moveValidationProcessing(movable, moveBlockers));
	}

}

class MyMovable extends GameMovable {

	boolean superPower = false;

	@Override
	public Rectangle getBoundingBox() {
		return null;
	}

	@Override
	public void oneStepMoveAddedBehavior() {

	}
}

class MyMoveBlocker implements MoveBlocker {

	@Override
	public Rectangle getBoundingBox() {
		return null;
	}

}

class MyMoveBlockerRulesApplier extends MoveBlockerRulesApplierDefaultImpl {
	public void moveBlockerRule(MyMovable movable, MyMoveBlocker blocker)
			throws IllegalMoveException {
		if (!movable.superPower)
			throw new IllegalMoveException();
	}
}