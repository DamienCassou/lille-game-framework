package gameframework.motion;

import java.awt.Point;

/**
 * Indicates a 2D direction and speed
 */
public class SpeedVector implements Cloneable {
	private static final int DEFAULT_SPEED = 8;
	private Point direction;
	private int speed;

	public static SpeedVector createNullVector() {
		return new SpeedVector(new Point(0, 0), 0);
	}

	public SpeedVector(Point direction, int speed) {
		this.direction = direction;
		this.speed = speed;
	}

	public SpeedVector(Point direction) {
		this(direction, DEFAULT_SPEED);
	}

	public Point getDirection() {
		return direction;
	}

	public int getSpeed() {
		return speed;
	}

	public void setDirection(Point direction) {
		this.direction = direction;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	@Override
	public Object clone() {
		return new SpeedVector(direction, speed);
	}
}
