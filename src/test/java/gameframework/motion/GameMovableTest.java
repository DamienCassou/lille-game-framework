package gameframework.motion;

import static org.junit.Assert.assertEquals;
import gameframework.motion.blocking.MoveBlockerChecker;

import java.awt.Point;
import java.awt.Rectangle;

import org.junit.Before;
import org.junit.Test;

public class GameMovableTest {

	GameMovable gameMovable;
	GameMovableDriver driver;
	SpeedVector driverSpeedVector;
	int oneStepMoveAddedBehavior = 0;

	void createGameMovable() {
		gameMovable = new GameMovable() {

			@Override
			public Rectangle getBoundingBox() {
				return null;
			}

			@Override
			public void oneStepMoveAddedBehavior() {
				oneStepMoveAddedBehavior++;
			}
		};
	}

	void createGameMovableDriver() {
		driver = new GameMovableDriver() {

			@Override
			public SpeedVector getSpeedVector(GameMovable m) {
				return driverSpeedVector;
			}

			@Override
			public void setStrategy(MoveStrategy strat) {

			}

			@Override
			public void setmoveBlockerChecker(MoveBlockerChecker obst) {

			}
		};
	}

	@Before
	public void createAll() {
		createGameMovableDriver();
		createGameMovable();
		gameMovable.setDriver(driver);
	}

	@Test
	public void dontMoveWhenSpeedIs0() {
		Point origin = new Point(100, 200);
		driverSpeedVector = new SpeedVector(new Point(99, 11), 0);
		gameMovable.setPosition(origin);
		gameMovable.oneStepMove();
		assertEquals(origin, gameMovable.getPosition());
	}

	@Test
	public void dontMoveWhenDirectionIs00() {
		Point origin = new Point(100, 200);
		driverSpeedVector = new SpeedVector(new Point(0, 0), 99);
		gameMovable.setPosition(origin);
		gameMovable.oneStepMove();
		assertEquals(origin, gameMovable.getPosition());
	}

	@Test
	public void testMovement() {
		int x = 100;
		int y = 200;
		Point origin = new Point(x, y);
		int dX = 1;
		int dY = 2;
		int speed = 3;

		driverSpeedVector = new SpeedVector(new Point(dX, dY), speed);
		gameMovable.setPosition(origin);
		gameMovable.oneStepMove();
		assertEquals(new Point(x + (dX * speed), y + (dY * speed)),
				gameMovable.getPosition());
	}

	@Test
	public void callsAddedBehavior() throws Exception {
		Point origin = new Point(100, 200);
		driverSpeedVector = new SpeedVector(new Point(0, 0), 99);
		gameMovable.setPosition(origin);
		gameMovable.oneStepMove();
		assertEquals(1, oneStepMoveAddedBehavior);
	}
	
	@Test
	public void testGameMovableGetDriver(){
		assertEquals(driver,gameMovable.getDriver());
	}
	
	@Test
	public void testSetSpeedVector(){
		assertEquals(0,gameMovable.getSpeedVector().getSpeed());
		SpeedVector mySpeedVector = new SpeedVector(new Point(8, 8), 33);
		gameMovable.setSpeedVector(mySpeedVector);
		assertEquals(33,gameMovable.getSpeedVector().getSpeed());
	}

}
