package gameframework.motion;

import java.awt.Point;
import java.util.Random;

/**
 * MoveStrategy which randomly selects one of the four directions (top, bottom,
 * left, right)
 */
public class MoveStrategyRandom implements MoveStrategy {
	SpeedVector currentMove = new SpeedVector(new Point(0, 0));
	static Random random = new Random();

	public MoveStrategyRandom() {
		super();
	}
	
	public MoveStrategyRandom(int speed) {
		super();
		this.currentMove = new SpeedVector(new Point(0, 0), speed);
	}
	
	public int getSpeed() {
		return this.currentMove.getSpeed();
	}
	
	public void setSpeed(int speed) {
		this.currentMove.setSpeed(speed);
	}
	
	@Override
	public SpeedVector getSpeedVector() {
		int i = random.nextInt(4);

		switch (i) {
		case 0:
			currentMove.setDirection(new Point(1, 0));
			break;
		case 1:
			currentMove.setDirection(new Point(-1, 0));
			break;
		case 2:
			currentMove.setDirection(new Point(0, -1));
			break;
		case 3:
			currentMove.setDirection(new Point(0, 1));
			break;
		default:
			throw new IllegalStateException();
		}
		return currentMove;
	}
}
