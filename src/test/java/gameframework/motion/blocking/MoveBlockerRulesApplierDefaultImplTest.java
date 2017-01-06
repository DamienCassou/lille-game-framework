package gameframework.motion.blocking;

import gameframework.motion.GameMovable;
import gameframework.motion.IllegalMoveException;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MoveBlockerRulesApplierDefaultImplTest {

	List<MoveBlocker> moveBlockers = new ArrayList<MoveBlocker>();
	MyMovable movable = new MyMovable();
	int rulesApplied = 0;
	MoveBlockerRulesApplier rulesApplier;

	@Before
	public void createRuleApplier() {
		rulesApplier = new MoveBlockerRulesApplierDefaultImpl() {

			@SuppressWarnings("unused")
			// tools can't see that this method is only called using reflexion
			public void moveBlockerRule(MyMovable movable, MyMoveBlocker blocker)
					throws IllegalMoveException {
				rulesApplied++;

				if (!movable.superPower)
					throw new IllegalMoveException();
			}
		};
	}

	@Test
	public void testWithNoSuperPower() throws Exception {
		moveBlockers.add(new MyMoveBlocker());
		assertFalse(rulesApplier
				.moveValidationProcessing(movable, moveBlockers));
		assertEquals(1, rulesApplied);
	}

	@Test
	public void testWithSuperPower() throws Exception {
		moveBlockers.add(new MyMoveBlocker());
		movable.superPower = true;
		assertTrue(rulesApplier.moveValidationProcessing(movable, moveBlockers));
		assertEquals(1, rulesApplied);
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

	@Override
	public boolean isMovable() {
		return false;
	}

}