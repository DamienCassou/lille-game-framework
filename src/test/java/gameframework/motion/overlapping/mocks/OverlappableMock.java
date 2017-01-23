package gameframework.motion.overlapping.mocks;

import java.awt.Point;
import java.awt.Rectangle;

import gameframework.motion.overlapping.Overlappable;

public class OverlappableMock implements Overlappable {

	@Override
	public Rectangle getBoundingBox() {
		return new Rectangle();
	}

	@Override
	public boolean isMovable() {
		return false;
	}

	@Override
	public Point getPosition() {
		return new Point(0, 0);
	}
}
