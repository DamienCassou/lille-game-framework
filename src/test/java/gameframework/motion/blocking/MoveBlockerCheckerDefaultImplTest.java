package gameframework.motion.blocking;

import gameframework.game.GameData;
import gameframework.motion.GameMovable;
import gameframework.motion.SpeedVector;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MoveBlockerCheckerDefaultImplTest {

	MoveBlockerCheckerDefaultImpl checker;
	SpeedVector speedVector;
	GameMovable movable;
	int width = 100;
	int height = 200;
	Vector<MoveBlocker> foundBlockers = new Vector<MoveBlocker>();

	@Before
	public void createMovable() {
		movable = new GameMovable() {

			@Override
			public Rectangle getBoundingBox() {
				return new Rectangle(0, 0, width, height);
			}

			@Override
			public void oneStepMoveAddedBehavior() {
			}
		};
	}

	@Before
	public void createChecker() {
		checker = new MoveBlockerCheckerDefaultImpl();
		checker.setMoveBlockerRules(new MoveBlockerRulesApplier() {

			@Override
			public boolean moveValidationProcessing(GameMovable m,
					Vector<MoveBlocker> blockers) {
				foundBlockers = blockers;
				// by default, a blocker invalidates the move
				return false;
			}

			@Override
			public void setGameData(GameData gameData) {
			}
		});
	}

	public void setSpeedVector(int x, int y, int speed) {
		speedVector = new SpeedVector(new Point(x, y), speed);
	}

	private MoveBlocker createMoveBlocker(final int x, final int y,
			final int width, final int height) {
		return new MoveBlocker() {

			@Override
			public Rectangle getBoundingBox() {
				return new Rectangle(x, y, width, height);
			}

			@Override
			public boolean isMovable() {
				return false;
			}
		};
	}

	public void assertMoveValidated() {
		assertTrue(checker.moveValidation(movable, speedVector));
	}

	public void denyMoveValidated(MoveBlocker... blockers) {
		assertFalse(checker.moveValidation(movable, speedVector));
		assertCorrectFoundBlockers(blockers);
	}

	public void assertCorrectFoundBlockers(MoveBlocker[] blockers) {
		assertEquals(new HashSet<MoveBlocker>(Arrays.asList(blockers)),
				new HashSet<MoveBlocker>(foundBlockers));
	}

	@Test
	public void validateWhenNoBlocker() {
		setSpeedVector(1, 1, 1);
		assertMoveValidated();
	}

	@Test
	public void validateWhenBlockerIsAway() throws Exception {
		checker.addMoveBlocker(createMoveBlocker(-100, -100, 1, 1));
		setSpeedVector(1, 1, 1);
		assertMoveValidated();
	}

	@Test
	public void dontValidateWhenBlockerIsBlocking() throws Exception {
		MoveBlocker blocker = createMoveBlocker(width, 0, 10, 10);
		checker.addMoveBlocker(blocker);
		setSpeedVector(1, 0, 1);
		denyMoveValidated(blocker);
	}

	@Test
	public void validateWhenBlockerIsRemoved() throws Exception {
		MoveBlocker blocker = createMoveBlocker(width, 0, 10, 10);
		checker.addMoveBlocker(blocker);
		setSpeedVector(1, 0, 1);
		denyMoveValidated(blocker);
		checker.removeMoveBlocker(blocker);
		assertMoveValidated();
	}

}
