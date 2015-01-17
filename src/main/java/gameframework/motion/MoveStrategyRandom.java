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
