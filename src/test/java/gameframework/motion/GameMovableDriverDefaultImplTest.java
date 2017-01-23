package gameframework.motion;

import gameframework.motion.blocking.MoveBlocker;
import gameframework.motion.blocking.MoveBlockerChecker;
import gameframework.motion.blocking.MoveBlockerRulesApplier;

import java.awt.Point;
import java.awt.Rectangle;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameMovableDriverDefaultImplTest {

	MoveBlockerChecker moveBlockerChecker;
	MoveStrategy moveStrategy;
	SpeedVector strategySpeedVector = new SpeedVector(new Point(101, 213), 55);
	GameMovable movable;
	SpeedVector movableSpeedVector = new SpeedVector(new Point(1, 99), 896);
	SpeedVector acceptableSpeedVector;
	GameMovableDriverDefaultImpl driver;
	boolean acceptAllSpeedVectors = false;

	public void createMoveBlockerChecker() {
		moveBlockerChecker = new MoveBlockerChecker() {

			@Override
			public boolean moveValidation(GameMovable movable,
					SpeedVector requestedSpeedVector) {
				return acceptAllSpeedVectors
						|| requestedSpeedVector.equals(acceptableSpeedVector);
			}

			@Override
			public void setMoveBlockerRules(
					MoveBlockerRulesApplier moveBlockerRules) {
			}

			@Override
			public void removeMoveBlocker(MoveBlocker blocker) {
			}

			@Override
			public void addMoveBlocker(MoveBlocker blocker) {
			}
		};
	}

	public void createMoveStrategy() {
		moveStrategy = new MoveStrategy() {

			@Override
			public SpeedVector getSpeedVector() {
				return strategySpeedVector;
			}

			@Override
			public int getSpeed() {
				return strategySpeedVector.getSpeed();
			}

			@Override
			public void setSpeed(int speed) {
				strategySpeedVector.setSpeed(speed);
			}
		};
	}

	public void createMovable() {
		movable = new GameMovable() {

			@Override
			public SpeedVector getSpeedVector() {
				return movableSpeedVector;
			}

			@Override
			public Rectangle getBoundingBox() {
				return null;
			}

			@Override
			public void oneStepMoveAddedBehavior() {
			}
		};
	}

	@Before
	public void createAll() {
		createMovable();
		createMoveStrategy();
		createMoveBlockerChecker();
		driver = new GameMovableDriverDefaultImpl();
		driver.setmoveBlockerChecker(moveBlockerChecker);
		driver.setStrategy(moveStrategy);
	}

	@Test
	public void vectorFromStrategyWhenAcceptable() throws Exception {
		acceptableSpeedVector = strategySpeedVector;
		assertSame(strategySpeedVector, driver.getSpeedVector(movable));
	}

	@Test
	public void vectorFromMovableWhenAcceptable() throws Exception {
		acceptableSpeedVector = movableSpeedVector;
		assertSame(movableSpeedVector, driver.getSpeedVector(movable));
	}

	@Test
	public void nullSpeedVectorWhenTheRestFails() throws Exception {
		acceptableSpeedVector = new SpeedVector(new Point(111, 9111), 1231);
		SpeedVector actualSpeedVector = driver.getSpeedVector(movable);
		assertEquals(new Point(0, 0), actualSpeedVector.getDirection());
		assertEquals(0, actualSpeedVector.getSpeed());
	}

	@Test
	public void preferVectorFromStrategy() throws Exception {
		acceptAllSpeedVectors = true;
		assertSame(strategySpeedVector, driver.getSpeedVector(movable));
	}
}
